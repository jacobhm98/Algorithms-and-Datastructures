/*
A class which accepts two arrays, sorts the integer array in ascending order, and moves the entries in the string array
in the same way.
 */

public class Sort {

    public static void sort(Comparable[] array, String[] wordArray){
        for(int i = 1; i < array.length; i++){
            for (int j = i; j > 0 && array[j].compareTo(array[j-1]) < 0; j--){
                Comparable element = array[j];
                String wordElement = wordArray[j];
                array[j] = array[j-1];
                wordArray[j] = wordArray[j-1];
                array[j-1] = element;
                wordArray[j-1] = wordElement;
            }
        }
    }
}

