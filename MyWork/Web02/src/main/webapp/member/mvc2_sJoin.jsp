<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Web_MVC2 Student Join**</title>
</head>
<body>
<h2>** Web_MVC2 Student Join**</h2>
<form action="/Web01/join" method="get">
   <table>
		<tr height="40">
			<th bgcolor="aqua">Name</th>
			  <td><input type="text" name ="name" placeholder="한글 또는 영어" size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="aqua">Age</th>
			  <td><input type="text" name ="age" placeholder="숫자입력" size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="aqua">Jno</th>
			<td> <select name ="jno"  size="20">
			  <option value="1">1조 : 119조</option>
			  <option value="2">2조 : 여우조</option>
			  <option value="3">3조 : i4조</option>
			  <option value="4">4조 : 최고조</option>
			  <option value="5">5조 : 오조</option>
			  <option value="7">7조 : 관리팀</option>
			  </select>
			  <input type="text" name ="jno" placeholder="숫자입력" size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="aqua">Info</th>
			<td><input type="text" name ="info" placeholder="자기소개와 희망사항을 반드시 입력하세요" size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="aqua">Point</th>
			 <td><input type="text" name ="point" placeholder="실수" size="20"></td>
		</tr>
		<tr height="40">
			<th bgcolor="aqua">Birthday</th>
			 <td><input type="date" name ="birthday" size="20"></td>
		</tr>
		<tr height="40">
			 <td><input type="submit" value="가입"> &nbsp;&nbsp;&nbsp;
			 <input type="reset" value="취소">
			 </td>
		</tr>
	</table>

</form>
<hr>
<c:if test="${not empty message}">
 => ${message}
</c:if>
<hr>
&nbsp;<a href="javascript:history.go(-1)">이전으로</a>
&nbsp;<a href="/Web01/index.jsp">HOME</a>
</body>
</html>