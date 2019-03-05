/*
An integer implementation of the insertion sort algorithm. The method sort accepts an integer array and sorts it. It does
not return a new array, the sorting takes place within the provided array (in place sorting). The main class prompts the user
for the necessary information to fill up an array of integers. A counter is added in the sorting algorithm that is updated each
time a switch takes place.
 */



import java.util.*;

public class IntegerInsertionSortReversedCounter {


    public static void sort(int[] input){
        int n = input.length;
        int counter = 0;                     //adding a counter that increments by 1 each time a switch is performed
        for (int i = 1; i < n; i++){        // Outer for loop, specifies the index of the element being sorted
            for (int j = i; j > 0; j--){     //inner for loop, compares and switches the element being sorted with each larger element to the left in the array
                int t;
                if (input[j] < input[j-1]){   //switch taking place within the array
                    t = input[j];
                    input[j] = input[j-1];
                    input[j-1] = t;
                    counter += 1;
                    System.out.println(Arrays.toString(input));     //printing out the state of the array after each sort
                }
                else
                    continue;
                System.out.println(Arrays.toString(input));

            }
        }
        System.out.println(counter);

    }

    public static void main(String[] args){     //prompts the user for dimensions + elements that it inputs into an array, then calls method sort with this array as arg
        Scanner scanify = new Scanner(System.in);

        System.out.println("Enter the amount of elements you want sorted");
        int[] capacity = new int[scanify.nextInt()];
        System.out.print("Enter the elements:");
        for (int i = 0; i < capacity.length;i++) {
            capacity[i] = (scanify.nextInt()); //turns the input into negative numbers so abs value will be sorted descendingly
        }
        sort(capacity);
        System.out.println(Arrays.toString(capacity));
    }
}
