/*
      I got help from some websites like stack overflow and etc ...
      I learned from a random indian programer how to use constructor
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JPanel panel;
    JTextField textField;
    Font font = new Font("Fixedsys Regular",Font.BOLD,30);
    Font titleFont = new Font("Arial", Font.BOLD, 16);
    JButton[] N_button = new JButton[10];
    JButton[] F_button = new JButton[9];
    JButton sumBut , menha, zarb, taghsim, decBut , mosavi, delBut , clrBut , manfi;
    double n1=0,n2=0, answer =0;
    char namad ;
    String temp ;

    // make a constructor of our class
    Calculator(){
        //set frame
        JLabel textLabel = new JLabel("Hi this is Hamid's calculator");
        frame = new JFrame("Hamid's Calculator");frame.setSize(600,580);
        frame.setDefaultCloseOperation(3);frame.setLayout(null);
        frame.setResizable(false);
        textLabel.setBounds(200,8,600,20);textLabel.setFont(titleFont);

        // set panel
        panel = new JPanel();panel.setBounds(50,100,480,350);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new GridLayout(4,4,20,20));

        // LCD of calculator (textfield)
        textField = new JTextField();textField.setBounds(50,30,480,60);textField.setFont(font);
        textField.setEnabled(false); //because to control that you don't use keyboard to type :)

        // Set function keys
        sumBut = new JButton("+");menha = new JButton("-");zarb = new JButton("X");
        taghsim = new JButton("/");decBut = new JButton(".");mosavi = new JButton("=");
        delBut = new JButton("Del");clrBut = new JButton("Clr");manfi = new JButton("(-)");

        F_button[0] = sumBut;F_button[1] = menha;F_button[2] = zarb;F_button[3] = taghsim;F_button[4] = decBut;
        F_button[5] = mosavi;F_button[6] = delBut;F_button[7] = clrBut;F_button[8] = manfi;

        // set numbers keys
        for (int i=0;i<10;i++) {
            N_button[i] = new JButton(String.valueOf(i));
            N_button[i].addActionListener(this);
            N_button[i].setFont(font);
        }

        // set function keys final task
        for (int i=0;i<9;i++) {
            F_button[i].addActionListener(this);
            F_button[i].setFont(font);
        }

        // set the place of keys
        clrBut.setBounds(230,470,120,50);delBut.setBounds(50,470,120,50);
        manfi.setBounds(410,470,120,50);

        // add to frame
        frame.add(textField);frame.add(clrBut);frame.add(delBut);frame.add(manfi);frame.add(panel);
        frame.setVisible(true);frame.add(textLabel);

        // add to panel (it will be line by line)
        panel.add(N_button[1]);panel.add(N_button[2]);panel.add(N_button[3]);panel.add(sumBut); //line one
        panel.add(N_button[4]);panel.add(N_button[5]);panel.add(N_button[6]);panel.add(menha); //line two
        panel.add(N_button[7]);panel.add(N_button[8]);panel.add(N_button[9]);panel.add(zarb); //line three
        panel.add(F_button[4]);panel.add(N_button[0]);panel.add(mosavi);panel.add(taghsim); //line four
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0 ; i<10 ; i++){
            if(e.getSource() == N_button[i]){
                textField.setText(textField.getText().concat(String.valueOf(i))); // I found this to get numbers easily
                // from stack overflow
            }
        }
        // set etc keys

        if(e.getSource()==manfi){
            textField.setText("-");
        }

        if(e.getSource()==sumBut){
            n1 =Double.parseDouble(textField.getText());
            namad = '+';
            textField.setText("");
        }

        if(e.getSource()==menha){
            n1 =Double.parseDouble(textField.getText());
            namad = '-';
            textField.setText("");
        }

        if(e.getSource()==taghsim) {
            n1 =Double.parseDouble(textField.getText());
            namad = '/';
            textField.setText("");
        }

        if(e.getSource()==zarb) {
            n1 =Double.parseDouble(textField.getText());
            namad = '*';
            textField.setText("");
        }

        if(e.getSource()==decBut)
            textField.setText(textField.getText().concat(String.valueOf('.')));

        if(e.getSource()==mosavi){
            n2 =Double.parseDouble(textField.getText());

            switch (namad){
                case '+':
                    answer = n1+n2;
                    break;
                case '-':
                    answer = n1-n2;
                    break;
                case '*':
                    answer = n1*n2;
                    break;
                case '/':
                    answer = n1/n2;
            }

            // printing
            textField.setText(String.valueOf(answer));
            n1=answer;
        }
        // clearing and cleaning textfield (LCD of calculator)
        if(e.getSource()==delBut) {
            temp = textField.getText();
            textField.setText("");
            for (int i = 0; i < temp.length()-1; i++)
                textField.setText(temp.charAt(i)+textField.getText());
        }
        if(e.getSource()==clrBut) {
            n1 = Double.parseDouble(textField.getText());
            textField.setText("");
        }
    }
}