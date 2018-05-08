package com.brama.vogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.brama.vogue.entity.Score;
import com.brama.vogue.entity.jsonapi.JsonApiObject;
import com.brama.vogue.service.ScoreService;

/**
 * The Class ScoreController is a controller that serves data as REST documents.
 */
@RestController
public class ScoreControllerV2 {

	@Autowired
	private ScoreService contentService;

	/**
	 * Bonus part of the task where JsonApi.org standard should be applied.
	 * 
	 * There are three ways for versioning API. By headers, by subdomain or by path.
	 * For the sake of simplicity, I chose to do it by path.
	 *
	 * @param term
	 *            the term
	 * @return the score V 2
	 */
	@GetMapping({ "/v2/scores/{term}", "/scores/{term}" })
	public JsonApiObject getScore(@PathVariable String term) {
		Score score = contentService.getScore(term);

		JsonApiObject jsonApiObject = new JsonApiObject("2.0");
		jsonApiObject.getData().setId(term);
		jsonApiObject.getData().setType("score");
		jsonApiObject.getData().getAttributes().put("score", score.getScore());

		return jsonApiObject;
	}
}
