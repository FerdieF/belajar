package tugastiga21145;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kalkulator21145 extends JFrame implements ActionListener {
    private JButton delBtn, clrBtn;
    private JButton NumberBtn[];
    private JButton funcBtn[];
    private JButton Add_btn, Sub_btn, Mul_btn, Div_btn, equalBtn, decBtn;
    private JPanel panel;
    private JTextField text;

    private double number, result = 0, current, temp = 0;
    private char operator = ' ';
    private int x = 0;
    private String del="", str="";

    public Kalkulator21145(){
        initialize();
    }

    private void initialize(){
        this.setSize(new Dimension(300, 420));
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        text = new JTextField();
        text.setSize(new Dimension(250,40));
        text.setLocation(new Point(20,20));
        text.setFont(new Font("Sono",Font.PLAIN, 20));
        text.setEditable(false);
        text.setForeground(Color.black);
        text.setHorizontalAlignment(JTextField.RIGHT);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        panel.setSize(new Dimension(250, 250));
        panel.setLocation(new Point(20, 70));

        Add_btn = new JButton("+");
        Sub_btn = new JButton("-");
        Mul_btn = new JButton("x");
        Div_btn = new JButton("/");
        equalBtn = new JButton("=");
        decBtn = new JButton(".");

        clrBtn = new JButton("C");
        clrBtn.setLocation(new Point(20,330));

        delBtn = new JButton("del");
        delBtn.setLocation(new Point(170, 330));

        funcBtn = new JButton[8];

        funcBtn[0] = Add_btn;
        funcBtn[1] = Sub_btn;
        funcBtn[2] = Mul_btn;
        funcBtn[3] = Div_btn;
        funcBtn[4] = equalBtn;
        funcBtn[5] = delBtn;
        funcBtn[6] = clrBtn;
        funcBtn[7] = decBtn;

        for(int i=0;i<8;i++){
            funcBtn[i].setFocusable(false);
            funcBtn[i].setVerticalTextPosition(JButton.CENTER);
            funcBtn[i].setHorizontalTextPosition(JButton.CENTER);
            funcBtn[i].setFont(new Font("Sono", Font.PLAIN, 20));
            funcBtn[i].setSize(new Dimension(100,30));
            funcBtn[i].addActionListener(this);
            funcBtn[i].setForeground(Color.BLACK);
        }

        NumberBtn = new JButton[10];

        for(int i=0;i<10;i++){
            NumberBtn[i] = new JButton(String.valueOf(i));
            NumberBtn[i].setFocusable(false);
            NumberBtn[i].setFont(new Font("Sono", Font.PLAIN, 20));
            NumberBtn[i].setSize(new Dimension(100,30));
            NumberBtn[i].addActionListener(this);
            NumberBtn[i].setForeground(Color.BLACK);
        }

        panel.add(NumberBtn[7]);
        panel.add(NumberBtn[8]);
        panel.add(NumberBtn[9]);
        panel.add(funcBtn[0]);

        panel.add(NumberBtn[6]);
        panel.add(NumberBtn[5]);
        panel.add(NumberBtn[4]);
        panel.add(funcBtn[1]);

        panel.add(NumberBtn[3]);
        panel.add(NumberBtn[2]);
        panel.add(NumberBtn[1]);
        panel.add(funcBtn[2]);

        panel.add(funcBtn[7]);
        panel.add(NumberBtn[0]);
        panel.add(funcBtn[4]);
        panel.add(funcBtn[3]);

        this.add(funcBtn[6]);
        this.add(funcBtn[5]);
        this.add(text);
        this.add(panel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void operation(char op, double curr){
        switch(operator){
            case '+':
                result = number + curr;
                break;
            case '-':
                result = number - curr;
                break;
            case 'x':
                result = number * curr;
                break;
            case '/':
                result = number / curr;
                break;
        }

        text.setText(String.valueOf(result));
        temp = result;
        x = 0;
    }

    public void actionPerformed(ActionEvent e) { //adding func
        if (e.getSource() == funcBtn[0]) {
            if (!text.getText().isEmpty()) {
                current = Double.valueOf(text.getText());
                if (operator != ' ' && operator != '+') {
                    operation(operator, current);
                    operator = ' ';
                }

                current = Double.valueOf(text.getText());

                if (x == 0) {
                    temp = current;
                    number = temp;
                    operator = '+';
                    x = 1;
                } else {
                    number = temp;
                    result = number + current;
                    text.setText(String.valueOf(result));
                    temp = result;
                    x = 1;
                }
            }
        }

        if (e.getSource() == funcBtn[1]) {    //subtract func
            if (!text.getText().isEmpty()) {
                current = Double.valueOf(text.getText());
                if (operator != ' ' && operator != '-') {
                    operation(operator, current);
                    operator = ' ';
                }

                current = Double.valueOf((text.getText()));

                if (x == 0) {
                    temp = current;
                    number = temp;
                    operator = '-';
                    x = 1;
                } else {
                    number = temp;
                    result = number - current;
                    text.setText(String.valueOf(result));
                    temp = result;
                    x = 1;
                }
            }
        }

        if (e.getSource() == funcBtn[2]) {    //multiple func
            if (!text.getText().isEmpty()) {
                current = Double.valueOf(text.getText());
                if (operator != ' ' && operator != 'x') {
                    operation(operator, current);
                    operator = ' ';
                }

                current = Double.valueOf((text.getText()));

                if (x == 0) {
                    temp = current;
                    number = temp;
                    operator = 'x';
                    x = 1;
                } else {
                    number = temp;
                    result = number * current;
                    text.setText(String.valueOf(result));
                    temp = result;
                    x = 1;
                }
            }
        }

        if (e.getSource() == funcBtn[3]) { //div func
            if (!text.getText().isEmpty()) {
                current = Double.valueOf(text.getText());
                if (operator != ' ' && operator != '/') {
                    operation(operator, current);
                    operator = ' ';
                }

                current = Double.valueOf(text.getText());

                if (x == 0) {
                    temp = current;
                    number = temp;
                    operator = '/';
                    x = 1;
                } else {
                    number = temp;
                    result = number / current;
                    text.setText(String.valueOf(result));
                    temp = result;
                    x = 1;
                }
            }
        }

        if (e.getSource() == funcBtn[4]) {    //equal func
            if (!text.getText().isEmpty()) {
                current = Double.valueOf(text.getText());
                operation(operator, current);
                operator = ' ';
            }
        }

        if (e.getSource() == funcBtn[5]) {    //delete func
            String string = text.getText();
            text.setText("");
            for(int i=0;i<string.length()-1;i++){
                text.setText(text.getText()+string.charAt(i));
            }
        }

        if (e.getSource() == funcBtn[6]) {    //clear func
            result = 0;
            x = 0;
            temp = 0;
            number = 0;
            operator = ' ';
            text.setText("");
        }

        if(e.getSource() == funcBtn[7]) {
            if (x == 1) {
                text.setText("");

                if (!text.getText().contains(".")) {
                    text.setText(text.getText().concat("."));
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == NumberBtn[i]) {
                if (x == 1) {
                    text.setText("");
                    text.setText(text.getText().concat(String.valueOf(i)));
                    x = 2;
                } else {
                    text.setText(text.getText().concat(String.valueOf(i)));
                }
            }
        }
    }

    public static void main(String args[]){
        new Kalkulator21145();
    }
}
