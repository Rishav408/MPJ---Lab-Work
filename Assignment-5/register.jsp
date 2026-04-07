<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration Form</title>
</head>
<body>
    <h2>Employee Registration</h2>
    <form action="register" method="post">
        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>
        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>
        <label>Department:</label><br>
        <input type="text" name="department" required><br><br>
        <label>Salary:</label><br>
        <input type="number" step="0.01" name="salary" required><br><br>
        <button type="submit">Register</button>
    </form>
    <p><a href="index.jsp">Back to Home</a></p>
</body>
</html>
