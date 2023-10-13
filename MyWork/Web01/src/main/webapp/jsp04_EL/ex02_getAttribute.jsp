<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Scope, Attribute</title>
<%
// 1) 동일한 속성(Attribute)명을 모든 영역에 정의
// => 호출, 우선순위 
   pageContext.setAttribute("name", "pageContext Value1");
   request.setAttribute("name", "request Value1");
   session.setAttribute("name", "session Value1");
   application.setAttribute("name", "application Value1");
// 2) 로 다른 속성(Attribute)명을 모든 영역에 정의   
   pageContext.setAttribute("pname", "pageContext Value2");
   request.setAttribute("rname", "request Value2");
   session.setAttribute("sname", "session Value2");
   application.setAttribute("aname", "application Value2");

// 3) 연산자 Test 
// => request 영역에 속성(Attribute) 2개 만들고 활용 Test
   request.setAttribute("num1", 123);
   request.setAttribute("num2", 456);
%>
</head>
<body>
<h2>** EL Scope , Attribute **</h2>
<pre>
1) 동일한 속성(Attribute)명을 모든 영역에 정의
   => 호출, 우선순위 
   => el 내부에 변수명이 오면 속성(Attribute) 의 이름으로 인식
<b>   
      \${name} => ${name} 
      => 좁은범위(가까운곳) 부터 넓은 범위로 적용됨 
      => EL에 속성의 이름을 적용하면 해당 속성의 값이 출력됨 
      => 모두 구별하여 출력 하려면 해당되는 영역을 속성명 앞에 붙여서 적용
         (앞의 객체명이 생략 된것임)  
      \${page_name} => ${pageScope.name} 
      \${request_name} => ${requestScope.name} 
      \${sessionS_name} => ${sessionScope.name} 
      \${application_name} => ${applicationScope.name} 
   
<hr>  
2) 서로 다른 속성(Attribute)명을 모든 영역에 정의
   => 속명만 사용해서 출력가능
   => 그러나 영역(Scope)을 붙여주는것이 효율적 (direct로 찾으므로)
   \${pname} => ${pname} 
   \${rname} => ${rname} 
   \${sname} => ${sname} 
   \${aname} => ${aname} 


<hr>  
3) 연산자 Test 
=> request 영역에 속성(Attribute) 2개 만들고 활용 Test
3.1) Java
<% int n1 = (Integer)request.getAttribute("num1");
   int n2 = (Integer)request.getAttribute("num2");%>
   <%=n1%>+<%=n2%>=<%=n1+n2%>
   
3.2) EL
	${requestScope.num1}+${requestScope.num2}=${num1+num2} <br>
	
3.3) Parameter: Java
<% 
n1=Integer.parseInt(request.getParameter("num1"));
n2=Integer.parseInt(request.getParameter("num2"));
%>
<%=n1%>+<%=n2%>=<%=n1+n2%>

3.4) Parameter:EL
 ${param.num1} + ${param.num2}=${param.num1+param.num2} <br>
 
</b></pre>
</body>
</html>