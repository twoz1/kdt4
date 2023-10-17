<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>**Web_MVC2 StudentList**</title>
</head>
<body>
<h2>**Web_MVC2 StudentList**</h2>
<hr>
<c:if test="${not empty requestScope.message}">
=>${requestScope.message} <br> <hr>
</c:if>
<table border = "1" style = "width : 90%;">
<tr bgcolor="Pink">
<th>SNO</th>
<th>NAME</th>
<th>Age</th>
<th>Jno</th>
<th>Info</th>
<th>Point</th>
<th>Birthday</th>
<th>Delete</th>
</tr>
<c:if test="${not empty requestScope.banana}">
   <c:forEach var="s" items="${requestScope.banana}">
	<tr>
		<td>${s.sno}</td>
		<td>${s.name}</td>
		<td>${s.age}</td>
		<td>${s.jno}</td>
		<td>${s.info}</td>
		<td>${s.point}</td>
		<td>${s.birthday}</td>
		<td align="center"><a href="/Web01/delete?sno=${s.sno}">삭제</a></td>
	</tr>
   </c:forEach> 
</c:if>
<c:if test="${empty requestScope.banana}">
	<tr>
		<td colspan="7">출력할 데이터가 1건도 없습니다.</td>
	</tr>
</c:if>
</table>
&nbsp;<a href="/Web01/index.jsp">Home</a>
</body>

</html>