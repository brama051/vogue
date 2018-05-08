package com.brama.vogue.entity.jsonapi;

import java.io.Serializable;

/**
 * The Class JsonApi top level JsonApiObject optional member.
 */
public class JsonApi implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8342252101382703935L;

	/** The version. */
	String version;

	/**
	 * Instantiates a new json api.
	 */
	public JsonApi() {
	}

	/**
	 * Instantiates a new json api.
	 *
	 * @param version
	 *            the version
	 */
	public JsonApi(String version) {
		this.setVersion(version);
	}

	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param version
	 *            the new version
	 */
	public void setVersion(String version) {
		this.version = version;
	}
}
