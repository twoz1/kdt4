package mapperInterface;

import java.util.List;

import domain.BoardDTO;
import domain.MemberDTO;

public interface MemberMapper {

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
