package com.example.arecanut.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.arecanut.Dto.MarketResponse;


@Service
public interface MarketService {

	List<MarketResponse> getLatestMarketPrices();

}
