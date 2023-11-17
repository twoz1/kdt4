package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// ** Entity
// => Password 처음 입력은 가능하지만,
//    수정은 별도로 처리해야 하므로 수정불가
// => MultipartFile uploadfilef
//    SQL 구문에서 제외시켜줌


@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//=> 정의된 모든 필드에 대한 
//   Getter, Setter, ToString 과 같은 모든 요소를 한번에 만들어주는 애너테이션.
public class Member {
   
   @Id
   private String id; // Primary Key
   
   @Column(updatable = false)
   private String password; // not null 
   
   private String name;
   private int age;
   private int jno;
   private String info;
   private double point;
   private String birthday;
   private String rid;  // 추천인
   private String uploadfile; // Table에 보관된 File_Path
   
   @Transient
   private MultipartFile uploadfilef;
   // => form 의 Upload_File 정보를 전달받기위한 필드
   //    MultipartFile (Interface) -> CommonsMultipartFile

} //class