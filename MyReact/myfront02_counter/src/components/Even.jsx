// 🤍클린업 함수
//    - useEffect 의 콜백함수에서 return 하는 함수
//    - 콜백함수를 재호출하기 전에 실행됨.
import { useEffect } from "react"
export default function Even() {
    // 🤍언마운트 제어하기 
    //    => useEffect의 콜백함수에서 콜백함수 return하도록 작성 
    //    => 이 콜백함수를 클린업 함수라하고 Even 컴포넌트가 리렌더링 되기 직전에 호출됨. 
    useEffect( ()=>{
        return()=>{console.log('** Even 컴포넌트 언마운트');}
    } );
    
    return <div>현재 count 값은 짝수입니다.</div> 
} //Even
//return의 괄호는 생략할 수 있음 -> return문이 짧을때만 안 쓰는 게 좋을 듯