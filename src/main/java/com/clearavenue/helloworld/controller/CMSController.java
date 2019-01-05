package com.clearavenue.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CMSController {
	
	@GetMapping("/cms")
	public String cms(final ModelMap model) {
		return "cms";
	}	
}
