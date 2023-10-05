package jdbc02;

import java.util.List;

// ** Controller
// => 요청 : 요청분석 -> 담당 Service -> Service 는 DAO 
// => 결과 : DAO -> Service -> Controller
// => View : Controller -> View 담당 (Java:Console // Web:JSP, Html.., React) 

public class StudentController {
	// 전역변수 정의
	StudentService service = new StudentService();
	
	// View 역할 메서드 
	// => select List 호출
	public void printList(List<StudentVO> list) {
		System.out.println("--------------------------------------------");
		System.out.println("Student_List");
		System.out.println("--------------------------------------------");
		if(list != null) {
			// list 출력
			for(StudentVO s : list) {
				System.out.println(s);
			}
		}else {
			System.out.println("selectList : 출력 Data 가 1건도 없음");
		}
	}

	// =================================================================================
	
	// => selectOne 호출
	public void printDetail(StudentVO vo) {
		System.out.println("--------------------------------------------");
		System.out.println("Student_Detail");
		System.out.println("--------------------------------------------");
		if(vo != null) {
			System.out.println(vo);
		}else {
			System.out.println("selectOne : 출력할 Data 가 없음");
		}
	}
	
	// =================================================================================
	
	// => groupList 호출
	public void printGroup(List<GroupDTO> list) {
		System.out.println("--------------------------------------------");
		System.out.println("조별 통계 List");
		System.out.println("--------------------------------------------");
		if(list != null) {
			// list 출력
			for(GroupDTO g : list) {
				System.out.println(g);
			}
		}else {
			System.out.println("selectList : 출력 Data 가 1건도 없음");
		}
	}
	
	
	public static void main(String[] args) {
		// StudentController 인스턴스 생성
		StudentController sc = new StudentController();
		
		// Student_List
		// => 요청에 해당하는 service.selectList() 메서드 실행
		// => 위 의 결과를 view 에 처리하도록 전달
		sc.printList(sc.service.selectList());
		
		// Student_Detail
		StudentVO vo = new StudentVO();
		vo.setSno(22);
		sc.printDetail(sc.service.selectOne(vo));
		
		// Group 적용
		sc.printGroup(sc.service.groupList());
		
		
	}

}
