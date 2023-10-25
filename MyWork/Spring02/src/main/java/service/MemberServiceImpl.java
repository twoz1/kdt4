package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.MemberDTO;
import model.MemberDAO;

@Component
public class MemberServiceImpl implements MemberService {
	// ** 전역변수 정의
	// MemberDAO dao = new MemberDAO();
	@Autowired
	MemberDAO dao;
	
	// ** selectList
	@Override
	public List<MemberDTO> selectList() {
		return dao.selectList();
	}
	// ** selectOne
	@Override
	public MemberDTO selectOne(MemberDTO dto) {
		return dao.selectOne(dto);
	}

	// ** insert
	@Override
	public int insert(MemberDTO dto) {
		return dao.insert(dto);
	}
	// ** update
	@Override
	public int update(MemberDTO dto) {
		return dao.update(dto);
	}
	// ** delete
	@Override
	public int delete(MemberDTO dto) {
		return dao.delete(dto);
	}

	
} //class
