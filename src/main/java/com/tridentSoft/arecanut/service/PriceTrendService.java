package com.tridentSoft.arecanut.service;

import java.util.List;

import com.tridentSoft.arecanut.projectors.PriceTrendProjection;

public interface PriceTrendService {

	public List<PriceTrendProjection> getShortTerm(String arecaType);

	public List<PriceTrendProjection> getMidTerm(String arecaType);

	public List<PriceTrendProjection> getLongTerm(String arecaType);

}
