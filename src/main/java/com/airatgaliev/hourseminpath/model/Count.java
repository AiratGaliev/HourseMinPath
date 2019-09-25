package com.airatgaliev.hourseminpath.model;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Count extends ResourceSupport {
	private String count;

	@JsonCreator
	public Count(@JsonProperty("count") String count) {
		this.count = count;
	}

	public String getCount() {
		return count;
	}

}
