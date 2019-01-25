package com.clearavenue.helloworld.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "createdAt", "updatedAt", "submissionId", "category", "submissionMethod", "measureSet",
		"submitterId", "submitterType", "programName", "practiceId", "performanceStart", "performanceEnd",
		"measurements" })
@Getter
@Setter
public class MeasurementSet {
	@JsonProperty("id")
	private String id;

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("updatedAt")
	private String updatedAt;

	@JsonProperty("submissionId")
	private String submissionId;

	@JsonProperty("category")
	private String category;

	@JsonProperty("submissionMethod")
	private String submissionMethod;

	@JsonProperty("measureSet")
	private Object measureSet;

	@JsonProperty("submitterId")
	private String submitterId;

	@JsonProperty("submitterType")
	private String submitterType;

	@JsonProperty("programName")
	private String programName;

	@JsonProperty("practiceId")
	private String practiceId;

	@JsonProperty("performanceStart")
	private String performanceStart;

	@JsonProperty("performanceEnd")
	private String performanceEnd;

	@JsonProperty("measurements")
	private List<Measurement> measurements = null;

	@Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}
