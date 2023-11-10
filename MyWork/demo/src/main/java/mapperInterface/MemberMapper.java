package mapperInterface;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.MemberDTO;

//import criTest.SearchCriteria;

public interface MemberMapper {
   
   // Junit Test
   // => @Select 적용 연습
   // @Select("select * from member where id=#{id}")
   // MemberDTO selectOneID(String id);
   // => mapper 메서드의 매개변수는 Type 무관, 그러나 개수는 반드시 1개
   
   // @Param 적용 Test
   //  -> 기본규칙 : Mybatis 에서는 매개변수 Type은 무관하지만, 개수는 1개만 허용
   //  -> @Param : mapper 에서 #{...} 적용, 복수개수 사용 가능 (단, 기본자료형은 사용불가)
   @Select("select * from member where id=#{ii} and jno=#{jno}")
   MemberDTO selectOneJno(@Param("ii") String id, @Param("jno") Integer jno);
   
   // => totalCount (Group 함수 Test)
   // @Select("select count(*) from member where id != 'admin'")
   // int totalCount();
   
   /*   
   // ** Member SearchCri_PageList *******************
   List<MemberDTO> searchList(SearchCriteria cri);
   int searchTotalCount(SearchCriteria cri);
   
   // ** Member Check_List
   List<MemberDTO> mcheckList(SearchCriteria cri);
   int checkTotalCount(SearchCriteria cri);
   
   // ** JoInfo_List 추가 
   List<MemberDTO> joInfoList();
*/
   
   // ** Jo_List 추가
   List<MemberDTO> joList(int jno);
   
   // ** selectList
   List<MemberDTO> selectList();

   // ** selectOne
   MemberDTO selectOne(MemberDTO dto);

   // ** insert
   int insert(MemberDTO dto);

   // ** update
   // => id (P.Key) 제외한 모든 컬럼수정
   int update(MemberDTO dto);

   // ** delete
   int delete(MemberDTO dto);
   
}