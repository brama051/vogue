package com.brama.vogue.consumer;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.brama.vogue.entity.response.ApiResponse;

@Component
public class WebServiceConsumer {
	public ApiResponse fetchScore(String keyword) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://api.github.com/search/issues?q={term}", ApiResponse.class, keyword);
	}
}
