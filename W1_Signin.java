
package project;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

public class W1_Signin extends JFrame {
    private JPanel panel1; 
    private JPanel panel2; 
    private JPanel panel3; 
    private JPanel panel4; 
    private JPanel panel5; 
    private JPanel panel6; 
    private JPanel panel7; 
    private JPanel panel8;
    private JPanel panel9;
    private JPanel panel10;
    private JPanel panel11;
   
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JLabel birthLabel;
    private JLabel genderLabel;
    private JLabel femaleImage;
    private JLabel maleImage;
    private JLabel citiesLabel;
    private JLabel errorLabel;
   
    private JLabel imageLabel; 
    
    private JTextField nameTextField; 
    private String name;
    private JTextField phoneTextField; 
    private JTextField emailTextField; 
    
    private JPasswordField passwordField; 
    
    private JRadioButton femaleButton;
    private JRadioButton maleButton; 
    private ButtonGroup group;
    
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JComboBox cityBox;
    
    private String[] day={"1","2","3","4","5","6","7","8","9","10","11","12",
                          "13","14","15","16","17","18","19","20","21","22","23"
                          ,"24","25","26","27","28","29","30","31"};
    
    private String[] month={"1","2","3","4","5","6","7","8","9","10","11","12"};
    
    private String[] year={"2008","2007","2006","2005","2004","2003","2002",
                          "2001","2000","1999","1998","1997","1996","1995","1994",
                          "1993","1992","1991","1990"};
    
    private String[]Cities={"Jeddah","Riyadh","Abha","Mekkah"};
    
    private JButton nextButton;
    
    public W1_Signin (){
        setTitle("Sign in"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        setLayout(new BorderLayout());

        panel1=new JPanel(); 
        panel2=new JPanel(); 
        panel3=new JPanel(); 
        panel4=new JPanel(); 
        panel5=new JPanel();
        panel6=new JPanel();
        panel7=new JPanel();
        panel8=new JPanel(); 
        panel9=new JPanel(); 
        panel10=new JPanel(); 
        panel11=new JPanel(); 
        
        
        panel9. setLayout(new GridLayout(9,1)); 
       
        nameLabel=new JLabel("Name :"); 
        birthLabel=new JLabel("Birthday :"); 
        phoneLabel=new JLabel("Phone number :"); 
        emailLabel=new JLabel("Email :"); 
        passwordLabel=new JLabel("Password :"); 
        genderLabel=new JLabel("Select Your Gender :"); 
        citiesLabel=new JLabel("Choose City :"); 
        errorLabel=new JLabel();
        imageLabel=new JLabel();
        
        ImageIcon image = new ImageIcon("gymc.JPG"); 
        imageLabel.setIcon(image);
         
        nameTextField=new JTextField(10); 
        phoneTextField=new JTextField(10); 
        emailTextField=new JTextField(15); 
        
        passwordField=new JPasswordField(10); 
        
        femaleButton=new JRadioButton("");
        maleButton=new JRadioButton("");
        
        group=new ButtonGroup();
        group.add(femaleButton);
        group.add(maleButton);
        
        ImageIcon Fimage = new ImageIcon("woman.PNG"); 
        ImageIcon Mimage = new ImageIcon("man.PNG"); 
        
        
        femaleImage = new JLabel(Fimage);
        maleImage = new JLabel(Mimage);
       
        
        dayComboBox= new JComboBox(day);
        monthComboBox= new JComboBox(month);
        yearComboBox= new JComboBox(year);
        cityBox= new JComboBox(Cities);
        
        ImageIcon nextImage = new ImageIcon("next.PNG"); 
        nextButton=new JButton(""); 
        nextButton.setIcon(nextImage);
        nextButton.setBackground(Color.WHITE);
        nextButton.addActionListener(new nextButtonListener());
       
       nameLabel.setFont(new Font("Serif",Font.PLAIN,15));
       birthLabel.setFont(new Font("Serif",Font.PLAIN,15));
       genderLabel.setFont(new Font("Serif",Font.PLAIN,15));
       phoneLabel.setFont(new Font("Serif",Font.PLAIN,15));
       citiesLabel.setFont(new Font("Serif",Font.PLAIN,15));
       emailLabel.setFont(new Font("Serif",Font.PLAIN,15));
       passwordLabel.setFont(new Font("Serif",Font.PLAIN,15));
       errorLabel.setFont(new Font("Serif",Font.PLAIN,15));
       
       errorLabel.setForeground(Color.red);
       
        panel1.add(nameLabel);  
        panel1.add(nameTextField);
        panel2.add(birthLabel);
        panel2.add(dayComboBox);
        panel2.add(monthComboBox);
        panel2.add(yearComboBox);
        panel3.add(phoneLabel); 
        panel3.add(phoneTextField); 
        panel4.add(emailLabel); 
        panel4.add(emailTextField); 
        panel5.add(passwordLabel); 
        panel5.add(passwordField); 
        panel6.add(errorLabel);
        panel6.add(nextButton);
        panel7.add(genderLabel);
        panel7.add(femaleButton);
        panel7.add(femaleImage);
        panel7.add(maleButton);
        panel7.add(maleImage);
        panel8.add(citiesLabel);
        panel8.add(cityBox);
        panel10.add(imageLabel);
        
        
        panel9.add(panel1);
        panel9.add(panel2);
        panel9.add(panel7);
        panel9.add(panel3);
        panel9.add(panel8);
        panel9.add(panel4);
        panel9.add(panel5);
        panel9.add(panel6);
        
        
        add(panel9,BorderLayout.EAST);
        add(panel10,BorderLayout.WEST);

       
        setSize(450, 650);
        setLocationRelativeTo(null); 
        setVisible(true);
         
     }
    private class nextButtonListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e) {
            Validation();
            
           }
    }
    public String customerInformation()
    {
        int indexday=dayComboBox.getSelectedIndex();
        String selectedDay=day[indexday];
        int indexmonth=monthComboBox.getSelectedIndex();
        String selectedMonth=month[indexmonth];
        int indexyear=yearComboBox.getSelectedIndex();
        String selectedYear=year[indexyear];
        int indexcity=cityBox.getSelectedIndex();
        String selectedCity=Cities[indexcity];
        String selectedGender="";
        if(femaleButton.isSelected()){
             selectedGender="Female";
        }else if(maleButton.isSelected()){
           selectedGender="Male";
        }
        String txt,Birthday;
        Birthday=selectedDay+"/"+selectedMonth+"/"+selectedYear;
         txt=nameTextField.getText()+" "+Birthday
             +" "+selectedGender+" "+phoneTextField.getText()+" "+selectedCity
             +" "+emailTextField.getText()+" "+passwordField.getText();
        return txt;
    }
    
    public void Validation(){
        String user_name=nameTextField.getText();
        String user_phone=phoneTextField.getText();
        String user_email=emailTextField.getText();
        String user_password=passwordField.getText();
        
        

        if(user_name.isEmpty()){
        errorLabel.setText("Please enter your name! ");
        }else if(!(femaleButton.isSelected())&&!(maleButton.isSelected())){
        errorLabel.setText("Please select your  gender! ");
        }else if(user_phone.isEmpty()){
        errorLabel.setText("Please enter your  phone number! ");
        }else if(user_phone.length()!=10 || !(user_phone.contains("05"))){
        errorLabel.setText("Invalid phone number! ");
        }else if(user_email.isEmpty()){
        errorLabel.setText("Please enter your  email! ");
        }else if(!(user_email.contains("@"))){
        errorLabel.setText("Invalid  email! ");
        }else if(user_password.isEmpty()){
        errorLabel.setText("Please enter your  password! ");
        }else{
             File file=new File ("output.txt");
            
            try {
                
                String x=phoneTextField.getText();
                int y=Integer.parseInt(x);
                
                
                
                FileWriter write=new FileWriter(file,true);
                PrintWriter outputFile=new PrintWriter(write);
                outputFile.println(customerInformation());
                JOptionPane.showMessageDialog(null, "customers have"
                                                +" been registerd successfully!");
                write.close();
                
                Menu_W menu=new Menu_W();
                menu.setLocationRelativeTo(null);
                menu.setVisible(true);
                setVisible(false);
              
            }catch(NumberFormatException e){
                errorLabel.setText("Phone number is not valid!");
                   
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "File not found!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error in file!");
                }
        }
    }
    public static void main(String[] args) { 
        new W1_Signin(); 
   }
}
