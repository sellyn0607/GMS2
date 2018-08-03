package template;
import java.lang.reflect.Field;

import enums.Domain;
import domain.MemberBean;

public class ColumnFinder {
	public static String find(Domain dom) {
		String s="";
		Class<MemberBean> clazz = null;
		switch(dom) {
		case MEMBER:
			clazz=MemberBean.class;
			break;
		case ADMIN:
			clazz=MemberBean.class;
			break;
		default:
			break;
			
		}
		 Field[] f = clazz.getDeclaredFields();
		 for(int i=0; i<f.length;i++) {
			 s+=(i!=(f.length-1))?
					 f[i].getName()+",":
						 f[i].getName();
		 }
		 return s;
	}

}
