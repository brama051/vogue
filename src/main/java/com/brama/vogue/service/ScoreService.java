package com.brama.vogue.service;

import com.brama.vogue.entity.Score;

/**
 * The Interface ScoreService.
 */
public interface ScoreService {

	/**
	 * Contains the logic of how should score be calculated.
	 *
	 * @param term
	 *            the term
	 * @return the score
	 */
	public Score getScore(String term);
}
