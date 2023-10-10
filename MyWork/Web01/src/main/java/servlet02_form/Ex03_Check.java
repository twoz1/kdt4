package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class Ex03_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex03_Check() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석 
		// => 한글처리, Parameter처리
		request.setCharacterEncoding("UTF-8");
		
		// => CheckBox 처리
		//	-> 하나의 Name 에 복수개의 Value 들이 있음
		//	-> request.getParameterValues("gift") 를 이용해서 배열로 처리 		 
		
		String[] gift =	request.getParameterValues("gift");
		
		// 2) Service : add 연산
		// 3) View 처리 : 연산결과 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** CheckBox Test **</h2>");
		
		// => 선택여부를 확인 후 출력 
		if ( gift!=null && gift.length>0 ) {
			// 선택
			for (String s:gift) {
				out.print(s+"<br>");
			}//for
		}else {
			out.print("<h2>=> 선택항목이 없음</h2>");
		}//else
		
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");
	
	} //doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("* Post Test **");
		doGet(request,response);
	}//doPost	

}//class
