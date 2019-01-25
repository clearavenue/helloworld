package com.clearavenue.helloworld.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "startIndex", "itemsPerPage", "totalItems", "submissions" })
@Getter
@Setter
public class SubmissionData {
	@JsonProperty("startIndex")
	private Integer startIndex;

	@JsonProperty("itemsPerPage")
	private Integer itemsPerPage;

	@JsonProperty("totalItems")
	private Integer totalItems;

	@JsonProperty("submissions")
	private List<Submission> submissions = null;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
