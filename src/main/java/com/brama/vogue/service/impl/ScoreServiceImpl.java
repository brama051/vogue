package com.brama.vogue.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.brama.vogue.consumer.WebServiceConsumer;
import com.brama.vogue.entity.Score;
import com.brama.vogue.service.ScoreService;

/**
 * The Class ScoreServiceImpl is a service which utilizes web service consumer
 * and applies logic of how should score be calculated .
 */
@Service
public class ScoreServiceImpl implements ScoreService {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ScoreServiceImpl.class);

	/** The web service consumer. */
	@Autowired
	WebServiceConsumer webServiceConsumer;

	/**
	 * Calculates popularity of a term in GitHub issues on scale from 1 to 10 based
	 * on how many times it was mentioned in issues as "some_term rocks" or as
	 * "some_term sucks"
	 * 
	 * @param String
	 *            term
	 * 
	 * @return Score score
	 */
	@Cacheable(value = "scores", key = "#term")
	public Score getScore(String term) {
		logger.info("Cache MISS for key '{}'", term);

		float rocksCount = this.webServiceConsumer.fetchScore(term + " rocks").getTotalCount();
		float sucksCount = this.webServiceConsumer.fetchScore(term + " sucks").getTotalCount();
		float score = rocksCount / (rocksCount + sucksCount) * 10;

		return new Score(term, score);
	}
}
