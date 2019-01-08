package com.clearavenue.helloworld.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.clearavenue.helloworld.HelloworldApplication;
import com.clearavenue.helloworld.model.ReturnedBenchmarks;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { HelloworldApplication.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CmsRestControllerTests {

	final ObjectMapper mapper = new ObjectMapper();

	@InjectMocks
	CMSRestController controller;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getBenchmarks() throws Exception {
		final MvcResult result = mockMvc.perform(get("/getBenchmarks")).andExpect(status().isOk()).andReturn();
		ReturnedBenchmarks actual = mapper.readValue(result.getResponse().getContentAsString(), ReturnedBenchmarks.class);
		assertNotNull("returned benchmarks should not be null", actual);
	}
	
	@Test
	public void getGetDefualtScoreFile() throws Exception {
		final MvcResult result = mockMvc.perform(get("/defaultScoreRequest")).andExpect(status().isOk()).andReturn();
		String actual = result.getResponse().getContentAsString();
		assertNotNull("returned defaultscorefile should not be null", actual);
	}
	
	// /getSubmissions/{taxpayerId}/{nationalId}/{entityType}
	@Test
	public void getSubmissionsDefault() throws Exception {
		final MvcResult result = mockMvc.perform(get("/getSubmissions/null/null/null")).andExpect(status().isOk()).andReturn();
		String actual = result.getResponse().getContentAsString();
		assertNotNull("returned submissions should not be null", actual);
	}
	
	
	//@Test
	public void getGetScore() throws Exception {
		final MvcResult result = mockMvc.perform(get("/defaultScoreRequest")).andExpect(status().isOk()).andReturn();
		String actual = result.getResponse().getContentAsString();
		assertNotNull("returned benchmarks should not be null", actual);
	}

}
