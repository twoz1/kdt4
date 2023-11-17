package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

// MemberController 에서 요청하는 메서드만 작성하면됨
// => selectList(),
//    service.selectOne(entity.getId())
//    save(entity)

// @Log4j2
@Service
@RequiredArgsConstructor 
public class MemberServiceImpl implements MemberService {
   
   private final MemberRepository repository;

   // ** selectList
   @Override
   public List<Member> selectList() {
      return repository.findAll();
   }
   
   // ** selectOne
   @Override
   public Member selectOne(String id) {
      Optional<Member> result = repository.findById(id);
       if ( result.isPresent() ) return result.get();
       else return null;
   }
   
    @Override
    public String save(Member entity) {
        repository.save(entity); // 저장 또는 수정
        return entity.getId();   // 저장후 Key return
    }
    
   // ** delete
   @Override
   public String delete(String id) {
      repository.deleteById(id);
      return id; // 삭제후 Key return
   }
   
} //class