package com.clearavenue.helloworld.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data" })
public class ReturnedBenchmarks {

	@JsonProperty("data")
	private BenchmarkData data;

	@JsonProperty("data")
	public BenchmarkData getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(BenchmarkData data) {
		this.data = data;
	}
	
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

}
