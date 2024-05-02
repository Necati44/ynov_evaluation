package com.ynov.evaluation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoMVCController {

	@GetMapping("/demo")
	@ResponseBody
	public String displayMessage()
	{
		return "Hello Ynov";
	}
	
}
