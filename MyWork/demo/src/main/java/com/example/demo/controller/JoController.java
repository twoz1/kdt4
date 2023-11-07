package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.JoDTO;
import com.example.demo.service.JoService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;

//@Log4j
@RequestMapping(value="/jo")
@AllArgsConstructor
@Controller
public class JoController {
	
	//@Autowired
	JoService service;
	//@Autowired
	MemberService mservice;
	 
	// ** JoList
	@GetMapping(value="/joList")
	public void joList(Model model) {
		model.addAttribute("banana", service.selectList());
	} //joList
	
	// ** JoDetail
	// => 아랫쪽에 조원목록 출력 (추가기능) -> joDetail.jap 에 Member_List 출력 코드 추가  
	// => jo Table에서 selectOne  ->  apple 
	// => member Table에서 조건검색 jno=#{jno}  ->  banana 
	@GetMapping(value="/jdetail")
	public String jdetail(HttpServletRequest request, Model model, JoDTO dto) {
		
		String uri = "jo/joDetail";
		model.addAttribute("apple", service.selectOne(dto));
		// => 수정요청 시엔 수정폼으로 
		if ( "U".equals(request.getParameter("jCode")) )
			uri = "jo/joUpdate";
		
		// ** 조원목록 출력하기 추가
		// => MemberService 실행
		//	-> joList 메서드 추가 : service, DAO 
		//	-> 실행결과는 banana 로 
		model.addAttribute("banana", mservice.joList(dto.getJno()));
		
		return uri;
	} //jdetail
	
	// ** Jo_Insert
	// => joInsert 출력
	@GetMapping(value="/joInsert")
	public void joInsert() {
		// viewName 생략
	} //joInsert
	
	// => jo_insert 처리
	@PostMapping(value="/jinsert")
	public String jinsert(Model model, JoDTO dto, RedirectAttributes rttr) {
		// ** Insert Service 처리
		// => 성공: joList 로 redirect
		// => 실패: 재입력 유도 -> insert 폼 요청
		String uri="redirect:joList";
		
		if ( service.insert(dto)>0 ) {
			rttr.addFlashAttribute("message", "~~ Jo_Insert 성공 ~~");
		}else {
			model.addAttribute("message", "~~ Jo_Insert 실패 , 다시 하세요 ~~");
			uri="jo/joInsert";
		}
		
		// 3) View 처리
		return uri;
	} //jinsert	
	
	// ** Update
	@PostMapping(value="/jupdate")
	public String jupdate(HttpServletRequest request, Model model, JoDTO dto, RedirectAttributes rttr) {
		
		// ** Update Service 처리
		// => 성공: joList 로 redirect
		// => 실패: 재수정 유도 -> joUpdate 폼으로
		// => 그러므로 출력가능하도록 dto 를 setAttribute
		model.addAttribute("apple", dto);
		String uri="redirect:joList";
		
		if ( service.update(dto)>0 ) {
			// 수정성공 -> JList 로 redirect
			rttr.addFlashAttribute("message", "~~ Jo 정보 수정 성공 ~~");
		}else {
			// 수정실패
			model.addAttribute("message", "~~ Jo 정보 수정 실패 , 다시 하세요 ~~");
			uri="jo/joUpdate";
		}
		
		// 3) View 처리
		return uri;
	} //jupdate
	
	// ** Delete
	@GetMapping(value="/jdelete")
	public String jdelete(JoDTO dto, RedirectAttributes rttr) {
		
		// ** Delete Service 처리
		// => 성공, 실패 : joList 로 redirect
		String uri="redirect:joList";
		if ( service.delete(dto)>0 ) {
			rttr.addFlashAttribute("message", "~~ Jo 삭제 성공 !!! ~~");
		}else {
			rttr.addFlashAttribute("message", "~~ Jo 삭제 실패 !!! ~~");
		}
		// 3) View 처리
		return uri;
	} //jdelete
	
} //class

