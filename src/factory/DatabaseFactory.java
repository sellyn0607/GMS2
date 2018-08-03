package factory;

import java.util.Map;

import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {

	public static Database createDatabase(Vendor v,String id,String pass) {
		Database database =null;
		
		switch(v) {
		case ORACLE:
			database=new Oracle(DBConstant.ORACLE_DRIVER,DBConstant.CONNECTION_URL,id,pass);
		
			
			break;
		case MARIADB: 
		/*	driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			*/
			break;
		case MYSQL: 
			/*driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			*/
			break;
		case MSSQL: break;
		
			default:break;
		}

		return database;
		
	}
	public static Database createDatabase2(Map<String,?> map) {
		Database db =null;
		String driver="",url="";
		
		switch((Vendor)map.get("Vendor")) {
		case ORACLE:
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db=new Oracle(driver,url,(String)map.get("userid"),(String)map.get("userpw"));
		
			
			break;
		case MARIADB: 
			/*driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db=new MariaDB(driver,url,(String)map.get("userid"),(String)map.get("userpw"));*/
			break;
		case MYSQL: 
			/*driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			*/
			break;
		case MSSQL: break;
		
			default:break;
		}

		return db;
		
	}
}
