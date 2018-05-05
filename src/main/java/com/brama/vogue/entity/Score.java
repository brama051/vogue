package com.brama.vogue.entity;

public class Score {

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
