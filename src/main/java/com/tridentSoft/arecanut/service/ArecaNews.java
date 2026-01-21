package com.tridentSoft.arecanut.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tridentSoft.arecanut.Dto.NewsDto;

@Service
public interface ArecaNews {

	List<NewsDto> fetchLatestNews();

}
