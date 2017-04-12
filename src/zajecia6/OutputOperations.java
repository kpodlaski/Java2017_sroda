package zajecia6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by Krzysztof Podlaski on 12.04.2017.
 */
public class OutputOperations {

    public static void main (String[] a) throws Exception {
        PrintWriter pw = new PrintWriter(
           new OutputStreamWriter(
              new FileOutputStream("out.txt",
                                        true)
           )
        );
        pw.println("Ala ma kota");
        pw.print("kot ma myszy");
        pw.close();
    }
}
