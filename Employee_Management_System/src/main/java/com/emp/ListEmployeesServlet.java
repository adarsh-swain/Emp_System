package com.emp;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listEmployees")
public class ListEmployeesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_database_username";
    private static final String DB_PASSWORD = "your_database_password";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = new ArrayList<>();

        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empmanage","root","1234")) {
            
            String sql = "SELECT * FROM employees";
            PreparedStatement statement = conn.prepareStatement(sql);

            
            ResultSet resultSet = statement.executeQuery();

           
            while (resultSet.next()) {
                int employeeid = resultSet.getInt("employeeid");
                String name = resultSet.getString("name");
                String designation = resultSet.getString("designation");
                String address = resultSet.getString("address");
                int gender = resultSet.getInt("gender");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                BigDecimal salary = resultSet.getBigDecimal("salary");

                Employee employee = new Employee();
                employee.setEmployeeid(employeeid);
                employee.setName(name);
                employee.setDesignation(designation);
                employee.setAddress(address);
                employee.setGender(gender);
                employee.setBirthday(birthday);
                employee.setSalary(salary);

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        request.setAttribute("employees", employees);
        request.getRequestDispatcher("listEmployees.jsp").forward(request, response);
    }
}
