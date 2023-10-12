package servlet02_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class Ex04_Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex04_Select() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1) 요청분석 
		// => 한글처리, Parameter처리 (Get 방식은 생략가능)
		request.setCharacterEncoding("UTF-8");
		
		// => job 단일선택 select
		String job=request.getParameter("job");
		
		// => interest 복수선택 select
		String[] interest = request.getParameterValues("interest"); 
		
		// 2) Service
		// 3) View 처리 : 연산결과 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** Select Test **</h2>");
		
		// => 선택여부를 확인하고 출력
		//	-> 선택하지 않아도 Parameter job는 존재, 그러나 Value는 없음
		//		(select Tag 확인해 보세요 ~~)
		if (job!=null && job.length()>0) {
			out.print("<h2>** 당신의 직업 => "+job+"</h2>");
		}else {
			out.print("<h2>** 당신은 직업을 선택하지 않았습니다. **</h2>");
		}
		
		out.print("<h2>** 당신의 관심분야 => </h2>");
		// => 아무것도 선택하지 않으면 Parameter 가 없음 ( null return )
		//    ( !=null 만 비교해도 가능함 ) 
		if ( interest!=null && interest.length>0 ) {
			// 선택
			for ( String s:interest ) {
				out.print(s+"<br>");
			}
		}else {
			out.print("<h2>~~ 선택 항목이 없음 ~~</h2>");
		}
		
		out.print("<br><br><h2><a href='javascript:history.go(-1)'>다시 입력하기</a></h2><br>");
	
	} //doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("* Post Test **");
		doGet(request,response);
	}//doPost	

}//class
