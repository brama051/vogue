package com.brama.vogue.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
	@JsonProperty("total_count")
	Float totalCount;

	public Float getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Float totalCount) {
		this.totalCount = totalCount;
	}
}
