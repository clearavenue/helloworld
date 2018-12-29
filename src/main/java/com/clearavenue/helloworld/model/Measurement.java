package com.clearavenue.helloworld.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "measurementSetId", "measureId", "value" })
public class Measurement {
    @JsonProperty("id")
    private String id;

    @JsonProperty("measurementSetId")
    private String measurementSetId;
    
    @JsonProperty("measureId")
    private String measureId;
    
    @JsonProperty("value")
    private Boolean value;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("measurementSetId")
    public String getMeasurementSetId() {
        return measurementSetId;
    }

    @JsonProperty("measurementSetId")
    public void setMeasurementSetId(String measurementSetId) {
        this.measurementSetId = measurementSetId;
    }

    @JsonProperty("measureId")
    public String getMeasureId() {
        return measureId;
    }

    @JsonProperty("measureId")
    public void setMeasureId(String measureId) {
        this.measureId = measureId;
    }

    @JsonProperty("value")
    public Boolean getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Boolean value) {
        this.value = value;
    }

}
