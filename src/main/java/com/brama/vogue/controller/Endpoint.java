package com.brama.vogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brama.vogue.consumer.WebServiceConsumer;
import com.brama.vogue.entity.Score;
import com.brama.vogue.entity.response.ApiResponse;
import com.brama.vogue.service.ScoreService;

@RestController
public class Endpoint {

	private static final Logger logger = LoggerFactory.getLogger(Endpoint.class);

	@Autowired
	private ScoreService contentService;

	@Autowired
	private WebServiceConsumer webServiceConsumer;

	@RequestMapping("/score")
	public Score getScore(@RequestParam(value = "term", defaultValue = "") String term) {
		return contentService.getScore(term);
	}

	@RequestMapping("")
	public ApiResponse defaultEndpoint(@RequestParam(value = "term", defaultValue = "") String term) {
		return webServiceConsumer.fetchScore(term);

	}

}
