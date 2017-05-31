package zajecia8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * Created by Krzysztof Podlaski on 10.05.2017.
 */
public class CommClient implements ActionListener {
    private int port;
    private String addres;
    private Socket socket;
    private JFrame frame;
    private JTextArea history = new JTextArea(20,30);
    private JTextField textToSend = new JTextField(30);
    private JButton sendButton = new JButton("Send");

    public CommClient( String addres, int port) {
        this.port = port;
        this.addres = addres;
        frame = new JFrame("Komunikator");
        frame.getContentPane().add(history, BorderLayout.CENTER);
        frame.getContentPane().add(textToSend, BorderLayout.SOUTH);
        frame.getContentPane().add(sendButton, BorderLayout.EAST);
        frame.setSize(300,300);
        frame.setLocation(150,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        sendButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textToSend.getText();
        try {
            sendMessage(text);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        textToSend.setText("");
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
                    history.append(""+(char) c);
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
