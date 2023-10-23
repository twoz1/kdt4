package com.ncs.green;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.MemberDTO;
import service.MemberService;
//** Bean 생성하는 @
//* Java : @Component
//* Spring 세분화 됨
//=> @Controller,  @Service,  @Repository
// 스프링 프레임웤 이 역할별로 객체를 인식할 수 있도록
//=> @Controller                                                                                                                                                                           
// -> interface 없이도 Controller 로 인식
// -> 오버라이딩 의무가 없어짐 (메서드명, 매개변수, 리턴값 자유) 
// -> 하나의 컨트롤러에 여러개의 메서드를 작성할수있고,
//    메서드 단위로 매핑 ( @RequestMapping )
// -> 일반적으로 Table 단위로 컨트롤러를 구현

@Controller
public class MemberController {
   
   @Autowired
   MemberService service;
   
   @RequestMapping(value = "/mlist", method = RequestMethod.GET)
   public String mlist(Model model) {
      
      model.addAttribute("banana", service.selectList());
      return "member/memberList";
   }
   
   // ** MemberDetail
   @RequestMapping(value = "/mdetail", method = RequestMethod.GET)
   public String mdetail(Model model, MemberDTO dto) {
     //dto.setId("검색id");
      model.addAttribute("apple", service.selectOne(dto));
      return "member/memberDetail";
   }
   // ** Member Login  & Logout
   // => LoginForm : Get
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String loginForm() {
      return "member/loginForm";
   }
   
   // => Login 처리 : Post
   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public String login(HttpSession session, Model model, MemberDTO dto) {
      // 로그인 Service 처리
      // => request 로 전달되는 id, password 처리:
      //    메서드 매개변수로 MemberDTO 를 정의해주면 자동 처리
      //   ( Parameter name 과 일치하는 setter 를 찾아 값을 할당해줌)
      String password = dto.getPassword();
      String uri = "redirect:home"; 
      // "home" : home.jsp(성공)
      // "redirect : home -> home 을 재요청, 그러므로 HomeController 의 home 메서드로
      
      // 2. 서비스처리
      // => id 확인
      // => 존재하면 Password 확인
      // => 성공 : id, name 은 session 에 보관, home.jsp 으로
      // => 실패 : 재로그인 유도
      dto = service.selectOne(dto);
      if (dto != null && dto.getPassword().equals(password)) {
         session.setAttribute("loginID",dto.getId());
         session.setAttribute("loginName",dto.getName());
      }else {
         uri = "member/loginForm";
         model.addAttribute("message", "로그인 실패 다시하세요.");
      }
      
      System.out.println("Login Post 처리 준비중");
      return uri;
      
   }
   
   // => LogOut
   // => session 무효화, home으로
   @RequestMapping(value = "/logout", method = RequestMethod.GET)
   public String logout(HttpSession session, Model model, RedirectAttributes rttr) {
      session.invalidate();
      //model.addAttribute("message", "로그아웃 성공");
      // => 단, request 에 보관한 값들은 사라지므로 위의 메세지 처리를 고려해야함.
      // => session 에 보관 ( 이미 logOut 경우 세션을 무효화 했으므로 500 발생 )
      // 그리고 session 무효화를 하지 않더라도 이 메시지는 사용후 삭제를 해야함
      // session.setAttribute("message", "로그아웃 성공");
      //=> 이렇게 redirect 하는 경우 메시지 처리등을 편리하게
      //   지원해주는 객체가 RedirectAttributes
      rttr.addFlashAttribute("message", "로그아웃 성공");
      return "redirect:home";
   }
   
   // Join 기능
   // joinform : GET
   @RequestMapping(value = "/join", method = RequestMethod.GET)
   public String memberJoin() {
      return "member/memberJoin";
   }
   // => Join Service 처리 : POST
   @RequestMapping(value = "/join", method = RequestMethod.POST)
   public String join(MemberDTO dto, Model model) {
      // 1. 요청분석 & Service
      // => 한글처리 필수 : filter 로 처리
      // => request Parameter 처리 : 매개변수로 MemberDTO 정의하면 자동으로 set
      // => 성공: 로그인유도 (loginForm 으로, member/loginForm.jsp)
      // => 실패: 재가입유도 (joinForm 으로, member/memberJoin.jsp)
      String uri = "member/loginForm";
      
      // 2. Service 처리
      if(service.insert(dto) > 0) {
         model.addAttribute("message" , "회원가입 성공 로그인 후 이용하세요.");
      }else {
         model.addAttribute("message" , "회원가입 실패 다시 하세요.");
         uri = "member/memberJoin";
      }
      
      // 3. View
      return uri;
   }// Join_Post
   
   // ** Member Update
   
   // ** Member Delete : 회원탈퇴
   // => 삭제대상 : Parameter로 전달, dto에 자동으로 set
   @RequestMapping(value = "mdelete", method = RequestMethod.GET)
   public String mdelete(HttpSession session, MemberDTO dto, Model model, RedirectAttributes rttr) {
	      
	      // 1) 본인 탈퇴
	      // 결과 : message(삭제 성공/실패), home.jsp, session 무효화
	      
	      // 2) 관리자 강제 탈퇴
	      // 결과 : message(삭제 성공/실패), memberList.jsp, 
	      
	      // => 본인탈퇴 or 관리자에 의한 강제탈퇴 구분이 필요
	      //    dto 의 id 와 session 의 loginID 와 같으면 본인탈퇴,
	      //     다르면서 session 의 loginID 값이 "admin" 이면 강제탈퇴
	      
	      String uri = "redirect:home";
	      if( service.delete(dto) > 0) {
	         rttr.addFlashAttribute("message", "탈퇴 성공 1개월 후 재가입 가능");
	         if( ((String)session.getAttribute("loginID")).equals("admin") ) {
	            // 관리자에 의한 강제탈퇴
	            uri = "redirect:mlist";
	         }else {
	            // 본인 직접 탈퇴
	            session.invalidate();
	         }
	      }else {
	         rttr.addFlashAttribute("message", "탈퇴 실패");
	      }
	      
	      return uri;
   }//mdelete
   
   
}