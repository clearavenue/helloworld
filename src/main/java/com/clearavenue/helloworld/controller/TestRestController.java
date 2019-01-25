package com.clearavenue.helloworld.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clearavenue.helloworld.model.InpatientClaims;
import com.clearavenue.helloworld.service.CmsQualityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestRestController {

	@Autowired
	CmsQualityService service;

	ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();

	@GetMapping("/inpatientClaims")
	public List<InpatientClaims> inpatientClaims() {
		List<InpatientClaims> claims = new ArrayList<InpatientClaims>();

		ClassPathResource csvFile = new ClassPathResource("DE1_0_2008_to_2010_Inpatient_Claims_Sample_1.csv");

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(csvFile.getInputStream(), Charset.defaultCharset()));) {
			CsvToBean<InpatientClaims> csvToBean = new CsvToBeanBuilder<InpatientClaims>(reader)
					.withType(InpatientClaims.class).withIgnoreLeadingWhiteSpace(true).withThrowExceptions(false)
					.build();

			Iterator<InpatientClaims> inpatientClaimsIterator = csvToBean.iterator();

			log.info("starting iterator");
			while (inpatientClaimsIterator.hasNext()) {
				InpatientClaims claim = inpatientClaimsIterator.next();
				claims.add(claim);
			}
			log.info("done...");

			if (csvToBean.getCapturedExceptions().isEmpty()) {
				log.info("Parsing {} claims OK", claims.size());
			} else {
				csvToBean.getCapturedExceptions().forEach(exp -> log.error(exp.getCause().getMessage()));
				log.info("Parsing {} claims OK - {} errors", claims.size(), csvToBean.getCapturedExceptions().size());
			}
		} catch (RuntimeException e) {
			log.error("{} : {}", e.getMessage(), e.getLocalizedMessage());
			throw e;
		} catch (Exception e) {
			log.error("{} : {}", e.getMessage(), e.getLocalizedMessage());
		}

		return claims;
	}
}
