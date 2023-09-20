<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Employee Management System</h1>
    <form action="addEmployee" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required><br><br>
        <label for="designation">Designation:</label>
        <input type="text" name="designation" id="designation" required><br><br>
        <label for="address">Address:</label>
        <input type="text" name="address" id="address" required><br><br>
        <label for="gender">Gender:</label>
        <select name="gender" id="gender" required>
            <option value="1">Male</option>
            <option value="2">Female</option>
        </select><br><br>
        <label for="birthday">Birthday:</label>
        <input type="date" name="birthday" id="birthday" required><br><br>
        <label for="salary">Salary:</label>
        <input type="text" name="salary" id="salary" required><br><br>
        <input type="submit" value="Add Employee">
    </form>
    <br>
    <a href="listEmployees">List Employees</a>
</body>
</html>
