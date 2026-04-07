-- MySQL script for Assignment-5 Employee Registration (JSP/Servlet/JDBC)
CREATE DATABASE IF NOT EXISTS mpj_labwork;
USE mpj_labwork;

CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    salary DECIMAL(12, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
