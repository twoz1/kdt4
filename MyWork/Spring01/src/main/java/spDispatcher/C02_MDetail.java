package spDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import domain.MemberDTO;
import service.MemberService;

public class C02_MDetail implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      // ** Member Detail
      MemberService service = new MemberService();
      MemberDTO dto = new MemberDTO();
      dto.setId((String)request.getSession().getAttribute("loginID"));

      ModelAndView mv = new ModelAndView();
      mv.addObject("apple", service.selectOne(dto));
      mv.setViewName("member/memberDetail");
      return mv;
   }   
}
