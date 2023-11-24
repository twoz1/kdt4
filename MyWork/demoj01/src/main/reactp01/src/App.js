import './App.css';
import React, { useState, useEffect } from 'react';
import axios from 'axios';

// ** useEffect ( myfront02_counterLF, App.js 참고 )
// => 어떤 값이 변경될때 마다 특정코드를 실행하는 리액트훅이며
//    이것을 "특정값을 검사한다" 라고 표현함
// => 예를 들면 State 값이 바뀔때 마다 변경된 값을 콘솔에 출력하게 할 수 있음

// => useEffect(callback_함수, [deps]_의존성 배열)
//    두번째 인자인 의존성 배열요소의 값이 변경되면 첫번째 인자인 콜백함수를 실행함 
//    - 조건값이 없는(두번째 인자를 사용하지 않음) 경우 : 랜더링 할때마다 호출됨
//    - 조건값으로 빈배열 사용하면 마운트시점에만 (처음한번만) 콜백함수 실행
//      (그러므로 Mount 제어에 이용)     

function App() {
  const [data, setData] = useState('');

  // => 실행과 동시에 처음 한번 서버요청
  useEffect(() => {
    axios
      .get('/rest/checkdata')
      .then((response) => {
        setData(response.data);
        console.log(`** checkdata 서버연결 성공 => ${response.data}`);
      }).catch((err) => {
        alert(`** checkdata 서버연결 실패 => ${err.message}`);
      });
  }, []);

  return (
    <div className="App">

      from Server Data : {data}

    </div>
  );
}

export default App;