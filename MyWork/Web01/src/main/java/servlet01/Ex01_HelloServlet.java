package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** 톰켓10 사용시 주의사항
//=> Java 8 까지 지원
//=> 문제가 많아 실무에서 잘 안쓰임
//=> javax.servlet을 지원안함.
//그러므로 javax -> jakarta 로 변경
//=> 실습: 톰켓9

//** Servlet 계층도
//=> Object -> interface : Servlet, ServletConfig, java.io.Serializable 
//         -> GenericServlet (A) -> HttpServlet (A) 

//  public abstract class HttpServlet extends GenericServlet {...}
//  public abstract class GenericServlet implements Servlet, ServletConfig,
//                               java.io.Serializable {...}

//** Servlet 의 실행방식
//=> 클라이언트의 요청에 자동반응하는 이벤트 드리븐 방식으로 작동
//=> 요청방식 이 Get -> doGet , Post -> doPost

//** url 매핑 네임
//=> url 배열 형태로 복수 선언가능
//=> 그러나 프로젝트 전체 기준 중복되면 안됨 : server Start 안됨. 
//=> 숫자, 한글 사용시 오류는 없으나 비추
//=> xml 로 설정가능 (web.xml 설정화일)
//=> @ , xml 모두 사용가능하지만 매핑네임 중복은 허용하지않음  

//@WebServlet(urlPatterns = { "/helloS","/안녕","/77","/7seven", "/seveb7" })
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
