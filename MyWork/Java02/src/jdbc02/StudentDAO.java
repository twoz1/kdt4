package jdbc02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc01.DBConnection;

//** DAO(Data Access Object)
//=> SQL 구문 처리
//=> CRUD 구현 
// Create(Insert), Read(selectList, selectOne), Update, Detete

//=> 첫번째 예제 Ex01_~~~ 와 DAO 와 다른점
//  - 요청 처리 결과를 제공
//  - 즉, 메서드의 역할별로 처리결과를 return 해야함
//  - 그러므로 특히 select 결과를 전달하기위해 결과를 담는 작업이 필요함
public class StudentDAO {

	private static Connection cn = DBConnection.getConnection();
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static String sql;

	// selectList
	public List<StudentVO> selectList() {
		sql="select * from student";
		List<StudentVO> list = new ArrayList<StudentVO>();

		try {
			st=cn.createStatement();
			rs=st.executeQuery(sql);

			if(rs.next()) {
				// => selectList 결과 존재
				do {
					// rs의 데이터를 list에 담기
					// 1row 단위로 옮겨야함

					// vo의 선언도 반복문에 꼭 넣어주어야 함
					StudentVO vo = new StudentVO();

					vo.setSno(rs.getInt(1));
					vo.setName(rs.getString(2));
					vo.setAge(rs.getInt(3));
					vo.setJno(rs.getInt(4));
					vo.setInfo(rs.getString(5));
					vo.setPoint(rs.getDouble(6));
					vo.setBirthday(rs.getString(7));
					list.add(vo);

				}while(rs.next());

			}else {
				list=null;
			}

		} catch (Exception e) {
			System.out.println("** selectList Exception => "+e.toString());
			list=null;

		}

		return list;
	}

	// selectOne
	public StudentVO selectOne(StudentVO vo) {
		sql="select * from student where sno=?";
		try {
			pst=cn.prepareStatement(sql);
			pst.setInt(1, vo.getSno());

			rs=pst.executeQuery();

			if(rs.next()) {
				vo.setName(rs.getString(2));
				vo.setAge(rs.getInt(3));
				vo.setJno(rs.getInt(4));
				vo.setInfo(rs.getString(5));
				vo.setPoint(rs.getDouble(6));
				vo.setBirthday(rs.getString(7));

				return vo;

			}else {
				return null;
			}
		}catch(Exception e){
			System.out.println("** selectOne Exception => "+e.toString());
			return null;
		}
	}//selectOne

	// Group 적용
	public List<GroupDTO> groupList() {
		sql = "select jno, count(*), sum(age), avg(age), max(age), min(age)"
				+ "from student Group by jno order by jno";
		List<GroupDTO> list = new ArrayList<>();
		try {
			pst =cn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()) {
				do {
					GroupDTO dto = new GroupDTO();
					dto.setJno(rs.getInt(1));
					dto.setCount(rs.getInt(2));
					dto.setSum(rs.getInt(3));
					dto.setAvg(rs.getDouble(4));
					dto.setMax(rs.getInt(5));
					dto.setMin(rs.getInt(6));
					
					list.add(dto);
				}while(rs.next());
			}else list = null;
		} catch (Exception e) {
			System.out.println("** groupList Exception => "+e.toString());
			list = null;
		}
		return list;
	}


	// Insert

	// Update

	// Detete

}