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
<h2>SpringBoot MemberUpdate</h2>

<form action="mupdate" method="post" enctype="multipart/form-data">
	<table>
		<c:if test="${ not empty requestScope.apple }">
			
			<!-- id: 화면 출력, 서버로 전송, 수정은 불가( 즉, 입력 못하게 막기 )
					  -> readonly : 값이 서버로 전송 (권장)
					  -> disabled : 값이 서버로 전송되지 않음
			-->
			<tr height="40">
				<th bgcolor="brown">I D</th>
				<td><input type="text" name="id" value="${requestScope.apple.id}" size="20" readonly></td>
			</tr>
			
			<!-- password 수정 : 기본적으로 복호화가 불가능한 방식으로 암호화되어있기 때문에 별도로 처리 
			     	            -> 본인 재인증 후, 새암호를 발송 -> 새암호로 본인이 로그인 후 수정 
			<tr height="40">
				<th bgcolor="khaki">Password</th>
				<td><input type="password" name="password" value=${requestScope.apple.password} size="20"></td>
			</tr>
			-->
			
			<tr height="40">
				<th bgcolor="khaki">Name</th>
				<td><input type="text" name="name" value="${requestScope.apple.name}" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="khaki">Age</th>
				<td><input type="text" name="age" value="${requestScope.apple.age}" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="khaki">Jno</th>
				<td>
					<select name="jno">
						<option value="1" ${requestScope.apple.jno == 1 ? "selected" : ""} >1조: 119조</option>
						<option value="2" ${requestScope.apple.jno == 2 ? "selected" : ""} >2조: 여우조</option>
						<option value="3" ${requestScope.apple.jno == 3 ? "selected" : ""} >3조: I4조</option>
						<option value="4" ${requestScope.apple.jno == 4 ? "selected" : ""} >4조: 최고조</option>
						<option value="5" ${requestScope.apple.jno == 5 ? "selected" : ""} >5조: 오조</option>
						<option value="7" ${requestScope.apple.jno == 7 ? "selected" : ""} >7조: 관리팀</option>
					</select>
				</td>
			</tr>
			<tr height="40">
				<th bgcolor="khaki">Info</th>
				<td><input type="text" name="info" value="${requestScope.apple.info}" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="khaki">Point</th>
				<td><input type="text" name="point" value="${requestScope.apple.point}" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="khaki">Birthday</th>
				<td><input type="date" name="birthday" value="${requestScope.apple.birthday}" size="20"></td>
			</tr>
			<tr height="40">
				<th bgcolor="khaki">추천인</th>
				<td><input type="text" name="rid" value="${requestScope.apple.rid}" size="20"></td>
			</tr>
			<!-- Image Update 추가 
     			    => form Tag : method, enctype 확인
   			        => new Image 를 선택하는 경우 -> uploadfilef 사용
      			    => new Image 를 선택하지않는 경우 
      			      -> 본래 Image 를 사용 -> uploadfile 값이 필요함
   			-->   
			<tr height="40">
				<th bgcolor="khaki">Image</th>
				<td>
					<img alt="MyImage" src="/Spring02/${apple.uploadfile}" class="select_img" width="50" height="70">
					<input type="hidden" name="uploadfile" value="${apple.uploadfile}"><br>					
					<input type="file" name="uploadfilef" id="uploadfilef"size="20">
				</td>
			</tr>
			<script>
				document.getElementById('uploadfilef').onchange = function(e) {
					if (this.files && this.files[0]) {
						let reader = new FileReader;
						reader.readAsDataURL(this.files[0]);
						reader.onload = function(e) {
							$(".select_img").attr("src", e.target.result)
									.width(70).height(90);
						} // onload_function
					} // if   
				}; //change  -> }); JQ 사용시
			</script>
			
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