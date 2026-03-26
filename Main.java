import java.sql.*;
import java.util.*;

class Main {

    static final String URL = "jdbc:mysql://localhost:3306/student_db";
    static final String USER = "root";
    static final String PASS = "1234"; // your MySQL password

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {

                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1 Add Student");
                System.out.println("2 View Students");
                System.out.println("3 Delete Student");
                System.out.println("4 Search Student");
                System.out.println("5 Update Student");
                System.out.println("6 Exit");

                int ch = sc.nextInt();

                // 🔹 ADD STUDENT
                if (ch == 1) {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    // check duplicate
                    PreparedStatement check = con.prepareStatement(
                        "SELECT id FROM students WHERE id=?"
                    );
                    check.setInt(1, id);
                    ResultSet rsCheck = check.executeQuery();

                    if (rsCheck.next()) {
                        System.out.println("ID already exists ❌");
                        continue;
                    }

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO students VALUES (?, ?, ?, ?)"
                    );

                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, age);
                    ps.setInt(4, marks);

                    ps.executeUpdate();

                    System.out.println("Student Added Successfully ✅");
                }

                // 🔹 VIEW STUDENTS
                else if (ch == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM students");

                    System.out.println("\n--- Student Records ---");

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getInt("age") + " " +
                            rs.getInt("marks")
                        );
                    }
                }

                // 🔹 DELETE STUDENT
                else if (ch == 3) {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM students WHERE id=?"
                    );

                    ps.setInt(1, id);

                    int rows = ps.executeUpdate();

                    if (rows > 0)
                        System.out.println("Student Deleted ✅");
                    else
                        System.out.println("Student not found ❌");
                }

                // 🔹 SEARCH STUDENT
                else if (ch == 4) {
                    System.out.print("Enter ID to search: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM students WHERE id=?"
                    );

                    ps.setInt(1, id);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        System.out.println(
                            rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getInt("age") + " " +
                            rs.getInt("marks")
                        );
                    } else {
                        System.out.println("Student not found ❌");
                    }
                }

                // 🔹 UPDATE STUDENT
                else if (ch == 5) {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter new marks: ");
                    int marks = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE students SET marks=? WHERE id=?"
                    );

                    ps.setInt(1, marks);
                    ps.setInt(2, id);

                    int rows = ps.executeUpdate();

                    if (rows > 0)
                        System.out.println("Updated Successfully ✅");
                    else
                        System.out.println("Student not found ❌");
                }

                // 🔹 EXIT
                else if (ch == 6) {
                    con.close();
                    System.out.println("Exiting... 👋");
                    break;
                }

                else {
                    System.out.println("Invalid choice ❌");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}