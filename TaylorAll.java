package Week7;

import java.util.Scanner;

public class TaylorAll {
    public static void expandExp(double x, int n){
        double derivative = Math.exp(0);
        double result;

        //f(0), f'(0)
        result = derivative + x;

        //f(n>=2)
        for (int k = 2 ; k < n + 1 ; k++){
            result += ( derivative * Math.pow(x, k) ) / factorialCalculator(k);
            System.out.printf("%2d: %.15f%n", k, result);
        }
    }
    public static void expandSin(double x, int n){
        //f(0) + f'(0)
        double result = Math.sin(0) + Math.cos(0) * x;

        for (int k = 2 ; k <= n ; k++){
            if ( k % 4 == 0 ){
                result += Math.sin(0) * Math.pow(x, k) / factorialCalculator(k);
            }
            else if ( k % 4 == 1 ){
                result += Math.cos(0) * Math.pow(x, k) / factorialCalculator(k);
            }
            else if ( k % 4 == 2 ){
                result += (-1) *Math.sin(0) * Math.pow(x, k) / factorialCalculator(k);
            }
            else {
                result += (-1)*Math.cos(0) * Math.pow(x, k) / factorialCalculator(k);
            }
            System.out.printf("%2d: %.15f%n", k, result);
        }
    }
    public static void expandLog(double x, int n){
        double result = x;
        double derivative;

        for (int k = 2 ; k < n + 1 ; k++){
            if ( k % 2 == 0 ) {
                derivative = (-1) * factorialCalculator(k-1);
                result += ( derivative * Math.pow(x, k) ) / factorialCalculator(k);
            } else {
                derivative = factorialCalculator(k-1);
                result += (derivative * Math.pow(x, k)) / factorialCalculator(k);
            }
            System.out.printf("%2d: %.15f%n", k, result);
        }
    }
    public static double factorialCalculator(int n){
        double factorial = 1;
        for (int i = 1 ; i < n + 1 ; i++){
            factorial = factorial * i;
        }
        return factorial;
    }
    public static void main(String[] args){
        //instantiate variables
        double x = 5;
        int n;
        Scanner keyboard = new Scanner(System.in);

        //exp(x)
        System.out.print("For exp(x), enter x (|x|<1.0) and n: ");
        x = keyboard.nextDouble();
        n = keyboard.nextInt();

        System.out.printf("---Approximation of exp(%f)---%n", x);
        if (Math.abs(x) < 1) {
            expandExp(x,n);
        }
        else {
            System.out.print("|x| >= 1");
        }
        System.out.printf("Math.exp(%f): %.15f%n", x, Math.exp(x));

        //sin(x)
        System.out.print("For sin(x), enter x (|x|<1.0) and n:");
        x = keyboard.nextDouble();
        n = keyboard.nextInt();

        System.out.printf("---Approximation of sin(%f)---%n", x);
        if (Math.abs(x) < 1) {
            expandSin(x,n);
        }
        else {
            System.out.print("|x| >= 1");
        }
        System.out.printf("Math.sin(%f): %.15f%n", x, Math.exp(x));

        //log(x)
        System.out.println("For log(1 + x), enter x (|x|<1.0) and n:");
        x = keyboard.nextDouble();
        n = keyboard.nextInt();

        System.out.printf("---Approximation of log(1 + %f)---%n", x);
        if (Math.abs(x) < 1) {
            expandLog(x,n);
        }
        else {
            System.out.println("|x| >= 1");
        }
        System.out.printf("Math.log(1 + %f): %.15f%n", x, Math.log(1 + x));

    }//end of main method


}//end of class
