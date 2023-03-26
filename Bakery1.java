package Week3;
import java.util.Scanner;
public class Bakery1 {
    public static void main(String[] args){
        //variable declaration
        int pastries, coffees, sandwiches, loaves ;
        double subtotal = 0, tax , total ;
        Scanner scan = new Scanner(System.in);
        //initial output
        System.out.println("Welcome to Dana's Bakery!");
        System.out.println("Pastries are 4.5 dollars each.");
        System.out.println("Coffees are 3.0 dollars each.");
        System.out.println("Sandwiches are 6.0 dollars each.");
        System.out.println("Loaves of breads are each 7.0 dollars.");
        //initial assignments
        System.out.println("How many pastries? ");
        pastries = scan.nextInt();
        subtotal += (double)pastries * 4.5 ;
        System.out.println("Subtotal is " + subtotal + " dollars.");

        System.out.println("How many coffees? ");
        coffees = scan.nextInt();
        subtotal += (double)coffees * 3.0 ;
        System.out.println("Subtotal is " + subtotal + " dollars.");

        System.out.println("How many sandwhiches? ");
        sandwiches = scan.nextInt();
        subtotal += (double)sandwiches * 6.0 ;
        System.out.println("Subtotal is " + subtotal + " dollars.");

        System.out.println("How many loaves? ");
        loaves = scan.nextInt();
        subtotal += (double)loaves * 7.0 ;
        System.out.println("Subtotal is " + subtotal + " dollars.");

        tax = (int)( subtotal * 0.07 * 100 ) / 100.0 ;
        total = tax + subtotal;

        // final printing
        System.out.println("Tax is " + tax + " dollars.");
        System.out.println("Total is " + total +" dollars.");
        System.out.println("Thank you for coming. See you soon!");

        //close scan
        scan.close();


    } //end of the main method
} //end of the class
