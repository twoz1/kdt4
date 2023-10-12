package servlet03_flow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ** getAttribute
//=> 전달된 Attribute들 확인

@WebServlet("/02get")
public class Ex03_02getAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex03_02getAttribute() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. getAttribute 처리
		// => request
		String rid=(String)request.getAttribute("rid");
		String rname=(String)request.getAttribute("rname");
		//int rage = (Integer)request.getAttribute("rage");
		// => "rage" 가 존재하지 않아 null 을 return 하면 Exception 발생
		//    그러므로 Test 를 위해 String 으로 처리
		String rage = (String)request.getAttribute("rage");
		
		// => session
		String sid=(String)request.getSession().getAttribute("sid");  
		String sname=(String)request.getSession().getAttribute("sname");  
		String sage=(String)request.getSession().getAttribute("sage");  
		
		// 2. View
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h2>** 1) Parameter 값 확인 **</h2>");
		out.print("<h3>=> request객체에 담겨있는 Parameter값이 유지되고 있는지 확인</h3>");
		out.print("<h3> I D  : "+request.getParameter("id")+"</h3>");
		out.print("<h3> Name : "+request.getParameter("name")+"</h3>");
		out.print("<h3> Age  : "+request.getParameter("age")+"</h3>");
		out.print("<h2>** 2) request.getAttribute 값 확인 **</h2>");
		out.print("<h3> rI D : "+rid+"</h3>");
		out.print("<h3> rName: "+rname+"</h3>");
		out.print("<h3> rAge : "+rage+"</h3>"); 
		out.print("<h2>** 3) session.getAttribute 값 확인 **</h2>");
		out.print("<h3> sI D : "+sid+"</h3>");
		out.print("<h3> sName: "+sname+"</h3>");
		out.print("<h3> sAge : "+sage+"</h3>"); 
		
	} //doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} //class
