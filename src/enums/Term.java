package enums;

public enum Term {
	MEMBER,EXAM,PROJECTTEAM,RECORD,SUBJECT,CONTEXT,WEBPATH,MAIN;

	public String toString() {
		String res="";
		switch(this) {
		case CONTEXT:
			res = "CONTEXT"; break;
		case WEBPATH:
			res = "/WEB-INF/view"; break;
		case MAIN:
			res = "/main.jsp"; break;
		
		}
		return res;
	}

}
