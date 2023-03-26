package Week3;
import java.util.Scanner;
public class LinEq1 {
    public static void main(String[] args){
        // variable declarations
        double a, b, p, c, d, q, det, solutionX, solutionY;
        Scanner scan = new Scanner(System.in);
        // initial assignments
        System.out.println("This program solves a system of Linear Equations.");
        System.out.println("ax + by = p, cx + dy = q");
        System.out.print("Enter a, b, and p: ");
        a = scan.nextDouble();
        b = scan.nextDouble();
        p = scan.nextDouble();
        System.out.print("Enter c, d, and g: ");
        c = scan.nextDouble();
        d = scan.nextDouble();
        q = scan.nextDouble();
        det = ( a * d ) - ( b * c );
        solutionX =  (d * p - b * q) / det ;
        solutionY = (a * q - c * p) / det ;
        //output generation
        System.out.println("The equations are:");
        System.out.println( a + " x + " + b + " y = " + p +" and " + c + " x + " + d + " y = " + q);
        System.out.println("The solution is (" + solutionX + ", " + solutionY + ")");
        //close scan
        scan.close();
    } //end of the main method
} //end of the class