package com.brama.vogue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brama.vogue.entity.Score;

@RestController
public class Endpoint {

	@RequestMapping("/score")
	public Score getScore(@RequestParam(value = "term", defaultValue = "") String term) {
		Score score = new Score();
		score.setTerm("keyword");
		score.setScore(new Float(3.3));

		return score;
	}
}
