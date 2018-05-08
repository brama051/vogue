package com.brama.vogue.consumer;

import com.brama.vogue.dto.CountDto;

/**
 * The Interface WebServiceConsumer.
 */
public interface WebServiceConsumer {

	/**
	 * Fetch score from a third party web service.
	 *
	 * @param keyword
	 *            the keyword
	 * @return the CountDto
	 */
	public CountDto fetchScore(String keyword);
}
