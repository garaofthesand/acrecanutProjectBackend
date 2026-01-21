package com.tridentSoft.arecanut.serviceImpl;

import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tridentSoft.arecanut.Dto.NewsDto;
import com.tridentSoft.arecanut.service.ArecaNews;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Service
public class ArecaNewsImpl implements ArecaNews{

	private static final String RSS_URL = "https://news.google.com/rss/search?q=arecanut+areca+betel+market+India&hl=en-IN&gl=IN&ceid=IN:en";

	public List<NewsDto> fetchLatestNews() {
		try {
			SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(RSS_URL)));

			return feed.getEntries().stream().limit(10)
					.map(entry -> new NewsDto(entry.getTitle(), entry.getLink(),
							entry.getPublishedDate() != null ? entry.getPublishedDate().toString() : "", "Google News"))
					.toList();

		} catch (Exception e) {
			throw new RuntimeException("Failed to fetch arecanut news", e);
		}
	}
}
