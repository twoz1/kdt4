<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring_MVC2 JoDetail **</title>
</head>
<body>
<h2>** Spring_MVC2 JoDetail **</h2>
   <table>
   <c:if test="${not empty requestScope.apple}">
      <tr height="40">
         <th bgcolor="thistle">Jno</th>
         <td>${requestScope.apple.jno}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Jname</th>
        <td>${requestScope.apple.jname}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Id</th>
         <td>${requestScope.apple.id}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Project</th>
        <td>${requestScope.apple.project}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Slogan</th>
        <td>${requestScope.apple.slogan}</td>
      </tr>
     
   </c:if>   
   <c:if test="${empty requestScope.apple}">
      <tr>
        <td colspan="2">~~출력할 자료가 없습니다.</td>
      </tr>
   </c:if>
   </table>
   
<c:if test="${not empty requestScope.message}">
	${requestScope.message}
</c:if>
   
   <hr>
   <!-- 로그인 한 경우 새글등록, 답글등록 --> 
   &nbsp; <a href="joInsert">new 조+</a>&nbsp;
   <!-- 로그인 id 와 글쓴이 id가 동일하면 수정과 삭제 가능 -->
   
       &nbsp; <a href="jdetail?jCode=U&jno=${requestScope.apple.jno}">글수정</a>&nbsp;
       &nbsp; <a href="jdelete?jno=${requestScope.apple.jno}">글삭제</a>&nbsp;

   <hr>   
   &nbsp; <a href="javascript:history.go(-1)">이전으로</a>
   &nbsp; <a href="/green/home">Home</a> <br>
</body>
</html>