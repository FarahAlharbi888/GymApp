/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.*;
import javax.swing.*;

public class W4_Payment extends JFrame {
    private JPanel panel;
    private JPanel Namepanel;
    private JPanel Cardpanel;
    private JPanel Datepanel;
    private JPanel Cvvpanel;
    private JPanel RadioButtonpanel;
    private JPanel Endpanel;
    private JLabel bTitle;
    private JLabel namecard;
    private JLabel cardnumber;
    private JLabel date;
    private JLabel cvv;
    private JTextField nameText;
    private JTextField cardText;
    private JTextField cvvText;
    private JRadioButton cardButton;
    private JRadioButton tamaraButton;
    private JButton endButton;
    private JComboBox monthBox;
    private JComboBox yearBox;
    
    private String [] year={"Year","2008","2007","2006","2005","2004","2003",
    "2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990"};
    
    private String [] month={"Month","1","2","3","4","5","6","7","8","9","10","11","12"};
    
    public W4_Payment (){
        setTitle("Payment");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8,1));
        
        
        buildNamepanel();
        buildCardpanel();
        buildDatepanel();
        buildCvvpanel();
        buildpanel();
        buildRadioButtonpanel();
        buildEndpanel();
        
        add(Namepanel);
        add(Cardpanel);
        add(Datepanel);
        add(Cvvpanel);
        add(panel);
        add(RadioButtonpanel);
        add(Endpanel);
        
        pack();
        setVisible(true);
        
    }

    private void buildNamepanel() {
        Namepanel=new JPanel();
        namecard=new JLabel("Full Name");
        nameText=new JTextField(12);
        
        Namepanel.add(namecard);
        Namepanel.add(nameText);    
    }

    private void buildCardpanel() {
        Cardpanel=new JPanel();
        cardnumber=new JLabel("Card Number");
        cardText=new JTextField(10);
        
        Cardpanel.add(cardnumber);
        Cardpanel.add(cardText);   
    }

    private void buildDatepanel() {
        Datepanel=new JPanel();
        date=new JLabel("Date");
        monthBox=new JComboBox(month);
        yearBox=new JComboBox(year);
        
        Datepanel.add(date);
        Datepanel.add(monthBox);
        Datepanel.add(yearBox);
        
        
    }

    private void buildCvvpanel() {
        Cvvpanel=new JPanel();
        cvv=new JLabel("CVV");
        cvvText=new JTextField(10);
        
        Cvvpanel.add(cvv);
        Cvvpanel.add(cvvText);
    }

    private void buildpanel() {
        panel=new JPanel();
        bTitle=new JLabel("Choose payment method");
        
        panel.add(bTitle);
    }

    private void buildRadioButtonpanel() {
        RadioButtonpanel=new JPanel();
        cardButton=new JRadioButton("Credit");
        tamaraButton=new JRadioButton("Tamara");
        ButtonGroup group=new ButtonGroup();
        group.add(cardButton);
        group.add(tamaraButton);
        
        RadioButtonpanel.add(cardButton);
        RadioButtonpanel.add(tamaraButton);
    }

    private void buildEndpanel() {
        Endpanel=new JPanel();
        endButton=new JButton("END");
        
        Endpanel.add(endButton); 
    }
    
    public static void main(String args[])
        { 
            W4_Payment x = new W4_Payment();
        }
    
    
}
