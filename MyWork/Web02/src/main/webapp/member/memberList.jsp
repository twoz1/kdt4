<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web_MVC2 MemberList</title>
</head>
<body>
<h2>Web_MVC2 MemberList</h2>

<!-- MVC2_sDelete에 만든 message 부분 구현하기 -->
<hr>
<c:if test="${not empty requestScope.message}">
   ${requestScope.message} <br><hr>
</c:if>

<table border="1" style="width:90%">
   <tr bgcolor="pink">
      <th>Id</th>
      <th>Password</th>
      <th>Name</th>
      <th>Age</th>
      <th>Jno</th>
      <th>Info</th>
      <th>Point</th>
      <th>Birthday</th>
      <th>Rid</th>
      <th>Delete</th>
   </tr>
   <c:if test="${not empty requestScope.banana}">
      <c:forEach var="s" items="${requestScope.banana}">
         <tr>
            <td>${s.id}</td>
            <td>${s.password}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.jno}</td>
            <td>${s.info}</td>
            <td>${s.point}</td>
            <td>${s.birthday}</td>
            <td>${s.rid}</td>
            <td align="center"><a href="/Web01/delete?sno=${s.id}">삭제</a></td>
         </tr>
      </c:forEach>
   </c:if>
   <c:if test="${empty requestScope.banana}">
      <tr>
         <td colspan="7">출력할 Data 가 1건도 없습니다.</td>
      </tr>
   </c:if>
</table>

<hr>
&nbsp; <a href="/Web02/index.jsp">home</a> <br>

</body>
</html>