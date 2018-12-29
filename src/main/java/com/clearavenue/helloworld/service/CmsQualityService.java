package com.clearavenue.helloworld.service;

import java.util.Collections;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.clearavenue.helloworld.model.ReturnedBenchmarks;

@Service
public class CmsQualityService {

	private final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJxcHAtYXV0aC1zZXJ2aWNlLTVjYmM5MTcxLTMxZGQtNGRkYS1iODI0LTkxNWVmMDc5M2MyMiIsImV4cCI6MTU3NTE1ODQwMCwiZGF0YSI6eyJpZCI6IjVjYmM5MTcxLTMxZGQtNGRkYS1iODI0LTkxNWVmMDc5M2MyMiIsInByb2dyYW1ZZWFyIjoyMDE4LCJvcmdUeXBlIjoiZGVmYXVsdFN3YWdnZXJTdWJtaXR0ZXIiLCJjbXNJZCI6Ijk5MDAwMDEiLCJuYW1lIjoicXBwLXN1Ym1pc3Npb25zLWFwaS1zd2FnZ2VyIiwic3RhdHVzIjoic3VibWl0In0sImlhdCI6MTU0MzYwMzU5OH0.04z2hkBhBK5jX4QVSASjN2jA9XJEAxv2frnmql9ottY";

	private final RestTemplate restTemplate;

	public CmsQualityService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public ReturnedBenchmarks getBenchmarks() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return this.restTemplate.exchange("https://preview.qpp.cms.gov/api/submissions/public/benchmarks", HttpMethod.GET, entity, ReturnedBenchmarks.class).getBody();
	}

	public String getSubmissions(String taxpayerId, String nationalId, String entityType) {
		nationalId = nationalId.equals("null") ? "0876543210" : nationalId;
		entityType = entityType.equals("null") ? "individual" : entityType;
		taxpayerId = taxpayerId.equals("null") ? "000456789" : taxpayerId;

		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl("https://preview.qpp.cms.gov/api/submissions/submissions")
				.queryParam("nationalProviderIdentifier", nationalId).queryParam("entityType", entityType)
				.queryParam("itemsPerPage", 1).queryParam("startIndex", 0);

		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		headers.set("qpp-taxpayer-identification-number", taxpayerId);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class).getBody();
	}

	public String getQualityScore(String req) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity<String>(req, headers);
		return this.restTemplate.postForObject("https://preview.qpp.cms.gov/api/submissions/submissions/score-preview",
				request, String.class);
	}

}
