package com.ynov.evaluation.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class DemoMVCControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void test1_Demo() throws Exception {
		mockMvc.perform(get("/demo")).andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello Ynov")));
	}

}
