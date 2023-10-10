package servlet01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//** Get
//- request 의 header 영역의 url 뒤에 쿼리스트링으로 전달,
//- 일반적으로 256 byte 이내로 크기제한이 있는 것으로 알려져 있으나,
//이 용량은 브라우져 또는 장비에 따라 다를수 있음
//- 결론은 이미지 등 무거운 자료의 전송은 대부분 불가능 하므로 이때는 post로 해야함.  

//** Post
//- request 의 body 영역에 담겨져 전달됨
//- 크기제한 없음, 보안성 유리 

@WebServlet("/getpost")
public class Ex03_GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex03_GetPost() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // ** 요청분석
	      // => 한글처리
	      //   - getParameter 전에 해야함
	      //   - Tomcat(WAS) 은 Get 방식요청에서는 "UTF-8" 을 default 로 적용함 
	      //   ( html 문서에서 "UTF-8" 작성되었고 , Get 방식으로 전송되면 생략가능
	      //     단, post 방식에서는 반드시 처리해야함 ) 
	      request.setCharacterEncoding("UTF-8");
	      // => Parameter 로 전달된 Data 처리
	      // => request.getParameter("...") 등등
	      //   - 해당하는 Parameter (id) 가 없으면 null 을 return \
	      //   - 단, Parameter (id) 는 존재하지만 값이 없는 경우와는 구별됨 (null 값이 아님 "") 

		String id=request.getParameter("id");
		String name=request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		// *출력(응답, response) 처리
	      // => 한글처리
	      // => 응답객체에 결과물 담기(출력객체 생성)
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		out.print("<html><body>");   //string 타입으로 print 선택
		out.print("<h2 style = 'color : blue;'>** Get_Post Test ** </h2>");
		out.print("<h2> 전달된 Data 확인 => </h2>");
		out.print("<h3>* id=" +id+"</h3>");
		out.print("<h3>* name=" +name+"</h3>");
		out.print("<h3>* age=" +age+"</h3>");
		out.print("</body></html>");

	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("** Post Test");
		doGet(request, response);
	}//doPost

}
