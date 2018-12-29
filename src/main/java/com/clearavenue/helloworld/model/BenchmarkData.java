package com.clearavenue.helloworld.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "startIndex",
    "itemsPerPage",
    "benchmarks"
})
public class BenchmarkData {
	@JsonProperty("startIndex")
    private Integer startIndex;
	
    @JsonProperty("itemsPerPage")
    private Integer itemsPerPage;
    
    @JsonProperty("benchmarks")
    private List<Benchmark> benchmarks = null;
    
    @JsonProperty("startIndex")
    public Integer getStartIndex() {
        return startIndex;
    }

    @JsonProperty("startIndex")
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    @JsonProperty("itemsPerPage")
    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    @JsonProperty("itemsPerPage")
    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    @JsonProperty("benchmarks")
    public List<Benchmark> getBenchmarks() {
        return benchmarks;
    }

    @JsonProperty("benchmarks")
    public void setBenchmarks(List<Benchmark> benchmarks) {
        this.benchmarks = benchmarks;
    }

    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

}
