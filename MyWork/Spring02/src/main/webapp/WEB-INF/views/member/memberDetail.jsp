<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Spring Student Detail **</title>
</head>
<body>
<h2>** Spring Student Detail **</h2>
   <table>
   <c:if test="${not empty requestScope.apple}">
      <tr height="40">
         <th bgcolor="thistle">ID
         </th>
           <td>${requestScope.apple.id}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Password
         </th>
           <td>${requestScope.apple.password}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Name
         </th>
           <td>${requestScope.apple.name}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Age
         </th>
           <td>${requestScope.apple.age}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Jno
         </th>
           <td>${requestScope.apple.jno}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Info
         </th>
           <td>${requestScope.apple.info}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Point
         </th>
           <td>${requestScope.apple.point}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">Birthday
         </th>
           <td>${requestScope.apple.birthday}</td>
      </tr>
      <tr height="40">
         <th bgcolor="thistle">추천인
         </th>
           <td>${requestScope.apple.rid}</td>
      </tr>
   </c:if>   
   <c:if test="${empty requestScope.apple}">
      <tr>
        <td colspan="2">~~출력할 자료가 없습니다.</td>
      </tr>
   </c:if>
   </table>
   <hr>
   &nbsp; <a href="javascript:history.go(-1)">이전으로</a>
    &nbsp; <a href="/green/home">Home</a> <br>
   
</body>
</html>