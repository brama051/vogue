package com.brama.vogue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brama.vogue.entity.Score;
import com.brama.vogue.service.ScoreService;

/**
 * The Class Endpoint is a controller that serves data as REST documents.
 */
@RestController
public class ScoreController {

	private static final Logger logger = LoggerFactory.getLogger(ScoreController.class);

	@Autowired
	private ScoreService contentService;

	/**
	 * Returns a calculated score which can either be read from third party API or
	 * from application cache.
	 *
	 * @param term
	 *            the term
	 * @return the score
	 */
	@RequestMapping("/score")
	public Score getScore(@RequestParam(value = "term") String term) {
		return contentService.getScore(term);
	}
}
