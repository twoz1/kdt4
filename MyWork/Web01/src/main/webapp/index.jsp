<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>** Hello Dynamic Web_Project **</h2>
<%--
<%
   // String loginName= (String)request.getSession().getAttribute("name");
   // jsp에서는 request.getSession()을 session만 써도 가능
    if(session.getAttribute("loginName")!=null){ %>
       <%= session.getAttribute("loginName") %>님 안녕하세요 ~!
<%  }else{ %>
   로그인 후 이용하세요.
<%}
%>
--%>
<c:if test="${empty sessionScope.loginName}">
   로그인 후 이용하세요.
</c:if>
<c:if test="${!empty sessionScope.loginName}">
   ${sessionScope.loginName}님 안녕하세요~!
</c:if>

<hr>

<img src="./images/a1.png" width="400" height="300" alt="a1">
<hr>
<c:if test="${empty sessionScope.loginName}">
&nbsp;<a href="/Web01/servletTestForm/flowEx04_LoginForm.jsp">Login Form</a>
</c:if>
<c:if test="${!empty sessionScope.loginName}">
&nbsp;<a href="/Web01/logout">Logout</a> &nbsp;
&nbsp;<a href="/Web01/detail">Myinfo</a> <br>
</c:if>
&nbsp;<a href="/Web01/jsp99_MVCTest/mvc2_sJoin.jsp">Join</a> <br>
&nbsp;<a href="/Web01/helloS">Hello Servlet</a>
&nbsp;<a href="/Web01/lifeCycle">Servlet LifeCycle</a>
&nbsp;<a href="/Web01/flow01">Flow01</a>
&nbsp;<a href="/Web01/servletTestForm/flow02_TestForm.jsp">Flow02_Form</a><br>
&nbsp;<a href="/Web01/sessioni">SessionInfo</a>
&nbsp;<a href="/Web01/01set">Scope Test</a>
&nbsp;<a href="/Web01/list2">List2</a>

</body>
</html>