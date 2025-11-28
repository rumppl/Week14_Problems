import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Stack s = new Stack();
        String line; // the string of characters to be checked

        Scanner scan = new Scanner(System.in);
        System.out.println ("\nParenthesis Matching");
        System.out.print ("Enter a parenthesized expression: ");
        line = scan.nextLine(); // capture string
        int countLeft = 0;
        int countRight = 0;
        int strIndex = 0;
        boolean error = false;

        // loop to process the line one character at a time
        for(strIndex = 0; strIndex < line.length(); strIndex++){
            char c = line.charAt(strIndex);

            if(c == ')' && !s.empty()){
                if((char)s.peek() == '('){
                    s.pop(); //remove associated
                    countRight++;
                }
            } else if (c == ')' && s.empty()) {
                System.out.println("ERROR: MATCHING LEFT PARATHESES NOT FOUND");
                error = true;
                break;
                // this should only run if the char is ')' and there is no '('
            }

            if(c == '('){
                s.push(c);
                countLeft++;
            }

        }
        if(!s.empty()){
            error = true;
            System.out.println("ERROR: DID NOT CLOSE LEFT PARENTHESES");
        }

// print the results
        System.out.println("No. Left Parentheses : " + countLeft +
                "\nNo. Right Parentheses : " + countRight);

        if(error){
            System.out.println("Failure at string index: " + strIndex);
        } else {
            System.out.println("Passed with no errors");
        }

    }
}