<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="/Spring02/resources/myLib/myStyle.css">
<title>**  member Login Test **</title>
</head>
<body>

<h2>** SpringBoot member Login Test **</h2>
<form action="login" method="post">
<table>
   <tr height="40">
   	  <td><label for="id">ID</label></td>
      <td><input type="text" id="id" name="id"></td>
   </tr>
   <tr height="40">
      <td><label for="password">Password</label></td>
      <td><input type="password" id="password" name="password"></td>
   </tr>
   <tr height="0"><td></td>
      <td>
         <input type="submit" value="로그인">&nbsp;&nbsp;
         <input type="reset" value="취소">
      </td>
   </tr>
</table>
</form>
<hr>

<c:if test="${not empty requestScope.message}">
message : ${requestScope.message}
</c:if>
<hr>

&nbsp; <a href="/home">Home</a>&nbsp;

</body>
</html>