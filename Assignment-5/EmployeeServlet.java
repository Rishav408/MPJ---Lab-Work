package com.mpj.assignment5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String department = req.getParameter("department");
        String salaryStr = req.getParameter("salary");

        String message;
        if (name == null || name.isBlank() || email == null || email.isBlank() || department == null || department.isBlank() || salaryStr == null || salaryStr.isBlank()) {
            message = "All fields are mandatory. Please fill the form completely.";
            req.setAttribute("error", message);
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryStr);
            if (salary <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            message = "Please enter a valid positive salary amount.";
            req.setAttribute("error", message);
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO employees (name, email, department, salary) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, department);
                pst.setDouble(4, salary);
                int rows = pst.executeUpdate();
                if (rows == 1) {
                    Employee emp = new Employee(name, email, department, salary);
                    req.setAttribute("employee", emp);
                    req.getRequestDispatcher("success.jsp").forward(req, resp);
                } else {
                    message = "Emp registration failed, please try again.";
                    req.setAttribute("error", message);
                    req.getRequestDispatcher("error.jsp").forward(req, resp);
                }
            }
        } catch (Exception e) {
            req.setAttribute("error", "Database error: " + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}
