/**
** 입력값의 무결성 확인
** member 무결성 확인사항
// ID : 길이(4~10), 영문자,숫자 로만 구성
// Password : 길이(4~10), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
// Password2: 재입력후 Password 와 일치성 확인
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Age: 정수의 범위  ( 숫자이면서, '.'이 없어야함 )  
// BirthDay : 입력 여부 확인  ( length == 10 )
// Point : 실수 ( 구간설정 100 ~ 10000 까지만 가능 )
// Jno : select 를 이용 (X)
// Info : (X)

** 작성 규칙
   => JavaScript function 으로 정의 하고 
      결과를 true or false 로 return
   => 정규식을 활용한다.
   
** match Test
   => 아래 조건에 true -> not (!)  match 적용해보면
   => 정확하지 않으므로 (부적절, replace 를 사용)
        ...       
        } else if (!id.match(/[a-z.0-9]/gi)) {
            alert(' ID는 영문자와 숫자로만 입력하세요. !!!')
            return false;
        }    
 */

        "use strict"

        // 1) ID
        function idCheck() {
          let id=document.getElementById('id').value;
          if (id.length<4 || id.length>10) { 
             document.getElementById('iMessage').innerHTML='id 는 4~10 글자 입니다.' ;
             return false;
        
          // => 영문과 숫자로만 입력했는지 : id 에서 영문과 숫자를 모두 '' 로 변경했을때 length 가 0 이면 OK    
          }else if ( id.replace(/[a-z.0-9]/gi,'').length > 0 ) {
              document.getElementById('iMessage').innerHTML='id 는 영문과 숫자만 입력하세요.' ;
              return false;
          }else {
             document.getElementById('iMessage').innerHTML='' ;
             return true;
           };//if
        } //idCheck
        
        // 2) Password
        function pwCheck() {
          let password=document.getElementById('password').value;
          let special = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
          special = /[!-*.@]/gi;  // 특수문자범위 축소
          if (password.length<4 || password.length>10) { 
            document.getElementById('pMessage').innerHTML='password 는 4~10 글자 입니다.' ;
            return false;
          // => 영문, 숫자, 특수문자 로만 구성 되었는지 확인  
          }else if(password.replace(/[a-z.0-9.!-*.@]/gi,'').length > 0) {  
            document.getElementById('pMessage').innerHTML = '영문, 숫자, 특수문자 로만 입력하세요 ~~';
            return false;
          // => 특수문자 포함 확인 : 정규식의 test 메서드 활용 
          }else if (special.test(password) == false) {
            document.getElementById('pMessage').innerHTML = '특수문자가 포함되어야 합니다.';
            return false;
          }else {
            document.getElementById('pMessage').innerHTML = '';
            return true;
          }
        } //pwCheck
        // 3) Password2
        // => Password 와 동일성확인
        function pw2Check() {
          let password=document.getElementById('password').value;
          let password2=document.getElementById('password2').value;
          if (password!=password2) { 
            document.getElementById('p2Message').innerHTML='password 가 다릅니다.' ;
            return false;
          }else {
            document.getElementById('p2Message').innerHTML='' ;
            return true;  
          }
        } //pw2Check
        
        // 4) Name : 길이, 한글과 영문
        function nmCheck() {
          let name=document.getElementById('name').value;
          if (name.length<2) { 
            document.getElementById('nMessage').innerHTML='name 은 2글자 이상 입력하세요.' ;
            return false;
          }else if ( name.replace(/[a-z.가-힣]/gi,'').length>0 ) {
            document.getElementById('nMessage').innerHTML='name 은 한글과 영문으로만 입력하세요.' ;
            return false;
          }else {
            document.getElementById('nMessage').innerHTML='' ;
            return true;  
          }
        
        } //nmCheck
        // 5) Age (정수)
        // => 정수의 조건: 숫자이면서, "." 이 없어야함
        // => Number.isInteger(n): 정수확인가능 (n 이 정수일때만 true)
        //    단, n 이 숫자타입이어야함
        //    아래처럼 value 는 문자로 인식하기때문에 숫자화_parseInt 가 필요함. 
        //    단, parseInt(age) 사용시 주의
        //      - 실수 입력시 정수로 바뀌어 처리됨 (123.456 -> 123)
        //      - 문자가 숫자뒤쪽에 포함된 숫자도 앞쪽의 숫자값만 가져와 정수 return (123aaa -> 123)
        //    - 문자로 시작되면 문자로 취급, NaN 을 return (Not a Number)
        function agCheck() {
          let age=document.getElementById('age').value; 
          console.log('** parseInt(age) => '+parseInt(age)); //123
          console.log('** Number.isInteger(age) => '+Number.isInteger(age)); //false
          console.log('** Number.isInteger(parseInt(age)) => '+Number.isInteger(parseInt(age))); //true
        
          // => 숫자가 아닌 값이 있는지 확인
          // => Number.isInteger....확인
          if ( age.replace(/[^0-9]/g,'').length < age.length ||        
               Number.isInteger(parseInt(age))==false ) {
              document.getElementById('aMessage').innerHTML='age 는 정수로만 입력하세요.' ;
              return false;
          }else {
              document.getElementById('aMessage').innerHTML='' ;
              return true;  
          }
        } //agCheck
        
        // 6) Birthday
        function bdCheck() {
          let birthday=document.getElementById('birthday').value;
          if (birthday.length!=10) { 
            document.getElementById('bMessage').innerHTML='birthday (yyyy-mm-dd) 입력 확인 !!!' ;
            return false;
          }else {
            document.getElementById('bMessage').innerHTML='' ;
            return true;
          };//if
        } //bdCheck
        
        // 7) Point
        // => 정수 또는 실수 허용
        // => 범위: 100 ~ 10000
        // => parseFloat(point)
        //      -> 오류 또는 입력값이 없는 경우 NaN return
        //      -> 확인 : Number.isNaN(parseFloat(point)) 
        //    -> 단, 숫자로 시작하면 뒤쪽에 문자가 섞여있어도 숫자값만 사용함 ( NaN 을 return 하지않음 ) 
        function poCheck() {
          let point=document.getElementById('point').value;
          
          console.log('** parseFloat(point) => '+parseFloat(point)); //123.456
          console.log('** Number.isNaN(point) => '+Number.isNaN(point));
          console.log('** Number.isNaN(parseFloat(point)) => '+Number.isNaN(parseFloat(point))); 
          
          // => 숫자가 아닌 값이 있는지 확인 & Number.isNaN 적용
           // => 소수점이 있으면 포함시켜야 하므로 정규식에 추가
           //    소수점이 기호가 아니라 비교값이므로 "/." 식으로 표기함 
          if ( point.replace(/[^0-9./.]/g,'').length < point.length ||
               Number.isNaN(parseFloat(point)) ) {
                // == true 는 생략가능
            document.getElementById('oMessage').innerHTML='point 는 정수 또는 실수 로 입력하세요.' ;
            return false;
          }else if ( parseFloat(point)<100 || parseFloat(point)>10000 ) { 
            document.getElementById('oMessage').innerHTML='point 값이 범위 (100~10000) 를 벗어납니다.' ;
            return false;
          }else {
            document.getElementById('oMessage').innerHTML='' ;
            return true;  
          }
        } //poCheck
        
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         <!-- 
        ** 정규 표현식 (정규식:Regular Expression) 객체 : RegExp
        => 자바스크립트의 기본 내장 객체 중의 하나
        => 특정한 규칙을 가진 문자열 집합을 표현하는데 사용하는 형식
        * 생성
           var regExp1= new RegExp('text') ;
           var regExp2= /text/ ; 
        * 메서드   
           test() : 정규식과 일치하는 문자열이 있으면 true 아니면  false 를 return 
           exec() : 정규식과 일치하는 문자열을 return 
        * 예제   
           var regExp= /script/ ; 
           var s='Javascript jQuery Ajax';
           
           var output = regExp.test(s) ;
           alert(output) ; 
        * 그러나 주로 문자열의 메서드와 같이 사용됨
            
        /.../ : 정규식 RegExp 의 리터럴
        
        ** 플래그 문자 
        g : global, 전역비교
        i : 대문자는 소문자 변환후 비교 (대/소문자 구분 없음)
        m : 여러줄의 검사 수행
           ( 각줄을 개별문자로 인식하고 검사해줌
            예 : 'JavaScript\njQuery\nAjax' )
        
        \. : . 문자 (. 는 한 문자를 의미하나 \. 는 . 문자를 의미함)
        a-z : abcdefghijklmnopqrstuvwxyz 와 같음
        0-9 : 0123456789 와 같음
        : : : 문자
        _ : _ 문자
        - : - 문자
        [~.~] : ~ 와 ~ , Or 의 묶음
        [..] : Or 의 묶음. 안에 기록된 1가지외 중복 적용됨.
        [^...] : 내부내용의 부정. 기록된 이외의 것을 찾음.
        + : 하나 이상의 반복적용. (단어(?) 찾음)
        
        */
        
        
        
        
        