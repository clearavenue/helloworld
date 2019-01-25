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
    "startIndex",
    "itemsPerPage",
    "benchmarks"
})
@Getter
@Setter
public class BenchmarkData {
	@JsonProperty("startIndex")
    private Integer startIndex;
	
    @JsonProperty("itemsPerPage")
    private Integer itemsPerPage;
    
    @JsonProperty("benchmarks")
    private List<Benchmark> benchmarks = null;

    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

}
