"use strict"

// Ajax_REST API Join Test

// => 1) joinForm 요청
// => Request : jQuery, MemberController 의 memberJoin 활용
// => Response : Page 
// => window.jQuery 객체 - > 줄여서 window 생략하고 $ 기호로 표현

function axiJoin() {
   // 1) Data 준비
   // =>  JS의 내장객체 FormData에 담아서 전송
   let formData = new FormData(document.getElementById('myform'));
   
   // 2) axios 요청
   let url = "/rest/rsjoin";
   
   axios.post( 
      url, 
      formData, 
      {headers: {"Content-Type": "multipart/form-data"}      
   }).then(response => {
      alert(`response.data: ${response.data}`);
      location.reload(); // 화면 새로고침
   }).catch(err => {
      if (err.response.status === '502') alert("error try again!");
      else alert("system error! try again later" + err.message);
   })
   document.getElementById('resultArea2').innerHTML = "";
 
} // axiJoin


// => 2. get
// => 웹 Page (memberList) 요청 -> MemberController
function axiMList() {
   let url = "/member/axMemberList";
   axios.get(url
   ).then(response => {
      alert("** Response 성공 **");
      document.getElementById("resultArea1").innerHTML = response.data;
   }).catch(err => {
      alert(`** Response 실패 => ` + err.message);
   });
   
   document.getElementById("resultArea2").innerHTML="";
}//axiMList()

// => delete
// delete 요청: 경로에 Request_Data를 연결
//             /rest/axidelete/banana
function axiDelete(id) {
   let url = "/rest/axidelete/" + id;
   
   axios.delete(url
   ).then(response => {
      alert("삭제 성공: " + response.data);
      
      // ** 삭제 성공 후
      // => Delete -> Deleted, Gray_color, Bold로
      // => onclick 이벤트 제거
      // => Style제거 (removeclass, textLink)
      document.getElementById(id).innerHTML="Deleted";
      document.getElementById(id).style.color="Gray";
      document.getElementById(id).classList.remove('textlink');
      document.getElementById(id).removeAttribute('onclick');
      
      
   }).catch(err => {
      if (err.response.status == '502') alert("삭제 오류 다시 하세요! " + err.response.data);
      else alert("시스템 오류 " + err.message);
   })
   
}










