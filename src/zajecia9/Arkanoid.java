package zajecia9;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Krzysztof Podlaski on 31.05.2017.
 */
public class Arkanoid extends JPanel {
    private double vx=1, vy=1;
    private double x=60,y=50;

    public Arkanoid(){
        Thread animThread = new Thread(new Animation());
        animThread.setDaemon(true);
        animThread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor( new Color(0x0000ff));
        g.fillArc((int)x, (int)y,
                40, 40,
                0, 360);
    }

    private void move(){
        x+=vx;
        y+=vy;
    }

    private void checkConstraints(){

    }
    class Animation implements Runnable{
        @Override
        public void run() {
            while(true){
                move();
                checkConstraints();
                repaint();
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid");
        Arkanoid ark = new Arkanoid();
        frame.setContentPane(ark);
        frame.setSize(500,500);
        frame.setLocation(100,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
