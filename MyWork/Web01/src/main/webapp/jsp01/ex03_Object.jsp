<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>**JSP Object**</h2>
<pre>
=> Web 애플리케이션 기본 객체(implicit object)
=> JSP에서 별도 인스턴스 선언 없이 사용 가능
=> request, response, out, session, 
   pageContext, application 등 9종류
   
</pre>
<h3>1. Request</h3>

 *ContextPath => <%=request.getContextPath() %> <br>
 *RealPath => <%=request.getRealPath("/")%> <br>
 *RequestURI: <%=request.getRequestURI() %>
 
 <h3>2. Session</h3>
 Session_ID =<%=session.getId()%>
 
 <h3>3. out</h3>
 * out 출력 => <%out.print("out객체로 출력하기"); %>
 
 <h3>4. PageContext</h3>
=> JSP 페이지에 대한 정보를 저장한다.
=> 기본 객체를 return 하는 메서드를 제공.
   -> request 객체와 메서드가 return하는 객체와 동일성 비교<br>S
   
<%
   HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
%> <br>
   -> 비교결과 : <%= request == req %>
   -> pageContext 가 제공하는 out 객체로 출력하기
   <% pageContext.getOut().print("pageContext 가 제공하는 out 객체로 출력");%>

<h3>5. Application</h3>
* 서버정보 => <%= application.getServerInfo() %> <br>
* 서블릿 메이저버젼 => <%= application.getMajorVersion() %> <br>
* 서블릿 마이너버젼 => <%= application.getMinorVersion() %> <br>
* RealPath1 => <%= application.getRealPath("") %> <br> ("" 사용시에는 실행중인 현 프로젝트의 RealPath return) <br>
* RealPath2 => <%= application.getRealPath("/jsp01") %> <br> (지정한 경로의 RealPath) <br>
* -> HDD 상의 소스 위치가 아님 주의




</body>
</html>