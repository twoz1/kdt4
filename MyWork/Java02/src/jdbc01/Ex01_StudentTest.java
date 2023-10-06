package jdbc01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ex01_StudentTest {
   // ** 전역변수 정의 
   private static Connection cn = DBConnection.getConnection();
   private static Statement st;
   private static PreparedStatement pst;
   private static ResultSet rs;
   private static String sql;


   // ** Student_List
   public static void selectList() {
      // 1) Connection
      // => 전역변수로 전달받음

      // 2) sql 구문 처리 
      sql = "select * from student";
      try {
         st = cn.createStatement();
         rs = st.executeQuery(sql);
         // 3) 결과 출력
         // => select 결과 존재 여부 확인 & 출력
         // => ResultSet 객체는 이를 위한 메서드 제공
         // => next() : 다음 Data가 존재하면 true, 현 Data를 제공
         System.out.println("----------------------------------------------------");
         System.out.println("** Student List");
         System.out.println("----------------------------------------------------");
        if(rs.next()) {
        	// => selectList 결과 존재
        	do {
        		System.out.print(rs.getInt(1));
        		System.out.print(rs.getString(2)+ " ");
        		System.out.print(rs.getInt(3)+ " ");
        		System.out.print(rs.getInt(4)+ " ");
        		System.out.print(rs.getString(5)+" ");
        		System.out.print(rs.getFloat(6)+ " ");
        		System.out.print(rs.getString(7)+" ");
        		System.out.print(rs.getString(8)+"\n");
        		
        	}while(rs.next());
        }else {
        	System.out.println("selectList : 출력 Data 가 1 도 없음");
        }
         
      }catch(Exception e) {
         System.out.println("** selectList Exception => "+e.toString());
      }
      
      
   }// selectList
    // ** 조별 StudentList
    // => 출력 jno는 매개변수로 전달
    // select sno, name, jno, point + age bonus from student where jno = 1,2,3,4,5,7
    
   public static void studentList(int jno) {
	   sql = "select sno, name, jno, point+age bonus from student where jno =" + jno;
	   try {  // 데이터를 처리하는 애
		   st = cn.createStatement();
	       rs = st.executeQuery(sql); 
	       System.out.println("----------------------------------------------------");
	       System.out.println("** StudentList " +jno+"조");
	       System.out.println("----------------------------------------------------");
	   if(rs.next()) {
		   do {
			   System.out.print(rs.getInt(1)+" ");
			   System.out.print(rs.getString("name")+" ");
			   System.out.print(rs.getInt(3)+" ");
			   System.out.print(rs.getInt("bonus")+" ");
			   System.out.print(rs.getString(4)+"\n");
			 
		   }while(rs.next());
	    }else{
       	 System.out.println("StudentList : 출력 Data 가 1 도 없음");
        }
        }
	   catch(Exception e) {
		   System.out.println("** StudentList Exception => "+e.toString());
	    	}
	    }//studentList
	    
   // *** insert
   // => insert into student (name, age, jno, info) values ('홍길동', 22 , 7 , 'Insert Test')
   // => Statement로 처리하면 아래처럼 매우 불편하고 오류 확률이 매우 높음
   // => 이 점을 해결한 것이 PreparedStatement
   // => PreparedStatement : 바인딩변수 ? 제공
   //     "insert into student values(?,?,?,?,?,?,?,?)"
   //    ? 해결 : Query 구문 실행전에
   public static void insert(String name, int age, int jno, String info) {
	   // Statement 적용
	   // sql="insert into student(name, age, jno, info) values ('"
	   //	         +name+"',"+age+","+jno+",'"+info+"')";
		         
	   // => PreparedStatement 적용
	   sql="insert into student (name, age, jno, info) values (?, ?, ?, ?)";       
		  
		  
	   try {
		pst=cn.prepareStatement(sql);
		pst.setString(1, name);
		pst.setInt(2, age);
		pst.setInt(3, jno);
		pst.setString(4, info);
		
		
		// int count = pst.executeUpdate(); // 매개변수로 sql이 들어가면 안 됨. 그럼 위 물음표가 들어감
		// if(count > 0 ) System.out.println("*** insert 성공 ***");
		//  => 비교
		
		if(pst.executeUpdate() > 0 ) System.out.println("*** insert 성공 ***");
		else System.out.println("*** insert 실패 ***");
		
	} catch (Exception e) {
	   System.out.println("*** insert Exception => " + e.toString());
	}
   } //insert
   
   // => PreparedStatement 연습
   // => ? 가 필요없는 selectList 에 적용하기 (될까 / 안될까)
   public static void selectList2() {
	      // 1) Connection
	      // => 전역변수로 전달받음

	      // 2) sql 구문 처리 
	      sql = "select * from student";
	      try {
	         pst = cn.prepareStatement(sql);
	         rs = pst.executeQuery(); // 매개변수 필요 없음.
	         // 3) 결과 출력
	         // => select 결과 존재 여부 확인 & 출력
	         // => ResultSet 객체는 이를 위한 메서드 제공
	         // => next() : 다음 Data가 존재하면 true, 현 Data를 제공
	         System.out.println("----------------------------------------------------");
	         System.out.println("** Student List");
	         System.out.println("----------------------------------------------------");
	        if(rs.next()) {
	        	// => selectList 결과 존재
	        	do {
	        		System.out.print(rs.getInt(1));
	        		System.out.print(rs.getString(2)+ " ");
	        		System.out.print(rs.getInt(3)+ " ");
	        		System.out.print(rs.getInt(4)+ " ");
	        		System.out.print(rs.getString(5)+" ");
	        		System.out.print(rs.getFloat(6)+ " ");
	        		System.out.print(rs.getString(7)+" ");
	        		System.out.print(rs.getString(8)+"\n");
	        		
	        	}while(rs.next());
	        }else {
	        	System.out.println("selectList : 출력 Data 가 1 도 없음");
	        }
	         
	      }catch(Exception e) {
	         System.out.println("** selectList Exception => "+e.toString());
	      }
	      
	   }// selectList
   
   public static void joList() {
	   sql = "select * from jo";
	   try {
		   st = cn.createStatement();
	       rs = st.executeQuery(sql); 
	         System.out.println("----------------------------------------------------");
	         System.out.println("** Jo List");
	         System.out.println("----------------------------------------------------");
	         if(rs.next()) {
	        	 do {
	        		System.out.print(rs.getInt(1)+" ");
	         		System.out.print(rs.getString("jname")+ " ");
	         		System.out.print(rs.getInt(3)+ " ");
	         		System.out.print(rs.getString(4)+" ");
	         		System.out.print(rs.getString(5)+" \n");
	        	 }while(rs.next());
	         }else{
	        	 System.out.println("joList : 출력 Data 가 1 도 없음");
	         }
	         }catch(Exception e) {
	        	 System.out.println("** joList Exception => "+e.toString());
	         }
   }
   
   

   public static void main(String[] args) {
      // ** Student_List
      // => MySql 작업순서
      // -> 로그인
      // -> Sql 구문 실행 & 결과출력
      // -> 결과출력
	   
      // 1) DB 연결
      System.out.println("DB 연결 확인 => " +cn);
  
      // 2) Sql 구문 실행 & 결과출력
      selectList2();
      // 3) joList 실습 
      joList();
      
      // 4) 조별 studentList : 내일
      studentList(3);
      
      //5) insert 
      //insert("냥냥관리자",99,7,"prepareStatement Test");
      
   }// main

}// class