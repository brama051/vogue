package com.brama.vogue.entity.jsonapi;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class JsonApiObject.
 */
public class JsonApiObject implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2105146929800565945L;

	/** The data. */
	JsonApiData data;

	/** The json api. */
	@JsonProperty("jsonapi")
	JsonApi jsonApi;

	/**
	 * Instantiates a new json api object.
	 */
	public JsonApiObject() {
		this.setData(new JsonApiData());
		this.setJsonApi(new JsonApi());
	}

	/**
	 * Instantiates a new json api object.
	 *
	 * @param version
	 *            the version
	 */
	public JsonApiObject(String version) {
		this();
		this.getJsonApi().setVersion(version);
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public JsonApiData getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(JsonApiData data) {
		this.data = data;
	}

	/**
	 * Gets the json api.
	 *
	 * @return the json api
	 */
	public JsonApi getJsonApi() {
		return jsonApi;
	}

	/**
	 * Sets the json api.
	 *
	 * @param jsonApi
	 *            the new json api
	 */
	public void setJsonApi(JsonApi jsonApi) {
		this.jsonApi = jsonApi;
	}

}
