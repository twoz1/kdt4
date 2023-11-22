package com.example.demo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.GuestBookDTO;
import com.example.demo.domain.PageRequestDTO;
import com.example.demo.domain.PageResultDTO;
import com.example.demo.entity.GuestBook;
import com.example.demo.service.GuestBookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class HomeController {
   
   GuestBookService service;
   
   @GetMapping("/home")
   //@GetMapping(value={"/", "/home"})
   // => void : 요청명.jsp 를 viewName 으로 처리함 (home.jsp)
   //           그러므로 "/" 요청은 .jsp 를 viewName 으로 찾게됨(주의) 
   // => Boot 의 매핑메서드 에서 "/" 요청은 적용안됨(무시됨) 
   //     WebMvcConfig 의 addViewControllers 메서드로 해결
   public void home(Locale locale, Model model) {
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      String formattedDate = dateFormat.format(date);
      model.addAttribute("serverTime", formattedDate );
   } //home
   
   @GetMapping("/gpagelist")
   public String gpagelist() {
	   //1) request 준비
	   PageRequestDTO requestDTO = PageRequestDTO.builder()
			   .page(1).size(5).build();
	   // => 출력할 pageNo, Page당 출력할 row개수 입력
	   
	   //2) Service 처리
	   PageResultDTO<GuestBookDTO, GuestBook> resultDTO = 
			   service.gPageList(requestDTO);
	   
	   //3) view (Response)처리
	   
       for ( GuestBookDTO g:resultDTO.getDtoList() ) {
     	  System.out.println(g+", regDate:"+g.getRegDate()
           +", modDate:"+g.getModDate());
       }
      
      return "redirect:home" ;
   }//gpagelist
   
      @GetMapping("/ginsert")
      public String ginsert() {
         
         GuestBookDTO dto = GuestBookDTO.builder()
                  .title("JPA Test")
                  .content("Spring Boot Jpa Test")
                  .writer("admin")
                  .build();
         System.out.println("guest SAVE => "+service.register(dto));
         
         return "redirect:home" ;
      }
      
      @GetMapping("/guestlist")
      public String guestlist() {
         
          List<GuestBook> list = service.selectList(); 
          for ( GuestBook g:list ) {
        	  System.out.println(g+", regDate:"+g.getRegDate()
              +", modDate:"+g.getModDate());
          }
         
         return "redirect:home" ;
      }

      @GetMapping("/gupdate") 

      public String gupdate() {
         
         GuestBookDTO dto = GuestBookDTO.builder()
               .gno(9L)
               .title("가나다라")
               .content("스프링부트 Jpa Update Test")
               .writer("admin")
               .build();
         System.out.println("guest Update => "+service.register(dto));
         
         return "redirect:home" ;
      }
      
      @GetMapping("/gdetail")
      // => 퀴리스트링으로 Test : /gdetail?gno=2
      public String gdetail(Long gno) {
         System.out.println("gdetail => "+service.selectOne(gno));
         return "redirect:home" ;
      }
      
      @GetMapping("/gdelete")
      // => 퀴리스트링으로 Test : /gdelete?gno=3
      public String gdelete(Long gno) {
         try {
            service.delete(gno);
            System.out.println("** gdelete 삭제성공 **");
         } catch (Exception e) {
            System.out.println("** gdelete Exception => "+e.toString());
            // 자료가 없으면 org.springframework.dao.EmptyResultDataAccessException 발생확인
         }
         
         return "redirect:home" ;
      }

} //class