🎓 Student Management System (Java + MySQL + JDBC)

⭐ If you like this project, give it a star!

---

📌 Project Overview

This project is a console-based Student Management System developed using Java and MySQL.
It allows efficient management of student records with full CRUD (Create, Read, Update, Delete) operations.

---

🚀 Features

- ➕ Add Student
- 📋 View All Students
- 🔍 Search Student by ID
- ✏️ Update Student Marks
- ❌ Delete Student
- ⚠️ Duplicate ID Validation
- 💾 Persistent Data Storage using MySQL

---

🛠️ Tech Stack

- Language: Java
- Database: MySQL
- Connectivity: JDBC
- Concepts Used: OOP, Collections, Exception Handling, SQL

---

🗄️ Database Schema

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    marks INT
);

---

▶️ How to Run the Project

1. Compile

javac -cp ".;mysql-connector-j-9.6.0.jar" Main.java

2. Run

java -cp ".;mysql-connector-j-9.6.0.jar" Main

---

📷 Sample Output

1 Add Student

2 View Students

3 Delete Student

4 Search Student

5 Update Student

6 Exit

---

💡 Key Learnings

- Implemented database connectivity using JDBC
- Understood CRUD operations with SQL
- Learned real-world backend logic
- Practiced input validation and error handling

---

🔮 Future Improvements

- 🌐 Convert into web application using Servlets or Spring Boot
- 🎨 Add frontend using HTML, CSS, JavaScript
- 🔐 Implement user authentication system
- 📊 Add analytics (top student, average marks)
- 📁 Store logs and history

---

👨‍💻 Author

Alekhya

---

🔗 GitHub Repository

https://github.com/alekhya003/Student-Management-System
