import java.util.Random;
public class QuickSort {

    public static void sort(Comparable[] array){
    shuffle(array);     //shuffling the input array to guarantee performance of the quicksort algorithm
    sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high){
        if (high <= low) return;        //If the array consists of one value, it is sorted
        int j = partition(array, low, high);    //partition the array by placing all values smaller than the partitioning element to the left of it, and all values larger to the right of it
        sort(array, low, j-1);  //recursively sort each of these partitions in the same way
        sort(array, j+1, high);
    }

    private static int partition(Comparable[] array, int low, int high){
        int i = low;
        int j = high + 1;
        Comparable v = array[low];  //v is the new partitioning element
        while (true) {

            //increment the low pointer, each time we find an element smaller than v, we stop searching for an element. Break the loop if low reaches the end of the partition
            while (array[++i].compareTo(v) < 0) {
                if (i == high) break;
            }
            //do the same thing for the high pointer, when we find an element larger than the partitioning element, we stop looking for an element
            while (v.compareTo(array[--j])<0) {
                if (j == low) break;
            }

            // check if pointers cross
            if (i >= j) break;
            //Swap the elements found by the high and low pointer
            Comparable element = array[i];
            array[i] = array[j];
            array[j] = element;
        }

        // when the loop is done, move the partitioning element into the correct position
        Comparable element = array[low];
        array[low] = array[j];
        array[j] = element;

        //return position of the old partitioning element.
        return j;
    }


    public static void shuffle(Comparable[] array){
        Random rand = new Random(); //a random number generator with seed based off the system clock
        for (int i = 0; i < array.length - 1;i++){  //for each element in the array to be shuffled
            int index = rand.nextInt(array.length); //we swap it with a random element in the bounds of the array
            Comparable swappable = array[i];
            array[i] = array[index];
            array[index] = swappable;
        }
    }
}
