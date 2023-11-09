// Ajax_REST API Test

// 1.1) rsLogin
// => form 출력
function rsLoginf() {
   let resultHtml = 
   `<table border=1 align=center width=80%>
      <caption><h3>** Ajax Login  **<h3></caption>
      <tr height="40">
         <td bgcolor="Aqua"><label for="id">ID</label></td>
         <td><input type="text" id="id" name="id"></td>
      </tr>
      <tr height="40">
         <td bgcolor="Aqua"><label for="password">Password</label></td>
         <td><input type="password" id="password" name="password"></td>
      </tr>
      <tr height="40"><td></td>
         <td><span class="textlink" onclick="rsLogin()">rsLogin</span>&nbsp;&nbsp;
             <span class="textlink" onclick="rsLoginJJ()">rsLoginJJ</span>&nbsp;&nbsp;
         <input type="reset" value="취소">
         </td>
      </tr>
   </table>
   `;
   document.getElementById('resultArea1').innerHTML=resultHtml;
}

// =============================================================================================

// => Login 기능 Service 요청처리
//    Ajax 요청처리, fetch 적용
// => @RestController, 계층적 uri 적용, Post 요청

function rsLogin() {
   let url="/rest/rslogin";
   
   fetch(url, {method:'Post',
            body:JSON.stringify({
                  id:document.getElementById('id').value,
                  password:document.getElementById('password').value
               }),
            headers:{'Content-Type' : 'application/json'}
         // => POST 요청에서는 반드시 headers 형식 작성 
           //    (JSON 포맷을 사용함을 알려줘야함)
   
   }).then(response => {
       // ** then 1 단계
        // => status 확인 -> Error catch 블럭으로 또는 Response Body-reading Data return
        // => Response Body의 Data-reading & return.
        
      if( !response.ok ) throw new Error(response.status);
      // => Error 임을 인지시켜 catch 블럭으로 
        //   - fetch는 네트워크 장애가 발생한 경우에만 promise를 거부(reject -> catch 블럭으로) 하므로,
        //     .then절(1단계) 에서 수동으로 HTTP 에러를 처리함.
        //     그러나 axios는 상태코드가 2xx의 범위를 넘어가면 거부(reject)함.
      
      return response.text();
      // => 서버에서 Text 형식으로 보냈으므로 text() 메서드 사용
      //    ( Type별로 Body-Reading method를 적용함 )
      
   }).then(responseData => {
      // then 2단계
      // => 1단계에서 return 한 Data 처리
      alert(`responseData =>  ${responseData}`);   
      location.reload();
      // => reload() 호출 구문 이전에 작성한 console message는 출력 안되므로 alert 사용함.
   }).catch(err => {
   
      console.error(`Error => ${err.message}`);
      if( err.message == '502') alert('id or password Error. retry');
      else alert('System Error');
   });

}

// =============================================================================================

// 1.3) rsLoginJJ
// => JSON -> JSON (성공시 id, name을 JSON 으로 전송)
function rsLoginJJ() {
   let url="/rest/rsloginjj";
   fetch(url, {method:'Post',
            body:JSON.stringify({
                  id:document.getElementById('id').value,
                  password:document.getElementById('password').value
               }),
            headers:{'Content-Type' : 'application/json'}
   }).then(response => {
      if( !response.ok ) throw new Error(response.status);
      return response.json();
      // => 서버에서 JSON 형식으로 보냈으므로 json() 메서드 사용
      // => UserDTO 를 사용했으므로 변수명 주의(id,username..)
      
   }).then(responseData => {
      alert(`responseData => id= ${responseData.id} , name=${responseData.username}`);   
      location.reload();
      
   }).catch(err => {
      console.error(`Error => ${err.message}`);
      if( err.message == '502') alert('id or password Error. retry');
      else alert('System Error');
   });

}//rsLoginJJ


