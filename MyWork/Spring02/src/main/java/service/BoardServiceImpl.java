package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.BoardDTO;
import mapperInterface.BoardMapper;

//** Mybatis 적용
//=> CRUD 처리를 Mapper 를 이용
//=> DAO -> Mapper interface ->  Mapper.xml

//** Mybatis interface 방식으로 적용
//=> MemberDAO 대신 MemberMapper 사용
//=> MemberMapper 의 인스턴스를 스프링이 생성해주고 이를 주입받아 실행함
// (스프링이 생성해주는 동일한 타입의 클래스는 JUnit Test 로 확인가능, 추후 실습) 
//=> 단, 설정화일에 <mybatis-spring:scan base-package="mapperInterface"/> 반드시 추가해야함
// MemberDAO 의 Sql구문 처리-> mapperInterface 사용으로 MemberMapper 가 역할을 대신함

//=> SQL 구문 : xml 로작성 -> 이 파일을 Mapper 라 함 

//=> Mapper 작성규칙
//-> mapperInterface 와 패키지명, 파일명이 동일해야함

@Component
public class BoardServiceImpl implements BoardService {
	// ** 전역변수 정의
	@Autowired
	// => BoardMapper 의 인스턴스를 스프링이 생성해주고 이를 주입받아 실행함
	//    즉, 위 인터페이스에 구현체(클래스 객체)는 개발자 작성할 필요가 없음
	BoardMapper mapper;
	
	// 답글등록
	@Override
	public int rinsert(BoardDTO dto) {
		if(mapper.rinsert(dto) >0) {
			// stepUpdate
			System.out.println("stepUpdate Count => " + mapper.rinsert(dto));
			return 1;
		}else {
			return 0;
		}
		
	}
	
	// ** selectList
	@Override
	public List<BoardDTO> selectList() {
		return mapper.selectList();
	}
	// ** selectOne
	@Override
	public BoardDTO selectOne(BoardDTO dto) {
		return mapper.selectOne(dto);
	}

	// ** insert
	@Override
	public int insert(BoardDTO dto) {
		return mapper.insert(dto);
	}
	// ** update
	@Override
	public int update(BoardDTO dto) {
		return mapper.update(dto);
	}
	// ** delete
	@Override
	public int delete(BoardDTO dto) {
		return mapper.delete(dto);
	}

	
} //class
