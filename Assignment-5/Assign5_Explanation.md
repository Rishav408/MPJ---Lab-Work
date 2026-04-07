# Assignment 5: Employee Registration Web Application

Aim: Develop Employee Registration using JSP, Servlet, JDBC.

Files created:
- `Employee.java`: Employee model class.
- `DBUtil.java`: JDBC connection utility (MySQL).
- `EmployeeServlet.java`: Handles GET/POST, inserts employee record.
- `index.jsp`, `register.jsp`, `success.jsp`, `error.jsp`: UI pages.
- `WEB-INF/web.xml`: servlet mapping and welcome page.
- `create_employee_table.sql`: MySQL schema setup.

Usage:
1. Create DB and table with `create_employee_table.sql`.
2. Update DB credentials in `DBUtil.java` if needed.
3. Build and deploy as a WAR in Tomcat 8.5+.
4. Open `http://localhost:8080/<appname>/` and register employee.
