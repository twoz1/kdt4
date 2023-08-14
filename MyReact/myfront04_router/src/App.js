// 🤍 Router 적용하기 
// => 마치 Page 가 이동하는것처럼 url 에 의해 
//    적당한 컴포넌트가 배치 되도록 해줌

// ** Routing
// => 경로를 지정하는 과정
// ** Page Routing
// => 요청에 따라 적절한 페이지를 반환하는 과정
// => 이때 웹 페이지를 어디서 만드느냐에 따라 
//    SSR(Server Side Rendering), CSR(Client Side Rendering) 로 나뉘며,
//    리액트는 SPA(Single Page Application) 이며 CSR 방식을 채택하고 있다.
// => 두 방법 모두 장단점이 있으므로 서비스의 목적에 따라 적절한 방식을 채택한다.
// => CSR 은 처음접속시 Html 과 JS 에플리케이션을 함께 제공받기 때문에 처음접속은 느리지만,  
//    이후 페이지 이동은 브러우저에서 교체하므로 훨씬 빠르다. 

// 1. 프로젝트 root 경로에 리액트 라우터 설치
// => npm install react-router-dom
// => package.json 으로 버전확인 ( 6.x.x 인지 )
// => 구버전 제거 : npm uninstall react-router-dom
// => 최신버전 재설치 : npm install react-router-dom@6

// 2. Project 구성
// => src -> components, pages, images

// 3. 실습
// 1) BrowserRouter 컴포넌트
// => Router 적용하려는 최상위 컴포넌트를 감싸는 Rapper 컴포넌트
// => index.js 의 App 에 적용

// 2) Routes, Route 컴포넌트
// => Routes: Route 컴포넌트들을 감싸며 ( 6 이전버전의 Switch 가 변경됨)
// => Route : path, element_path에 해당하는 컴포넌트
// => a_href : page가 리로드 됨
// => Link_to : Page 가 리로드 되지않도록 해줌 (SPA 구현에 적합)
// => NavLink_to
//    - 사용자가 어느 페이지에 위치하는지 알 수 있도록 해줌
//    - 개발자도구 elements Tab 에서 확인해보면 class="active" 속성 추가되어있음
//    - App.css 에 아래코드 추가후 확인
//      .active {
//          background-color: tomato;
//          text-decoration: none;
//       }

// 3) HashRouter 컴포넌트
// => url 에 # 을 추가해 어떤 Path 에서 접근 하더라도
//    동일한 웹Page 를 제공할 수 있도록 해줌
// => BrowserRouter 와 비교해본다 

// 4) Nested Routing
// => Topics.jsx

// ** 버전 6 달라진점
// => Switch -> Routes
// => path 매칭 규칙
//    앞부분만 일치(exact 옵션사용) -> 정확히 일치 (exact 옵션사용불가)

import logo from './logo.svg';
import './App.css';
import Contact from './pages/Contact';
import Home from './pages/Home';
import Topics from './pages/Topics';
import {NavLink,Link, Route,Routes} from 'react-router-dom';


function App() {
  return (
    <div className="App">
      <h2>🤍React Router Dom Test🤍</h2>
      {/* 1) 적용 전 */}
      {/* <Contact/> */}
      {/* <Home/> */}
      {/* <Topics/> */}

      {/* 2) a_href : page 가 리로드 됨 */}

      {/* 3) Link : page가 리도드 되지 않음(SPA구현에 적합) */}
      
      {/* <ul>
        <li><Link to="/">Home</Link></li>
        <li><Link to="/topics">Topics</Link></li>
        <li><Link to="/contact">Content</Link></li>
      </ul>
      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/topics' element={<Topics/>}/>
        <Route path='/contact' element={<Contact/>}/>
      </Routes> */}

      {/* 4) NavLink_to */}
      {/* 사용자가 어느 페이지에 위치하는지 알 수 있도록 해줌 */}
      <ul>
        <li><NavLink to="/">Home</NavLink></li>
        <li><NavLink to="/topics">Topics</NavLink></li>
        <li><NavLink to="/contact">Content</NavLink></li>
      </ul>

      <Routes>
        <Route path='/' element={<Home/>}/>
        <Route path='/topics' element={<Topics/>}/>
        <Route path='/contact' element={<Contact/>}/>
      </Routes>

    </div>

  );
}

export default App;
