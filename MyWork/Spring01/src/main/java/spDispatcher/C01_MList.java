package spDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import service.MemberService;

public class C01_MList implements Controller {
	
	//MemberService service = new MemberService();
	@Autowired
	MemberService service;
	
    @Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	//MemberList
    	ModelAndView mv = new ModelAndView();
    	// => Model 과 View 를 전달하는 객체
    	mv.addObject("banana",service.selectList());
    	mv.setViewName("member/memberList");
    	return mv;
	}	
	public String handleRequest11(HttpServletRequest request, HttpServletResponse response) {
		// MemberList
		MemberService service = new MemberService();
		request.setAttribute("banana", service.selectList());
		return "member/memberList";
	}
}
