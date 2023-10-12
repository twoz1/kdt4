<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>** Hello Dynamic Web_Project **</h2>
<%
   if( session.getAttribute("loginName") != null ){ %>
      <%=session.getAttribute("loginName") %> 님 안녕하세요 ~~ <br>
<%   }else { %>
   로그인 후 이용하세요 <br>
<% }%> 

<hr>
<img src="./images/a2.png" width ="400" height="300">
<hr>
&nbsp;<a href="/Web01/servletTestForm/flowEx04_LoginForm.jsp">Login Form</a>
&nbsp; <a href="/Web01/helloS">HelloServelt</a> <br>
&nbsp; <a href="/Web01/lifecycle">ServletLF</a>
&nbsp;<a href="/Web01/helloS">Hello Servlet</a>
&nbsp;<a href="/Web01/lifeCycle">Servlet LifeCycle</a>
&nbsp;<a href="/Web01/flow01">Flow01</a>
&nbsp;<a href="/Web01/servletTestForm/flow02_TestForm.jsp">Flow02_Form</a><br>
&nbsp;<a href="/Web01/sessioni">SessionInfo</a>
&nbsp;<a href="/Web01/01set">Scope Test</a>
&nbsp;<a href="/Web01/logout">Logout</a>
</body>
</html>