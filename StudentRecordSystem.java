import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private String studentId;
    private String name;
    private int age;
    private String department;
    private double gpa;
    public Student(String studentId, String name, int age, String department, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.gpa = gpa;
    }

    // Getters and Setters for Encapsulation
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "ID: " + studentId + " | Name: " + name + " | Age: " + age + 
               " | Dept: " + department + " | GPA: " + gpa;
    }
}

public class StudentRecordSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== UNIVERSITY STUDENT RECORD SYSTEM ===");
            System.out.println("1. Add New Student Record");
            System.out.println("2. View All Student Records");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student Record");
            System.out.println("6. Exit Application");
            System.out.print("Please enter your choice (1-6): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option selected. Please choose between 1 and 6.");
            }
        }
    }
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("Error: A student with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Department: ");
        String dept = scanner.nextLine();

        System.out.print("Enter GPA: ");
        double gpa = Double.parseDouble(scanner.nextLine());

        studentList.add(new Student(id, name, age, dept, gpa));
        System.out.println("Student record added successfully!");
    }
    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found in the system.");
            return;
        }
        System.out.println("\n--- All Student Records ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("\nRecord Found: " + s);
                return;
            }
        }
        System.out.println("Record not found for Student ID: " + id);
    }
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();

        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("Current details: " + s);
                
                System.out.print("Enter New Name (Press enter to keep current): ");
                String newName = scanner.nextLine();
                if (!newName.trim().isEmpty()) s.setName(newName);

                System.out.print("Enter New Age (Enter 0 to keep current): ");
                int newAge = Integer.parseInt(scanner.nextLine());
                if (newAge > 0) s.setAge(newAge);

                System.out.print("Enter New Department (Press enter to keep current): ");
                String newDept = scanner.nextLine();
                if (!newDept.trim().isEmpty()) s.setDepartment(newDept);

                System.out.print("Enter New GPA (Enter -1 to keep current): ");
                double newGpa = Double.parseDouble(scanner.nextLine());
                if (newGpa >= 0) s.setGpa(newGpa);

                System.out.println("Student details updated successfully!");
                return;
            }
        }
        System.out.println("Record not found for Student ID: " + id);
    }
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getStudentId().equalsIgnoreCase(id)) {
                studentList.remove(i);
                System.out.println("Student record deleted successfully.");
                return;
            }
        }
        System.out.println("Record not found for Student ID: " + id);
    }
}
