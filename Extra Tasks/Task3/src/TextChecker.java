import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class TextChecker {

    public static void main(String[] args) throws FileNotFoundException {
        if (args[0] == "test") {
            File input = new File(args[1]);
            Scanner scan = new Scanner(input);
            BST<String, Integer> st = new BST();
            int words = 0;
            while (scan.hasNext()) {     //Build up a symbol table with distinct words as key, their number of occurrences as value
                String key = scan.next();
                if (key == null) continue;
                else if (st.contains(key)) {
                    st.put(key, st.get(key) + 1);
                } else {
                    st.put(key, 1);
                    words++;
                }

            }
            Integer[] frequency = new Integer[words];
            String[] unorderedWords = new String[words];
            int i = 0;
            for (String word : st.keys()) {   //put all of the words into an array of strings
                frequency[i] = st.get(word);    //put their occurences into an array of integers at same index
                unorderedWords[i] = word;
                i++;
            }
            Sort.sort(frequency, unorderedWords);   //insertion sort the array of integers in ascending order
            System.out.println(Arrays.toString(unorderedWords));    //when we move a number, the corresponding word is moved in the same way, as such most common word will be at end of array, least common at start
            System.out.println(Arrays.toString(getWords(1, 1, unorderedWords)));
        }
    }

   public static String[] getWords(int k, int n, String[] wordArray){   //a method which retrieves most common words in the range k-n
    String[] mostCommon = new String[n-k+1];
    int j = 0;
    for(int i = wordArray.length-k; i >= wordArray.length-n; i--){
        mostCommon[j] = wordArray[i];
        j++;
    }
    return mostCommon;
   }
}
