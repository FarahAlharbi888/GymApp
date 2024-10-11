/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class W_Payment extends JFrame {
    private JPanel panel;
    private JPanel Namepanel;
    private JPanel Cardpanel;
    private JPanel Datepanel;
    private JPanel Cvvpanel;
    private JPanel RadioButtonpanel;
    private JPanel Endpanel;
    private JPanel panelEast;
    private JPanel panelWest;
   
    private JLabel bTitle;
    private JLabel paymentL;
    private JLabel namecard;
    private JLabel cardnumber;
    private JLabel date;
    private JLabel cvv;
    private JLabel imageLabel;
    private JLabel errorLabel;
   
    private JTextField nameText;
    private JTextField cardText;
    private JPasswordField cvvField;
   
    private JRadioButton cardButton;
    private JRadioButton tamaraButton;
    private ButtonGroup group;
   
    private JButton endButton;
   
    private JComboBox monthBox;
    private JComboBox yearBox;
   
    private String [] year={"27","26","25","24","23","22", "21","20",
                            "19","18","17","16","15"};
    private String [] month={"1","2","3","4","5","6","7","8","9","10",
                             "11","12"};
   
    public W_Payment (double amount){
        setTitle("Payment");
        paymentL=new JLabel("Your total amount is "+amount);
        paymentL.setFont(new Font("Serif",Font.PLAIN,15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        setLayout(new BorderLayout());
        buildNamepanel();
        buildCardpanel();
        buildDatepanel();
        buildCvvpanel();
        buildpanel();
        buildRadioButtonpanel();
        buildEndpanel();
        panelEast=new JPanel();
        panelWest=new JPanel();
        panelEast.setLayout(new GridLayout(9,1));
       
      
       
        imageLabel=new JLabel();
        ImageIcon image = new ImageIcon("gymc.JPG");
        imageLabel.setIcon(image);
        panelWest.add(imageLabel);
       
        panelEast.add(paymentL);
        panelEast.add(Namepanel);
        panelEast.add(Cardpanel);
        panelEast.add(Datepanel);
        panelEast.add(Cvvpanel);
        panelEast.add(panel);
        panelEast.add(RadioButtonpanel);
        panelEast.add(Endpanel);

        add(panelEast,BorderLayout.EAST);
        add(panelWest,BorderLayout.WEST);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void buildNamepanel() {
        Namepanel=new JPanel();
        namecard=new JLabel("Full Name");
        namecard.setFont(new Font("Serif",Font.PLAIN,15));
        nameText=new JTextField(12);
        Namepanel.add(namecard);    
        Namepanel.add(nameText);
    }
    private void buildCardpanel() {
        Cardpanel=new JPanel();
        cardnumber=new JLabel("Card Number");
        cardnumber.setFont(new Font("Serif",Font.PLAIN,15));
        cardText=new JTextField(13);
        Cardpanel.add(cardnumber);
        Cardpanel.add(cardText);
    }
    private void buildDatepanel() {
        Datepanel=new JPanel();
        date=new JLabel("Date");
        date.setFont(new Font("Serif",Font.PLAIN,15));
        monthBox=new JComboBox(month);
        yearBox=new JComboBox(year);
        Datepanel.add(date);
        Datepanel.add(monthBox);
        Datepanel.add(yearBox);
    }
    private void buildCvvpanel() {
        Cvvpanel=new JPanel();
        cvv=new JLabel("CVV");
        cvv.setFont(new Font("Serif",Font.PLAIN,15));
        cvvField=new JPasswordField(10);
        Cvvpanel.add(cvv);
        Cvvpanel.add(cvvField);
    }
    private void buildpanel() {
        panel=new JPanel();
        bTitle=new JLabel("Choose payment method");
        bTitle.setFont(new Font("Serif",Font.PLAIN,15));
        panel.add(bTitle);
    }
    private void buildRadioButtonpanel() {
        RadioButtonpanel=new JPanel();
        cardButton=new JRadioButton("Credit");
        tamaraButton=new JRadioButton("Tamara");
        cardButton.setFont(new Font("Serif",Font.PLAIN,15));
        tamaraButton.setFont(new Font("Serif",Font.PLAIN,15));
        group=new ButtonGroup();
        group.add(cardButton);
        group.add(tamaraButton);
        RadioButtonpanel.add(cardButton);
        RadioButtonpanel.add(tamaraButton);
    }
    private void buildEndpanel() {
        Endpanel=new JPanel();
        endButton=new JButton("END");
        endButton.setBackground(Color.WHITE);
        errorLabel=new JLabel();
        errorLabel.setFont(new Font("Serif",Font.PLAIN,15));
        errorLabel.setForeground(Color.red);
       
        endButton.addActionListener(new endListener());
        Endpanel.add(errorLabel);
        Endpanel.add(endButton);
    }
  
  
    private class endListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            Validation();
            
        }
    }
   
    public void Validation(){
        String card_name=nameText.getText();
        String card_number=cardText.getText();
        String card_cvv=cvvField.getText();
       
        if(card_name.isEmpty()){
        errorLabel.setText("Please enter name in card! ");
        }else if(card_number.isEmpty()){
        errorLabel.setText("Please enter card number! ");
        }else if(card_number.length()!=16){
        errorLabel.setText("Invalid card number! ");
        }else if(card_cvv.isEmpty()){
        errorLabel.setText("Please enter CVV! ");
        }else if(card_cvv.length()!=3){
        errorLabel.setText("Invalid CVV! ");
        }else if(!(cardButton.isSelected())&&!(tamaraButton.isSelected())){
        errorLabel.setText("Please choose payment method! ");
        }else{
           
           try{
                String a=cvvField.getText();
                int b=Integer.parseInt(a);
               
                } catch(NumberFormatException ex) {
                errorLabel.setText("CVV is not valid!");
                }
                if(card_number.length()==16){
                 try {

                     String x=cardText.getText();
                     double y=Double.parseDouble(x);

                    try{
                    File openfile = new File("output.txt");
                    String name,birthday,gender,phoneNmuber,city,email,pass,txt = "";
                 
                    Scanner scanfile = new Scanner(openfile);
                     
                    while(scanfile.hasNext())
                    {
                        name=scanfile.next();
                        birthday=scanfile.next();
                        gender=scanfile.next();
                        phoneNmuber=scanfile.next();
                        city=scanfile.next();
                        email=scanfile.next();
                        pass=scanfile.next();
                        txt=String.format("---Customer information---\n"+"Name: %s\n"
                                +"Birthday: %s\n"+"Gender: %s\n"+"Phone number: %s\n"
                                +"City: %s\n"+"Email: %s\n"+"Password: %s\n"
                                , name,birthday,gender,phoneNmuber,
                                city,email,pass);
                    }
                    JOptionPane.showMessageDialog(null, txt);
                    System.exit(0);
                    }catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "File not found!");
                     }
                    }catch(NumberFormatException e){
                     errorLabel.setText("card number is not valid!");
                  
                    }
                 }
          
        }
    }
       
}
 

