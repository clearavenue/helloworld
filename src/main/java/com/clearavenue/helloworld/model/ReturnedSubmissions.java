package com.clearavenue.helloworld.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data" })
@Getter
@Setter
public class ReturnedSubmissions {

	@JsonProperty("data")
	private SubmissionData data;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
