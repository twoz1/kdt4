package controllerF;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

public class Ex05_MDetail implements Ex04_Controller {
	
	@Override
	public String doUser(HttpServletRequest request, HttpServletResponse response) {
		// ** Member Detail
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		dto.setId((String)request.getSession().getAttribute("loginID"));
		
		request.setAttribute("apple", service.selectOne(dto));
		return "member/memberDetail.jsp";
	} //doUser

} //class
