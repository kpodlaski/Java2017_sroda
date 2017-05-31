package zajecia8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Krzysztof Podlaski on 10.05.2017.
 */
public class CommServer {
    private ServerSocket ssocket;
    private int port;
    private Socket clientSocket;

    public CommServer(int port) {
        this.port = port;
    }

    public void startServer() throws IOException {
        ssocket = new ServerSocket(port);
        clientSocket = ssocket.accept();
    }


    //Echo Server
    public void echoCommunication() throws IOException {
        InputStream is = clientSocket.getInputStream();
        OutputStream os = clientSocket.getOutputStream();
        while(true){
            int c = is.read();
            System.out.print((char) c);
            os.write(c);
        }
    }

    public void sendMessage(String message) throws IOException {
        OutputStream os = clientSocket.getOutputStream();
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
                InputStream is = clientSocket.getInputStream();
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
        CommServer cs = new CommServer(8000);
        cs.startServer();
        //cs.echoCommunication();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));
        cs.listenOnSocket();
        for (int i=0; i<3; i++){
            String msg = in.readLine();
            cs.sendMessage(msg);
        }
    }
}
