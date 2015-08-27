package impl;

import java.sql.*;

import impl.*;
import factory.*;

public class Database1 implements MyConnection{

	public static Database1 instance = new Database1();
	public static final String URL = "jdbc:mysql://localhost:3306/world";
	public static final String USER = "root";
	public static final String PASSWORD = "Tpg@1234";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	@Override
	public Connection getConnection() throws SQLException {
		
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		connection = DriverManager.getConnection(URL,USER,PASSWORD);
		return connection;
	}

	@Override
	public int insert(String username, String password) throws SQLException {
		
		Connection con =null;  
        PreparedStatement ps=null;  
          
        int Counter=0;    
        try {  
        		Database1 jdbc = new Database1();
                con = jdbc.getConnection();  
                ps = con.prepareStatement("insert into user(username,password) values(?,?)");  
                ps.setString(1,username);  
                ps.setString(2,password);  
                Counter = ps.executeUpdate();  
                  
        } catch (Exception e) { 
        	e.printStackTrace(); 
        } finally{  
              if (ps!=null){  
                ps.close();  
            }if(con!=null){  
                con.close();  
            }   
        }  
        
       return Counter;  
	}

	@Override
	public void view() throws SQLException {
		
		Connection con = null;  
	    PreparedStatement ps = null;  
	    ResultSet rs = null;          
	          try { 
	        	  	Database1 jdbc = new Database1();
	        	  	con = jdbc.getConnection();  
	                ps = con.prepareStatement("select * from user");    
	                rs = ps.executeQuery();  
	                while (rs.next()) {  
	                	System.out.println("Name= "+rs.getString(2)+"\t"+"Password= "+rs.getString(3));       
	                }  
	          } 
	          catch (Exception e) { 
	        	  System.out.println(e);
	          }  
	          finally{  
	              if(rs!=null){  
	                  rs.close();  
	              }if (ps!=null){  
	                ps.close();  
	            }if(con!=null){  
	                con.close();  
	            }   
	          }  
		
		
	}

	@Override
	public int update(String name, String password) throws SQLException {
		Connection c=null;  
        PreparedStatement ps=null;  
          
        int Counter=0;  
        try {  
        		Database1 jdbc = new Database1();
                c = jdbc.getConnection();  
                ps = c.prepareStatement("update user set password=? where username='"+name+"' ");  
                ps.setString(1,password);  
                Counter = ps.executeUpdate();  
        } catch (Exception e) {  
        	e.printStackTrace(); 
        } finally{         
            if (ps!=null){  
                ps.close();  
            }
            if(c!=null){  
                c.close();  
            }   
         }  
       return Counter; 
	}

	@Override
	public int delete(String username) throws SQLException {
		Connection c = null;  
        PreparedStatement ps = null;  
        int Counter=0;  
        try {
        	Database1 jdbc = new Database1();
        	c = jdbc.getConnection();  
            ps = c.prepareStatement("delete from user where username='"+username+"' ");  
            Counter = ps.executeUpdate();  
        } catch (Exception e) { 
        	e.printStackTrace(); 
        }finally{  
        	if (ps!=null){  
        		ps.close();  
        	}
        	if(c!=null){  
               c.close();  
        	}   
        }	  
       return Counter;  
    }

}
