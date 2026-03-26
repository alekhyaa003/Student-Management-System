import java.util.*;

class StudentManager {

    ArrayList<Student> list = new ArrayList<>();

    // ADD STUDENT (with duplicate check)
    void addStudent(int id, String name, int age, int marks) {

        // check duplicate ID
        for(Student s : list) {
            if(s.id == id) {
                System.out.println("ID already exists");
                return;
            }
        }

        Student s = new Student(id, name, age, marks);
        list.add(s);

        System.out.println("Student Added Successfully");
    }

    // VIEW STUDENTS
    void viewStudents() {
        if(list.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        for(Student s : list) {
            s.display();
        }
    }

    // SEARCH STUDENT
    void searchStudent(int id) {
        for(Student s : list) {
            if(s.id == id) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found");
    }

    // DELETE STUDENT
    void deleteStudent(int id) {
        Iterator<Student> it = list.iterator();

        while(it.hasNext()) {
            Student s = it.next();
            if(s.id == id) {
                it.remove();
                System.out.println("Student Deleted");
                return;
            }
        }

        System.out.println("Student not found");
    }

    // UPDATE STUDENT
    void updateStudent(int id, int marks) {
        for(Student s : list) {
            if(s.id == id) {
                s.marks = marks;
                System.out.println("Updated Successfully");
                return;
            }
        }
        System.out.println("Student not found");
    }
}