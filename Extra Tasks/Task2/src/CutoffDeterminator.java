import java.util.Arrays;
import java.util.Random;
public class CutoffDeterminator {

    public static void main(String[] args) {
            int n = 40;   //number of elements to be sorted
            int k = 100;     //elements within range 0-100

            Integer[] arrayInsertion = new Integer[n];  //array which we will sort containing int
            Double[] arrayInsert = new Double[n];       //array to sort double precision Float
            Random rand = new Random();     //the random number generator used to generate the input

            for (int i = n - 1; i >= 0; i--) {
                arrayInsertion[i] = rand.nextInt(k + 1);  //filling the arrays with random numbers in the bound we want
                arrayInsert[i] = rand.nextDouble() * k;
            }

            Integer[] arrayQuick = new Integer[n];
            Double[] arrayQuicksort = new Double[n];    //creating copies of the arrays we send to insertion sort, we can send to quicksort
            System.arraycopy(arrayInsertion, 0, arrayQuick, 0, arrayInsertion.length);  //integer
            System.arraycopy(arrayInsert, 0, arrayQuicksort, 0, arrayQuicksort.length); //double

            double startTime1 = System.nanoTime();  //Insertion sort the integer array and time this process
            InsertionSort.sort(arrayInsertion);
            double executionTime1 = System.nanoTime() - startTime1;

            double startTimeInsert = System.nanoTime(); //insertion sort the double array and time it
            InsertionSort.sort(arrayInsert);
            double executionTimeInsert = System.nanoTime() - startTimeInsert;

            double startTime2 = System.nanoTime();  //quicksort the integer array and time the process
            QuickSort.sort(arrayQuick);
            double executionTime2 = System.nanoTime() - startTime2;

            double startTimeQuick = System.nanoTime();  //quicksort the double array and time it
            QuickSort.sort(arrayQuicksort);
            double executionTimeQuick = System.nanoTime() - startTimeQuick;


            if (executionTime2 < executionTime1)
                System.out.println("Above cutoff integer");

            else
                System.out.println("Below cutoff integer");

            if (executionTimeInsert > executionTimeQuick)
                System.out.println("Above cutoff double");
            else
                System.out.println("Below cutoff double");

        }
    }

