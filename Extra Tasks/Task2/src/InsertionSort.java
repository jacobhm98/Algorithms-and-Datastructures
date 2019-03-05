/*
A class which accepts an array of comparable values and sorts them using insertion sort
 */


public class InsertionSort {

    public static void sort(Comparable[] array){
        for(int i = 1; i < array.length; i++){      //Start with the second element in the list
            for (int j = i; j > 0 && array[j].compareTo(array[j-1]) < 0; j--){      //while the array we are sorting is smaller than the element to its left, sort chosen element down
                Comparable element = array[j];      //exchanging elements
                array[j] = array[j-1];
                array[j-1] = element;
                }
            }
        }
    }

