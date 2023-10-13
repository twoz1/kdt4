<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL forEach begin, end, step Test</title>
</head>
<body>
<h2>** JSTL forEach begin, end, step Test **</h2>
<pre>
=> 구간반복: StartIndex(begin), LastIndex(end), 증감값(step) 적용하기
=> step 의 default 값은 1
=> 실습 1)
   1 ~ 10 까지를 다음처럼 출력하세요 ~~
   -> 1, 2, 3, .....10         
   -> java의 예 : for (int i=1; i<11; i++) { ......  }   
=> 결과
</pre>
<b>
<c:forEach var="i" begin="1" end="10" step="1" varStatus="vs">
    ${i}
    ${vs.last ? "" : ","}
</c:forEach>


<hr><pre>
=> 실습 2)
   1 ~ 10 중에서 짝수만, index, count 출력하기
   단, table 을 이용해서 출력하세요 ~~
   ex03_for01 의 table 과 비교해 보세요 ~~    
=> count : 반복횟수 
=> index : 배열등 index가 존재하는 경우에는 index 값을 출력
           반복자(iterator) 의 값   
           begin, step 을 지정하지 않으면 0 부터 1씩 증가     
</pre>
=>결과 1<br>
<table border="1" style="text-align:center; width:90%;">
   <tr style="background-color:pink;">
      <th>짝수</th>
      <th>index</th>
      <th>count</th>
   </tr>
   <c:forEach var="i" begin="1" end="10" step="1" varStatus="vs">
      <c:if test="${i % 2 == 0 }">
         <tr>
            <td>${i}</td>
            <td>${vs.index}</td>
            <td>${vs.count}</td>
         </tr>
      </c:if>
   </c:forEach>
</table>

<br>
=>비교 (조건: 2부터 2씩 증가)
<table border="1" style="text-align:center; width:90%;">
   <tr style="background-color:orange;">
      <th>짝수</th>
      <th>index</th>
      <th>count</th>
   </tr>
   <c:forEach var="i" begin="2" end="10" step="2" varStatus="vs">
      <tr>
         <td>${i}</td>
         <td>${vs.index}</td>
         <td>${vs.count}</td>
      </tr>
   </c:forEach>
</table>
<hr>
=> 실습 3) 1~30 을 다음처럼 1행에 5개씩 출력하세요~<br>

<c:forEach var="i" begin="1" end="30" >
   ${i}
<%--    <c:if test="${i%5!=0}">,</c:if>
      <c:if test="${i%5==0}"><br></c:if> --%>
   ${i%5==0 ? "<br>" : ","}
</c:forEach>
<hr>
=> Table (중첩 for 구문)<br>
<table>
   <c:forEach var="i" begin="1" end="26" step="5" >
   <tr align="right">
      <c:forEach var="j" begin="${i}" end="${i+4}" step="1">
         <td width="50">${j}</td>
      </c:forEach>
   </tr>
   </c:forEach>
</table>

<!-- 
1,2,3,4,5
6,7,8,9,10
11,12,13,14,15
...
............30 -->

</body>
</html>