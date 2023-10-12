package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** PageFlow 실습
//=> testForm: servletTestForm/flow02_TestForm.jsp

@WebServlet("/flow02")
public class Ex01_Flow02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Ex01_Flow02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청(request) 분석
		// => select 의 선택된 value의 값에 따라 uri 결정
		//    radio 의 선택값에 따라 Forward or Redirect 결정
		String pageCode = request.getParameter("page");
		String uri = "";
		if (pageCode.equals("1")) {
			uri="helloS" ;
		}else if (pageCode.equals("2")) {
			uri="lifecycle" ;
		}else if (pageCode.equals("3")) {
			uri="servletTestForm/form03_Check.jsp" ;
		}else if (pageCode.equals("4")) {
			uri="servletTestForm/form04_Select.jsp" ;	
		}else System.out.println("** PageCode 를 정확하게 선택하지 않음 ~~");	
		
		// => console 로 확인
		System.out.println("** flow02 Test **");
		
		// 2. Forward or Redirect
		// ** NullPointExeption 예방
		// => request.getParameter("send")가 값이 없는경우 NullPointExeption 발생 
		//    if ( "f".equals(request.getParameter("send")) )
		
		if (request.getParameter("send").equals("f")) {
			// Forward 이동 : 서버내에서 결과 웹 Page가 바뀜  
			request.getRequestDispatcher(uri).forward(request, response); 
		}else {
			// Redirect : 재요청 처리
			response.sendRedirect(uri);
		} 
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} //class
