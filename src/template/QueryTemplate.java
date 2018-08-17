package template;

import java.sql.*;
import java.util.*;

import domain.ImageBean;
import domain.MemberBean;
import enums.*;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;

@Data
public abstract class QueryTemplate {
		abstract void initialize();
	    abstract void startPlay();
	    abstract void endPlay();
	   
	   Map<String,Object>map;
	   List<Object> list;
	   PreparedStatement pstmt;
	   MemberBean mem2;
	   ImageBean img2;
	   Object o; // 멤버빈 담는그릇 수정할것 
	   
	   int count;

	   //template method
	   public final void play(Map<?,?> map){
		   this.pstmt = null;
		   this.list = new ArrayList<>();
		   this.map =new HashMap<>();
		   this.o=null;
		   this.img2=new ImageBean();
		   this.count= 0;
		   this.mem2= new MemberBean();
		   this.map.put("Vendor", Vendor.ORACLE);
		   this.map.put("userId", DBConstant.USERID);
		   this.map.put("userpw", DBConstant.USERPW);
		   Iterator<?> keys = map.keySet().iterator();
		   while(keys.hasNext()) {
			   String key = (String) keys.next();
			   this.map.put(key,map.get(key));
		   }
		   //initialize the game
		      initialize();
		      pstmtInit();
		      //start game
		      startPlay();

		      //end game
		      endPlay();
		   
	    
}
	   public void pstmtInit() {
			try {
				this.pstmt=DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	   
}