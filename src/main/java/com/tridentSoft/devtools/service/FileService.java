package com.tridentSoft.devtools.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tridentSoft.devtools.dto.ApiResponse;

@Service
public class FileService {

    private static final String BASE_DIR = "D://devTools//files";

    // ---------------- FILE LIST ----------------
    public ApiResponse findFileNames(String username) {

        List<String> fileList = new ArrayList<>();

        // basic validation
        if (username == null || username.contains("..")) {
            return new ApiResponse(false, "Invalid username", fileList);
        }

        Path userDir = Paths.get(BASE_DIR, username);

        // If directory does not exist → return empty list (not an error)
        if (!Files.exists(userDir) || !Files.isDirectory(userDir)) {
            return new ApiResponse(true, "No files found", fileList);
        }

        try {
            Files.list(userDir)
                 .filter(path -> Files.isRegularFile(path))
                 .filter(path -> path.getFileName().toString().endsWith(".txt"))
                 .forEach(path -> fileList.add(path.getFileName().toString()));

            return new ApiResponse(true, "Files fetched successfully", fileList);

        } catch (IOException e) {
            return new ApiResponse(false, "Failed to read files", fileList);
        }
    }

    // ---------------- READ FILE ----------------
    public ApiResponse<String> getFileContent(String username, String filename) {

        if (!validate(username, filename)) {
            return new ApiResponse<>(false, "Invalid username or filename");
        }

        Path filePath = Paths.get(BASE_DIR, username, filename);

        if (!Files.exists(filePath)) {
            return new ApiResponse<>(false, "File not found");
        }

        try {
            String content = Files.readString(filePath, StandardCharsets.UTF_8);
            return new ApiResponse<>(true, "File read successfully", content);
        } catch (IOException e) {
            return new ApiResponse<>(false, "Failed to read file");
        }
    }

    // ---------------- SAVE FILE ----------------
    public ApiResponse<Void> saveFile(String username, String filename, String content) {

        if (!validate(username, filename)) {
            return new ApiResponse<>(false, "Invalid username or filename");
        }

        Path userDir = Paths.get(BASE_DIR, username);
        Path filePath = userDir.resolve(filename);

        try {
            Files.createDirectories(userDir);

            Files.writeString(
                filePath,
                content == null ? "" : content,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
            );

            return new ApiResponse<>(true, "File saved successfully");

        } catch (IOException e) {
            return new ApiResponse<>(false, "Failed to save file");
        }
    }

    // ---------------- CREATE FILE ----------------
    public ApiResponse<Void> createFile(String username, String filename) {

        if (!validate(username, filename)) {
            return new ApiResponse<>(false, "Invalid username or filename");
        }

        Path userDir = Paths.get(BASE_DIR, username);
        Path filePath = userDir.resolve(filename);

        try {
            Files.createDirectories(userDir);

            if (Files.exists(filePath)) {
                return new ApiResponse<>(false, "File already exists");
            }

            Files.createFile(filePath);
            return new ApiResponse<>(true, "File created successfully");

        } catch (IOException e) {
            return new ApiResponse<>(false, "Failed to create file");
        }
    }

    // ---------------- DELETE FILE ----------------
    public ApiResponse<Void> deleteFile(String username, String filename) {

        if (!validate(username, filename)) {
            return new ApiResponse<>(false, "Invalid username or filename");
        }

        Path filePath = Paths.get(BASE_DIR, username, filename);

        try {
            if (!Files.exists(filePath)) {
                return new ApiResponse<>(false, "File does not exist");
            }

            Files.delete(filePath);
            return new ApiResponse<>(true, "File deleted successfully");

        } catch (IOException e) {
            return new ApiResponse<>(false, "Failed to delete file");
        }
    }

    // ---------------- RENAME FILE ----------------
    public ApiResponse<Void> renameFile(String username, String oldFilename, String newFilename) {

        if (!validate(username, oldFilename) || !validate(username, newFilename)) {
            return new ApiResponse<>(false, "Invalid filename");
        }

        Path userDir = Paths.get(BASE_DIR, username);
        Path oldPath = userDir.resolve(oldFilename);
        Path newPath = userDir.resolve(newFilename);

        try {
            if (!Files.exists(oldPath)) {
                return new ApiResponse<>(false, "File does not exist");
            }

            if (Files.exists(newPath)) {
                return new ApiResponse<>(false, "Target file already exists");
            }

            Files.move(oldPath, newPath);
            return new ApiResponse<>(true, "File renamed successfully");

        } catch (IOException e) {
            return new ApiResponse<>(false, "Failed to rename file");
        }
    }

    // ---------------- VALIDATION ----------------
    private boolean validate(String username, String filename) {

        if (username == null || filename == null) return false;
        if (username.contains("..") || filename.contains("..")) return false;
        if (!filename.endsWith(".txt")) return false;

        return true;
    }
}
