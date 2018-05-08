package com.brama.vogue.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CountDto can be used to unmarshalling JSON String to POJO.
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountDto {

	/** The total count. */
	@JsonProperty("total_count")
	Float totalCount;

	/**
	 * Gets the total count.
	 *
	 * @return the total count
	 */
	public Float getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the total count.
	 *
	 * @param totalCount
	 *            the new total count
	 */
	public void setTotalCount(Float totalCount) {
		this.totalCount = totalCount;
	}
}
