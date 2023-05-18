package org.AtmInterface;
import javax.swing.*;
import java.awt.*;          //image class exist in awt package so we import java.awt package
import java.awt.event.*;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {

    JButton signIn,signUp,clear;       //here we define it globally to access outside the constructor
    JTextField cardNoTextField;
    JPasswordField passField;

    LoginPage(){
        setTitle("WELCOME TO THE BANK OF BARODA ATM");

        setLayout(null);                  //to ignore the default layout and create our own layout
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2 = image.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);

        i4.setBounds(50,20,100,100);     //here we use jlabel to set the image i.e., to set the boundary from the frame
        add(i4);                                          //add means to add the image in frame without jframe we cant add image in frame


       // jlabel mainly used to write content in the frame
        JLabel text1 = new JLabel("WELCOME TO THE BOB WORLD");
        add(text1);
        text1.setFont(new Font("Osward",Font.BOLD,28));
        text1.setBounds(170,20,550,50);


        JLabel text2 = new JLabel("BANK OF BARODA ATM ");
        add(text2);
        text2.setFont(new Font("Osward",Font.BOLD,28));
        text2.setBounds(170,70,400,50);


        JLabel cardno = new JLabel("CARD NO : ");
        add(cardno);
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(80,180,140,20);


        cardNoTextField = new JTextField();
        cardNoTextField.setBounds(240,182,240,25);

        cardNoTextField.setFont(new Font("Areal",Font.BOLD,13));
        add(cardNoTextField);


        JLabel password = new JLabel("PIN :");
        add(password);
        password.setFont(new Font("Raleway",Font.BOLD,20));
        password.setBounds(80,260,180,20);


        passField =  new JPasswordField();
        passField.setBounds(240,262,240,25);

        passField.setFont(new Font("Areal",Font.BOLD,13));
        add(passField);


        signIn = new JButton("SIGN IN");
        signIn.setBounds(240,320,100,30);
        add(signIn);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);     //we use addActionListener here to catch the event of the button (i.e., we will know that someone clicked the button)



        clear = new JButton("CLEAR");
        clear.setBounds(380,320,100,30);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);


        signUp = new JButton("SIGN UP");
        signUp.setBounds(310,380,100,30);
        add(signUp);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);

        getContentPane().setBackground(Color.white);      //to set the background of the frame


        setSize(710,500);      //setSize set the length and width of the frame
        setVisible(true);                  //to show the frame to user because it is default false
        setLocation(280,100);        //to set the location of the frame 350 from left and 200 from top
    }


    //this function is used to tell us what we have to do when the user click on the button (sign in,login etc) i.e., which action we have to perform
    public void actionPerformed(ActionEvent ob){        //ob is the object of ActionEvent class
           if(ob.getSource() == clear){
                  cardNoTextField.setText("");          //setText() function is used to set the value in textField
                  passField.setText("");
           }
           else if(ob.getSource() == signIn){
                   CreateConn conn = new CreateConn();
                   String cardNo = cardNoTextField.getText();
                   String pinNo = passField.getText();
                   String query = "select * from login where cardNumber = '"+cardNo+"' and pin = '"+pinNo+"' ";
                   try{
                      // conn.st.executeQuery(query);    //The above command is a  ddl command so we will use the function executeQuery rather than executeUpdate
                       ResultSet result = conn.st.executeQuery(query);  //ResultSet is a datatype which store the response of executeQuery function and ResultSet belongs to the java sql package so we have to import it

                       if(result.next()){                                //if the entered data matched then (it is extracted by using result.next())
                           setVisible(false);                           //close the current frame
                           new Transactions(pinNo).setVisible(true);    //here we are passing the pin because we need pin in next transaction
                       }
                       else{
                           JOptionPane.showMessageDialog(null,"Incorrect Card No or pin");
                       }
                   }
                   catch (Exception e){
                       System.out.println(e);
                   }
           }
           else if(ob.getSource() == signUp){
               setVisible(false);
               new SignUpFirst().setVisible(true);
           }
    }

    public static void main(String[] args) {

        new LoginPage();
    }
}
