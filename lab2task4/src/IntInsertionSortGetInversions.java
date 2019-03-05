/*
An integer implementation of the insertion sort algorithm. The method sort accepts an integer array and sorts it. It does
not return a new array, the sorting takes place within the provided array (in place sorting). The main class prompts the user
for the necessary information to fill up an array of integers. It also counts and gives the indexes of all inversions present in
the input array. Furthermore it counts and prints the amounts of switches performed.
 */



import java.util.*;

public class IntInsertionSortGetInversions {


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
                    counter += 1;       //increment counter for switch performed
                    System.out.println(Arrays.toString(input));     //printing out the state of the array after each sort
                }
                else
                    continue;
                System.out.println(Arrays.toString(input));

            }
        }
        System.out.println("Number of sorts performed: " + counter);

    }

    public static void main(String[] args){     //prompts the user for dimensions + elements that it inputs into an array, then calls method sort with this array as arg
        Scanner scanify = new Scanner(System.in);

        System.out.println("Enter the amount of elements you want sorted");
        int[] capacity = new int[scanify.nextInt()];
        System.out.print("Enter the elements:");

        for (int i = 0; i < capacity.length;i++) {
            capacity[i] = (scanify.nextInt());
        }
        System.out.println("Number of inversions is: " + inversionCounter(capacity));   //prints the amount and type of inversions
        System.out.println(Arrays.toString(capacity));
        sort(capacity);
        System.out.println(Arrays.toString(capacity));
    }

    public static int inversionCounter(int[] input){
      int inversionCounter = 0;
      for (int i = 0; i < input.length; i++){
          for (int j = i+1; j < input.length; j++){
              if (input[i] > input[j]){
                  System.out.println("[(" + i + "," + input[i] +")" + "," + "(" + j + "," + input[j] + ")]" );
                  inversionCounter++;
              }
          }
      }
      return inversionCounter;
    }
}
