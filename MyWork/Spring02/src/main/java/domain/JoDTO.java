package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // 모든값을 초기화하는 생성자
@NoArgsConstructor  // default 생성자
@Data
public class JoDTO {
	private int jno;
	private String jname;
	private String id;
	private String project;
	private String slogan;

	private String cname; // 조장이름, 필요시사용
}
