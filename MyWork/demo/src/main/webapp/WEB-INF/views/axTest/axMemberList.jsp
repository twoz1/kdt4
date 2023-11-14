<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** SpringBoot Axios_MemberList **</title>
<link rel="stylesheet" type="text/css" href="/resources/myLib/myStyle.css">
<script src="/resources/myLib/axTest02.js"></script>
</head>
<body>
<h2>** SpringBoot Axios_MemberList **</h2>
<c:if test="${!empty requestScope.message}">
	=> ${requestScope.message}
</c:if>
<hr>
<table border=1 style="width:100%">
	<tr bgcolor="Lime">
		<th>Id</th>
		<th>Password</th>
		<th>name</th>
		<th>age</th>
		<th>jno</th>
		<th>info</th>
		<th>point</th>
		<th>birthday</th>
		<th>rid</th>
		<th>이미지</th>
		<th>이미지 다운로드</th>
		<c:if test="${sessionScope.loginID == 'admin'}">
			<th></th>
		</c:if>
		
	</tr>
	
	<c:if test="${not empty requestScope.banana}">
		<c:forEach var="m" items="${requestScope.banana}" >
			<tr>
				<td><span class="textlink" onclick="idbList('${m.id}')">${m.id}</span></td>
				<td>${m.password}</td>
				<td>${m.name}</td>
				<td>${m.age}</td>
				<td>${m.jno}</td>
				<td>${m.info}</td>
				<td>${m.point}</td>
				<td>${m.birthday}</td>
				<td>${m.rid}</td>
				<!-- 이미지 추가 -->
				<td><img src="/${m.uploadfile}" alt="UpImage" width="100px" height="100px"></td>
				<td><a href="download?dnfile=${m.uploadfile}">${m.uploadfile}</a></td>
				<!-- File Download ** 
		           => download 요청을 받으면 서버는 해당화일을 찾아 response 에 담아보내면,
		              웹브라우져가 받아 download 시켜줌 
		           => 최종적 처리를 웹브라우져가 해주기때문에 일반적으로 a Tag 로 처리함     
		              ( 즉, 비동기 처리_Ajax 를 하지 않음, 비동기처리에서는 response를 웹브라우져가 받지않기때문 )
		        -->
		        
		    	<!-- 관리자 delete 기능 : axios로 처리하기
		    		 => 삭제할 대상을 function에 전달 : 매개변수 활용
		    		    axiDelete('아이디')형식으로 들어가야 함
		    		  -->
				<c:if test="${sessionScope.loginID == 'admin'}">
					<td><span class="textlink" onclick="axiDelete('${m.id}')" id="${m.id}">삭제하기</span></td>
				</c:if> 
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty requestScope.banana}">
		<tr>
			<td colspan="7">출력할 Data가 없습니다.</td>
		</tr>
	</c:if>
</table>
<hr>
&nbsp;<a href="/home">Home</a>
</body>
</html>