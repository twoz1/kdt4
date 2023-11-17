package com.example.demo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

// ** MemberController
// => SpringBoot JPA , JSP사용, 계층적 uri 적용
// => 기본적 CRUD 구현

@Controller
@RequestMapping("/member")
@Log4j2  //@Log4j -> Boot 에서는 2015년 이후 지원중단
@AllArgsConstructor // 모든 맴버변수 생성자 주입하므로 각각 @Autowired 할 필요없음
public class MemberController {

   MemberService service;
   PasswordEncoder passwordEncoder;


   // ** ID 중복확인
   @GetMapping("/idDupCheck")
   public String idDupCheck(Member entity, Model model) {
      // 1) newID 확인
      if ( service.selectOne(entity.getId()) != null) {
         // => 존재 : 사용불가
         model.addAttribute("idUse", "F");
      }else {
         // => 없으면: 사용가능
         model.addAttribute("idUse", "T");
      }
      return "member/idDupCheck";
   }


   // ** MemberList
   @GetMapping("/memberList")
   public void memberList(Model model) {
      model.addAttribute("banana", service.selectList());
   }

   // ** MemberDetail
   @GetMapping(value ="/mdetail")
   public String mdetail(HttpServletRequest request, Model model, Member entity) {
      model.addAttribute("apple", service.selectOne(entity.getId()));

      if ( "U".equals(request.getParameter("jCode")) )
         return "member/memberUpdate";
      else return "member/memberDetail";
   } //mdetail

   // ** Member Login & Logout
   // => LoginForm : Get
   // => 계층적 url 적용 
   @GetMapping(value="/loginForm")
   public void loginForm() {
      // viewName 생략 
   }

   // => Login 처리 : Post
   @PostMapping(value="/login")
   public String login(HttpSession session, Model model, Member entity) {
      // ** 로그인 Service 처리
      // 1. 요청분석
      String password = entity.getPassword();
      String uri="redirect:/home"; 
      // "home" -> home.jsp (성공)
      // "redirect:home" -> home 을 재요청, 그러므로 HomeController 의 home 메서드로

      // 2. 서비스 처리
      entity=service.selectOne(entity.getId());

      if ( entity!=null && 
            passwordEncoder.matches(password, entity.getPassword()) ) {   
         session.setAttribute("loginID", entity.getId());
         session.setAttribute("loginName", entity.getName());
      }else {
         uri="member/loginForm";
         model.addAttribute("message", "로그인 실패! 다시 하세요 ~~");
      }
      return uri;
   } //login_Post

   // => Logout
   // => session 무효화, home으로 
   @GetMapping(value="/logout")
   public String logout(HttpSession session, Model model, RedirectAttributes rttr) {

      session.invalidate();
      rttr.addFlashAttribute("message", "~~ 로그아웃 성공 ~~");
      return "redirect:/home";
   } //logout

   // ** Join 기능
   // => JoinForm: GET
   @GetMapping(value="/memberJoin")
   public void memberJoin() {
      // viewName 생략 -> 요청명이 viewName 이 됨
   }

   // => Join Service 처리: POST
   @PostMapping(value="/join")
   public String join(HttpServletRequest request, 
         Member entity, Model model) throws IOException  {
      // 1. 요청분석 & Service
      // => 성공: 로그인유도 (loginForm 으로, member/loginForm.jsp)
      // => 실패: 재가입유도 (joinForm 으로, member/memberJoin.jsp)
      String uri="member/loginForm";

      // ** PasswordEncoder (암호화 적용)
      entity.setPassword(passwordEncoder.encode(entity.getPassword()));

      // ** MultipartFile ***********************
      String realPath = "D:\\twoz1_top\\twoz1\\MyWork\\Spring02\\src\\main\\webapp\\resources\\uploadImages\\";
      // => 기본 이미지 지정하기
      String file1, file2="resources/uploadImages/basicman4.png";

      // => 저장경로 완성
      MultipartFile uploadfilef = entity.getUploadfilef();
      if ( uploadfilef!=null && !uploadfilef.isEmpty() ) {
         // => image_File 을 선택함 -> 저장 (저장경로: relaPath+화일명)
         // 1.3.1) 물리적위치 저장 (file1)
         file1 = realPath + uploadfilef.getOriginalFilename(); //저장경로 완성 
         uploadfilef.transferTo(new File(file1)); //해당경로에 저장(붙여넣기)

         // 1.3.2) Table 저장경로 완성 (file2)
         file2 = "resources/uploadImages/" + uploadfilef.getOriginalFilename();
      } // Image 선택한 경우

      // 1.4) 완성된 경로를 dto 에 set
      entity.setUploadfile(file2);

      // 2. Service 처리
      try {
         log.info("** insert 성공 id => "+service.save(entity));
         model.addAttribute("message", "~~ 회원가입 성공!! 로그인후 이용하세요 ~~");
      } catch (Exception e) {
         log.info("** insert Exception => "+e.toString());
         model.addAttribute("message", "~~ 회원가입 실패!! 다시 하세요 ~~");
         uri="member/memberJoin";
      }

      // 3. View 
      return uri;
   } // Join_Post

   // ** Member Update
   // => 요청: home 에서 내정보수정 -> 내정보수정Form (memberUpdate.jsp) 출력
   // => 수정후 submit -> 수정 Service 
   //      -> 성공: detail
   //      -> 실패: 재시도 유도 (memberUpdate.jsp)
   @PostMapping(value="/mupdate")
   public String memberUpdate(HttpSession session,
         Member entity, Model model) throws IOException {

      // => 처리결과에 따른 화면 출력을 위해서 dto 의 값을 Attribute에 보관
      model.addAttribute("apple", entity);
      String uri="member/memberDetail";

      // ** password는 수정불가

      // *** ImageUpload 처리 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      MultipartFile uploadfilef = entity.getUploadfilef(); 
      // => new Image 를 선택한 경우에만 처리하면 됨 
      if ( uploadfilef!=null && !uploadfilef.isEmpty() ) {
         // => Image 재선택 MultipartFile 처리
         String realPath = "D:\\twoz1_top\\twoz1\\MyWork\\Spring02\\src\\main\\webapp\\resources\\uploadImages\\";

         // => 물리적위치에 저장 (file1)
         String file1 = realPath + uploadfilef.getOriginalFilename(); //저장경로 완성
         uploadfilef.transferTo(new File(file1)); // IO 발생: Checked Exception 처리  

         // => Table 저장경로 완성 (file2)
         String file2="resources/uploadImages/" + uploadfilef.getOriginalFilename();
         entity.setUploadfile(file2);
      } // Image 선택 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

      // => Service 처리
      try {
         log.info("** update 성공 id => " + service.save(entity));
         session.setAttribute("loginName", entity.getName());
         // => 이름을 수정한 경우 session 값 변경 
         model.addAttribute("message", "~~ 회원정보 수정 성공 ~~");
      } catch (Exception e) {
         log.info("** update Exception => "+e.toString());
         model.addAttribute("message", "~~ 회원정보 수정 실패 !! 다시 하세요 ~~");
         uri="member/memberUpdate";
      }

      return uri;
   } //memberUpdte

   // ** Member Delete: 회원탈퇴
   @GetMapping(value="/mdelete")
   public String mdelete(HttpSession session, Member entity, RedirectAttributes rttr) {

      String uri = "redirect:/home";

      try {
         log.info("** delete 성공 id => " + service.delete(entity.getId()));
         rttr.addFlashAttribute("message", "~~ 탈퇴 성공!! 1개월후 재가입 가능 합니다 ~~") ;   
         if ( ((String)session.getAttribute("loginID")).equals("admin") ) {
            // => 관리자에 의한 강제탈퇴 : memberList.jsp
            uri="redirect:memberList";
         }else {
            // => 본인탈퇴 : home.jsp, session 무효화 
            session.invalidate();
         }
      } catch (Exception e) {
         log.info("** delete Exception => "+e.toString());
         rttr.addFlashAttribute("message", "~~ 탈퇴 실패 ~~");
      }

      return uri;
   } // mdelete

} //class