package com.brama.vogue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brama.vogue.entity.Score;
import com.brama.vogue.repository.WebRepository;

@Component
public class ScoreService {

	@Autowired
	WebRepository webRepository;

	public Score getScore(String term) {
		float rocksCount = this.webRepository.fetchScore(term + " rocks").getTotalCount();
		float sucksCount = this.webRepository.fetchScore(term + " sucks").getTotalCount();
		float score = rocksCount / (rocksCount + sucksCount) * 10;

		return new Score(term, score);
	}
}
