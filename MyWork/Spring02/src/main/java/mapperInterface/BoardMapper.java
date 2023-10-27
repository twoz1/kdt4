package mapperInterface;

import java.util.List;

import domain.BoardDTO;

public interface BoardMapper {
	
	    // ** Reply Insert
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
		
		// ** Reply Insert
		
		

}
