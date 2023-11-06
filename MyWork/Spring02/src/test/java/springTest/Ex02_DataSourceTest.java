package springTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.MemberDTO;

//*** DataSourceTest
//=> pom.xml 에 <dependency> spring-jdbc 추가
//=> 인터페이스 DataSource 구현객체 DriverManagerDataSource 를 bean 등록하고 (servlet~.xml 또는 root~.xml 에)
//=> DB Connection 생성 확인

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class Ex02_DataSourceTest {
	@Autowired
	DataSource dataSource;
	// ** 계층도 확인 ( Ctrl+T )
	// => DataSource (interface)
	// 		-> AbstractDataSource
	// 		-> AbstractDriverBasedDataSource
	// 		-> DriverManagerDataSource 
	//    		org.springframework.jdbc.datasource.DriverManagerDataSource
	@Autowired
	MemberDTO dto;

	// 1) DB Connection 확인
	public void connectionTest() {
		try {
			assertNotNull(dataSource.getConnection());
			System.out.println("** DB Connection 성공 => "+dataSource.getConnection());
		} catch (Exception e) {
			System.out.println("** DB Connection 실패 => "+e.toString());
		}
	} //connectionTest
	
	// 2) SQL 실행 Test
	public int delete(MemberDTO dto) {
		String sql="delete from member where id=?";
		try {
			Connection cn = dataSource.getConnection();
			PreparedStatement pst = cn.prepareStatement(sql);
			pst.setString(1, dto.getId());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("** delete Test Exception => "+e.toString());
			return 0;
		}
	} //delete
	@Test
	public void deleteTest() {
		dto.setId("junitSp");
		assertEquals(delete(dto), 1);       
	}
	
} //class
