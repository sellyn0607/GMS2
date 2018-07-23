package domain;

import lombok.Data;

@Data
public class ExamBean extends ProjectBean{
	
	String examSeq,memId,score,month,subSeq,recoreSeq,
	scJava,scHtml,scR,scPhy,scSql;
	

	@Override
	public String toString() {
		return "시험정보[시험SEQ="+examSeq
				+"  학생ID="+memId
				+"  점수=" + score
				+"  월=" + month+"]";
	}


}
