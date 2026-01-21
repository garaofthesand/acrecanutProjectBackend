package com.tridentSoft.devtools.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tridentSoft.devtools.dto.*;
import com.tridentSoft.devtools.service.FileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/devTools/file")
public class FileManagementController {

    @Autowired
    private FileService fileService;

    // ---------------- FILE LIST ----------------
    @GetMapping("/mock/{username}")
    public ResponseEntity<ApiResponse<List<String>>> getFileNames(
            @PathVariable String username) {

        ApiResponse<List<String>> response = fileService.findFileNames(username);
        return ResponseEntity.ok(response);
    }

    // ---------------- READ FILE ----------------
    @GetMapping("/content")
    public ResponseEntity<ApiResponse<String>> getFileContent(
            @RequestParam String username,
            @RequestParam String filename) {

        ApiResponse<String> response = fileService.getFileContent(username, filename);

        return ResponseEntity
                .status(response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(response);
    }

    // ---------------- SAVE FILE ----------------
    @PostMapping("/save")
    public ResponseEntity<ApiResponse<Void>> saveFile(
            @RequestBody SaveFileRequest request) {

        ApiResponse<Void> response = fileService.saveFile(
                request.getUsername(),
                request.getFilename(),
                request.getContent()
        );

        return ResponseEntity
                .status(response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(response);
    }

    // ---------------- CREATE FILE ----------------
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createFile(
            @RequestBody CreateFileRequest request) {

        ApiResponse<Void> response = fileService.createFile(
                request.getUsername(),
                request.getFilename()
        );

        return ResponseEntity
                .status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
                .body(response);
    }

    // ---------------- DELETE FILE ----------------
    @PostMapping("/delete")
    public ResponseEntity<ApiResponse<Void>> deleteFile(
            @RequestBody DeleteFileRequest request) {

        ApiResponse<Void> response = fileService.deleteFile(
                request.getUsername(),
                request.getFilename()
        );

        return ResponseEntity
                .status(response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(response);
    }

    // ---------------- RENAME FILE ----------------
    @PostMapping("/rename")
    public ResponseEntity<ApiResponse<Void>> renameFile(
            @RequestBody RenameFileRequest request) {

        ApiResponse<Void> response = fileService.renameFile(
                request.getUsername(),
                request.getFilenameOld(),
                request.getFilenameNew()
        );

        return ResponseEntity
                .status(response.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
