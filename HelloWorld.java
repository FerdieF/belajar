package pbol;

import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JFrame {
    public JLabel label;

    public HelloWorld() {
        super("Our first Swing program");
        setLayout(new FlowLayout());
        label = new JLabel("Hello World");
        label.setFont(new Font("San Serif", Font.PLAIN, 30));
        add(label);
    }

    public static void main(String[] args) {
        String str1 = JOptionPane.showInputDialog("Enter 1st integer");
        String str2 = JOptionPane.showInputDialog("Enter 2nd integer");
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);
        int sum = num1 + num2;
        JOptionPane.showMessageDialog(null, num1 + " + " + num2 + " = " + sum);
    }
}
