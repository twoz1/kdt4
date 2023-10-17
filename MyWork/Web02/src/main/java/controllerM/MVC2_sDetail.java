package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class MVC2_sDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MVC2_sDetail() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청분석 & Service
		// => 검색 대상의 id(sno) 필요 (로그인시에 보관해둠)
		// => session에서 getAttribute
		int sno = (Integer)request.getSession().getAttribute("loginID");
		MemberService service = new MemberService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);
		dto = service.selectOne(dto);
		//2. View 준비
		//=> 결과를 View가 인식 가능하도록 setAttribute
		//=> Forward
		request.setAttribute("apple", dto);
		request.getRequestDispatcher("jsp99_MVCTest/mvc2_sDetail.jsp").forward(request, response);
		
	}

}
