<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** servlet03_flow Student Login Test **</title>
</head>
<body>
<h2>** servlet03_flow Student Login Test **</h2>
<form action="/Web01/slogin" method="get">
<table>
	<tr height="30"><td><label for="sno">SNO</label></td>
		<td><input type="text" id="sno" name="sno"></td>
	</tr>
	<tr height="30"><td><label for="name">Name</label></td>
		<td><input type="text" id="name" name="name"></td>
	</tr>
	<tr height="30"><td></td>
		<td><input type="submit" value="로그인">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>
<hr>
<%	if ( request.getAttribute("message") !=null ) {
	// message 출력 %>
	=> message: <%=request.getAttribute("message")%>
<%	} %>
</body>
</html>