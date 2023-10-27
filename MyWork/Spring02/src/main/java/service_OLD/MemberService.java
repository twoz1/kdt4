package service_OLD;

import java.util.List;

import domain.MemberDTO;

public interface MemberService {
	
	// ** Jo_List 추가
	List<MemberDTO> joList(int jno);

	// ** selectList
	List<MemberDTO> selectList();

	// ** selectOne
	MemberDTO selectOne(MemberDTO dto);

	// ** insert
	int insert(MemberDTO dto);

	// ** update
	int update(MemberDTO dto);

	// ** delete
	int delete(MemberDTO dto);

}