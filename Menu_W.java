/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Menu_W extends JFrame {
   
    JLabel icon;
    JPanel p1;
    JPanel p2;
    JMenuBar menubar;
    JMenu accountmenu;
    JMenu subsmenu;
    JMenu classmenu;
    JMenuItem Exit;
    JMenuItem editaccount;
    JMenuItem about;
    JRadioButtonMenuItem Gold;
    JRadioButtonMenuItem Silver;
    JRadioButtonMenuItem Bronze;
    JCheckBoxMenuItem Boxing;
    JCheckBoxMenuItem Swimming;
    JCheckBoxMenuItem HITcardio;
    JButton next;
    double totalAmount=0.0;
   
   
    public Menu_W(){
        setTitle("Main Menu");
       
        icon=new JLabel("Welcome To Fitness Time");
        icon.setFont(new Font("Serif",Font.ITALIC,28));
        ImageIcon s = new ImageIcon("gym3.JPG");
        icon.setIcon(s);
       
        next=new JButton("");
        next.addActionListener(new subsListener());
        ImageIcon n = new ImageIcon("arrow.PNG");
        next.setIcon(n);
        next.setBackground(Color.WHITE);
       
        setLayout(new FlowLayout());
        p1=new JPanel();
        p2=new JPanel();
  
        p1.add(icon);
        p2.add(next);
        add(p1);
        add(p2);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        buildMenubar();
        
        setSize(610,400);
        setVisible(true);
       
       
    }
   
    public Menu_W(String name,String email){
        setTitle("Main Menu");
       
        icon=new JLabel("Welcome To Fitness Time");
        icon.setFont(new Font("Serif",Font.ITALIC,28));
        ImageIcon s = new ImageIcon("gym3.JPG");
        icon.setIcon(s);
       
        next=new JButton("");
        next.addActionListener(new subsListener());
        ImageIcon n = new ImageIcon("arrow.PNG");
        next.setIcon(n);
        next.setBackground(Color.WHITE);
       
        setLayout(new FlowLayout());
        p1=new JPanel();
        p2=new JPanel();
  
        p1.add(icon);
        p2.add(next);
        add(p1);
        add(p2);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        buildMenubar();
        
        setSize(610,400);
        setLocationRelativeTo(null);
        setVisible(true);
       
    }

    private void buildMenubar() {
        menubar=new JMenuBar();
       
        buildAccountMenu();
        buildSubsMenu();
        buildClassMenu();
       
        menubar.add(accountmenu);
        menubar.add(subsmenu);
        menubar.add(classmenu);
        setJMenuBar(menubar);
         
    }

    private void buildAccountMenu() {
       
        accountmenu=new JMenu("");
        ImageIcon s = new ImageIcon("user.PNG");
        accountmenu.setIcon(s);
        accountmenu.setToolTipText("Account");
        accountmenu.setMnemonic(KeyEvent.VK_A);
       
        editaccount=new JMenuItem("Edit");
        editaccount.setMnemonic(KeyEvent.VK_D);
        editaccount.addActionListener(new editListener());
       
        Exit=new JMenuItem("Exit");
        Exit.setMnemonic(KeyEvent.VK_E);
        Exit.addActionListener(new exitListener());
       
        accountmenu.add(editaccount);
        accountmenu.add(Exit);
    }

private void buildSubsMenu() {
       
        subsmenu=new JMenu("");
        subsmenu.setMnemonic(KeyEvent.VK_T);
        ImageIcon s = new ImageIcon("subscription.PNG");
        subsmenu.setIcon(s);
        subsmenu.setToolTipText("Subscription");
        ButtonGroup group=new ButtonGroup();
       
        Gold=new JRadioButtonMenuItem("Gold");
        Gold.setMnemonic(KeyEvent.VK_G);
       
        Silver=new JRadioButtonMenuItem("Silver");
        Silver.setMnemonic(KeyEvent.VK_S);
       
        Bronze=new JRadioButtonMenuItem("Bronze");
        Bronze.setMnemonic(KeyEvent.VK_B);
       
        about=new JMenuItem("About");
        about.setMnemonic(KeyEvent.VK_I);
       
        about.addActionListener(new AboutListener());
       
        group.add(Gold);
        group.add(Silver);
        group.add(Bronze);
       
        subsmenu.add(Gold);
        subsmenu.add(Silver);
        subsmenu.add(Bronze);
        subsmenu.addSeparator();
        subsmenu.add(about);
       
    }

    private void buildClassMenu() {
       
        classmenu=new JMenu("");
        ImageIcon s = new ImageIcon("workout1.PNG");
        classmenu.setIcon(s);
        classmenu.setToolTipText("Classes");
        classmenu.setMnemonic(KeyEvent.VK_C);
       
        Boxing=new JCheckBoxMenuItem("Boxing");
        Boxing.setMnemonic(KeyEvent.VK_X);
       
        Swimming=new JCheckBoxMenuItem("Swimming");
        Swimming.setMnemonic(KeyEvent.VK_W);
       
        HITcardio=new JCheckBoxMenuItem("HITcardio");
        HITcardio.setMnemonic(KeyEvent.VK_H);
       
        classmenu.add(Boxing);
        classmenu.add(Swimming);
        classmenu.add(HITcardio);
       
    }
   
    private static class AboutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"      Subscribtion Information"
            + "\n\nGold   4000$\n\nOffer personal trainer\nCardio section\nSwimming pool\nFree classes for a year\nUnlimited InBody tests"
            +"\n\nSilver   2800$\n\nFree consulation\nCardio section\nSwimming pool\nFree classes for 6 months\n5 InBody tests each month"
            +"\n\nBronze   1200$\n\nFree consulation\nCardio section\nFree classes for a month\n2 InBody tests each month"
            +"\n\nClasses Information"+"\nBoxing   150$"+"\nSwimming   50$"+"\nHITcardio   180$");
           
        }
    }

    private class exitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class subsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            totalAmount();
             W_Payment y=new W_Payment(totalAmount);
                              y.setVisible(true);
                              setVisible(false);
            }
             
        }
   

     private class editListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          W1_Signin t=new W1_Signin();
          t.setVisible(true);
          dispose();
        }
     }
    
     public double totalAmount(){
        
        
        
                // Handle radio button events
                if (Gold.isSelected()) {
                    totalAmount += 4000; // Adjust the amount as needed
                   
                } else if (Silver.isSelected()) {
                    totalAmount += 2800; // Adjust the amount as needed
                   
                } else if (Bronze.isSelected()) {
                    totalAmount += 1200; // Adjust the amount as needed
                   
                }

                // Handle check box events
                if (Boxing.isSelected()) {
                    totalAmount += 150; // Adjust the amount as needed
                   
                } else if (Swimming.isSelected()) {
                    totalAmount += 50; // Adjust the amount as needed
                   
                } else if (HITcardio.isSelected()) {
                    totalAmount += 180; // Adjust the amount as needed
                   
                }
               
         return totalAmount;
     }
    
}