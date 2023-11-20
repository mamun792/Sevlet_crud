package cruD;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DB_Connection;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int userIdToDelete = Integer.parseInt(request.getParameter("id"));

	        // Delete the user data from the database
	        boolean deletionSuccessful = deleteUserData(userIdToDelete);

	        if (deletionSuccessful) {
	            response.sendRedirect(request.getContextPath() + "/read");
	        } else {
	            response.sendRedirect(request.getContextPath() + "/error.jsp");
	        }
	    }

	    private boolean deleteUserData(int userId) {
	        String sql = "DELETE FROM UserData WHERE id = ?";

	        try (Connection connection = new DB_Connection().get_connection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	            preparedStatement.setInt(1, userId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

}
