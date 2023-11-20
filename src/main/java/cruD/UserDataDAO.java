package cruD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DB_Connection;
import common.UserData;

public class UserDataDAO {

	 public List<UserData> getAllUserData() throws SQLException {
	        List<UserData> userList = new ArrayList<>();
	        String sql = "SELECT * FROM UserData";

	        try (Connection connection = new DB_Connection().get_connection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String name = resultSet.getString("name");
	                String email = resultSet.getString("email");

	              
	                
	                UserData userData = new UserData();
	                userData.setId(id);
	                userData.setName(name);
	                userData.setEmail(email);

	                userList.add(userData);
	            }
	        }

	        return userList;
	    }
}
