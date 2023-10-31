package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.JoDTO;
import mapperInterface.JoMapper;

@Component
public class JoServiceImpl implements JoService {
	// ** 전역변수 정의
	// MemberDAO dao = new MemberDAO();
	@Autowired
	JoMapper mapper;
	
	// ** selectList
	@Override
	public List<JoDTO> selectList() {
		return mapper.selectList();
	}
	// ** selectOne
	@Override
	public JoDTO selectOne(JoDTO dto) {
		return mapper.selectOne(dto);
	}

	// ** insert
	@Override
	public int insert(JoDTO dto) {
		return mapper.insert(dto);
	}
	// ** update
	@Override
	public int update(JoDTO dto) {
		return mapper.update(dto);
	}
	// ** delete
	@Override
	public int delete(JoDTO dto) {
		return mapper.delete(dto);
	}

	
} //class
