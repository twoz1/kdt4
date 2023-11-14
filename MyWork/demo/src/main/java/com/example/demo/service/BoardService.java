package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardDTO;

import criTest.SearchCriteria;

public interface BoardService {
	   // REST API, Axios Test
	   List<BoardDTO> idBList(String id);
	   
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