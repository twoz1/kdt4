package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.MemberDTO;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

// ** MemberController
// => SpringBoot, JSP 사용 , 계층적 uri 적용 

@Controller
@RequestMapping("/member")
@Log4j2    // @Log4j -> Boot 애서는 2015년 이후 지원중단
@AllArgsConstructor //모든 멤버변수 생성자주입하므로 각각 @Autowired 할 필요없음
public class MemberController {

	MemberService service;
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/memberList")
	public void memberList(Model model) {
		model.addAttribute("banana", service.selectList());
		log.info("**MemberList**");
		
	}
	
	// ** MemberDetail
	
	@GetMapping(value = "/mdetail")
	public String mdetail(HttpServletRequest request, Model model, MemberDTO dto) {
		//dto.setId("검색id");
		model.addAttribute("apple", service.selectOne(dto));
		if( "U".equals(request.getParameter("jCode")) ) {
			return "member/memberUpdate";
		}else {
			return "member/memberDetail";
		}
	}

	// ===============================================================

	// ** Member Login  & Logout
	
	@GetMapping(value = "/loginForm")
	public void loginForm() {
		// viewName 생략 -> 요청명이 viewName 이 됨
	}

	// ===============================================================

	// => Login 처리 : Post

	@PostMapping(value = "/login")
	public String login(HttpSession session, Model model, MemberDTO dto) {

		String password = dto.getPassword();
		String uri = "redirect:/"; 
	
		dto = service.selectOne(dto);

		if(dto!=null &&
			passwordEncoder.matches(password, dto.getPassword())) {
			session.setAttribute("loginID",dto.getId());
			session.setAttribute("loginName",dto.getName());
		
		}else {
			uri = "member/loginForm";
			model.addAttribute("message", "로그인 실패 다시하세요.");
		}

		System.out.println("Login Post 처리 준비중");
		return uri;

	}

	// ===============================================================

	// => LogOut

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, Model model, RedirectAttributes rttr) {
		session.invalidate();
		rttr.addFlashAttribute("message", "로그아웃 성공");
		return "redirect:/";
	}

	// ===============================================================

	// Join 기능


	@GetMapping(value = "/memberJoin")
	public void memberJoin() {
		// viewName 생략 -> 요청명이 viewName 이 됨
	}

	// => Join Service 처리 : POST

	@PostMapping(value = "/join")
	public String join(HttpServletRequest request, MemberDTO dto, Model model) throws IOException {
		// 1. 요청분석 & Service
	
		String uri = "member/loginForm";
		
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
	
		String realPath = request.getRealPath("/");
		System.out.println("** realPath => " + realPath);
		
		// 1.2) 위의 값(realPath)을 이용해서 실제저장위치 확인

		if(realPath.contains(".eclipse"))  {// 개발중(배포전 : eclipse 개발환경)
			realPath = "D:\\twoz1_top\\twoz1\\MyWork\\Spring02\\src\\main\\webapp\\resources\\uploadImages\\";
		}else {
			realPath += "resources\\uploadImages\\";
		
		}
	
		
		File f1 = new File(realPath);
		if(!f1.exists()) {
			f1.mkdir();
			// => realPath 가 존재하지 않으면 생성
		}
		
		// => 기본이미지(basicman4.png)가 uploadImages 폴더에 없는경우 기본폴더(images) 에서 가져오기
		f1 = new File(realPath + "basicman4.png"); // uploadImages 폴더에 파일존재 확인을 위함
		if( !f1 .isFile() ) { // 존재하지 않는다면
			String basicImagePath 
					= "D:\\twoz1_top\\twoz1\\MyWork\\Spring02\\src\\main\\webapp\\resources\\images\\basicman4.png";
			FileInputStream fi = new FileInputStream(new File(basicImagePath));
			// => basicImage 읽어 파일 입력바이트스트링 생성
			FileOutputStream fo = new FileOutputStream(f1); 
			// => 목적지 파일(realPath + "basicman4.png") 출력바이트스트링 생성 
			FileCopyUtils.copy(fi, fo);
		}
		// => 기본 이미지 지정하기
		String file1, file2 = "resources/uploadImages/basicman4.png";

		// ** MultipartFile

		// 1.3) 저장경로 완성
		MultipartFile uploadfilef = dto.getUploadfilef();
		if( uploadfilef != null && !uploadfilef.isEmpty() ) {

			// 1.3.1) 물리적위치 저장 (file1)
			file1 = realPath + uploadfilef.getOriginalFilename(); // 저장경로 완성
			uploadfilef.transferTo(new File(file1)); // 해당경로에 저장(붙여넣기)
			
			// 1.3.2) Table 저장경로 완성 (file2)
			file2 = "resources/uploadImages/" + uploadfilef.getOriginalFilename(); 
		}
		// 1.4) 완성된 경로를 dto 에 set
		dto.setUploadfile(file2);
		
		// ==========================================================================
		
        // ** Transaction_AOP 적용 ********************* 
     
		
		// 2. Service 처리
		if(service.insert(dto) > 0) {  //Transaction_Test, insert2
			model.addAttribute("message" , "회원가입 성공 로그인 후 이용하세요.");
		}else {
			model.addAttribute("message" , "회원가입 실패 다시 하세요.");
			uri = "member/memberJoin";
		}

		// 3. View
		return uri;
	}

	// ===============================================================
	
	// Member Update

		@PostMapping(value="/mupdate")
		public String memberUpdate(HttpServletRequest request, 
								  MemberDTO dto, Model model) throws IOException {
			
			// => 처리결과에 따른 화면 출력을 위해서 dto 의 값을 Attribute에 보관
			model.addAttribute("apple", dto);
			String uri="member/memberDetail";
				
			MultipartFile uploadfilef = dto.getUploadfilef(); 
			// => new Image 를 선택한 경우에만 처리하면 됨 
			if ( uploadfilef!=null && !uploadfilef.isEmpty() ) {
				// => Image 재선택 MultipartFile 처리
				String realPath = request.getRealPath("/");
			
				// => 개발중인지, 배포했는지에 따라 실제저장위치 결정
				if(realPath.contains(".eclipse"))  {// 개발중(배포전 : eclipse 개발환경)
					realPath = "D:\\twoz1_top\\twoz1\\MyWork\\Spring02\\src\\main\\webapp\\resources\\uploadImages\\";
				}else {
					realPath += "resources\\uploadImages\\";
				}
				
				// => 물리적위치에 저장 (file1)
				String file1 = realPath + uploadfilef.getOriginalFilename(); //저장경로 완성
				uploadfilef.transferTo(new File(file1)); // IO 발생: Checked Exception 처리  
				
				// => Table 저장경로 완성 (file2)
				String file2="resources/uploadImages/" + uploadfilef.getOriginalFilename();
				dto.setUploadfile(file2);
			} // Image 선택 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			
			// => Service 처리
			if ( service.update(dto) > 0 ) {
				model.addAttribute("message", "~~ 회원정보 수정 성공 ~~");
			}else {
				model.addAttribute("message", "~~ 회원정보 수정 실패 !! 다시 하세요 ~~");
				uri="member/memberUpdate";
			}
			return uri;
		} //memberUpdte

		// ** PasswordUpdate
		// => passwordUpdate_Form 출력
		@GetMapping(value="/pUpdateForm")
		public void pUpdateForm() {

		} //pUpdateForm
		
		// => password 만 수정
		@PostMapping(value="/pwupdate")
		public String passwordUpdate(HttpServletRequest request, Model model, MemberDTO dto) {
			// ** password Update

			String id =(String)request.getSession().getAttribute("loginID");
			// ** id 가 존재하지 않는 경우 -> 로그인유도, 메서드종료
			if (id==null) {
				model.addAttribute("message", "~~ 로그인 정보가 없으니 로그인 후 하세요 ~~");
				return "member/loginForm";
			}
			// ** id 가 존재하는 경우 수정
			dto.setId(id);
			dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			
			String uri="member/loginForm";
			if ( service.update(dto)>0 ) {
				// password 수정성공, session 무효화, loginForm 으로
				request.getSession().invalidate(); 
				model.addAttribute("message", "~~ password 수정 성공, 재로그인 하세요 ~~");
			}else {
				// password 수정실패
				model.addAttribute("message", "~~ password 수정 실패 , 다시 하세요 ~~");
				uri="member/pUpdateForm";
			}
			// 3) View 처리
			return uri;
		} //passwordUpdate
		
	// ===============================================================

	// Member Delete : 탈퇴

	@GetMapping(value = "/mdelete")
	public String mdelete(HttpSession session, MemberDTO dto, Model model, RedirectAttributes rttr) {

		String uri = "redirect:/";
		if( service.delete(dto) > 0) {
			rttr.addFlashAttribute("message", "탈퇴 성공 1개월 후 재가입 가능");
			if( ((String)session.getAttribute("loginID")).equals("admin") ) {
				// 관리자에 의한 강제탈퇴
				uri = "redirect:memberList";
			}else {
				// 본인 직접 탈퇴
				session.invalidate();
			}
		}else {
			rttr.addFlashAttribute("message", "탈퇴 실패");
		}
		return uri;
	}
	
	// ** ID 중복확인
	@GetMapping("/idDupCheck")
	public String idDupCheck(MemberDTO dto, Model model) {
		// 1) newID 확인
		if(service.selectOne(dto) !=null) {
			// => 존재 : 사용불가
			model.addAttribute("idUse", "F");
		}else {
			// => 없으면 : 사용가능
			model.addAttribute("idUse", "T");
		}
		return "member/idDupCheck";
	}
	
	// ** Axios_MemberList
	   @GetMapping("/axMemberList")
	   public String axmemberList(Model model) {
	      model.addAttribute("banana", service.selectList());
	      log.info("** MemberList 성공 **");
	      return "axTest/axMemberList";
	   }

}
