package com.example.demo.service;

import java.util.List;


import com.example.demo.domain.MemberDTO;


public interface MemberService {
   
   // ** RTestController incheck2 Test
   MemberDTO selectOneJno(String id, Integer jno);
   
   // ** Jo_List 추가
   List<MemberDTO> joList(int jno);

   // ** selectList
   List<MemberDTO> selectList();

   // ** selectOne
   MemberDTO selectOne(MemberDTO dto);

   // ** insert
   int insert(MemberDTO dto);

   // ** update
   int update(MemberDTO dto);

   // ** delete
   int delete(MemberDTO dto);

}