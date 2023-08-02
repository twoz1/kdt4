// 1) 순차정렬(sort)과 반복문
// => Data 구분
//    기본자료형 (단일값 : 정수, 실수, 문자, boolean..등)
//    배열 , Map, Set 

// => 기본알고리즘 : Sort, Search
// let s1 =10, s2=20 ,s3=30, s4=12,s5=100;
// let point = [100,555,200,300,111];
//=> 과제 : 이 명단을 point 순으로 출력하세요.
//           100, 555
//           100, 200
//           100, 300
//           100, 111

//           555, 200
//           555, 300
//           555, 111

//           200, 300
//           200, 111

//           300, 111

// for (let i = 0; i < point.length - 1; i++) {
//     for (let j = i + 1; j < point.length; j++) {
//       console.log(point[i] + ", " + point[j]);
//     }
//   }

// 3) 정렬(Sort) 하기
// => point 배열의 Data를 index 0 부터 차례대로 재배치 하는데,
//    이  Data 가 오름차순 인것임.
// => 기본배열 반복문 for_i , 비교반복문 for_j
// => i Data 와 j Data 를 비교하면서 작은값이 있으면 서로 맞바꿈(치환)

//   let point = [100,555,200,300,111];
// for (let i = 0; i < point.length - 1; i++) {
//     for (let j = i + 1; j < point.length; j++) {
//      if(point[i] > point[j]){     //오름차순
//     //  if(point[i] < point[j]){  //내림차순
//         //Data 치환
//         let temp = point[i];
//         point[i] = point[j];
//         point[j] = temp;
//       }//if
//     } //for_j
//   } //for_i
//   // => 배열 : in -> index
//   for(let p in point){
//     console.log(point[p]);
//   }



//   point.sort((a, b) => a - b); //오름차순
//   for(let p in point){
//       console.log(point[p]);
//   }

//   point.sort((a, b) => b - a); // 내림차순
//   for(let p in point){
//       console.log(point[p]);
//   }

// ** 과제 
// =>  student 객체 (속성 : name , score)를 생성자 함수를 
// 이용해서 구현하고 인스턴스를 3개 생성하고 배열에 담는다.
// => score 순으로 출력(sort 메서드 사용하지 않고 직접 구현)


function Student(name, score) {
    this.name = name;
    this.score = score;
}

let students = [];

students.push(new Student('멍청이', 90));
students.push(new Student('바보', 80));
students.push(new Student('똥깨', 100));

for (let i = 0; i < students.length; i++) {
    for (let j = i + 1; j < students.length; j++) {

        if (students[i].score < students[j].score) {     //오름차순
            let temp = students[i];
            students[i] = students[j];
            students[j] = temp;
        }
    }
}

for (let student of students) {
    console.log(`${student.name} : ${student.score}`);
}

 // ** 과제
    // => student 객체 (속성: name, score) 를 생성자함수를 이용해서 구현 하고
    //    인스턴스를 3개 생성하고 배열에 담는다
    // => score 순으로 출력(sort 메서드 사용하지않고 직접구현)

//     function Student(name, score){
//         this.name=name;
//         this.score=score;
//   }//function

//   let st1=new Student('홍길동', 50);
//   let st2=new Student('김길동', 90);
//   let students=[ st1, st2, new Student('이길동', 70) ]; 

//   for (let i=0; i<students.length; i++) {
//       for (let j=i+1; j<students.length; j++) {
//           if ( students[i].score < students[j].score ){  //내림차순 
//             let temp = students[i];
//             students[i] = students[j];
//             students[j] = temp;
//           } //if
//       } //for_j
//   } //for_i
//   for ( let i in students) {
//     console.log(`${i}, ${students[i].name}=${students[i].score} `)
//   }


 // => students 배열에 map 적용해서 score 배열 만들기
 //    score+index*100 의 값을 가진 score 배열로 만들어 출력해보세요 ~~
 //    (주의 : students 배열은 성적순 정렬된 상태임)


let score = students.map((student, index) => student.score + index * 100);
//요소값 인덱스 순회하는 대상
console.log(score);

