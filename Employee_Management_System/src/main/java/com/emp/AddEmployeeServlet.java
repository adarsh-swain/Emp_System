package com.emp;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_database_username";
    private static final String DB_PASSWORD = "your_database_password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        String address = request.getParameter("address");
        int gender = Integer.parseInt(request.getParameter("gender"));
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        BigDecimal salary = new BigDecimal(request.getParameter("salary"));

        Employee employee = new Employee();
        employee.setName(name);
        employee.setDesignation(designation);
        employee.setAddress(address);
        employee.setGender(gender);
        employee.setBirthday(birthday);
        employee.setSalary(salary);

      
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empmanage","root","1234")) {
         
            String sql = "INSERT INTO employees (employeeid, name, designation, address, gender, birthday, salary) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 0); 
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDesignation());
            statement.setString(4, employee.getAddress());
            statement.setInt(5, employee.getGender());
            statement.setObject(6, java.sql.Date.valueOf(employee.getBirthday()));
            statement.setBigDecimal(7, employee.getSalary());

            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        response.sendRedirect("index.jsp");
    }
}
