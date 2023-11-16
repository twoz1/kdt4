<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringBoot Jo_Insert</title>
</head>
<body>
<h2>SpringBoot Jo_Insert</h2>

<form action="jinsert" method="post">
	<table>
		<tr height="40">
			<th bgcolor="green">Jno</th>
			<td><input type="text" name="jno" value="${sessionScope.Jno}"size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="green">Jname</th>
			<td><input type="text" name="jname" size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="green">I D</th>
			<td><input type="text" name="id" size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="green">Project</th>
			<td><input type="text" name="project" size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="green">Slogan</th>
			<td><input type="text" name="slogan" size="20"></td>
		</tr>
		<tr height="40">
			<th></th>
			<td>
				<input type="submit" value="등록"> &nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>

<hr>

<c:if test="${not empty requestScope.message}">
	${requestScope.message}
</c:if>

<hr>

&nbsp; <a href="/home">home</a>&nbsp;
&nbsp; <a href="javascript:history.go(-1)">이전</a>&nbsp;

</body>
</html>