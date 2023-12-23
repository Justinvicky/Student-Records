import java.util.Scanner;

// Define the Student class
class Student {
    String name;
    int rollNumber;
    double grade;

    // Constructor to initialize the student details
    Student(String name, int rollNumber, double grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }
}

public class StudentInformationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[10]; // Array to store student records
        int count = 0; // Counter to keep track of the number of students

        while (true) {
            System.out.println("Student Information System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (count < 10) {
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();

                        students[count] = new Student(name, rollNumber, grade);
                        count++;
                    } else {
                        System.out.println("Cannot add more students. Limit reached.");
                    }
                    break;

                case 2:
                    if (count > 0) {
                        for (int i = 0; i < count; i++) {
                            System.out.println("Student " + (i + 1));
                            students[i].displayDetails();
                            System.out.println("---------------------------");
                        }
                    } else {
                        System.out.println("No students added yet.");
                    }
                    break;

                case 3:
                    if (count > 0) {
                        System.out.print("Enter the roll number of the student to delete: ");
                        int rollToDelete = scanner.nextInt();
                        int indexToDelete = -1;

                        for (int i = 0; i < count; i++) {
                            if (students[i].rollNumber == rollToDelete) {
                                indexToDelete = i;
                                break;
                            }
                        }

                        if (indexToDelete != -1) {
                            for (int i = indexToDelete; i < count - 1; i++) {
                                students[i] = students[i + 1];
                            }
                            count--;
                            System.out.println("Student with roll number " + rollToDelete + " deleted successfully.");
                        } else {
                            System.out.println("Student with roll number " + rollToDelete + " not found.");
                        }
                    } else {
                        System.out.println("No students added yet.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the Student Information System. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}  