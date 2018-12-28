package com.clearavenue.helloworld.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "benchmarkYear",
    "performanceYear",
    "deciles",
    "status",
    "submissionMethod",
    "measureId"
})
public class Benchmark {
	@JsonProperty("benchmarkYear")
    private Integer benchmarkYear;

	@JsonProperty("performanceYear")
    private Integer performanceYear;
    
	@JsonProperty("deciles")
    private List<Integer> deciles = null;
    
	@JsonProperty("status")
    private String status;
    
	@JsonProperty("submissionMethod")
    private String submissionMethod;
    
	@JsonProperty("measureId")
    private String measureId;

    @JsonProperty("benchmarkYear")
    public Integer getBenchmarkYear() {
        return benchmarkYear;
    }

    @JsonProperty("benchmarkYear")
    public void setBenchmarkYear(Integer benchmarkYear) {
        this.benchmarkYear = benchmarkYear;
    }

    @JsonProperty("performanceYear")
    public Integer getPerformanceYear() {
        return performanceYear;
    }

    @JsonProperty("performanceYear")
    public void setPerformanceYear(Integer performanceYear) {
        this.performanceYear = performanceYear;
    }

    @JsonProperty("deciles")
    public List<Integer> getDeciles() {
        return deciles;
    }

    @JsonProperty("deciles")
    public void setDeciles(List<Integer> deciles) {
        this.deciles = deciles;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("submissionMethod")
    public String getSubmissionMethod() {
        return submissionMethod;
    }

    @JsonProperty("submissionMethod")
    public void setSubmissionMethod(String submissionMethod) {
        this.submissionMethod = submissionMethod;
    }

    @JsonProperty("measureId")
    public String getMeasureId() {
        return measureId;
    }

    @JsonProperty("measureId")
    public void setMeasureId(String measureId) {
        this.measureId = measureId;
    }
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}
