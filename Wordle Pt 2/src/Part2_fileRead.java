

import java.util.Scanner;

import static .Dictionary.LONG_LIST;
public class Part2_fileRead {
    public static int findIndex(Character[] arr, char c)
    {

        // traverse in the array
        for (int i = 0; i < arr.length; i++) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == c) {
                return i;
            }

        }
        return -1;
    }
    public static Character[] removeLetter(Character[] arr, char c){
        Character[] arr_new = new Character[arr.length-1];
        for(int i=0, k=0;i<arr.length;i++){
            if(arr[i]!=c){
                arr_new[k]=arr[i];
                k++;
            }
        }
        return arr_new;
    }

    public static Character[] addLetter(Character[] arr, char c){
        Character[] arr_new = new Character[arr.length+1];
        for(int i=0 ;i<arr.length;i++){
            arr_new[i] = arr[i];
        }
        arr_new[arr_new.length - 1] = c;
        return arr_new;
    }

    public static void printArray(Character[] arr){
        for(char c : arr){
            System.out.print(" " + c);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String secret;
        String input;
        String[] guesses = new String[6];
        String result = "";
        String[] checks = new String[6];
        Character[] mayUse = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'W', 'Y', 'Z'};
        Character[] mustUse = new Character[0];
        Character[] mustNotUse = new Character[0];

        //get secret
        secret = LONG_LIST[(int)(Math.random() * (double)(LONG_LIST.length + 1))];
        //ask for secret
        System.out.print("Do you want to see the secret? ");
        input = in.next().toUpperCase();
        if(input.equals("Y")){
            System.out.println("The secret is " + secret);
        }

        //6 rounds
        for( int round = 0; round < 6; round++){

            System.out.printf("%nRound %d. Enter guess: ", (round+1));
            guesses[round] = in.next().toUpperCase();

            while ( guesses[round].length() != 5 ){
                System.out.println("Invalid guess");
                System.out.printf("Round %d. Enter guess: ", (round+1));
                guesses[round] = in.next().toUpperCase();
            }

            //checking guess & letters

            for (int i = 0; i < 5; i++){
                char guessChar = guesses[round].charAt(i);
                if (guessChar == secret.charAt(i)){
                    result += "H";
                    if (findIndex(mayUse, guessChar) != -1){
                        mayUse = removeLetter(mayUse, guessChar);
                        mustUse = addLetter(mustUse, guessChar);
                    }

                }else if (secret.indexOf(guessChar) != -1){
                    result += "m";
                    if (findIndex(mayUse, guessChar) != -1){
                        mayUse = removeLetter(mayUse, guessChar);
                        mustUse = addLetter(mustUse, guessChar);
                    }
                }else{
                    result += "_";
                    if (findIndex(mayUse, guessChar) != -1){
                        mayUse = removeLetter(mayUse, guessChar);
                        mustNotUse = addLetter(mustNotUse, guessChar);
                    }
                }
            } //end of check guess for loop

            checks[round] = result;
            result = "";

            //print alphabet arrays
            System.out.println("--------");
            System.out.printf("%13S", "Must Use:");
            printArray(mustUse);
            System.out.printf("%13S", "May Use:");
            printArray(mayUse);
            System.out.printf("%13S", "Must Not Use:");
            printArray(mustNotUse);

            if(checks[round].equals("HHHHH")){
                System.out.println("You've got it right!");
                round = 10;
            }else{

                //print guesses
                for(int i = 0; i <= round; i++){
                    System.out.printf("%S : %S%n", guesses[i], checks[i]);
                }

                //print alphabet arrays
                System.out.println("--------");
                System.out.printf("%13S", "Must Use:");
                printArray(mustUse);
                System.out.printf("%13S", "May Use:");
                printArray(mayUse);
                System.out.printf("%13S", "Must Not Use:");
                printArray(mustNotUse);

                if(round == 5){
                    System.out.println("Secret was " + secret + ".");
                }

            }

        }// end of 6round for loop


    }//end of main method
}
