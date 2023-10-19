package myDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

public class C02_MDetail implements MyController {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// ** Member Detail
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		dto.setId((String)request.getSession().getAttribute("loginID"));

		request.setAttribute("apple", service.selectOne(dto));
		return "member/memberDetail";
	}
}

