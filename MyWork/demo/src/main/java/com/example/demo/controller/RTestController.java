package com.example.demo.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.BoardDTO;
import com.example.demo.domain.JoDTO;
import com.example.demo.domain.MemberDTO;
import com.example.demo.domain.UserDTO;
import com.example.demo.service.BoardService;
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
//=> JSON의 파일 확장자는 .json
//=> 주요 메서드
// - JSON.stringify() : JavaScript 값이나 객체를 JSON 문자열로 변환.
// - JSON.parse() :  JSON 문자열을 구문 분석하여 JavaScript 값이나 객체를 생성함.

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
   BoardService bservice;

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
   // => Status (200, 404 등 응답 상태 코드) , Headers, Body 등을 함께 전송할수있음. 
   // => status : 200(OK), 502(BAD_GATEWAY) , 500(INTERNAL_SERVER_ERROR)
   // => 즉, 직접 status code 지정 가능. 
   // => 사용법
   //   - Builder Pattern (권장)
   //   - Constructor 사용하는 방식 : 아래 rsdelete 참고

   // ** Parameter 를 쿼리스트링으로 전달하는 경우 서버에서 처리방법
   // 1) params 속성으로 처리
   //   - URL Query_String Param Parsing, "key=value" 형식으로 전달된 파라미터 매핑

   // 2) @RequestParam 으로 처리
   //   - @RequestParam("jno") int jno -> Spring02의 MemberController, /dnload 참고
   // => params 와 @RequestParam  비교 해보세요.   
   //     parameter 오류시 400
   //      - params : Parameter conditions "jno, id" not met for actual request parameters: jno2={11}, id={banana}
   //      - @RequestParam : Required request parameter 'jno' for method parameter type int is not present
   //      ( Mapper interface의 @Param 과는 구별 )

   // 3) @PathVariable
   // 4) @RequestBody

   // ** params 속성
   // => 값에 상관없이 파라미터에 params 속성으로 정의한 "jno", "id" 이 반드시 있어야 호출됨 
   //    만약 하나라도 전달받지 못하면 "400–잘못된 요청" 오류 발생
   // => Parameter name 과 매개변수는 이름으로 매핑함. (즉, 같아야함)
   // => Spring02 의 MemberController의 상단 주석 params 참고
      
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
         log.info("incheck Test HttpStatus.OK =>" + HttpStatus.OK);
      } else {
         // 실패(오류)
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
         log.info("incheck Test HttpStatus.BAD_GATEWAY =>" + HttpStatus.BAD_GATEWAY);
      }
      return result;
   }

   @GetMapping(value = "/incheck2")
   // http://localhost:8080/rest/incheck2?jno=7&id=banana
   // public ResponseEntity<JoDTO> incheck2(@RequestParam("jno") int jno,
   //                             @RequestParam("id") String id) {
   // => @RequestParam 은 생략가능 
   //      단, 이 경우에는 parameter 가 없으면 null 로 통과
   //    그러므로 매핑을 엄격하게 하기 위해 @RequestParam, params 등을 사용함
   public ResponseEntity<?> incheck2(int jno, String id) {
      // 1) 준비
      ResponseEntity<MemberDTO> result = null;
      MemberDTO dto = service.selectOneJno(id, jno);
      
      // 2) Service 처리
      if( dto != null) {
         // 성공
         result = ResponseEntity.status(HttpStatus.OK).body(dto);
         log.info("incheck Test HttpStatus.OK =>" + HttpStatus.OK);
      } else {
         // 실패(오류)
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
         log.info("incheck Test HttpStatus.BAD_GATEWAY =>" + HttpStatus.BAD_GATEWAY);
      }
      return result;
   }
   
   // =================================================================================

   // 5) @PathVariable
   // => URL 경로의 일부를 파라미터로 사용할때 이용
   //    http://localhost:8080/rest/order/outer/노랑
   // => 요청 URI 매핑에서 템플릿 변수를 결정하고 이를 매핑메서드 매개변수의 값으로 할당 시켜줌.
   //    이때 마라피터가 1개이면 @PathVariable 과 같이 name을 생략할 수 있다.

   @GetMapping("/order/{test1}/{test2}")
   public String[] order(@PathVariable("test1") String category, 
         @PathVariable("test2") String color) {
      return new String[] {"categoty : " + category, "color : " + color};

   }

   // =================================================================================

   // 6) @RequestBody
   // => JSON 형식으로 전달된 Data를 컨트롤러에서 객체(DTO) _Java 객체로 변활할대 사용
   // => 요청 url : http://localhost:8080/rest/convert
   // => Payload : {"jno":33, "jname":"삼삼오오", "id":"victory", "project":"RequestBody Test 중"}
   @PostMapping("/convert")
   public ResponseEntity<?> convert(@RequestBody JoDTO dto) {
      ResponseEntity<JoDTO> result = null;
      if(dto != null) {
         result = ResponseEntity.status(HttpStatus.OK).body(dto);
         log.info("convert Test HttpStatus.OK =>" + HttpStatus.OK);
      }else {
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(dto);
         log.info("convert Test HttpStatus.BAD_GATEWAY =>" + HttpStatus.BAD_GATEWAY);
      }
      return result;
   }

   // =================================================================================

   // ** Ajax : 비동기 통신
   // 1) Login1
   // => Request: JSON, Response: Text
   @PostMapping(value="/rslogin",
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.TEXT_PLAIN_VALUE)
   public ResponseEntity<?> rslogin(HttpSession session, 
         @RequestBody MemberDTO dto){
      ResponseEntity<String> result = null;
      // 1) password 보관
      String password = dto.getPassword();
      // 2) service 처리
      // => id & password 확인
      // => 성공: login 정보를 session에 보관후, status OK, body="성공 message"
      //    실패: status INTERNAL_BAD_GATEWAY 502, body="실패 message"
      dto = service.selectOne(dto);
      if(dto!=null && passwordEncoder.matches(password, dto.getPassword())) {
         session.setAttribute("loginID", dto.getId());
         session.setAttribute("loginName", dto.getName());
         result = ResponseEntity.status(HttpStatus.OK).body("Login 성공");
         log.info("** rslogin HttpStatus.OK => " + HttpStatus.OK);
      }else {
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("Login 실패");
         log.info("** rslogin HttpStatus.BAD_GATEWAY=> " + HttpStatus.BAD_GATEWAY);
      }
      return result;
   }

   // =================================================================================
   
   // 2) Login2
   // => Request: JSON, Response: JSON
   @PostMapping(value="/rsloginjj",
         consumes = MediaType.APPLICATION_JSON_VALUE,
         produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<?> rsloginjj(HttpSession session, 
         @RequestBody MemberDTO dto){
      ResponseEntity<UserDTO> result = null;
      // 1) password 보관
      String password = dto.getPassword();
      
      // 2) service 처리
      dto = service.selectOne(dto);
      if(dto!=null && passwordEncoder.matches(password, dto.getPassword())) {
         session.setAttribute("loginID", dto.getId());
         session.setAttribute("loginName", dto.getName());
         // => response 로 전송할 객체 생성
         //      UserDTO, @Builder(빌더 패턴) 적용
         //    UserDTO 의 값 변경을 막기위해 final 을 사용하기 함
         final UserDTO userDTO = UserDTO.builder()
               .id(dto.getId())
               .username(dto.getName())
               .build();
         
         result = ResponseEntity.status(HttpStatus.OK).body(userDTO);
         log.info("** rsloginJJ HttpStatus.OK => " + HttpStatus.OK);
      }else {
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
         log.info("** rsloginJJ HttpStatus.BAD_GATEWAY=> " + HttpStatus.BAD_GATEWAY);
      }
      return result;
   }

// 3) Join
   // => image 포함, "multipart/form-data" Type 으로 요청
   // =>
   @PostMapping(value = "/rsjoin",
         consumes = MediaType.MULTIPART_FORM_DATA_VALUE, // multipart/form-data 와 동일
         produces = MediaType.TEXT_PLAIN_VALUE)
   public ResponseEntity<?> rsjoin(MemberDTO dto) throws Exception {

      ResponseEntity<?> result = null;

      // ** Join Service
      // => PasswordEncoder (암호화 적용)
      dto.setPassword(passwordEncoder.encode(dto.getPassword()));

      // => MultipartFile  
      String realPath ="D:\\twoz1_top\\twoz1\\MyWork\\Spring02\\src\\main\\webapp\\resources\\uploadImages\\";
      String file1, file2="resources/uploadImages/basicman4.png";

      MultipartFile uploadfilef = dto.getUploadfilef();
      if ( uploadfilef!=null && !uploadfilef.isEmpty() ) {

         // =>  물리적위치 저장 (file1)
         file1 = realPath + uploadfilef.getOriginalFilename(); //저장경로 완성 
         uploadfilef.transferTo(new File(file1)); //해당경로에 저장(붙여넣기)

         // => 저장경로 완성 (file2)
         file2 = "resources/uploadImages/" + uploadfilef.getOriginalFilename();
      } // Image 선택한 경우

      // => 완성된 경로를 dto 에 set
      dto.setUploadfile(file2);

      // => Service 처리
      if ( service.insert(dto) > 0 ) {  
         result = ResponseEntity.status(HttpStatus.OK).body("회원가입 성공!! 로그인후 이용하세요");
         log.info("** rsjoin HttpStatus.OK => " + HttpStatus.OK);
      }else {
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("회원가입 실패!! 다시 하세요");
         log.info("** rsjoin HttpStatus.BAD_GATEWAY=> " + HttpStatus.BAD_GATEWAY);
      }

      return result;

   }
   
   @DeleteMapping("axidelete/{selectedId}")
   public ResponseEntity<?> axidelete(@PathVariable("selectedId") String id, MemberDTO dto) {
      dto.setId(id);
      if (service.delete(dto) > 0) {
         log.info("axidelete HttpStatus.OK =>" + HttpStatus.OK);
         return new ResponseEntity<String>("삭제 성공", HttpStatus.OK);
      } else {
          log.info("axidelete HttpStatus.BAD_GATEWAY =>" + HttpStatus.BAD_GATEWAY);
         return new ResponseEntity<String>("삭제 실패, Data_NotFound", HttpStatus.BAD_GATEWAY);
      }
   }//axidelete
   
   @GetMapping("/idblist/{id}")
   public ResponseEntity<?> idblist(@PathVariable("id") String id) {
      ResponseEntity<?> result = null;
      List<BoardDTO> list = bservice.idBList(id);
      // => 출력 Data 유/무 구별
      if ( list !=null && list.size()>0 ) {
         result = ResponseEntity.status(HttpStatus.OK).body(list);
         log.info("** rsjoin HttpStatus.OK => "+HttpStatus.OK);
      }else {
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("~~ 출력할 자료가 없습니다. ~~");
         log.info("** axidelete HttpStatus.BAD_GATEWAY => "+HttpStatus.BAD_GATEWAY); //502
      }
      return result;
   } //idblist
   
   @GetMapping(value="/jodetail", params={"jno"})    
   // => params로 정의한 "jno"가 요청 Parameter에 반드시 존재해야함 
   public ResponseEntity<?> jodetail(JoDTO dto) {

      // => dto 확인: parameter 와 같은 이름의 맴버변수가 있으면 자동으로 set 
      System.out.println("** jodetail dto => "+dto);
      ResponseEntity<?> result = null;

      // => Service 처리
      dto = jservice.selectOne(dto);
      // => 출력 Data 유/무 구별
      if ( dto !=null ) {
         result = ResponseEntity.status(HttpStatus.OK).body(dto);
         log.info("** idblist HttpStatus.OK => "+HttpStatus.OK);
      }else {
         result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("~~ 출력할 조의 자료가 없습니다. ~~");
         log.info("** idblist HttpStatus.BAD_GATEWAY => "+HttpStatus.BAD_GATEWAY); //502
      }
      return result;
   } //jodetail
}//class

