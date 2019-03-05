
/*
this class creates a stack of characters using an array. The maximum capacity of the stack is the size which the stack is initialized to.
Push adds an element to the top of the stack, pop pops off the element currently at the top of the stack. Method size tells you the current
size of the stack. The stack can be printed in string form. The main method inputs a line from stdin into a character array, then it iterates
through this array until it encounters an initializing bracket. When this is encountered, the bracket is pushed. When it encounters a closing
bracket the stack is popped, and the two brackets are compared. If these brackets are the same, the code is balanced, if they are not, the code
is not balanced.
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

        for (; i < charInput.length; i++) {
            if ((charInput[i] == '{') || (charInput[i] == '[') || (charInput[i] == '(')){       //if the stack encounters an initializing bracket it is pushed
                reversifier.push(charInput[i]);
            }
            if ((charInput[i] == '}') || (charInput[i] == ']') || (charInput[i] == ')')){       //if program encounters a closing bracket, the stack is popped,
                char popped = reversifier.pop();                                                //if the closing bracket does not match the bracket popped, code is not balanced
                if (isSame(popped, charInput[i]) == false){
                    System.out.println("Code is not balanced");
                }

                }


        }
    }

    public static boolean isSame(char popped, char closeBracket){       //a method which accepts two characters, if they are of same bracket type true is returned, if they are not, false is
        if ((popped == '(') && (closeBracket == ')')){
            return true;
        }
        else if ((popped == '{') && (closeBracket == '}')){
            return true;
        }
        else if ((popped == '[') && (closeBracket == ']')){
            return true;
        }
        else return false;
    }
}