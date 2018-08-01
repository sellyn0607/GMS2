package domain;

import lombok.Data;

@Data
public class MemberBean {
	
	String userid,password,ssn,name,roll,teamId,age,subject,gender;
	boolean overlap;

	@Override
	/*public String toString() {
		return "회원목록 [아이디=" + userid + ", 비밀번호=" + password + ", 주민번호=" + ssn + ", 이름=" + name + ", 역할="
				+ roll + ", TeamId=" + teamId + ", 나이=" + age + ", 성별=" + gender + "]";
	}*/

	public String toString() {
		return String.format("아이디 : %s , 비밀번호 : %s , 주민번호 : %s , 이름 : %s, %s",userid,password,ssn,name,overlap);
		
	}
}
	