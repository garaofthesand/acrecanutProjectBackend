package com.example.arecanut.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.arecanut.projectors.PriceTrendProjection;
import com.example.arecanut.repository.ArecanutPriceHistoryRepo;
import com.example.arecanut.service.PriceTrendService;

@Service
public class PriceTrendServiceImpl implements PriceTrendService {

	@Autowired
	private ArecanutPriceHistoryRepo repo;

	@Override
	public List<PriceTrendProjection> getShortTerm(String arecaType) {
		return repo.fetchWeeklyTrend(arecaType);
	}

	@Override
	public List<PriceTrendProjection> getMidTerm(String arecaType) {
		return repo.fetchMonthlyTrend(arecaType);
	}

	@Override
	public List<PriceTrendProjection> getLongTerm(String arecaType) {
		return repo.fetchYearlyTrend(arecaType);
	}

}
