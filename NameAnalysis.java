package Week6;
import java.util.*;

public class NameAnalysis {
    // method myTrim removes unnecessary white space
    public static String myTrim( String x ) {
        StringBuilder builder = new StringBuilder();
        boolean afterSpace = true;
        char ch;

        // iterates through string input and takes out unnecessary white space
        for ( int i = 0 ; i <= (x.length()-1) ; i++) {
            ch = x.charAt(i);

            switch(ch){
                case ',':
                    builder.append(", ");
                case ' ' :
                    if (afterSpace){
                        break;
                    }
                    afterSpace = true;
                    builder.append(" ");
                    break;
                default:
                    builder.append(ch);
                    afterSpace = false;
                    break;
            }

            // check status of variables on each iteration
            //System.out.println(i + " " + ch + " " + afterSpace + " " + builder);
        }
        // takes out white space at the end of input
        while (builder.charAt(builder.length()-1) == ' '){
            builder.deleteCharAt(builder.length()-1);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input;

        //get input
        System.out.print("Enter a name to analyze: ");
        input = keyboard.nextLine();
        System.out.println("\ninput = <" + input + ">");

        //take out "middle name"
        String nickName = "";
        int indexBeginningOfQuotation = input.indexOf( "\"");
        int indexEndOfQuotation;
        if ( indexBeginningOfQuotation >= 0 ) {
            indexEndOfQuotation = input.indexOf("\"", indexBeginningOfQuotation + 1);
            nickName = input.substring(indexBeginningOfQuotation + 1, indexEndOfQuotation);
            input = input.substring(0, indexBeginningOfQuotation) + input.substring(indexEndOfQuotation + 1);
        }

        //correct input
        String full = myTrim(input);

        //find suffix
        String suffix = "";
        int a = full.indexOf(',');
        if(a >= 0){
            suffix = full.substring(a+3);
            full = full.substring(0,a);
        }

        //find prefix
        String prefix = "";
        if (full.startsWith("Dr.")){
            prefix = "Dr.";
            full = full.substring(4);
        } else if (full.startsWith("Mr.")){
            prefix = "Mr.";
            full = full.substring(4);
        } else if (full.startsWith("Ms.")) {
            prefix = "Ms.";
            full = full.substring(4);
        } else if (full.startsWith("Mrs.")){
            prefix = "Mrs.";
            full = full.substring(5);
        } else if (full.startsWith("Rev.")){
            prefix = "Rev.";
            full = full.substring(5);
        }
        //find firstname
        String firstName;
        int indexFirstWhitespace = full.indexOf(' ');
        firstName = full.substring(0, indexFirstWhitespace);
        full = full.substring(indexFirstWhitespace+1);

        //find middle and lastname
        String lastName;
        String middleName = "";
        int indexLastWhitespace = full.lastIndexOf(' ');

        if (indexLastWhitespace >= 0) {
            middleName = full.substring(0,indexLastWhitespace);
            lastName = full.substring(indexLastWhitespace+1);
        }else{
            lastName = full;
        }


        //print names
        System.out.println("firstname =  <" + firstName + ">");
        System.out.println("middlename = <" + middleName + ">");
        System.out.println("lastname = <" + lastName + ">");
        System.out.println("prefix = <" + prefix + ">");
        System.out.println("suffix = <" + suffix + ">");
        System.out.println("nickname = <" + nickName + ">");

    } //end of main method


} //end of class
