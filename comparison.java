package Week5;
import java.lang.Math;
import java.util.*;

public class comparison {
    public static void find1st(String x1, double a1, String x2, double a2, String x3, double a3, String x4, double a4) {
        double m = Math.min(Math.min(a1, a2), Math.min(a3, a4));
        if (m == a1) {
            report(x1, a1);
            find2nd(x2, a2, x3, a3, x4, a4);
        } else if (m == a2) {
            report(x2, a2);
            find2nd(x1, a1, x3, a3, x4, a4);
        } else if (m == a3) {
            report(x3, a3);
            find2nd(x1, a1, x2, a2, x4, a4);
        } else {
            report(x4, a4);
            find2nd(x1, a1, x2, a2, x3, a3);
        }
    } // end of find1st method

    public static void find2nd(String x1, double a1, String x2, double a2, String x3, double a3) {
        double m = Math.min(Math.min(a1, a2), a3);
        if (m == a1) {
            report(x1, a1);
            find3rdAnd4th(x2, a2, x3, a3);
        } else if (m == a2) {
            report(x2, a2);
            find3rdAnd4th(x1, a1, x3, a3);
        } else {
            report(x3, a3);
            find3rdAnd4th(x1, a1, x2, a2);
        }
    } // end of find2nd method

    public static void find3rdAnd4th(String x1, double a1, String x2, double a2) {
        double m = Math.min(a1, a2);
        if (m == a1) {
            report(x1, a1);
            report(x2, a2);
        } else {
            report(x2, a2);
            report(x1, a1);
        }
    } // end of find3rdAnd4th method

    public static void report(String name, double num) {
        System.out.printf("%s for %.2f%n", name, num);
    } // end of report method

    public static double calcBMI(double height, double weight) {
        return 703.0 * weight / (height * height);
    } // end of calcBMI method

    public static void main(String[] args) {
        // initial variable declaration
        double height1, weight1, bmi1, height2, weight2, bmi2;
        double height3, weight3, bmi3, height4, weight4, bmi4;
        String name1, name2, name3, name4;
        Scanner keyboard = new Scanner(System.in);
        // input
        System.out.print("Name, Height , Weight for Person 1: ");
        name1 = keyboard.next();
        height1 = keyboard.nextDouble();
        weight1 = keyboard.nextDouble();
        System.out.print("Name, Height , Weight for Person 2: ");
        name2 = keyboard.next();
        height2 = keyboard.nextDouble();
        weight2 = keyboard.nextDouble();
        System.out.print("Name, Height , Weight for Person 3: ");
        name3 = keyboard.next();
        height3 = keyboard.nextDouble();
        weight3 = keyboard.nextDouble();
        System.out.print("Name, Height , Weight for Person 4: ");
        name4 = keyboard.next();
        height4 = keyboard.nextDouble();
        weight4 = keyboard.nextDouble();

        // BMI calculations
        bmi1 = calcBMI(height1, weight1);
        bmi2 = calcBMI(height2, weight2);
        bmi3 = calcBMI(height3, weight3);
        bmi4 = calcBMI(height4, weight4);

        // output height ranking
        System.out.println(" ---- Ranking by Height");
        find1st(name1, height1, name2, height2, name3, height3, name4, height4);
        // output weight ranking
        System.out.println("---- Ranking by Weight");
        find1st(name1, weight1, name2, weight2, name3, weight3, name4, weight4);
        // output BMI ranking
        System.out.println("---- Ranking by BMI");
        find1st(name1, bmi1, name2, bmi2, name3, bmi3, name4, bmi4);

    } //end of main method





} //end of class
