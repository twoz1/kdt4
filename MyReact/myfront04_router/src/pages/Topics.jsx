// ** Nested Routing
// 1) 자식 page 1,2,3 추가 ( Topics01 ) 
// => App.js의 라우트 path "/topics/*" 로 수정

// 2) 배열로 목록 정의 ( Topics )
// 3) Topic 컴포넌트 추가

// ** useParams()
// => 현재 URL에 포함되어 있는 key, value 형식의 객체를 반환
//   예) path /test/3 으로 이동한 경우 params의 값 {id:'3'}을 확인할 수 있고
//      path /test/something 으로 이동한 경우 params의 값 {id:'something'} 확인가능
// => "/user/:id" 라는 라우트가 있다면 useParams 로 :id 파라미터를 가져올 수 있음

import { NavLink, Route, Routes, useParams } from "react-router-dom";

// 2) 배열로 목록 정의
const contents = [
  {id:1, title:'HTML', description:'HTML 은 재미있다...'},
  {id:2, title:'JavaScript', description:'JavaScript 는 더 재미있다...'},
  {id:3, title:'React', description:'React 는 흥미롭다...'}
]

// 3) Topic 컴포넌트 추가
function Topic() {
  const {params} = useParams();
  console.log('** params='+params);
  return (
      <div className="App">
          <h3>** Topic **</h3>   
          Topic.....
      </div>
  ); // return
}; //Topic


// -------------------------------------------------------
// ** ver02
function Topics() {
  return (
    <div>
      <h2>Topics</h2>
      <ul>
        {/* 2) map 적용 */}
        { contents.map((it) => {
              <li key={it.id}><NavLink to="/topics/{it.id}">{it.title}</NavLink></li>
        }) }
      </ul>
      <div>
        <Routes>
          <Route path="/:topic_id" element={<Topic />} />
           {/* 2) map 적용 
            => Route 도  1개로 공유, 출력할 element는  Topic 컴포넌트로
               요청에 따른 출력내용은 Topic 컴포넌트에서 판단
            => 그러므로 주소창에서 전달되는 url 을  변수로 받아야 되고 이것을 파라미터라 함
            => 그리고 파라미터 를 구별하기위해 앞쪽에 : 을 붙여줌  
               주소창에서 전달된 :topic_id 위치의 값이 
               element 속성에 정의된 Topic 컴포넌트에 인자로 전달됨 */}
        </Routes>
      </div>
    </div>
  ); //return
} //Topics

// ** ver01
function Topics01() {
  return (
      <div className="App">
          <h2>** Topics **</h2>   
          {/* 1) 자식 page 1,2,3 추가 */}
          <ul>
              <li><NavLink to="/topics/1">HTML</NavLink></li>
              <li><NavLink to="/topics/2">JavaScript</NavLink></li>
              <li><NavLink to="/topics/3">React</NavLink></li>
          </ul>
          <Routes>
              <Route path="/1" element={"HTML 은 재미있다..."} />
              <Route path="/2" element={"JavaScript 는 더 재미있다..."} />
              <Route path="/3" element={"React 는 신기하다..."} />
          </Routes> 

      </div>
  ); // return
}; //Topics01   

export default Topics;