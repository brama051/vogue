package com.brama.vogue.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.brama.vogue.entity.response.ApiResponse;

@Component
public class WebRepository {
	public ApiResponse fetchScore(String keyword) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("https://api.github.com/search/issues?q={term}", ApiResponse.class, keyword);
	}
}
