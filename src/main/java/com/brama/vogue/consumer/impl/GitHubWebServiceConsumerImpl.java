package com.brama.vogue.consumer.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import com.brama.vogue.consumer.WebServiceConsumer;
import com.brama.vogue.dto.CountDto;

/**
 * The Class GitHubWebServiceConsumerImpl used for querying GitHub issues search
 * API. Docs: https://developer.github.com/v3/search/#search-issues
 * 
 */
@Service
public class GitHubWebServiceConsumerImpl implements WebServiceConsumer {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(GitHubWebServiceConsumerImpl.class);

	/**
	 * Makes a HTTP request to https://api.github.com/search/issues?q={term}
	 * replacing a term with api consumer provided keyword. The response JSON string
	 * will be unmarshalled to a CountDto object.
	 * 
	 * @param String
	 *            keyword
	 * @return CountDto countDto
	 */
	public CountDto fetchScore(String keyword) {
		StopWatch sw = new StopWatch("fetchScore: https://api.github.com/search/issues");
		sw.start();
		RestTemplate restTemplate = new RestTemplate();
		CountDto apiResponse = restTemplate.getForObject("https://api.github.com/search/issues?q={term}",
				CountDto.class, keyword);

		sw.stop();
		logger.debug(sw.shortSummary());
		return apiResponse;

	}
}
