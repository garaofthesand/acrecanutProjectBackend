package com.tridentSoft.arecanut.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tridentSoft.arecanut.Dto.MarketResponse;
import com.tridentSoft.arecanut.service.MarketService;

@Service
public class MarketServiceImpl implements MarketService {

	@Override
	public List<MarketResponse> getLatestMarketPrices() {

		List<MarketResponse> markets = new ArrayList<>();

		MarketResponse sirsi = new MarketResponse();
		sirsi.setName("Sirsi");
		sirsi.setRed(42000);
		sirsi.setWhite(39000);
		sirsi.setBette(45000);
		sirsi.setUpdated("1/8/2026");

		MarketResponse madikeri = new MarketResponse();
		madikeri.setName("Madikeri");
		madikeri.setRed(42500);
		madikeri.setWhite(39500);
		madikeri.setBette(45500);
		madikeri.setUpdated("1/8/2026");

		MarketResponse chikmagalur = new MarketResponse();
		chikmagalur.setName("Chikmagalur");
		chikmagalur.setRed(43000);
		chikmagalur.setWhite(40000);
		chikmagalur.setBette(46000);
		chikmagalur.setUpdated("1/8/2026");
		
		
		MarketResponse bangalore = new MarketResponse();
		bangalore.setName("Bangalore");
		bangalore.setRed(43000);
		bangalore.setWhite(40000);
		bangalore.setBette(46000);
		bangalore.setUpdated("1/8/2026");
		
		
		
		MarketResponse mysore = new MarketResponse();
		mysore.setName("mysore");
		mysore.setRed(43000);
		mysore.setWhite(40000);
		mysore.setBette(46000);
		mysore.setUpdated("1/8/2026");
		
		
		
		
		MarketResponse tumkur = new MarketResponse();
		tumkur.setName("tumkur");
		tumkur.setRed(43000);
		tumkur.setWhite(40000);
		tumkur.setBette(46000);
		tumkur.setUpdated("1/8/2026");
		
		
		
		
		MarketResponse Karwar = new MarketResponse();
		Karwar.setName("Karwar");
		Karwar.setRed(43000);
		Karwar.setWhite(40000);
		Karwar.setBette(46000);
		Karwar.setUpdated("1/8/2026");
		
		
	

		markets.add(sirsi);
		markets.add(madikeri);
		markets.add(chikmagalur);
		markets.add(bangalore);
		markets.add(mysore);
		markets.add(tumkur);
		markets.add(Karwar);

		return markets;

	}

}
