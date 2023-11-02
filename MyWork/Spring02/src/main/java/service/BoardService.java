package service;

import java.util.List;

import criTest.SearchCriteria;
import domain.BoardDTO;

public interface BoardService {
	
	// ** Board_Cri_Paging
	List<BoardDTO> bcriList(SearchCriteria cri); // 출력할 Data만 select
	int criTotalCount(SearchCriteria cri); // 전체 rows 갯수

	// ** 답글등록
	int rinsert(BoardDTO dto);
	
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