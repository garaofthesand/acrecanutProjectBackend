package com.tridentSoft.arecanut.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tridentSoft.arecanut.Dto.ApiResponse;
import com.tridentSoft.arecanut.Dto.MarketResponse;
import com.tridentSoft.arecanut.Dto.NewsDto;
import com.tridentSoft.arecanut.projectors.PriceTrendProjection;
import com.tridentSoft.arecanut.service.ArecaNews;
import com.tridentSoft.arecanut.service.MarketService;
import com.tridentSoft.arecanut.service.PriceTrendService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/markets")
public class MarketController {

	/*
	 * @Autowired private MarketService marketService;
	 * 
	 * @Autowired private PriceTrendService priceTrendService;
	 * 
	 * @Autowired private ArecaNews arecanutNewsService;
	 */
	/*
	 * @GetMapping("/getLatestPrices") public ApiResponse getMarketPrices() {
	 * 
	 * List<MarketResponse> markets = marketService.getLatestMarketPrices();
	 * 
	 * ApiResponse response = new ApiResponse(); response.setSuccess(true);
	 * response.setMessage("Market prices fetched successfully");
	 * response.setData(markets);
	 * 
	 * return response;
	 * 
	 * }
	 * 
	 * @GetMapping("/getRedArecanutTrends") public ApiResponse<Map<String,
	 * List<PriceTrendProjection>>> getRedArecanutTrends(@RequestParam String
	 * arecaType) {
	 * 
	 * List<PriceTrendProjection> shortTerm =
	 * priceTrendService.getShortTerm(arecaType); List<PriceTrendProjection> midTerm
	 * = priceTrendService.getMidTerm(arecaType); List<PriceTrendProjection>
	 * longTerm = priceTrendService.getLongTerm(arecaType);
	 * 
	 * Map<String, List<PriceTrendProjection>> trendData = new HashMap<>();
	 * trendData.put("shortTerm", shortTerm); trendData.put("midTerm", midTerm);
	 * trendData.put("longTerm", longTerm);
	 * 
	 * ApiResponse<Map<String, List<PriceTrendProjection>>> response = new
	 * ApiResponse<>(); response.setSuccess(true);
	 * response.setMessage("Red arecanut price trends fetched successfully");
	 * response.setData(trendData);
	 * 
	 * return response; }
	 * 
	 * @GetMapping("/getArecanutNews") public ApiResponse<List<NewsDto>>
	 * getArecanutNews() {
	 * 
	 * List<NewsDto> news = arecanutNewsService.fetchLatestNews();
	 * 
	 * ApiResponse<List<NewsDto>> response = new ApiResponse<>();
	 * response.setSuccess(true);
	 * response.setMessage("Latest arecanut news fetched successfully");
	 * response.setData(news);
	 * 
	 * return response; }
	 */

}
