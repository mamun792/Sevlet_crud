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
import common.UserData;

@WebServlet("/NewPost")

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");

        UserData userData = new UserData(name, email);
        
        System.out.println(name);

        DB_Connection db_connection = new DB_Connection();
        Connection connection = db_connection.get_connection();
        
        
        try (connection) {
            if (connection != null) {
                String sql = "INSERT INTO UserData (name, email) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, userData.getName());
                    preparedStatement.setString(2, userData.getEmail());

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        response.sendRedirect(request.getContextPath() + "/post.jsp");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/error.jsp");
                    }
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
	}

}
