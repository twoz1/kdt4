package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import domain.MemberDTO;
import mapperInterface.MemberMapper;

@Component
public class MemberServiceImpl implements MemberService {
	// ** 전역변수 정의
	//MemberDAO dao = new MemberDAO();
	@Autowired
	MemberMapper mapper;
	
	// ** Jo_List 추가
	@Override
	public List<MemberDTO> joList(int jno) {
		return mapper.joList(jno);
	}
	
	// ** selectList
	@Override
	public List<MemberDTO> selectList() {
		return mapper.selectList();
	}
	// ** selectOne
	@Override
	public MemberDTO selectOne(MemberDTO dto) {
		return mapper.selectOne(dto);
	}

	// ** insert
	@Override
	public int insert(MemberDTO dto) {
		return mapper.insert(dto);
	}
	// ** update
	@Override
	public int update(MemberDTO dto) {
		return mapper.update(dto);
	}
	// ** delete
	@Override
	public int delete(MemberDTO dto) {
		return mapper.delete(dto);
	}
	
} //class
