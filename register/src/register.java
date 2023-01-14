import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class register implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[14];
    JButton addButton, subButton, mulButton, divButton, negButton, delButton, tellbutton;
    JButton addIButton, subIbutton, mulIButton, divIbutton, storeButton, loadButton, stateButton;
    JPanel panel;

    Font myFont = new Font("Ink Free", Font.BOLD,20);
    double num1 = 0, num2 = 0, result =0;
    double[] heap = new double[100];
    char operator;

    register(){

        frame = new JFrame("Register");  //adds a frame named Register
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // closes by clicking on close button
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();   // declaring an user textfield
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);   //already declared font(myFont)
        textField.setEditable(false); //user can not edit any text on text field

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        addIButton = new JButton("AddI");
        subIbutton = new JButton("SubI");
        mulIButton = new JButton("MulI");
        divIbutton = new JButton("DivI");
        storeButton = new JButton("Store");
        stateButton = new JButton("State");
        loadButton = new JButton("Load");
        negButton = new JButton("(-)");
        delButton = new JButton("Clr");
        tellbutton = new JButton("TELL");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = addIButton;
        functionButtons[5] = subIbutton;
        functionButtons[6] = mulIButton;
        functionButtons[7] = divIbutton;
        functionButtons[8] = tellbutton;
        functionButtons[9] = stateButton;
        functionButtons[10] = loadButton;
        functionButtons[11] = negButton;
        functionButtons[12] = delButton;
        functionButtons[13] = storeButton;

        for(int i =0; i<14; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i =0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        stateButton.setBounds(50,430,100,50);
        storeButton.setBounds(150,430,100,50);
        delButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(5,4,8,8));
        panel.setBackground(Color.BLACK);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(negButton);
        panel.add(numberButtons[0]);
        panel.add(tellbutton);
        panel.add(divButton);
        panel.add(addIButton);
        panel.add(subIbutton);
        panel.add(mulIButton);
        panel.add(divIbutton);


        frame.add(panel);
        frame.add(stateButton);
        frame.add(delButton);
        frame.add(storeButton);
        frame.add(textField);   //adds text field to frame
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        register reg = new register();
    }
    @Override
    public void actionPerformed(ActionEvent e){

        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == addButton){
//            textField.setText(textField.getText().concat("ADD"));
            num1 = Double.parseDouble(textField.getText());
            result += num1;
            operator = '+';
            textField.setText("");
        }

        if(e.getSource()==subButton) {
            num1 = Double.parseDouble(textField.getText());
            result -= num1;
            operator ='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton) {
            num1 = Double.parseDouble(textField.getText());
            result *= num1;
            operator ='*';
            textField.setText("");
        }
        if(e.getSource()==divButton) {
            num1 = Double.parseDouble(textField.getText());
            result /= num1;
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == tellbutton) {
            textField.setText(String.valueOf(result));
//            textField.setText("");
        }
        if(e.getSource() == delButton) {
            result =0;
            textField.setText("");
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
            }
        if(e.getSource()==addIButton) {
            num1 = Double.parseDouble(textField.getText());
            int n = (int) num1;
            result += heap[n];
//            operator ='-';
            textField.setText("");
        }
        if(e.getSource()==mulIButton) {
            num1 = Double.parseDouble(textField.getText());
            int n = (int) num1;
            result *= heap[n];
//            operator ='-';
            textField.setText("");
        }
        if(e.getSource()==subIbutton) {
            num1 = Double.parseDouble(textField.getText());
            int n = (int) num1;
            result -= heap[n];
//            operator ='-';
            textField.setText("");
        }
        if(e.getSource()==divIbutton) {
            num1 = Double.parseDouble(textField.getText());
            int n = (int) num1;
            result /= heap[n];
//            operator ='-';
            textField.setText("");
        }
        if(e.getSource()==storeButton){
            num1 = Double.parseDouble(textField.getText());
            int n = (int) num1;
            heap[n] = result;
            textField.setText("");
        }
        if(e.getSource() == loadButton){
            num1 = Double.parseDouble(textField.getText());
            int n = (int) num1;
            result = heap[n];
            textField.setText("");
        }
        if(e.getSource() == stateButton){
            textField.setText("heap[1]] = " + heap[1] + " heap[2]] = " + heap[2] + " heap[3] = " + heap[3]+ " heap[4] = " + heap[4]+ " heap[5] = " + heap[5]);
        }


    }
}
