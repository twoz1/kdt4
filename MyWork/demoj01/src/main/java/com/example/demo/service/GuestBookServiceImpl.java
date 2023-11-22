package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.GuestBookDTO;
import com.example.demo.domain.PageRequestDTO;
import com.example.demo.domain.PageResultDTO;
import com.example.demo.entity.GuestBook;
import com.example.demo.repository.GuestBookRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;



// ** JPA 의 CRUD 메서드
// => ~Repository 를 통해 JPA 의 EntityManager 에 접근됨.
// => EntityManager : 영속 계층에 접근하여 엔티티에 대한 DB 작업을 제공함.
// => 주요 메서드
//		- Insert : save(엔티티 객체)
// 		- Select : findAll(), findById(키), getOne(키) ..
// 		- Update : save(엔티티 객체)
// 		- Delete : deleteById(키), delete(엔티티 객체)
// => Insert, Update 모두 save(엔티티 객체)를 사용하는 이유
//	  	- JPA의 save 는 비교후 없으면 insert, 있으면 update를 동작시킴.	
//		- deleteById(키) 삭제의 경우에도 select 후 없으면 ~~DataAccessException 발생시키고
//		  있으면 삭제하고 void 로 정의되어 return값 없음. 

@Service
@Log4j2
@RequiredArgsConstructor 
// => 각필드에 대해 1개의 매개변수가 있는 생성자를 생성함.
// => 초기화 되지않은 모든 final 필드에만 적용됨.
public class GuestBookServiceImpl implements GuestBookService {

    private final GuestBookRepository repository;
    // => JPA 처리위해 필요
    // => @RequiredArgsConstructor 를 통해 주입받음
    
    // JPA Paging & Sorting
    @Override
    public PageResultDTO<GuestBookDTO, GuestBook> gPageList(PageRequestDTO requestDTO) {
       
       Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
        // => Sort.by("gno").descending(): Sort 객체를 이용해서 정렬 조건 지정
        
        Page<GuestBook> result = repository.findAll(pageable);
        // => pageable 의 조건을 반영하여 findAll
        
        Function<GuestBook, GuestBookDTO> fn = (entity -> entityToDto(entity));
        // => Service 에 정의한 entityToDto 메서드를 이용해서 entity를 Dto로
        
        return new PageResultDTO<>(result, fn);
       
    }
    
    @Override
    public Long register(GuestBookDTO dto) {

        log.info("DTO------------------------");
        log.info(dto);

        GuestBook entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity); // 저장 또는 수정

        return entity.getGno();  // 저장후 gno return
    }
    
    @Override
    public List<GuestBook> selectList() {
    	return repository.findAll();
    }
    @Override
    public GuestBook selectOne(Long gno) {
    	//return repository.getById(gno);
    	
    	// ** Optional<T>
    	// => Java8부터 Optional<T>클래스를 사용해 NullPointerException(이하 NPE)를 방지할수 있도록 지원.
    	//	  즉, Optional<T>는 null이 올수 있는 값을 감싸는 Wrapper클래스로, 참조하더라도 NPE가 발생하지 않도록 도와줌.
    	//	  제공되는 메소드로 복잡한 조건문 없이 NPE를 회피할 수 있어록 해줌
    	// => sPresent() : Optional객체에 저장된 값이 null인지 확인
    	// => get() : Optional객체에 저장된 값 제공
    	// => 참고 https://esoongan.tistory.com/95
    	
    	Optional<GuestBook> result = repository.findById(gno);
    	if ( result.isPresent() ) return result.get();
    	else return null;
    }
    @Override
    public void delete(Long gno) {
    	repository.deleteById(gno);
    }

}
