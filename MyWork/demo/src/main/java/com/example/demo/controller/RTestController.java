package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.JoDTO;
import com.example.demo.domain.UserDTO;
import com.example.demo.service.JoService;
import com.example.demo.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

//** @RestController
//=> 스프링4 부터 추가됨,
//  Controller의 모든 매핑메서드 리턴타입을 기존과 다르게 처리함을 명시
// viewPage가 아닌 Data를 다양한 Type으로 return 하며,
//  이들을 JSON이나 XML로 자동으로 처리함.
//=> @ResponseBody 애너테이션을 생략해도 
//   xhr, ajax, fetch, axios(리액트) 등의 비동기 요청에 Data로 응답을 해줄수 있음.
//=> Return 데이터 Type
// - String, Integer 등의 단일값
// - 사용자 정의 객체
// - Collection
// - ResponseEntity<> 타입 : 주로 이용됨

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//** status 
//=> https://ko.wikipedia.org/wiki/HTTP_상태코드
//1xx (메시지정보): 요청을 받았으며 프로세스를 계속한다
//2xx (요청성공): 요청을 성공적으로 받았으며 인식했고 수용하였다
//3xx (리다이렉션): 요청 완료를 위해 추가 작업 조치가 필요하다
//4xx (클라이언트 오류): 요청의 문법이 잘못되었거나 요청을 처리할 수 없다
//5xx (서버 오류): 서버가 명백히 유효한 요청에 대해 충족을 실패했다

//400: Bad request (사용자의 잘못된 요청을 처리할 수 없음)
//401: Unauthorized (허가_승인 되지 않음, 권한 없음) 
//403: Forbidden (금지된, 접근금지, 서버에 요청이 전달되었지만, 권한 때문에 거절되었음을 의미)
// ( 401은 익명의 사용자, 403는 로그인은 하였으나 권한이 없는 사용자, 
//   HTTP1.1 에서는 이 둘을 명확하게 구분하지 않고 Web API의 속성은 대부분 401을 내보낸다고 하지만,
//      401은 익명의 사용자, 403는 로그인은 하였으나 권한이 없는 사용자로 구분 가능하다.
//   즉 로그인전 접근시에는 401 , 로그인후 접근시는 403 ) 
//415: 지원되지 않는 미디어 유형 (요청이 요청한 페이지에서 지원하지않는 형식으로 되어있음.)

//404: Not found (요청한 페이지 없음)
//405: Method not allowed (허용되지 않는 http method 사용함)
//500: Internal server error (내부 서버 오류)
//501: Not implemented (웹 서버가 처리할 수 없음)
//503: Service unavailable (서비스 제공 불가)
//504: Gateway timeout (게이트웨이 시간초과)
//505: HTTP version not supported (해당 http 버전 지원되지 않음)
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//*** JSON 제이슨, (JavaScript Object Notation) **********
//=> 자바스크립트의 객체표기법으로, 데이터를 전달할때 사용하는 표준형식.
//   속성(key) 과 값(value) 이 하나의 쌍을 이룸
    
//** JAVA의 Data 객체 -> JSON 변환하기
//** 참고용어 
//=> 마샬링(Marshalling)
// - 메모리상에 형상화된 객체 데이터를 다른 데이터 형태로 변환하는 과정을 말함.
// - JAVA 객체를 JSON 포맷으로 변환하는것

//=> 언마샬링(UnMarshalling)
// - 변환된 데이터를 다시 원래의 객체 모양으로 복원하는 작업
// - JSON 포맷을 JAVA 객체로 변환하는것

//=> 직렬화(Serialization)
// - 객체 데이터를 일련의 byte stream으로 변환하는 작업
// - 반대로 일련의 byte stream을 본래 객체 모양으로 복원하는 작업은 역직렬화(Deserialization) 
// - 직렬화와 마샬링은 거의 같은개념이지만, 직렬화 작업이 프로그래밍적으로 보다더 전문화 된것이 마샬링.
// ( 즉, 직렬화는 마샬링이 포함된 폭넓은 개념 )

//1) GSON
// : 자바 객체의 직렬화/역직렬화를 도와주는 라이브러리 (구글에서 만듦)
// 즉, JAVA객체 -> JSON 또는 JSON -> JAVA객체
    
//2) @ResponseBody (매핑 메서드에 적용)
// : 메서드의 리턴값이 View 를 통해 출력되지 않고 HTTP Response Body 에 직접 쓰여지게 됨.
// 이때 쓰여지기전, 리턴되는 데이터 타입에 따라 종류별 MessageConverter에서 변환이 이뤄진다.
// MappingJacksonHttpMessageConverter 를 사용하면 request, response 를 JSON 으로 변환
// view (~.jsp) 가 아닌 Data 자체를 전달하기위한 용도
// @JsonIgnore : VO 에 적용하면 변환에서 제외

//3) jsonView
//=> Spring 에서 MappingJackson2JsonView를 사용해서
//   ModelAndView를 json 형식으로 반환해 준다.
//=> 방법
// -> pom dependency추가
// -> 설정화일 xml 에 bean 등록 
// ( 안하면 /WEB-INF/views/jsonView.jsp 를 찾게되고  없으니 404 발생 )
// -> return할 ModelAndView 생성시 View_Name을 "jsonView"로 설정

// =================================================================================

@RestController
@RequestMapping("/rest")
@Log4j2
@AllArgsConstructor
public class RTestController {

   MemberService service;
   PasswordEncoder passwordEncoder;
   JoService jservice;

   @GetMapping("/hello")
   // => 메뉴없이 직접 요청 http://localhost:8080/rest/hello/
   public String hello() {
      log.info("Rest API Test");
      return "Hello Spring Boot Rest API Test";
   }

   // ** RestController 의 다양한 Return Type
   // 1) Text Return
   // => http://localhost:8080/rest/gettext/
   // @GetMapping(value="/gettext", produces="text/plain; charset=UTF-8")
   @GetMapping(value="/gettext")
   // => produces 속성
   //  - 해당 메서드 결과물의 MIME Type을 의미 ( UI Content-Type 에 표시됨 )
   //  - 위처럼 문자열로 직접 지정 할수도 있고, 메서드내의 MediaType 클래스를 이용할 수도 있음
   //  - 필수속성은 아님 ( 기본값은 text/html, 그러므로 적용하지 않은 경우 아래 <h1></h1> 적용됨 )
   public String getText() {
      log.info("MIME Type, MediaType 클래스적용 => " + MediaType.TEXT_PLAIN_VALUE);
      return "<h1> 안녕하세요~~ 점심 뭐 먹었니? REST API </h1>";
   }
   
   // 객체 주의사항
   // => Java 의 객체를 UI 가 인식가능한 형태의 객체로 변환 후 전송
   // => xml 또는 JSON 포멧
   // => 즉, Java <-> JSON 변환을 지원하는 API 필요함
   //    여기부터는 pom 에 dependency 추가 해야함
   
   // =================================================================================
   
   // 2) 사용자 정의 객체 
   // 2.1) 객체 Return1. : produces 지정한 경우
   @GetMapping(value="getdto1", 
            produces = {MediaType.APPLICATION_JSON_VALUE,
                     MediaType.APPLICATION_XML_VALUE })
   // @GetMapping(value="getdto1")
   // => produces
   //  - JSON 과 XML 방식의 데이터를 생성할 수 있도록 설정
   //  - Response Data Type을 제한 함으로 오류를 줄임
   //  - 입력값을 제한할때는 "consumes" 속성 사용
   // => 요청 url의 확장자에 따라 다른 타입으로 서비스
   //  - Test1) 브라우져에서 /rest/getdto1 호출 -> 위 둘중 XML 전송(default) 
   //  - Test2) 브라우져에서 /rest/getdto1.json 호출 -> JSON 전송  
   //    단, SpringBoot 에서는 요청 Data가 없는경우에는 Test 불가함.
   //    ( produces 속성 지정하지 않은 getDTO2 만 정성적으로 실행됨. )
   public UserDTO getDTO1() {
      return new UserDTO("mytoken111", "banana", "홍길동", "banana@green.com", "12345!");
   }

   // 2.2) 객체 Return2. : produces 지정하지 않은 경우 (JSON 으로 전달됨)
   @GetMapping("/getdto2")
   public UserDTO getDTO2() {
      return new UserDTO("mytoken222", "banana", "홍길동", "banana@green.com", "12345!");
   }
   
   // =================================================================================
   
   // 3) Collection Return
   // 3.1) Map 
   @GetMapping("/getmap")
   public Map<String, UserDTO> getMap() {
      Map<String, UserDTO> map = new HashMap<String, UserDTO>();
      map.put("one", new UserDTO("mytoken111", "banana", "홍길동", "banana@green.com", "12345!"));
      map.put("two", new UserDTO("mytoken222", "banana", "홍길동", "banana@green.com", "12345!"));
      map.put("three", new UserDTO("mytoken333", "banana", "홍길동", "banana@green.com", "12345!"));
      map.put("four", new UserDTO("mytoken444", "banana", "홍길동", "banana@green.com", "12345!"));
      
      return map;
   }
   
   // 3.2) List
   @GetMapping("/getlist")
   public List<JoDTO> getlist() {
      return jservice.selectList();
   }

   // =================================================================================
   
   // ** ResponseEntity 
   
   // ** params 속성
   // => 값에 상관없이 파라미터에 params 속성으로 정의한 "jno", "captain" 이 반드시 있어야 호출됨
   //    만약 하나라도 전달받지 못하면 "400-잘못된 요청" 오류 발생
   // => Parameter name 과 매개변수는 이름으로 매핑함. (즉, 같아야함)

   // 4) ResponseEntity Test
   // => 실습
   //     전달된 jno값의 조건에 의하여 502(BAD_GATEWAY) 또는 200(OK) 상태코드와 데이터를 함께 전송하므로 
   //    요청 User가 이 응답결과(body값)의 정상/비정상 여부를 알수있도록 해준다
   // => 200 Test: http://localhost:8080/rest/incheck?jno=11&id=banana
   //              http://localhost:8080/rest/incheck.json?jno=11&id=banana
   // => 502 Test: http://localhost:8080/rest/incheck?jno=5&id=banana
   
   
   @GetMapping(value = "/incheck", params = {"jno","id"})
   public ResponseEntity<JoDTO> incheck(int jno, String id) {
      // 1) 준비
      ResponseEntity<JoDTO> result = null;
      JoDTO dto = new JoDTO(jno,"최고조", id, "tbtConcept", "열정빼면 시체", "김이지렁이");
      
      // 2) Service 처리
      // => jno 의 값이 11~20 에 속하면 성공 / 아니라면 오류
      if(jno > 10 && 21 < jno) {
         // 성공
         result = ResponseEntity.status(HttpStatus.OK).body(dto);
      } else {
         // 실패(오류)
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
      }
      return result;
   }
   
   // =================================================================================
   
   // 5) @PathVariable

   // 6) @RequestBody

   // ** Ajax : 비동기 통신


}