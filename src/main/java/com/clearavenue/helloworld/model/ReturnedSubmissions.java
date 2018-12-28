package com.clearavenue.helloworld.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "data" })
public class ReturnedSubmissions {

	@JsonProperty("data")
    private SubmissionData data;

    @JsonProperty("data")
    public SubmissionData getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(SubmissionData data) {
        this.data = data;
    }

}
