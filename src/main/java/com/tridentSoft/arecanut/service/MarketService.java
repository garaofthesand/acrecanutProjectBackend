package com.tridentSoft.arecanut.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tridentSoft.arecanut.Dto.MarketResponse;

@Service
public interface MarketService {

	List<MarketResponse> getLatestMarketPrices();

}
