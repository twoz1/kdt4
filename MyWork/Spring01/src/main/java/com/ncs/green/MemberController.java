package com.ncs.green;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.MemberDTO;
import service.MemberService;

@Controller
public class MemberController {
   
   @Autowired
   MemberService service;
   
   @RequestMapping(value = "/mlistsp", method = RequestMethod.GET)
   public String mlistsp(Model model) {
      
      model.addAttribute("banana", service.selectList());
      return "member/memberList";
   }
   
   // ** MemberDetail
   @RequestMapping(value = "/mdetailsp", method = RequestMethod.GET)
   public String mdetailsp(Model model, MemberDTO dto) {
	  //dto.setId("검색id");
      model.addAttribute("apple", service.selectOne(dto));
      return "member/memberDetail";
   }
   // ** Member Login ...
   
   
}