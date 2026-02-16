import java.util.*;

class Student {

    private String name;
    private int rollNo;
    private int marks[];
    private double percentage;

    Student(String name, int rollNo, int marks[]) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public void calculatePercentage() {
        int total = 0;
        for (int i = 0; i < marks.length; i++) {
            total += marks[i];
        }
        percentage = total / (double) marks.length;
    }

    public double getPercentage() {
        return percentage;
    }

    public void displayResult() {
        System.out.println("\n------------------------------");
        System.out.println("Name       : " + name);
        System.out.println("Roll No    : " + rollNo);

        System.out.print("Marks      : ");
        for (int m : marks) {
            System.out.print(m + " ");
        }

        System.out.println("\nPercentage : " + percentage);

        if (percentage >= 75)
            System.out.println("Grade      : A");
        else if (percentage >= 60)
            System.out.println("Grade      : B");
        else
            System.out.println("Grade      : C");
    }
}

public class Assignment1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();   // Clear buffer

        Student[] students = new Student[n];

        double totalClassPercentage = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Roll No: ");
            int rollNo = sc.nextInt();

            int[] marks = new int[5];
            System.out.println("Enter marks of 5 subjects:");
            for (int j = 0; j < 5; j++) {
                System.out.print("Subject " + (j + 1) + ": ");
                marks[j] = sc.nextInt();
            }
            sc.nextLine(); // Clear buffer

            students[i] = new Student(name, rollNo, marks);
            students[i].calculatePercentage();
            totalClassPercentage += students[i].getPercentage();
        }

        // Display Results
        System.out.println("\n========= STUDENT RESULTS =========");
        for (Student s : students) {
            s.displayResult();
        }

        // Class Average
        double classAverage = totalClassPercentage / n;
        System.out.println("\n=================================");
        System.out.println("Class Average Percentage = " + classAverage);

        sc.close();
    }
}

/*PS D:\College\Sem 6\MPJ\MPJ - Lab Work\Assignment-1> cd "d:\College\Sem 6\MPJ\MPJ - Lab Work\Assignment-1\" ; if ($?) { javac Assignment1.java } ; if ($?) { java Assignment1 }
Enter number of students: 2

Enter details of Student 1
Enter Name: Rishav Singh
Enter Roll No: 1
Enter marks of 5 subjects:
Subject 1: 9
Subject 2: 98
Subject 3: 87
Subject 4: 98
Subject 5: 98

Enter details of Student 2
Enter Name: Kunal Tailor
Enter Roll No: 2
Enter marks of 5 subjects:
Subject 1: 89
Subject 2: 79
Subject 3: 89
Subject 4: 86
Subject 5: 88

========= STUDENT RESULTS =========

------------------------------
Name       : Rishav Singh
Roll No    : 1
Marks      : 9 98 87 98 98
Percentage : 78.0
Grade      : A

------------------------------
Name       : Kunal Tailor
Roll No    : 2
Marks      : 89 79 89 86 88
Percentage : 86.2
Grade      : A

=================================
Class Average Percentage = 82.1
PS D:\College\Sem 6\MPJ\MPJ - Lab Work\Assignment-1>  */