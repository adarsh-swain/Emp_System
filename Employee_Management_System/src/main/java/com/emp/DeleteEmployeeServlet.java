package com.emp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int employee = Integer.parseInt(request.getParameter("employeeid"));
       

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empmanage","root","1234")) {
            
            String sql = "DELETE FROM employees WHERE employeeid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, employee);

            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        response.sendRedirect("listEmployees");
    }
}
