package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.BoardDTO;


//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
//   Create(Insert), Read(selectList, selectOne), Update, Detete

//=> 첫번째 예제 Ex01_~~~ 와 DAO 와 다른점
//    - 요청 처리 결과를 제공
//   - 즉, 메서드의 역할별로 처리결과를 return 해야함
//   - 그러므로 특히 select 결과를 전달하기위해 결과를 담는 작업이 필요함  
@Repository
public class BoardDAO {
	// ** 전역변수 정의
	private static Connection cn = DBConnection.getConnection(); 
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;
	
	// ** selectList
	public List<BoardDTO> selectList() {
		sql="select * from board order by root desc, step asc";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);
			if (rs.next()) {
				// => selectList 결과 존재
				// => 결과를 list 에 담기

				do {
					BoardDTO dto = new BoardDTO();
					dto.setSeq(rs.getInt(1));
					dto.setId(rs.getString(2));
					dto.setTitle(rs.getString(3));
					// dto.setContent(rs.getString(4));
					dto.setRegdate(rs.getString(5));
					dto.setCnt(rs.getInt(6));
					dto.setRoot(rs.getInt(7));
					dto.setStep(rs.getInt(8));
					dto.setIndent(rs.getInt(9));
					list.add(dto);
				}while(rs.next());
			}else {
				list=null;
			}
		} catch (Exception e) {
			System.out.println("** selectList Exception => "+e.toString());
			list=null;
		}
		return list;
	} //selectList

	// ================================================================================
	
	// ** selectOne
	public BoardDTO selectOne(BoardDTO dto) {
		sql="select * from board where seq=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, dto.getSeq());
			rs=pst.executeQuery();
			if (rs.next()) {
				// => Data 존재: rs 을 vo에 담아서 return
				dto.setSeq(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getString(5));
				dto.setCnt(rs.getInt(6));
				dto.setRoot(rs.getInt(7));
				dto.setStep(rs.getInt(8));
				dto.setIndent(rs.getInt(9));
				return dto;
			}else {
				return null; 
			}
		} catch (Exception e) {
			System.out.println("** Board selectOne Exception => "+e.toString());
			return null;
		}
	} //selectOne

	// ================================================================================

	// ** insert
	// => 원글 입력 컬럼: name, title, content
	// 	  default 값 : regdate, cnt
	// => Auto_Inc : seq (계산 : auto 보다 max(seq)를 이용하여 직접 계산) 
	
	// => 댓글 입력 추가후에는 수정해야함 (root_seq 와 동일값 추가)
	public int insert(BoardDTO dto) {
		// => 댓글 입력하기 전
//		sql="insert into board(seq, id, title, content) values("
//				+ " (select * from (select IFNULL(max(seq), 0) + 1 from board) as temp)" // seq값 계산
//				+ ",?,?,?)";
		sql="insert into board(seq, id, title, content, root) values("
				+ " (select * from (select IFNULL(max(seq), 0) + 1 from board) as temp)" // seq값 계산
				+ ",?,?,?,"
				+ "(select * from (select IFNULL(max(seq), 0) + 1 from board) as temp))";
					// seq 와 동일한 root 값 
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());
			return pst.executeUpdate(); // 처리갯수

		} catch (Exception e) {
			System.out.println("** insert Exception => "+e.toString());
			return 0;
		}
	} //insert
	
	// ================================================================================
	
	// ** 답글등록
	// => 댓글등록, seq는 IFNULL 이용
	// => stepUpdate 가 필요함
	//    댓글 입력 성공후 실행
	//     -> 현재 입력된 답글의 step 값은 수정되지 않도록 sql 구문의 조건 주의    
	// => JDBC subQuery 구문 적용시 주의사항
	//     -> MySql: select 구문으로 한번더 씌워 주어야함 (insert 의 경우에도 동일)   
	public int rinsert(BoardDTO dto) {
		sql="insert into board(seq, id, title, content, root, step, indent) values( "
				+"(select * from (select IFNULL(max(seq),0) + 1 from board) as temp)"
				+ ",?, ?, ?, ?, ?, ?)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			pst.setString(2, dto.getTitle());
			pst.setString(3, dto.getContent());
			pst.setInt(4, dto.getRoot());
			pst.setInt(5, dto.getStep());
			pst.setInt(6, dto.getIndent());
			pst.executeUpdate(); // 댓글 입력 성공 -> stepUpdate
			System.out.println("stepUpdate Count => " + stepUpdate(dto));
			// => 만약 rinsert 도중 오류발생시에는 catch 블럭으로 이동
			return 1;
		} catch (Exception e) {
			System.out.println("** Reply_insert Exception => "+e.toString());
			return 0;
		}
	}
	
	public int stepUpdate(BoardDTO dto) {
		sql="update board set step = step + 1 where root = ? and step >= ? "
				+ "and seq <> (select * from (select IFNULL(max(seq),0) from board) as temp)";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, dto.getRoot());
			pst.setInt(2, dto.getStep());
			return pst.executeUpdate(); // 수정된 Data 갯수 return
		} catch (Exception e) {
			System.out.println("** stepUpdate Exception => "+e.toString());
			return 0;
		}
	}
	// ================================================================================
	
	// ** update
	// => Title, Content 만 수정
	public int update(BoardDTO dto) {
		sql="update board set title=?, content=?, cnt=? where seq=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setString(1, dto.getTitle());
			pst.setString(2, dto.getContent());
			pst.setInt(3, dto.getCnt());
			pst.setInt(4, dto.getSeq());
			return  pst.executeUpdate(); // 처리개수 
		} catch (Exception e) {
			System.out.println("** update Exception => "+e.toString());
			return 0;
		}
	} //update

	// ================================================================================
	
	// ** delete
	// => id 로 삭제
	public int delete(BoardDTO dto) {
		sql="delete from board where seq=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, dto.getSeq());
			
			return pst.executeUpdate(); // 처리갯수
		} catch (Exception e) {
			System.out.println("** delete Exception => "+e.toString());
			return 0;
		}
	} //delete



} //class