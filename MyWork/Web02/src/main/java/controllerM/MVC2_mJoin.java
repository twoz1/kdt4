package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;

@WebServlet("/join")
public class MVC2_mJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MVC2_mJoin() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int jno = Integer.parseInt(request.getParameter("jno"));
		String info = request.getParameter("info");
		double point = Double.parseDouble(request.getParameter("point"));
		String birthday = request.getParameter("birthday");
		String rid = request.getParameter("rid");
		
		MemberService service = new MemberService();
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setAge(age);
		dto.setJno(jno);
		dto.setPoint(point);
		dto.setBirthday(birthday);
		dto.setRid(rid);
		
	    // 2) 결과 처리
	      // => 성공 : 로그인 유도 (loginForm으로 -> "member/loginForm.jsp")
	      // => 실패 : 재가입 유도 (joinForm으로 -> "member/memberJoin.jsp")
	      String uri = "member/loginForm.jsp";
	      
	      if (service.insert(dto) > 0) {
	         // 성공
	         request.setAttribute("message", "회원가입이 완료되었습니다. 로그인 후 이용 바랍니다.");
	      } else {
	         // 실패
	         uri = "member/memberJoin";
	         request.setAttribute("message", "회원가입을 실패하였습니다. 재가입 바랍니다.");
	      }
	      
	      request.getRequestDispatcher(uri).forward(request, response);
	      
	      
	   } // doGet

	   protected void doPost(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	      doGet(request, response);
	   } // doPost

	}

