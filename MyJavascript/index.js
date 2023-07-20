// 비동기적으로 데이터를 가져오는 함수 fetchUserData
// function fetchUserData(callback) {
//     // 비동기적인 작업을 수행한 후, 콜백 함수를 호출하여 결과를 전달합니다.
//     const userData = { name: 'John', age: 30 };
//     callback(userData);
//   }
  
//   // 콜백 함수를 정의합니다.
//   function displayUserData(userData) {
//     console.log(`Name: ${userData.name}, Age: ${userData.age}`);
//   }
  
//   // 함수 호출 시 콜백 함수로 displayUserData를 전달합니다.
//   fetchUserData(displayUserData); // 출력: Name: John, Age: 30

function greet(name, callback){
    console.log(`Hello, ${name}!`);
    callback();
}

function saygoodbye(){
    console.log('goodbye');
}

greet('alice',saygoodbye);