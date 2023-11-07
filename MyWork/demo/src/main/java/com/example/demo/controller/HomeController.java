package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	// => void : 요청명.jsp 를 viewName 으로 처리함 (home.jsp)
	// => Boot의 매핑메서드 에서는 "/" 요청은 적용안됨 -> addViewControllers 메서드로 해결
	//    WebMvcConfig의 addViewControllers 메서드로 해결
	public void home(Locale locale , Model model) {
		Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
	    String formattedDate = dateFormat.format(date);
	    model.addAttribute("serverTime", formattedDate );
	}//home
	
	
	

}//class 
