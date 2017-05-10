package zajecia8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

    public static void main(String[] args) throws IOException {
        CommServer cs = new CommServer(8000);
        cs.startServer();
        cs.echoCommunication();
    }
}
