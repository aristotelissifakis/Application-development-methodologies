package scannerexercise;

import java.util.Scanner;

public class ScannerExercise {

    public static void main(String[] args) {
        
        readGrades();
    }
    
    static void readGrades() {
        Scanner scanner = new Scanner(System.in);
        String am;
        String course;
        int countCourses;
        float grd;
        float sumGrds;
        
        System.out.println("Enter data : ");
        do {
           am = scanner.next();
           sumGrds = 0.0f;
           countCourses = 0;
           do {
               course = scanner.next();
               grd = scanner.nextFloat();
               sumGrds += grd;
               countCourses++;
           } while (!course.equals("end"));
           printAvg(am, countCourses, sumGrds);
        } while (!am.equals("000000"));
        
        scanner.close();
    }
    
    static void printAvg(String am, int countCourses, float sumGrds) {
        float avg;
        
        avg = sumGrds / (float) countCourses;
        System.out.println("Average of Student " + am + ": " + avg);
    }
    
    
}
