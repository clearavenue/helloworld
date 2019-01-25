package com.clearavenue.helloworld.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "measurementSetId", "measureId", "value" })
@Getter
@Setter
public class Measurement {
    @JsonProperty("id")
    private String id;

    @JsonProperty("measurementSetId")
    private String measurementSetId;
    
    @JsonProperty("measureId")
    private String measureId;
    
    @JsonProperty("value")
    private Boolean value;
    
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

}
