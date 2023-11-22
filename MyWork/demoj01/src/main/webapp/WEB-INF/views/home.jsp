<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta cahrset="UTF-8">
   <title>Home</title>
   <link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
</head>
<body>
<h1>
   Hello SpringBoot JPA !!  
</h1>

<P> * Server_Time : ${serverTime}. </P>
<hr>
<c:if test="${not empty sessionScope.loginID}">
   =>${sessionScope.loginName}님 안녕하세요 <br>
</c:if>
<c:if test="${not empty requestScope.message}">
   =>${requestScope.message} <br>
</c:if>
<hr>
<img alt="mainImage" src="/resources/images/jingjing.gif" width="500" height="500">
<hr>
<!-- Login 전 -->
<c:if test="${empty sessionScope.loginID}">
  &nbsp; <a href="member/loginForm">LoginF</a>  &nbsp;   <!-- get으로 요청 -->
  &nbsp; <a href="member/memberJoin">JoinF</a>  &nbsp;
</c:if>
<!-- Login 후 -->
<c:if test="${not empty sessionScope.loginID}">
  &nbsp; <a href="member/logout">Logout</a>  &nbsp;
  &nbsp; <a href="member/mdetail?id=${sessionScope.loginID}">내정보</a>  &nbsp;
  &nbsp; <a href="member/mdetail?jCode=U&id=${sessionScope.loginID}">내정보수정</a>  &nbsp;
  &nbsp; <a href="member/pUpdateForm">비밀번호수정</a>  &nbsp;
  &nbsp; <a href="member/mdelete?id=${sessionScope.loginID}">탈퇴</a>  &nbsp;
</c:if>
<br>
 &nbsp; <a href="member/memberList">mList</a>  &nbsp;
 &nbsp; <a href="board/boardList">bList</a>  &nbsp;
 &nbsp; <a href="board/bcriList">bcriList</a>  &nbsp;
 &nbsp; <a href="jo/joList">jList</a><br>
 &nbsp; <a href="/ginsert">GSave</a>&nbsp;
 &nbsp; <a href="/guestlist">GList</a>&nbsp;
 &nbsp; <a href="/gupdate">GUpdate</a>&nbsp;
 &nbsp; <a href="/gpagelist">GPageList</a>&nbsp;

</body>
</html>