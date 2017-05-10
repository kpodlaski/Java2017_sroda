package zajecia8;

import java.io.*;
import java.net.Socket;

/**
 * Created by Krzysztof Podlaski on 10.05.2017.
 */
public class CommClient {
    private int port;
    private String addres;
    private Socket socket;

    public CommClient( String addres, int port) {
        this.port = port;
        this.addres = addres;
    }

    public void connectToServer() throws IOException {
        socket = new Socket(addres,port);
    }

    public void sendMessage(String message) throws IOException {
        OutputStream os = socket.getOutputStream();
        os.write(message.getBytes());
        os.write(';');
    }


    public void listenOnSocket() throws IOException {
        SocketListener l = new SocketListener();
        Thread t = new Thread(l);
        t.setDaemon(true);
        t.start();
    }

    class SocketListener implements  Runnable{

        @Override
        public void run() {
            try{
                InputStream is = socket.getInputStream();
                while (true){
                    int c = is.read();
                    System.out.print((char) c);
                    //if (c == ';') break;
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        CommClient cc = new CommClient("127.0.0.1",8000);
        cc.connectToServer();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(System.in));
        cc.listenOnSocket();
        for (int i=0; i<3; i++){
            String msg = in.readLine();
            cc.sendMessage(msg);
        }
    }
}
