package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.JoDTO;
import model.JoDAO;

//** interface 자동완성 
//=> Alt + Shift + T  
//=> 또는 마우스우클릭 PopUp Menu 의  Refactor - Extract Interface...

@Service
public class JoServiceImpl implements JoService {
	
	@Autowired
	JoDAO dao;
	
	// ** selectList
	@Override
	public List<JoDTO> selectList() {
		return dao.selectList();
	}
	// ** selectOne
	@Override
	public JoDTO selectOne(JoDTO dto) {
		return dao.selectOne(dto);
	}
	// ** Insert
	@Override
	public int insert(JoDTO dto) {
		return dao.insert(dto);
	}
	// ** Update
	@Override
	public int update(JoDTO dto) {
		return dao.update(dto);
	}
	// ** Delete
	@Override
	public int delete(JoDTO dto) {
		return dao.delete(dto);
	}

} //class
