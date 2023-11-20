package cruD;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.DB_Connection;
import common.UserData;

@WebServlet("/update")

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        UserData userData = new UserData(userId, name, email);

        DB_Connection db_connection = new DB_Connection();
        Connection connection = db_connection.get_connection();

        try (connection) {
            if (connection != null) {
                String sql = "UPDATE UserData SET name = ?, email = ? WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    preparedStatement.setString(1, userData.getName());
                    preparedStatement.setString(2, userData.getEmail());
                    preparedStatement.setInt(3, userData.getId());

                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                    	HttpSession session = request.getSession();
                        session.setAttribute("userData", userData);
                        
                       

                        response.sendRedirect(request.getContextPath() + "/updateForm.jsp");
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

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
	        doPost(request, response);
	    }
	

}
