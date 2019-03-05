import java.io.*;
import java.util.Scanner;


/**
 *  The {@code FrequencyCounter} class provides a client for
 *  reading in a sequence of words and printing a word (exceeding
 *  a given length) that occurs most frequently. It is useful as
 *  a test client for various symbol table implementations.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/31elementary">Section 3.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class FrequencyCounterBST {

    // Do not instantiate.
    private FrequencyCounterBST() { }

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime(); //start the timer
        int distinct = 0, words = 0;
        //int minlen = Integer.parseInt(args[0]);
        BST<String, Integer> st = new BST<String, Integer>();
        File input = new File("C:\\Users\\jacob\\Documents\\KTH\\Algorithms and Data structures\\outputN400.txt");  //file with the first 400 words from the text
        Scanner scan = new Scanner(input);

        while (scan.hasNext()){     //input words into the symbol table using the scanner
            String key = scan.next();
            words++;
            if (st.contains(key)){
                st.put(key, st.get(key) + 1);
            }
            else{
                st.put(key, 1);
                distinct++;
            }

        }




        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;   //end the timer and calculate run time
        System.out.println("Runtime of program is: " + totalTime + " nanoseconds"); //print runtime
    }
}
