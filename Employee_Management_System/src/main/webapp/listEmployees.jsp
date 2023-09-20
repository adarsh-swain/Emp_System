<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Employees</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    
</head>
<body>
    <h1>List Employees</h1>
    <table border="1">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Designation</th>
            <th>Address</th>
            <th>Gender</th>
            <th>Birthday</th>
            <th>Salary</th>
            <th>Action</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.employeeid}</td>
                <td>${employee.name}</td>
                <td>${employee.designation}</td>
                <td>${employee.address}</td>
                <td>
                    <c:choose>
                        <c:when test="${employee.gender == 1}">Male</c:when>
                        <c:when test="${employee.gender == 2}">Female</c:when>
                        <c:otherwise>Unknown</c:otherwise>
                    </c:choose>
                </td>
                <td>${employee.birthday}</td>
                <td>${employee.salary}</td>
                <td>
                    <form action="deleteEmployee" method="post">
                        <input type="hidden" name="employeeid" value="${employee.employeeid}">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
