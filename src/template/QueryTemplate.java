package template;

import java.sql.*;
import java.util.*;
import enums.*;
import lombok.Data;
import pool.DBConstant;

@Data
public abstract class QueryTemplate {
		abstract void initialize();
	    abstract void startPlay();
	    abstract void endPlay();
	   
	   HashMap<String,Object>map;
	   List<Object> list;
	   PreparedStatement pstmt;

	   //template method
	   public final void play(HashMap<String,Object>map){
		   this.pstmt = null;
		   this.list = new ArrayList<>();
		   this.map =map;
		   this.map.put("Vendor", Vendor.ORACLE);
		   this.map.put("userid", DBConstant.USERID);
		   this.map.put("userpw", DBConstant.USERPW);
	      //initialize the game
	      initialize();

	      //start game
	      startPlay();

	      //end game
	      endPlay();
}
}