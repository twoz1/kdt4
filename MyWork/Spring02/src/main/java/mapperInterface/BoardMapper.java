package mapperInterface;

import java.util.List;

import criTest.SearchCriteria;
import domain.BoardDTO;

public interface BoardMapper {
	
	// ** Board_SearchCri_Paging
	// => Cri + 검색조건
	List<BoardDTO> searchCri(SearchCriteria cri);
	int searchTotalCount(SearchCriteria cri);
	
	   // Board_cri_Paging
	   List<BoardDTO> bcriList(SearchCriteria cri); // 출력할 Data만 select
	   int criTotalCount(); // 전체 rows 개수
	   
	
	// ** 답글등록
	// => rinsert , stepUpdate
	int rinsert(BoardDTO dto);
	int stepUpdate(BoardDTO dto);
	
	// ** selectList
	List<BoardDTO> selectList();

	// ** selectOne
	BoardDTO selectOne(BoardDTO dto);

	// ** insert
	int insert(BoardDTO dto);

	// ** update
	int update(BoardDTO dto);

	// ** delete
	int delete(BoardDTO dto);

}
