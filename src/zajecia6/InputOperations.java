package zajecia6;

import java.io.*;
import java.net.URL;

/**
 * Created by Krzysztof Podlaski on 12.04.2017.
 */
public class InputOperations {

    public static void main(String[] a) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("out.txt")
                )
        );

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();

        System.out.println("==================");
        br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("out.txt")
                ));
        int znak;
        while ( (znak = br.read())>=0 ){
            if(znak== 13) continue;
            System.out.print((char) znak + " ");
        }
        br.close();
        System.out.println("==================");
        InputStream is = new FileInputStream("out.txt");
        is.close();
        is = new URL("http://www.onet.pl").openStream();
        br = new BufferedReader(
                new InputStreamReader(
                        is
                ));
        char[] bufor = new char[20];
        int readedChars;
        while ( (readedChars =  br.read(bufor))>0 ){
            System.out.println(readedChars);
            //for( char c : bufor) {
            for(int i=0; i<readedChars; i++){
                System.out.print(bufor[i]);
            }
            System.out.println();
        }
        br.close();
    }
}
