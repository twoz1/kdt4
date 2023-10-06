package jdbc02;

import java.util.List;

//** Controller
//=> 요청 : 요청분석 -> 담당 Service -> Service 는 DAO 
//=> 결과 : DAO -> Service -> Controller
//=> View : Controller -> View 담당 (Java:Console // Web:JSP, Html.., React) 

public class StudentController {
	// ** 전역변수 정의
	StudentService service = new StudentService();
	
	// ** View 역할 메서드
	// => select List 호출
	public void printList(List<StudentDTO> list) {
		System.out.println("---------------------------------------------");
		System.out.println("** Student List **");
		System.out.println("---------------------------------------------");
		if ( list!=null ) {
			// ** list 출력
			for (StudentDTO s:list) {
				System.out.println(s);
			}//for
		}else {
			System.out.println("** selectList: 출력 Data 가 1건도 없음 **");
		}
	} //printList
	
	// => selectOne 호출
	public void printDetail(StudentDTO dto) {
		System.out.println("---------------------------");
		System.out.println("** Student Detail **");
		System.out.println("---------------------------");
		if (dto!=null) {
			System.out.println(dto);
		}else {
			System.out.println("** selectOne: 출력할 Data가 없음 **");
		}
	} //printDetail
	
	// => groupList 호출
	public void printGroup(List<GroupDTO> list) {
		System.out.println("---------------------------------------------");
		System.out.println("** 조별 통계 List **");
		System.out.println("---------------------------------------------");
		if ( list!=null ) {
			// ** list 출력
			for (GroupDTO g:list) {
				System.out.println(g);
			}//for
		}else {
			System.out.println("** groupList: 출력 Data 가 1건도 없음 **");
		}
	} //printGroup

	public static void main(String[] args) {
		//** StudentController 인스턴스 생성
		StudentController sc = new StudentController();
		
		/*	Transaction Test 를 위해 주석처리함	~~~~~~~
		//** Student_List 
		// => 요청에 해당하는 service.selectList() 메서드 실행
		// => 위 의 결과를 view 에 처리하도록 전달
		sc.printList(sc.service.selectList());
		//** Student_Detail
		StudentDTO dto = new StudentDTO();
		dto.setSno(22);
		sc.printDetail(sc.service.selectOne(dto));
		// ** Group 적용
		sc.printGroup(sc.service.groupList());
		
		// ** Insert
		// => dto에 입력값 담기 -> Service(-> DAO) -> 결과출력
		dto.setName("똥쟁이");
		dto.setAge(30);
		dto.setJno(7);
		dto.setInfo("insert test");
		if ( sc.service.insert(dto)>0 ) {
			System.out.println("** insert 성공 **");
		}else System.out.println("** insert 실패 **");
		
		// ** Update
		// => info, point, birthday 수정, sno=25번 
		dto.setSno(25);
		dto.setInfo("수정 테스트");
		dto.setPoint(123.456);
		dto.setBirthday("2000-09-09");
		if ( sc.service.update(dto)>0 ) { 
			System.out.println("** update 성공 & 확인 **");
			sc.printDetail(sc.service.selectOne(dto));
		}else System.out.println("** update 실패 **");
		
		// ** Delete
		dto.setSno(25);
		if ( sc.service.delete(dto)>0 ) {
			System.out.println("** delete 성공 & 확인 **");
			sc.printDetail(sc.service.selectOne(dto));
		}else System.out.println("** delete 실패 **");
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
		
		// ** Transaction Test
		// => command 에서 복습
		// => JDBC 에서 적용전/후 비교
		// => JDBC: Conection 객체가 관리 
		//			기본값은 AutoCommit  true 
		//      	setAutoCommit(false) -> commit 또는 rollback 	
		// => 적용전
		sc.service.transactionTest();
		
	} //main

} //class
