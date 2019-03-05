
/*
 * this program implements two methods for reading an input and outputting the reversed input.
 * The first function does this recursively, and the second stores the input in an array and reverses it iteratively.
 * There is a main method which prompts the user for a line to input, then outputs the reversed input using either of this functions.
 * The function chosen is determined by the variable 'ri'. It is set to i for the iterative method to be called, and anything else
 * for the answer to be given recursively.
 */



#include <stdio.h>
void recursiveReversive();
void iterationReversification();

int main() {
    char array1[25] = "Input string pls";
    printf("%s\n", array1);     //prompt the input of the string thats to be reversed
    char ri = 'i';          //choose which function to test, i for iterative, anything else for recursive


    if (ri == 'i') {

        recursiveReversive();
        return 0;
    }
    else {
        iterationReversification();
        return 0;
    }
    }

//a function that recursively reverses a single string form stdin and outputs it to stdout
void recursiveReversive() {
    char y;
    y = getchar();

    if (y != '\n') {
        recursiveReversive();
    }
    putchar(y);
}

//a function that inputs a string of characters from stdin into an array and iterates through it backwards while printing the string out
void iterationReversification(){
    char wordString[100];   //array to input the string from stdin
    int i = 0;
    for (;i <= 99; i++){        //for loop that fills up the array until it hits newline character
        char x;
        x = getchar();
        wordString[i] = x;
        if (wordString[i] == '\n'){
            break;      //when newline character is shown, for loop is ended and i = the index of the last letter inserted
        }
    }
    for (i >= 0; i--;){     //go through the array backwards and spit out the characters to stdout
        putchar(wordString[i]);
    }

}