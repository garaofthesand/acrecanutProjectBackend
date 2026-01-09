package com.example.arecanut.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.arecanut.Dto.NewsDto;

@Service
public interface ArecaNews {

	List<NewsDto> fetchLatestNews();

}
