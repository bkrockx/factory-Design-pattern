package impl;

import java.sql.*;

public interface MyConnection {
	
	Connection getConnection() throws SQLException, ClassNotFoundException;

	public int insert(String username, String password) throws SQLException;
	
	public  void view() throws SQLException;
	
	public int update(String name, String password) throws SQLException;
	
	public int delete(String username) throws SQLException;
}
