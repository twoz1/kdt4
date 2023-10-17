package servlet03_flow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvcTest.StudentDTO;
import mvcTest.StudentService;


@WebServlet("/login")
public class Ex04_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ex04_Login() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청분석
		//  => 한글 , request의 Parameter 처리
		request.setCharacterEncoding("UTF-8");
		int sno = 0;
		if(request.getParameter("sno") !=null && request.getParameter("sno").length()>0 ) {
			sno = Integer.parseInt(request.getParameter("sno"));
		}
		// sno을 입력하지 않으면 아무것도 없는 애를 integer로 바꾸라는 것이니 오류가 난다. 
		// 유효성 검사는 프론트에서 하긴 하지만 java에서도 대응하는 것이 좋다. 

		String name = request.getParameter("name");

		// 2. 서비스 처리
		// => Service, Dto 객체 생성
		// => sno로 확인 (selectOne 메서드)
		// => 존재하면 name 확인(DTO의 name과 Parameter로 전달된 name과 )

		StudentService service = new StudentService();
		StudentDTO dto = new StudentDTO();
		dto.setSno(sno);
		dto= service.selectOne(dto);
		//set은 data를 넣고 get은 data를 꺼내쓴다.
		// 개인정보 보호차원에서 요즘은 아이디,비밀번호가 틀렸는지 알려주지 않음
		String uri="";
		if(dto != null && dto.getName().equals(name)) { //String은 name으로 비교, == 이 아니라.
			// => dto 객체에는 해당학생의 정보가 모두 담겨있음.
			// => name의 일치 확인
			// => 성공 : index.jsp로
			// => ~~님 : index 화면에 항상 이름이 표시 되도록
			// => 그러므로 로그인 정보 보관 (session에) 
			request.getSession().setAttribute("loginName", name);
			request.getSession().setAttribute("loginID", sno);
			System.out.println("** 로그인 성공 ** "); //콘솔로그에 찍힘
		}else {
			// => 실패 : loginForm으로 (재로그인 유도)
			// => loginForm에 로그인 실패 다시 로그인 하세요 ~~~ 출력
			// String message = "로그인 실패 ! 다시 하세요 ~~~";
			// => 이러한 값들을 다른 서블릿 또는 jsp 문서와 공유하기 위한 방법이 Attibute 
			//    이 Attibute 값이 메모리에서 유지되는 시간이 4종류 -> Scope
			// => Scope 4종 : page < Request < Session < Application
			//    page는 page가 넘어가면 지워짐 넘 짧음 
			//    Request는 요청 들어 올 때 만들어지고 Response가 나갈 때 지워짐  
			//    Session 은 로그아웃할 때까지 메시지가 유지됨.
			//    Application은 서버가 종료될 때까지 계속 있음 서버가 운영되는 기간동안 
			//    따라서 가장 적절한 것은 request이다. 
			request.setAttribute("message", "로그인 실패 ! 다시 하세요 ~~~");
			uri="servletTestForm/flowEx04_LoginForm.jsp";
		}

		// 3. View (Response) : Forward
		request.getRequestDispatcher(uri).forward(request, response);
		//response.sendRedirect(uri);
	}//doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("** doPost 실행 ** ");
		doGet(request, response);
	}

}
