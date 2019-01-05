package com.clearavenue.helloworld.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
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
import org.springframework.web.context.WebApplicationContext;

import com.clearavenue.helloworld.HelloworldApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {HelloworldApplication.class}, webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CmsControllerTests {

	@InjectMocks
	CMSController controller;
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getCms() throws Exception {
		this.mockMvc.perform(get("/cms")).andExpect(status().isOk()).andExpect(view().name("cms"));
		assertTrue("always true", true);
	}
	
	@Test
	public void getCmsReturn() {
		assertEquals("Should return cms", "cms",this.controller.cms(null));
	}
}

