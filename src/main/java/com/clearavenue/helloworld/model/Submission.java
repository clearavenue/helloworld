package com.clearavenue.helloworld.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "createdAt", "updatedAt", "entityId", "entityType", "taxpayerIdentificationNumber",
		"nationalProviderIdentifier", "performanceYear", "measurementSets" })
@Getter
@Setter
public class Submission {

	@JsonProperty("id")
	private String id;

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("updatedAt")
	private String updatedAt;

	@JsonProperty("entityId")
	private String entityId;

	@JsonProperty("entityType")
	private String entityType;

	@JsonProperty("taxpayerIdentificationNumber")
	private String taxpayerIdentificationNumber;

	@JsonProperty("nationalProviderIdentifier")
	private String nationalProviderIdentifier;

	@JsonProperty("performanceYear")
	private Integer performanceYear;

	@JsonProperty("measurementSets")
	private List<MeasurementSet> measurementSets = null;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
