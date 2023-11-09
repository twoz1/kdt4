<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** AjaxTest Main Form **</title>
<script src="/resources/myLib/axTest01.js"></script>
</head>
<body>
<h2>** AjaxTest Main Form **</h2>

<hr>
<c:if test="${not empty sessionScope.loginID}">
   =>${sessionScope.loginName}님 안녕하세요 <br>
</c:if>
<c:if test="${not empty requestScope.message}">
   =>${requestScope.message} <br>
</c:if>
<hr>
&nbsp;<span class ="testlink" onclick="rsLoginf()">rsLogin</span>
&nbsp;<a href="/home">[Home]</a>
<hr>
<div id="resultArea1"></div>
<div id="resultArea2"></div>
</body>
</html>