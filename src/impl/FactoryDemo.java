package impl;

import java.sql.*;

import factory.*;

import java.io.*;

public class FactoryDemo {
	
	public static void main(String[] args) throws IOException{
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		System.out.println("enter the name of database you wanna operate upon");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dbname = br.readLine();
		
		while(true){  
	        System.out.println(" Enter Choice ");  
	        System.out.println(" 1. Insertion ");  
	        System.out.println(" 2. View      ");  
	        System.out.println(" 3. Delete    ");  
	        System.out.println(" 4. Update    ");  
	        System.out.println(" 5. Exit      ");  
	        
	        int count = 1;
			int ch;  
	        
			ch = Integer.parseInt(br.readLine());  
	        if(ch==1) {   
	        			Connection con = null;
	        			PreparedStatement ps=null;
	        			int Counter=0;
	        			
	        	   		System.out.println("Enter username ");  
	                    String username=br.readLine();  
	                    System.out.println("Enter the password");  
	                    String password=br.readLine();  
	                    try {  
	                            
	                    		//con = connectionFactory.getInstance(dbname).getConnection();
	                    		int Counter1= connectionFactory.getInstance(dbname).insert(username, password);
	                            if (Counter1>0) {  
	                            System.out.println((Counter1++) + "Data inserted successfully");  
	                            }else{  
	                                System.out.println("Data insertion failed");      
	                            }  
	                    }catch (Exception e) {  
	                    	System.out.println(e);  
	                    }  
	                    System.out.println("Press Y to continue");
	                    try{
	                    	String s1 = br.readLine();
							if(s1.equalsIgnoreCase("Y")){
								continue;
							}
							else{
								break;
							}
						}catch(Exception e){
							System.out.println("enter the valid input");
						}
	         }  
	        else if(ch==2){  
	                      
	        			Connection con = null;
	        			PreparedStatement ps=null;
	        			ResultSet rs = null;
	                    try{  
	                    	connectionFactory.getInstance(dbname).view();  
	    	                /*
	    	                con = jdbc.getConnection();
	                    	ps = con.prepareStatement("select * from user");  
	    	                ps.setString(1, name);  
	    	                rs = ps.executeQuery();  
	    	                while (rs.next()) {  
	    	                	System.out.println("Name= "+rs.getString(2)+"\t"+"Password= "+rs.getString(3));       
	    	                }
	    	                */  
	                    }catch (Exception e) {
	                          System.out.println(e);  
	                    }  
	                    System.out.println("Press Y to continue");
						try{
	                    	String s1 = br.readLine();
							if(s1.equalsIgnoreCase("Y")){
								continue;
							}
							else{
								break;
							}
						}catch(Exception e){
							System.out.println("enter the valid input");
						}
	                       
	         } 
	         else if(ch==3){  
	                     System.out.println("Enter the username of user,you want to delete: ");  
	                     String username = br.readLine(); 
	                     
	                     Connection c = null;  
	         	         PreparedStatement ps = null;  
	         	         int Counter=0; 
	             
	                     try {  
	                    	 int i= connectionFactory.getInstance(dbname).delete(username); 
	                    	 /*
	                    	 c = jdbc.getConnection();  
	         	             ps = c.prepareStatement("delete from user where username='"+username+"' ");  
	         	             Counter = ps.executeUpdate();
	                         if (Counter>0) {  
	                            System.out.println((Counter++) + " Data has been deleted successfully");  
	                         }else{  
	                        	 System.out.println("Data has not been deleted");      
	                         }
	                         */   
	                     }catch (Exception e) {  
	                          System.out.println(e);  
	                     }  
	                    System.out.println("Press Y to continue");
	                    try{
	                    	String s1 = br.readLine();
							if(s1.equalsIgnoreCase("Y")){
								continue;
							}
							else{
								break;
							}
						}catch(Exception e){
							System.out.println("enter the valid input");
						} 
	                       
	         }    
	         else if(ch==4){  
	        	 		Connection c=null;  
	        	 		PreparedStatement ps=null;  
	        	 		int Counter=0;
	                    System.out.print("Enter the password and username of user,you want to update:");  
	                    String username=br.readLine();  
	                    System.out.print("Enter the new password ");  
	                    String password=br.readLine();  
	                    try {  
	                    	int i= connectionFactory.getInstance(dbname).update(username, password);  
	                        /*
	                    	c = jdbc.getConnection();
	    	                ps = c.prepareStatement("update user set password=? where username='"+username+"' ");  
	    	                ps.setString(1,password);  
	    	                Counter = ps.executeUpdate();  
	                    	if (Counter>0) {  
	                        	System.out.println((Counter++) + " Data has been updated successfully");  
	                        }
	                        */    
	                    } catch (Exception e) {  
	                          System.out.println(e);  
	                    }  
	                    System.out.println("Press Y to continue");
	                    try{
	                    	String s1 = br.readLine();
							if(s1.equalsIgnoreCase("Y")){
								continue;
							}
							else{
								break;
							}
						}catch(Exception e){
							System.out.println("enter the valid input");
						} 
	         }
	         else{
	        	 System.exit(0);
	        }while(true);    
		
		}
	}

}
