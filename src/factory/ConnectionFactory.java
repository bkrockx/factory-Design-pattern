package factory;

import java.sql.*;

import impl.*;
import factory.*;

public class ConnectionFactory {
	
	public MyConnection getInstance(String databaseName) throws SQLException, ClassNotFoundException{
		
		if(databaseName==null){
			return null;
		}
		else if(databaseName.equalsIgnoreCase("world")){
			/*
			Database1 instance = new Database1();
			Connection con = null;
			con = instance.getConnection();
			return con;
			*/
			return new Database1();
		}
		else if(databaseName.equalsIgnoreCase("test")){
			/*
			Database2 instance = new Database2();
			Connection con = null;
			con = instance.getConnection();
			return con;
			*/
			return new Database2();
		}
		else{
			return null;
		}
	}

}
