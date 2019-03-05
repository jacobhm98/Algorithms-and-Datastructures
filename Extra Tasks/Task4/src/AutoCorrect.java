/*
A program which builds up a search tree of common misspellings where keys are misspellings and values are corrections.
We can then reference texts against this search tree and replace any commonly found misspellings. In effect building an autocorrector.
 */


import java.util.Scanner;
import java.io.*;
public class AutoCorrect {

    public static void main(String[] args) throws IOException {
        if (args[0] == "test") {
            File input = new File("C:\\Users\\jacob\\Documents\\KTH\\Algorithms and Data structures\\misspellings.txt"); //setting the file to be filtered
            File output = new File("C:\\Users\\jacob\\Documents\\KTH\\Algorithms and Data Structures\\output1.txt"); //specifying where the output is wanted
            File checkFile = new File(args[1]);
            File checkedFile = new File("C:\\Users\\jacob\\Documents\\KTH\\Algorithms and Data structures\\checkedFile.txt");
            Filter.Filter(input, output);   //filter the input source of common misspellings
            RedBlackBST<String, String> st = new RedBlackBST<>(); //create a binary search tree
            buildST(output, st);    //build the BST with key = misspelling, value = correct spelling
            spellCheck(checkFile, checkedFile, st); //spellCheck the wanted file
        }
    }

    public static void buildST (File input, RedBlackBST<String, String> st)throws FileNotFoundException {
        Scanner scan = new Scanner(input);
        String key;
        String value;
        while(scan.hasNext()){  //seeing as the file of misspellings are alternating between misspelling and correction of that misspelling
            key = scan.next();  //we can input every other String as value and every other string as key
            value = scan.next();
            st.put(key, value);
        }
    }
    public static void spellCheck(File input, File output, RedBlackBST<String, String> st)throws FileNotFoundException {
        Scanner scan = new Scanner(input);
        try {
            PrintWriter write = new PrintWriter(output);
            String word;
            while (scan.hasNext()) {    //check each word in the file we want to correct
                word = scan.next();     //if this word is contained in the BST "dictionary", swap it with the correction
                if (st.contains(word)) {    //otherwise leave the word as it is correct
                    write.print(st.get(word));
                } else {
                    write.print(word);
                }
                write.print(" ");
            }
            write.close();
        }catch(IOException e){

        }
    }
}
