<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>** Hello JSP **</title>
</head>
<body>
<h2>** Hello JSP **</h2>
<h3>~안뇽하떼요~~</h3>
<h3>JSP 장점 : View 작성 간편</h3>
<h3>JSP 단점 : Java code 작성 불편</h3>
<h3>=> Java Code</h3>
<pre>
1) Scriptlet : 자바코드
2) Expression : 표현식 (출력문)
3) Declaration : 선언부 (메서드 등)
</pre>
<%! //Declaration : 선언부
	public int multiply(int a, int b){
	return a*b;
}

	String name = "곰돌이";
	int i = 100;
	int j = 200;
%>
=> 표현식 Test <br>
 => multiply(4,5)의 결과는 <%=multiply(4,5)%> <br>
 => 변수출력 : i=<%=i%>, j=<%=j%>, name=<%=name%> <br>
 => 연산적용 : i + j=<%=i+j %> <br>
 
 => Scriptlet : 자바코드 <br>
 <%int result = multiply(i,j);
 	name="Korea";
 %>
 => result=<%=result %><br>
 => name =<%=name %><br>
</body>
</html>

