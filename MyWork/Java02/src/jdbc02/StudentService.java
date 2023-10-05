package jdbc02;

import java.util.List;
	
	
public class StudentService {
	//** 전역변수 정의 
	StudentDAO dao = new StudentDAO();
	
	// ** selectList
	public List<StudentVO> selectList(){
		return dao.selectList();
	}
	// ** selectOne
	public StudentVO selectOne(StudentVO vo) {
		return dao.selectOne(vo);
	}
	// Group 적용
	public List<GroupDTO> groupList(){
		return dao.groupList();
	}
}
