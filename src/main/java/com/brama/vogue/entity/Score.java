package com.brama.vogue.entity;

import java.io.Serializable;

/**
 * The Class Score is a serializable POJO class that represents Score entity.
 *
 * @author brama051
 */
public class Score implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -194523646242043645L;

	/** The term. */
	private String term;

	/** The score. */
	private Float score;

	/**
	 * Instantiates a new score.
	 */
	public Score() {
	}

	/**
	 * Instantiates a new score.
	 *
	 * @param term
	 *            the term
	 * @param score
	 *            the score
	 */
	public Score(String term, Float score) {
		this.setTerm(term);
		this.setScore(score);
	}

	public Score(String term, float score, String version) {
		this(term, score);
	}

	/**
	 * Gets the term.
	 *
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * Sets the term.
	 *
	 * @param term
	 *            the new term
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public Float getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score
	 *            the new score
	 */
	public void setScore(Float score) {
		this.score = score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Score{" + "term='" + this.term + "'}";
	}
}
