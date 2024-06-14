import java.util.Scanner;

public class Task2 {

    public static double average(int numSubjects, double totalMarks){
        double avg = totalMarks / numSubjects;
        return avg;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        double totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble();
            totalMarks += marks;
        }

        double Result = average(numSubjects, totalMarks); 

        char grade;

        if (Result >= 90) {
            grade = 'A';
        } else if (Result >= 80) {
            grade = 'B';
        } else if (Result >= 70) {
            grade = 'C';
        } else if (Result >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.err.println();
        System.out.println("Total Marks obtained by the candidate are: " + totalMarks);
        System.out.println("Average Percentage of the candidate is: " + Result);
        System.out.println("Congratulations! You got: " + grade + " grade");
    }
}