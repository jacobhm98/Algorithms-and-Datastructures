/*
This class sets a text file as input, removes all non letter characters and replaces them with a space. It then outputs
the result as a new file.
 */



import java.io.*;
import java.lang.*;

public class Filter {

    public static void Filter(File input, File output) throws IOException{
        FileInputStream fis = new FileInputStream(input);
        InputStreamReader in = new InputStreamReader(fis, "UTF-8"); //wrapping a bytewise reader with a character reader to get best results
        FileOutputStream fos = new FileOutputStream(output);
        OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");    //doing the same thing for the output
        int c;
        do {
            c =  in.read();     //the character to be read
            if (c == '-' || c == '>'){
                out.write(' ');
            }
            if(c == ','){   //write over alternate corrections as each key can only accept one value
                do {
                    out.write(' ');
                } while(in.read() != '\r');
            }
            if (Character.isLetter(c) || c == '\n' || c == '\r')
               out.write(c);       //if the character is a letter or newline or space, output as is


        } while (c != -1);      //do this until inputstreamreader reaches end of file
        in.close();
        out.close();        //close the streams
    }

}
