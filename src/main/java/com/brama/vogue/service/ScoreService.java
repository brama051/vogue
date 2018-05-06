package com.brama.vogue.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.brama.vogue.consumer.WebServiceConsumer;
import com.brama.vogue.entity.Score;

@Component
public class ScoreService {
	private static final Logger logger = LoggerFactory.getLogger(ScoreService.class);

	@Autowired
	WebServiceConsumer webServiceConsumer;

	@Cacheable(value = "scores", key = "#term")
	public Score getScore(String term) {
		logger.info("Cache MISS for key '{}'", term);

		float rocksCount = this.webServiceConsumer.fetchScore(term + " rocks").getTotalCount();
		float sucksCount = this.webServiceConsumer.fetchScore(term + " sucks").getTotalCount();
		float score = rocksCount / (rocksCount + sucksCount) * 10;

		return new Score(term, score);
	}
}
