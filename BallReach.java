package Week4;
import java.lang.Math;
import java.util.*;

public class BallReach {
    // gravity declarations
    public static final double Earth_Gravity =  9.807;
    public static final double Moon_Gravity = 1.620;
    // compute()
    public static void compute(double height, double u, double v, double g) {
        // declaration and computation
        double t0, t1, h0, h1, totalTime, r;
        t0 = v / g;
        h0 = ( v * t0 ) - ( 0.5 * g * t0 * t0);
        h1 = h0 + height;
        t1 = Math.sqrt( (2 * h1) / g );
        totalTime = t0 + t1;
        r = u * ( t0 + t1);

        // output
        myPrint("Height of the Cliff", height, "(m)");
        myPrint("Horizontal Speed", u, "(m/s)");
        myPrint("Vertical Speed", v, "(m/s)");
        myPrint("Gravity", g, "m/s^2");
        myPrint("Upward Time", t0, "(s)");
        myPrint("Upward Distance", h0, "(m)");
        myPrint("Downward Time", t1, "(s)");
        myPrint("Downward Distance", h1, "(m)");
        myPrint("Total Time", totalTime, "(s)");
        myPrint("Horizontal Distance", r, "(m)");
    }
    // message
    public static void message( String m) {
        System.out.printf("........ %s ........%n", m);
    }
    // myPrint
    public static void myPrint( String name, double value, String unit ) {
        System.out.printf( "%30s:%14.4f (%s)%n", name, value, unit );
    }

    // MAIN
    public static void main( String[] args ) {
        // declaration of variables
        Scanner keyboard = new Scanner( System.in );
        double angle, velocity, height;
        double horizV, verticV;

        // inputs : Distance Calculation
        message("Distance Calculation");        // title
        System.out.println(" Enter angle (degree): ");
        angle = keyboard.nextInt();
        System.out.println("Enter speed (m/s): ");
        velocity = keyboard.nextInt();
        System.out.println("Enter height (m): ");
        height = keyboard.nextInt();

        // correct values + convert to radians
        velocity = Math.max(0, velocity);
        height = Math.max(0, height);
        angle = Math.min(angle, 90);
        angle = Math.max(0,angle);
        angle = (Math.PI/180) * angle;


        // computations
        horizV = Math.sin(angle) * velocity;
        verticV = Math.cos(angle) * velocity;

        // compute()
        message("On the Earth");        // title
        compute(height, horizV, verticV, Earth_Gravity);
        message("On the Moon");     // title
        compute(height, horizV, verticV, Moon_Gravity);

    }// end of main method

}// end of class
