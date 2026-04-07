<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mpj.assignment5.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
    <h2>Employee Registered Successfully</h2>
    <% Employee emp = (Employee) request.getAttribute("employee"); %>
    <% if (emp != null) { %>
        <p>Name: <%= emp.getName() %></p>
        <p>Email: <%= emp.getEmail() %></p>
        <p>Department: <%= emp.getDepartment() %></p>
        <p>Salary: <%= emp.getSalary() %></p>
    <% } else { %>
        <p>No employee details available.</p>
    <% } %>
    <p><a href="register.jsp">Register Another</a> | <a href="index.jsp">Home</a></p>
</body>
</html>
