package com.tridentSoft.arecanut.Dto;

import lombok.Data;
import java.util.List;

@Data
public class ChartDataResponse {

	List<PriceTrendDto> shortTerm;
	List<PriceTrendDto> midTerm;
	List<PriceTrendDto> longTer;

}
