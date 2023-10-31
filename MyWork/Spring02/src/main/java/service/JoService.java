package service;

import java.util.List;

import domain.JoDTO;

public interface JoService {

	// ** selectList
	List<JoDTO> selectList();

	// ** selectOne
	JoDTO selectOne(JoDTO dto);

	// ** insert
	int insert(JoDTO dto);

	// ** update
	int update(JoDTO dto);

	// ** delete
	int delete(JoDTO dto);

}