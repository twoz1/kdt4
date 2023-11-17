package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.GuestBookDTO;
import com.example.demo.entity.GuestBook;
import com.example.demo.entity.Member;


public interface MemberService {
   
   // ** selectList
   List<Member> selectList();

   // ** selectOne
   Member selectOne(String id);

   // ** insert, update
   String save(Member entity);

   // ** delete
   String delete(String id);

}