let menu = '짬뽕';
// console.log(`bar.js menu=${window.menu}`);
console.log(`bar.js menu=${menu}`);

//**import 1
// import {pi, square , Person} from './m02_bar.mjs';
// console.log(`foo import 1 pi = ${pi}`);
// console.log(`foo import 1 pi = ${square(5)}`);
// console.log(new Person('Lee')); //person{name : 'Lee'}

// //**import 2.
// //=> myLib 를 통해 접근
// import * as myLib from './m02_bar.mjs';
// console.log(`foo import 2 pi = ${pi}`);
// console.log(`foo import 2 pi = ${square(5)}`);
// console.log(new Person('Lee')); //person{name : 'Lee'}

//**import 3.
// => export한 식별자 이름을 변경하여 import한다
import{pi as PI, square as mySquare, Person as P} from './m02_bar.mjs';
console.log(`foo import 2 pi = ${PI}`);
console.log(`foo import 2 pi = ${mySquare(5)}`);
console.log(new P('Lee')); //person{name : 'Lee'}

