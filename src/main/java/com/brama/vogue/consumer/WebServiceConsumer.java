package com.brama.vogue.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import com.brama.vogue.entity.response.ApiResponse;

@Component
public class WebServiceConsumer {
	private static final Logger logger = LoggerFactory.getLogger(WebServiceConsumer.class);

	public ApiResponse fetchScore(String keyword) {
		StopWatch sw = new StopWatch("fetchScore: https://api.github.com/search/issues");
		sw.start();
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse apiResponse = restTemplate.getForObject("https://api.github.com/search/issues?q={term}",
				ApiResponse.class, keyword);

		sw.stop();
		logger.debug(sw.shortSummary());
		return apiResponse;

	}
}
