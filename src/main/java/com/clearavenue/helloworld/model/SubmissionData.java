package com.clearavenue.helloworld.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "startIndex", "itemsPerPage", "totalItems", "submissions" })
public class SubmissionData {
	@JsonProperty("startIndex")
	private Integer startIndex;

	@JsonProperty("itemsPerPage")
	private Integer itemsPerPage;

	@JsonProperty("totalItems")
	private Integer totalItems;

	@JsonProperty("submissions")
	private List<Submission> submissions = null;

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

	@JsonProperty("totalItems")
	public Integer getTotalItems() {
		return totalItems;
	}

	@JsonProperty("totalItems")
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	@JsonProperty("submissions")
	public List<Submission> getSubmissions() {
		return submissions;
	}

	@JsonProperty("submissions")
	public void setSubmissions(List<Submission> submissions) {
		this.submissions = submissions;
	}

}
