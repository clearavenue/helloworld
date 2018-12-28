package com.clearavenue.helloworld.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.clearavenue.helloworld.model.ReturnedBenchmarks;
import com.clearavenue.helloworld.model.ReturnedSubmissions;

@Service
public class CmsQualityService {

	// https://preview.qpp.cms.gov/api/submissions/public/benchmarks

	private final RestTemplate restTemplate;

	public CmsQualityService(RestTemplateBuilder restTemplateBuilder) {
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new HeaderRequestInterceptor("Authorization",
				"Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJxcHAtYXV0aC1zZXJ2aWNlLTVjYmM5MTcxLTMxZGQtNGRkYS1iODI0LTkxNWVmMDc5M2MyMiIsImV4cCI6MTU3NTE1ODQwMCwiZGF0YSI6eyJpZCI6IjVjYmM5MTcxLTMxZGQtNGRkYS1iODI0LTkxNWVmMDc5M2MyMiIsInByb2dyYW1ZZWFyIjoyMDE4LCJvcmdUeXBlIjoiZGVmYXVsdFN3YWdnZXJTdWJtaXR0ZXIiLCJjbXNJZCI6Ijk5MDAwMDEiLCJuYW1lIjoicXBwLXN1Ym1pc3Npb25zLWFwaS1zd2FnZ2VyIiwic3RhdHVzIjoic3VibWl0In0sImlhdCI6MTU0MzYwMzU5OH0.04z2hkBhBK5jX4QVSASjN2jA9XJEAxv2frnmql9ottY"));

		this.restTemplate = restTemplateBuilder.interceptors(interceptors).build();
	}

	public ReturnedBenchmarks getBenchmarks() {
		return this.restTemplate.getForObject("https://preview.qpp.cms.gov/api/submissions/public/benchmarks",
				ReturnedBenchmarks.class);
	}

	public String getSubmissions(String taxpayerId, String nationalId, String entityType) {
		nationalId = nationalId.equals("null") ? "0876543210" : nationalId;
		entityType = entityType.equals("null") ? "individual" : entityType;
		taxpayerId = taxpayerId.equals("null") ? "000456789" : taxpayerId;

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl("https://preview.qpp.cms.gov/api/submissions/submissions")
				.queryParam("nationalProviderIdentifier", nationalId).queryParam("entityType", entityType)
				.queryParam("itemsPerPage", 1).queryParam("startIndex", 0);

		this.restTemplate.getInterceptors()
				.add(new HeaderRequestInterceptor("qpp-taxpayer-identification-number", taxpayerId));
		// taxpayerId != "null" ? taxpayerId : "000456789"));
		return this.restTemplate.getForEntity(builder.toUriString(), String.class).getBody();
	}
}
