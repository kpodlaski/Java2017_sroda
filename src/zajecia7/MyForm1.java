package zajecia7;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Krzysztof Podlaski on 19.04.2017.
 */
public class MyForm1 {
    private JTextField imieTextField;
    private JPanel panel1;
    private JRadioButton czyDoniczkaRButton;
    private JButton kliknijMnieButton;
    private JLabel stopkaLabel;

    public MyForm1() {
        kliknijMnieButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = imieTextField.getText();
                text += " : ";
                if (czyDoniczkaRButton.isSelected())
                    text += " jesteś doniczką";
                else
                    text += " jesteś kwiatkiem";
                stopkaLabel.setText(text);
            }
        });
        imieTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                System.out.println(e.getKeyChar());
            }
        });
        imieTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                System.out.println("FOCUS GAINED");
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                System.out.println("FOCUS LOST");
            }
        });
    }

    public static void main(String[] a){
        JFrame okno = new JFrame("Psychotest");
        MyForm1 form1 = new MyForm1();
        okno.setContentPane(form1.panel1);
        okno.setSize(300,300);
        okno.setLocation(150,150);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
        System.out.println("KONIEC PROGRAMU");
    }


}
