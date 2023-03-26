package Week10;
import java.util.*;

public class ReadingPrimeFactorization {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input;
        long number;

        System.out.print("Enter expression: ");
        do{
            input = keyboard.nextLine();
            number = convert(input);
            System.out.println(number);
            System.out.print("Enter expression: ");
        }while(!input.isBlank());


    }//end of main method

    public static boolean isPrime(int base) {
        boolean result = false;
        int d = 2;

        while ((d < base) && (base % d != 0)) {
            d++;
        }
        if (d == base) {
            result = true;
        }

        return result;
    } //end of isPrime method

    public static long power(int base, int exponent) {

        long x = 1;
        x = (long)Math.pow(base,exponent);
        return x;
    }

    public static long convert( String w){
        long result = 1;
        String op;
        int exponent, base;
        int prevBase = 1;

        w = w.replace("*" , " * ");
        w = w.replace("^", " ^ ");
        w = w + " *";
        Scanner in = new Scanner(w);

        while(in.hasNext()){
            base = in.nextInt();
            op = in.next();

            if (op.equals("^")){
                exponent = in.nextInt();
                op = in.next();
            }else{
                exponent = 1;
            }

            //error messages
            if(prevBase >= base){
                System.out.println(prevBase + " >= " + base);
            }
            if(exponent <=0){
                System.out.println("exponent " + exponent + "<=0");
            }
            if(!isPrime(base)){
                System.out.println(base + " is not prime");
            }


            //update result
            prevBase = base;

            result = result * power(base, exponent);

        }//end of convert method



        return result;
    }


} //end of class
