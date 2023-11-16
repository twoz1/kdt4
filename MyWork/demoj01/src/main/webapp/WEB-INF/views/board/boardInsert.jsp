<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/Spring02/resources/myLib/myStyle.css">
<title>SpringBoot Board_Insert</title>
</head>
<body>
<h2>SpringBoot Board_Insert</h2>

<form action="binsert" method="post">
	<table>
		<tr height="40">
			<th bgcolor="violet">I D</th>
			<td><input type="text" name="id" value="${sessionScope.loginID}" readonly size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="violet">Title</th>
			<td><input type="text" name="title" size="48"></td>
		</tr>
		<tr height="40">
			<th bgcolor="violet">Content</th>
			<td>
				<textarea rows="5" cols="50" name="content"></textarea>
			</td>
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