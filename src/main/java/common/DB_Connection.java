package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {

	public static void main(String[] args) {
		
        DB_Connection dbConnection = new DB_Connection();
        
        try (Connection connection = dbConnection.get_connection()) {
        	
            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	 public Connection get_connection() {
	        Connection connection = null;

	        try {
	         
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	          
	            String url = "jdbc:mysql://localhost:3308/s_crud?useSSL=false";
	            
	            connection = DriverManager.getConnection(url, "root", "root");
	            
	        } catch (Exception e) {
	            System.out.println(e);
	        }

	        return connection;
	    }
}
