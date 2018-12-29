package com.clearavenue.helloworld.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "createdAt", "updatedAt", "submissionId", "category", "submissionMethod", "measureSet",
		"submitterId", "submitterType", "programName", "practiceId", "performanceStart", "performanceEnd",
		"measurements" })
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

	@JsonProperty("submissionId")
	public String getSubmissionId() {
		return submissionId;
	}

	@JsonProperty("submissionId")
	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("submissionMethod")
	public String getSubmissionMethod() {
		return submissionMethod;
	}

	@JsonProperty("submissionMethod")
	public void setSubmissionMethod(String submissionMethod) {
		this.submissionMethod = submissionMethod;
	}

	@JsonProperty("measureSet")
	public Object getMeasureSet() {
		return measureSet;
	}

	@JsonProperty("measureSet")
	public void setMeasureSet(Object measureSet) {
		this.measureSet = measureSet;
	}

	@JsonProperty("submitterId")
	public String getSubmitterId() {
		return submitterId;
	}

	@JsonProperty("submitterId")
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}

	@JsonProperty("submitterType")
	public String getSubmitterType() {
		return submitterType;
	}

	@JsonProperty("submitterType")
	public void setSubmitterType(String submitterType) {
		this.submitterType = submitterType;
	}

	@JsonProperty("programName")
	public String getProgramName() {
		return programName;
	}

	@JsonProperty("programName")
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	@JsonProperty("practiceId")
	public String getPracticeId() {
		return practiceId;
	}

	@JsonProperty("practiceId")
	public void setPracticeId(String practiceId) {
		this.practiceId = practiceId;
	}

	@JsonProperty("performanceStart")
	public String getPerformanceStart() {
		return performanceStart;
	}

	@JsonProperty("performanceStart")
	public void setPerformanceStart(String performanceStart) {
		this.performanceStart = performanceStart;
	}

	@JsonProperty("performanceEnd")
	public String getPerformanceEnd() {
		return performanceEnd;
	}

	@JsonProperty("performanceEnd")
	public void setPerformanceEnd(String performanceEnd) {
		this.performanceEnd = performanceEnd;
	}

	@JsonProperty("measurements")
	public List<Measurement> getMeasurements() {
		return measurements;
	}

	@JsonProperty("measurements")
	public void setMeasurements(List<Measurement> measurements) {
		this.measurements = measurements;
	}

}
