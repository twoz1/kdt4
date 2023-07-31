// ** State
// => 값을 저장하거나 변경 할 수 있는 객체로 이벤트와 함께 주로 사용됨.
//    - 즉, 버튼 클릭시 버튼의 컬러를 변경할때 등에 사용됨 
//    - 이벤트 발생 -> 이로인하여 화면의 리랜더링이 필요한 경우 리랜더링이 자동으로실행될 수 있도록 해줌
//      -> State변수 로 지정된 변수의 값에 변화가 일어나면 리액트 에서는 리랜더링 해줌  
// => useState 생성자함수로 State 생성
//    const [text_State변수, setText_set함수] = useState("초기값");
// => useState 를 호출하면 현재상태값과 이 State변수의 값을 변경하는 set함수를 담은 배열을 return.
// => 이후 State변수 값이 변하면 이를 반영하기위해 컴포넌트를 리랜더링 함.
//    ( 이것을 컴포넌트의 Update 라함 )


import {useState} from 'react';  //react에서 useState를 갖고 온다.

function Body() {
//state Test1
    const [count, setCount] = useState(0);
    const onIncrease = () => {
        setCount(count+1);
        if (count >= 100) {
            alert('100보다 작게요');
            setCount(0);
        }
    }//onIncrease

    const onDecrease =() => {
        setCount(count-1);
        if (count <= 0) {
            alert('0보다 크게요');
            setCount(0);
        }
    }
   
//state Test2
const [text,setText] = useState('');
const textChange =(e)=>{
    setText(e.target.value);
    
}//textChange

const [date,setDate] = useState('');
const dateChange =(e)=>{
  setDate(e.target.value);
  console.log(e.target.value);
}

const [option,setOption] =useState('');
const companyChange =(e) =>{
    setOption(e.target.value);
    // => select option 의 key 값이 value 에 전달됨
    //    그리고 option 은 이벤트가 일어난 대상은 아님
    console.log('select : value' + e.target.value + ', key=' + e.target.key);

}

//** 컴포넌트의 Upadate 확인
console.log('**컴포넌트의 Update');
    return (
        <div className ='body'>
            <h1>**Body**</h1>
            <p>**State Test**</p>
            <button onClick={onIncrease}>+</button>
            <button onClick={onDecrease}>-</button>
            <div>count={count}</div>
            <hr/>
            <div>
                <input value={text} onChange={textChange}/>
                <p>{text}</p>
                <p>[연습] input Tag의 type date활용해서 값이 변경될때마다 
                    그 값을 console로 출력하기
                </p>
                <input type='date' value={date} onChange={dateChange}/>
                <p>{date}</p>
                <select value ={option} onChange={companyChange}>
                    <option>구글</option>
                    <option>아마존</option>
                    <option>네이버</option>
                    <option>카카오</option>
                    <option>마이크로소프트</option>
                </select>
            </div>
        </div>
        
    );//return

}//body
export default Body;

// import { useState } from 'react';

// function Body() {
//     const [count, setCount] = useState(0);

//     const onIncrease = () => {
//         setCount(count + 1);
//     };

//     const onDecrease = () => {
//         setCount(count - 1);
//     };

//     return (
//         <div className='body'>
//             <h1>**Body**</h1>
//             <p>**State Test**</p>
//             <button onClick={onIncrease}>+</button>
//             <button onClick={onDecrease}>-</button>
//             <h2>count={count}</h2>
//         </div>
//     );
// }

// export default Body;