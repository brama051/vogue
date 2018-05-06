package com.brama.vogue.entity;

import java.io.Serializable;

public class Score implements Serializable {

	private static final long serialVersionUID = -194523646242043645L;

	private String term;

	private Float score;

	public Score(String term, Float score) {
		this.setTerm(term);
		this.setScore(score);
	}

	public Score() {
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Score{" + "term='" + this.term + "'}";
	}
}
