package Week8;
import java.util.*;


public class Factor {
    public static String factor(int n) {
        StringBuilder builder = new StringBuilder();
        int m = n;
        int d = 2;
        while ( m > 1 ) {
            while ( m % d == 0){
                if (m < n){
                    builder.append(" * ");
                }
                builder.append(d);
                m = m/d;
            }
            d++;
        }

        return builder.toString();
    } //end of the factor method

    public static String factor2(int n){
        StringBuilder builder = new StringBuilder();
        int m = n;
        int d = 2;
        while ( m > 1 ) {
            if( m % d == 0) {
                if ( m < n ) {
                    builder.append(" * ");
                }
                builder.append(d);
                int c = 0;
                while (m % d == 0){
                    m = m/d;
                    c++;
                }
                if (c > 1) {
                    builder.append("^" + c);
                }
            }
            d++;
        }
        return builder.toString();
    }

    public static void main(String[] args){

        //receive input
        Scanner keyboard = new Scanner(System.in);
        int n;

        //factor and print
        do{
            System.out.println("Enter a number >= 2:  ");
            n = keyboard.nextInt();
            System.out.println(factor(n));
            System.out.println(factor2(n));
        } while ( n >= 2);


    } //end of the main method


} //end of class
