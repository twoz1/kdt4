package controllerM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberDTO;
import service.MemberService;


@WebServlet("/login")
public class MVC2_Login extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MVC2_Login() {
      super();
   }


   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 1. 요청분석
      // => 한글 , request의 Parameter 처리
      
      
      String id = request.getParameter("id");
      String password = request.getParameter("password");

      // 2. 서비스 처리
      // => Service, Dto 객체 생성
      // => sno로 확인 (selectOne 메서드)
      // => 존재하면 name 확인(DTO의 name과 Parameter로 전달된 name과 )

      MemberService service = new MemberService();
      MemberDTO dto = new MemberDTO();
      dto.setId(id);
      dto= service.selectOne(dto); // 의 결과에 따라
      
      String uri="";
      if(dto != null && dto.getPassword().equals(password)) {
         // => 성공 : index.jsp로
         // => 로그인정보(id, name) 보관(session에)
         request.getSession().setAttribute("loginName",dto.getName());
         request.getSession().setAttribute("loginID", id);
      }else {
         // => 실패 : loginForm으로 (재로그인 유도)
         request.setAttribute("message", "로그인 실패!! 다시 로그인하세요.");
         uri="member/loginForm.jsp";
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