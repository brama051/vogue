package com.brama.vogue.entity.jsonapi;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class JsonApiData.
 */
public class JsonApiData implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3354787377215940063L;

	/** The type. */
	String type;

	/** The id. */
	String id;

	/** The attributes. */
	Map<String, Object> attributes;

	/**
	 * Instantiates a new json api data.
	 */
	public JsonApiData() {
		this.setAttributes(new HashMap<>());
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the attributes.
	 *
	 * @return the attributes
	 */
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	/**
	 * Sets the attributes.
	 *
	 * @param attributes
	 *            the attributes
	 */
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
}
