
package project;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;


public class W_Login extends JFrame {
   
    JPasswordField password1;
    JButton login,signUp;
    JLabel iconL,signUpL,userL,passwordL,eLabel;
    JTextField Name;
    JPanel panel1,panel2,panel3,panel4,panel5;

    public W_Login(){
       
        setTitle("Login");
        setSize(600, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        buildLogin();
    
        add(panel2,BorderLayout.WEST);
        add(panel1,BorderLayout.CENTER);
        setVisible(true);
       
    }
   
    public void buildLogin(){
       
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        panel3.setLayout(new BorderLayout());
        panel4=new JPanel();
        panel5=new JPanel();
      
        iconL=new JLabel();
        ImageIcon s = new ImageIcon("gym3.JPG");
        iconL.setIcon(s);
       
        userL=new JLabel("Email: ");
        userL.setFont(new Font("Serif",Font.PLAIN,15));
       
        passwordL=new JLabel("Password: ");
        passwordL.setFont(new Font("Serif",Font.PLAIN,15));
       
        Name=new JTextField(20);
        password1=new JPasswordField(20);
       
        signUpL=new JLabel("Create new account ");
        signUpL.setFont(new Font("Serif",Font.PLAIN,15));
        signUpL.setForeground(Color.RED);
       
        signUp=new JButton();
        ImageIcon s1 = new ImageIcon("signup.PNG");
        signUp.setIcon(s1);
        signUp.setBackground(Color.WHITE);
       
        login=new JButton();
        ImageIcon s2 = new ImageIcon("login.PNG");
        login.setIcon(s2);
       
        login.addActionListener(new Menu());
        login.setBackground(Color.WHITE);
       
        eLabel=new JLabel();
        eLabel.setFont(new Font("Serif",Font.PLAIN,15));
        eLabel.setForeground(Color.red);
       
        panel1.add(userL);
        panel1.add(Name);
        panel1.add(passwordL);
        panel1.add(password1);
       
        panel2.add(iconL);
        panel4.add(signUpL);
        panel4.add(signUp);
       
        panel5.add(eLabel);
       
        panel3.add(login,BorderLayout.NORTH);
        panel3.add(panel4,BorderLayout.CENTER);
        panel3.add(panel5,BorderLayout.SOUTH);
        signUp.addActionListener(new SignUp());
        panel1.add(panel3);
       
       
      
    }
   
    private class SignUp implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          W1_Signin m=new W1_Signin();
          m.setVisible(true);
          dispose();
        }
    }
    private class Menu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
           String customerEmail;
           customerEmail=Name.getText();
            String customerPass;
            customerPass=password1.getText();
           
            if(customerEmail.isEmpty()){
                eLabel.setText("Please enter your email ");
            }
            else if(customerPass.isEmpty()){
                eLabel.setText("Please enter password ");
            }
            else{
                String name="";
                    try {
                        File x = new File("output.txt");
                        Scanner inputFile;
                        boolean f=false;
                        inputFile= new Scanner(x);
                        
                         while(inputFile.hasNext()){
                              name=inputFile.next();
                              String birthday=inputFile.next();
                              String gender=inputFile.next();
                              String phoneNmuber=inputFile.next();
                              String city=inputFile.next();
                              String email=inputFile.next();
                              //String email=Name.getText();
                              if(email.equals(customerEmail)){
                                  String pass=inputFile.next();
                                  if(pass.equals(customerPass)){
                                      f=true;
                                      break;
                                  }
                              }


                              inputFile.nextLine();
                          }

                         if(f){
                               Menu_W y=new Menu_W(name,customerEmail);
                               y.setLocationRelativeTo(null);
                              y.setVisible(true);
                              dispose();
                         } else
                             eLabel.setText("Wrong email or password");
                        
                   
            } catch (FileNotFoundException ex) {
                System.out.println("There is an error in file");
            }
                
            }
          
            
        }
    }
    public static void main(String[] args) {
       new W_Login();
    }
    }
