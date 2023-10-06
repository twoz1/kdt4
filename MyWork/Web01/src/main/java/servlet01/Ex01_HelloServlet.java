package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/helloS" })
public class Ex01_HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex01_HelloServlet() {
        super();
    }
    
 

    // -> web에서 get요청 들어오면 자동 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// ** 출력문 (response 객체에 html 문서를 담아줌)
	    // => 출력객체 생성 -> html 문서작성
	    // => 한글처리 해야함 (출력객체 생성전에 해야함)
	    
	    response.setContentType("text/html; charset=UTF-8"); //한글을 쓸 수 있도록 하기 위해 추가 
	    // => 웹브라우져에게 처리할 데이터의 MIME 타입을 알려줌
	    // => MIME : Multipurpose Internet Mail Extensions
	    // => 데이터 송.수신시 자료의 형식에 대한 정보 
	    // => Jsp 의 page 디렉티브의 contentType 속성값과 동일
	    
	    response.getWriter().append("Served at: ")
	    					.append(request.getContextPath())
	    					.append("~~Hello servlet~~")
	    					.append("~~안녕 서블릿~~");
	    
	    PrintWriter out =  response.getWriter();
	    String name = "냥냥이";
	    out.print("<html><body>");   //string 타입으로 print 선택
	    out.print("<h2 style = 'color : blue;'>** Hello Servlet ** </h2>");
	    out.print("<h2> 안녕하다냐옹 ~~~ </h2>");
	    out.print("<h3>* name=" +name+"</h3>");
	    out.print("<h3>* Servlet 장점 : Java Code 매우 편리</h3>");
	    out.print("<h3>* Servlet 단점 : View Html 매우 불편</h3>");
	    out.print("</body></html>");
	}//doGet
  
	
	// -> web에서 post 요청 들어오면 자동 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost
	
}
