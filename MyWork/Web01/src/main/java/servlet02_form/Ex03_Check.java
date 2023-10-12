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
	      // => 한글처리
	      // => request Parameter 처리
	      request.setCharacterEncoding("UTF-8");
	      
	      String[] gift = request.getParameterValues("gift");
	   
	      // 2) Service 처리
	      // 3) 결과 (View) 처리
	      // => 한글처리, 출력객체 생성 & response 에 담기
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      out.print("<h2>** Check Test **</h2>");
	      
	      if(gift!=null && gift.length>0) {
	    	  for(String g : gift) {
		    	  out.print(g+"<br>");
		      }  
	      }else {
	    	  out.print("<h2> 선택항목 없음 </h2>");
	      }
	     
	      
	     

	}

	


}
