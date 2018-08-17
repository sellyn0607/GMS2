package enums;

public enum Term {
	MEMBER,EXAM,PROJECTTEAM,RECORD,SUBJECT,CONTEXT,WEBPATH,MAIN,
	UPLOAD_PATH;

	public String toString() {
		String res="";
		switch(this) {
		case CONTEXT:
			res = "CONTEXT"; break;
		case WEBPATH:
			res = "/WEB-INF/view"; break;
		case MAIN:
			res = "/main.jsp"; break;
		case UPLOAD_PATH:
			res = "C:\\Users\\1027\\eclipse\\jee-oxygen\\eclipse\\Jeeworkspace\\GMS-Model2\\WebContent\\resources\\img\\upload\\";
			break;
		}
		return res;
	}

}
