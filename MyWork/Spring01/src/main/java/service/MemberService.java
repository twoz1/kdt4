package service;

import java.util.List;

import domain.MemberDTO;
import model.MemberDAO;

public class MemberService {
	// ** 전역변수 정의
	MemberDAO dao = new MemberDAO();
	// ** selectList
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}
	// ** selectOne
	public MemberDTO selectOne(MemberDTO dto) {
		return dao.selectOne(dto);
	}
	// ** Group 적용

	// ** insert
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
	// ** update
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}
	// ** delete
	public int delete(MemberDTO dto) {
		return dao.delete(dto);
	}
	
} //class
