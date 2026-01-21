package com.tridentSoft.arecanut.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tridentSoft.arecanut.projectors.PriceTrendProjection;
import com.tridentSoft.arecanut.repository.ArecanutPriceHistoryRepo;
import com.tridentSoft.arecanut.service.PriceTrendService;

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
