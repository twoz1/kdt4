import React from "react";
import { useState } from 'react';
//Viewer컴포넌트를 완성하세요.
// <h2> 크기로 숫자를 출력하는 컴포넌트
// 출력한 숫자는 부모컴포넌트로부터 전달받음


// 객체 구조분해 적용
const Viewer = ({count}) =>{
    console.log('**Viewer Update !!**');
    return(
        <div className="Viewer">
            <h2>현재 Count는 {count}입니당</h2>
        </div>
    );
}//Viewer

export default Viewer;