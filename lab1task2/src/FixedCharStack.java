
/*
this class creates a stack of characters using an array. The maximum capacity of the stack is the size which the stack is initialized to.
Push adds an element to the top of the stack, pop pops off the element currently at the top of the stack. Method size tells you the current
size of the stack. The stack can be printed in string form. The main method tests the character stack, it prompts the user for an input line,
pushes each character from the line, then pops each character. This results in the input effectively being reversed.
 */

import java.util.Scanner;

public class FixedCharStack {

    private char[] charStack;       //array where the input is to be stored, as characters
    private int index;              //index pointing to the top of the stack
    private int size;               //the size that the stack is initialized to

    public FixedCharStack(int size){        //a constructor for the stack, argument given is the size the stack is initialized to
        this.charStack = new char[size];
        this.index = 0;
        this.size = size;
    }

    public char pop(){          //returns the last element of the stack
        index--;
        char poppable = charStack[index];
        return poppable;
    }

    public void push(char pushable){        //adds an element to the stack, element is given as argument
        charStack[index] = pushable;
        index++;
    }

    @Override public String toString(){     //allows for printing of all elements in the stack

        String format = new String();
        for (int i = 0; i < size; i++){
            format += "[" + charStack[i] + "], ";
        }
        return format;
    }

    public int size(){      //returns the amount of elements present in the stack
        int size = index;
        return size;
    }

    public static void main(String args[]) {
        FixedCharStack reversifier = new FixedCharStack(100);  //initialize a fixed size stack of characters of size 100

        Scanner scanify = new Scanner(System.in);       //generate input to stdin and read this input
        System.out.println("Enter the input you want fam");
        String input = scanify.nextLine();
        char[] charInput;                               //read this input as a string, then store it in an array of characters
        charInput = input.toCharArray();
        int i = 0;                                      //iterate through this array and push each character into reversifier
        for (; i < charInput.length; i++){
            reversifier.push(charInput[i]);
        }
        for (; i > 0; i--){                             //pop the character stack as many times as you pushed into it, and print the characters
            System.out.print(reversifier.pop());        //effectively reversing the input as output
        }
    }


}
