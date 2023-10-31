package service_OLD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.BoardDTO;
import domain.JoDTO;
import model.JoDAO;

@Component
public class JoServiceImpl implements JoService {
	// ** 전역변수 정의
	// MemberDAO dao = new MemberDAO();
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

	// ** insert
	@Override
	public int insert(JoDTO dto) {
		return dao.insert(dto);
	}
	// ** update
	@Override
	public int update(JoDTO dto) {
		return dao.update(dto);
	}
	// ** delete
	@Override
	public int delete(JoDTO dto) {
		return dao.delete(dto);
	}

	
} //class
