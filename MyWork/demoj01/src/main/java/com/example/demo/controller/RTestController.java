package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@RestController
@RequestMapping("rest")
@Log4j2
@AllArgsConstructor
public class RTestController {
	
	@GetMapping("checkdata")
	public String hello() {	
		log.info("React Connect Test 중");
		return "SpringBoot & React 안녕 !!";
	}
}
