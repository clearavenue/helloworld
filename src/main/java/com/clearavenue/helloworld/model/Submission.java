package com.clearavenue.helloworld.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "createdAt", "updatedAt", "entityId", "entityType", "taxpayerIdentificationNumber",
		"nationalProviderIdentifier", "performanceYear", "measurementSets" })
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

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("createdAt")
	public String getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("createdAt")
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("updatedAt")
	public String getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updatedAt")
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty("entityId")
	public String getEntityId() {
		return entityId;
	}

	@JsonProperty("entityId")
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	@JsonProperty("entityType")
	public String getEntityType() {
		return entityType;
	}

	@JsonProperty("entityType")
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	@JsonProperty("taxpayerIdentificationNumber")
	public String getTaxpayerIdentificationNumber() {
		return taxpayerIdentificationNumber;
	}

	@JsonProperty("taxpayerIdentificationNumber")
	public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
		this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
	}

	@JsonProperty("nationalProviderIdentifier")
	public String getNationalProviderIdentifier() {
		return nationalProviderIdentifier;
	}

	@JsonProperty("nationalProviderIdentifier")
	public void setNationalProviderIdentifier(String nationalProviderIdentifier) {
		this.nationalProviderIdentifier = nationalProviderIdentifier;
	}

	@JsonProperty("performanceYear")
	public Integer getPerformanceYear() {
		return performanceYear;
	}

	@JsonProperty("performanceYear")
	public void setPerformanceYear(Integer performanceYear) {
		this.performanceYear = performanceYear;
	}

	@JsonProperty("measurementSets")
	public List<MeasurementSet> getMeasurementSets() {
		return measurementSets;
	}

	@JsonProperty("measurementSets")
	public void setMeasurementSets(List<MeasurementSet> measurementSets) {
		this.measurementSets = measurementSets;
	}

}
