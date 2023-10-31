<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring_MVC2 MemberUpdate</title>
<script src="/Spring02/resources/myLib/jquery-3.2.1.min.js"></script>
</head>
<body>
<h2>Spring_MVC2 MemberUpdate</h2>

<form action="pwupdate" method="post" enctype="multipart/form-data">
	<table>
		<c:if test="${ not empty requestScope.apple }">
			<tr height="40">
         <th bgcolor="thistle">ID
         </th>
           <td>${requestScope.apple.id}</td>
      </tr>
			<tr height="40">
				<th bgcolor="khaki">Password</th>
				<td><input type="password" name="password"  size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="khaki">재확인</th>
				<td><input type="password" name="password"  size="20"></td>
			</tr>
			<tr height="40">
				<th></th>
				<td>
					<input type="submit" value="수정"> &nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</td>
			</tr>
		</c:if>
	</table>
</form>

<hr>

<c:if test="${not empty requestScope.message}">
	${requestScope.message}
</c:if>

<hr>

&nbsp; <a href="/Spring02/home">home</a>&nbsp;
&nbsp; <a href="javascript:history.go(-1)">이전</a>&nbsp;

</body>
</html>