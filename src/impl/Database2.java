package impl;

import java.sql.*;

import impl.*;
import factory.*;

public class Database2 implements MyConnection{
	
	public static Database2 instance = new Database2();
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String USER = "root";
	public static final String PASSWORD = "Tpg@1234";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS);
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
        		Database2 jdbc = new Database2();
                con = jdbc.getConnection();  
                ps = con.prepareStatement("insert into employee(empName,empPassword) values(?,?)");
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
	        	  	Database2 jdbc = new Database2();
	        	  	con = jdbc.getConnection();  
	                ps = con.prepareStatement("select * from employee");
	                rs = ps.executeQuery();  
	                while (rs.next()) {  
	                	System.out.println("user= "+rs.getString(2)+"\t"+"Password= "+rs.getString(3));       
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
        		Database2 jdbc = new Database2();
                c = jdbc.getConnection();  
                ps = c.prepareStatement("update employee set empPassword=? where empName='"+name+"'");  
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
        	Database2 jdbc = new Database2();
        	c = jdbc.getConnection();  
            ps = c.prepareStatement("delete from employee where empName='"+username+"'");
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
