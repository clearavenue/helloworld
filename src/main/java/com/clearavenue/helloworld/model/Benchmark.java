package com.clearavenue.helloworld.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "benchmarkYear",
    "performanceYear",
    "deciles",
    "status",
    "submissionMethod",
    "measureId"
})
@Getter
@Setter
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
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }
}
