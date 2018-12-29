package com.clearavenue.helloworld.controller;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clearavenue.helloworld.model.ReturnedBenchmarks;
import com.clearavenue.helloworld.service.CmsQualityService;

@RestController
public class CMSRestController {

	@Autowired
	CmsQualityService service;

	@GetMapping("/getBenchmarks")
	public ReturnedBenchmarks getBenchmarks() {
		return service.getBenchmarks();
	}

	@GetMapping("/getSubmissions/{taxpayerId}/{nationalId}/{entityType}")
	public String getSubmissions(@PathVariable String taxpayerId, @PathVariable String nationalId,
			@PathVariable String entityType) {
		return service.getSubmissions(taxpayerId, nationalId, entityType);
	}

	@GetMapping("/defaultScoreRequest")
	public String getDefaultScoreRequest() throws IOException {
		ClassPathResource file = new ClassPathResource("defaultScoreRequest.txt");
		return StreamUtils.copyToString(file.getInputStream(), Charset.defaultCharset());
	}
	
	@PostMapping("/getScore")
	public String getQualityScore(String req) {
		return service.getQualityScore(req);
	}
}
