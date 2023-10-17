<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** forTokens , PageFlow (import, redirect) **</title>
</head>
<body>
<h2>1. forTokens</h2>
<pre><b>
=> 구분자로 분리된 각각의 토큰을 처리할때 사용됨.
=> test 1.1) 단일 구분자
<c:forTokens var="city" items="서울,용인,성남, 대전, 동경, Paris, NewYork" delims=",">
	${city}
</c:forTokens>

=> test 1.2) 복수 구분자
<c:forTokens var="city" items="서울,용인#성남,대전,동경!Paris#NewYork,부산" delims=",#!">
	${city}
</c:forTokens>

<h2>2. import</h2>
=> directive: include -> 소스코드포함, 변수공유가능
=> jsp:include -> 웹Page포함, 변수공유 불가능
=> jstl:import -> 웹Page포함, 변수공유 불가능
============================================
<%-- <c:import url="ex02_ifForm.jsp" /> --%>
<c:import var="iform" url="ex02_ifForm.jsp" />
=> var 사용 Test
${iform}
============================================

<h2>3. redirect</h2>
=> response.sendRedirect() 와 동일
=> 웹브라우져의 주소창 url 이 변경됨
<%-- <c:redirect url="ex02_ifForm.jsp" /> --%>

<h2>4. url</h2>
=> Value 를 url로 인식 시켜줌_set 으로 정의해도 결과는 동일
=> test 4.1) a_Tag Link
<%-- <c:url var="utest" value="ex02_ifForm.jsp" /> --%>
<c:set var="utest" value="ex02_ifForm.jsp" />

* utest => ${utest}
<a href="${utest}">urlTest</a>

=> test 4.2) image
</b></pre>
<c:url var="iName" value="../images/aaa.gif" />
<img alt="urlTest" src="${iName}">

</body>
</html>