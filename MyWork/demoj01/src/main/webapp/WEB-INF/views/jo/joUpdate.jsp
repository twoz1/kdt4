<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="/Spring02/resources/myLib/myStyle.css">
<title>SpringBoot BoardUpdate</title>
</head>
<body>
<h2>SpringBoot BoardUpdate</h2>

<form action="jupdate" method="post">
	<table>
		<c:if test="${ not empty requestScope.apple }">
			<tr height="40">
				<th bgcolor="chocolate">Jno</th>
				<td><input type="text" name="jno" value="${requestScope.apple.jno}" size="20" readonly></td>
			</tr>
			<tr height="40">
				<th bgcolor="chocolate">Jname</th>
				<td><input type="text" name="jname" value="${requestScope.apple.jname}" size="20" ></td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">ID</th>
				<td><input type="text" name="id" value="${requestScope.apple.id}" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="pink">Project</th>
				<td><input type="text" name="project" value="${requestScope.apple.project}" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="chocolate">Slogan</th>
				<td><input type="text" name="slogan" value="${requestScope.apple.slogan}" size="20"></td>
			</tr>
			<tr height="40">
				<th></th>
				<td>
					<input type="submit" value="수정"> &nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</c:if>
		
		<c:if test="${empty requestScope.apple}">
			<tr height="40">
				<td>수정할 자료가 존재하지 않습니다.</td>
			</tr>
		</c:if>
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