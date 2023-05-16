package org.AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin extends JFrame implements ActionListener {
    JPasswordField newPinTextField,reEnterPinTextField;
    JButton next,back;
    String pin;
    ChangePin(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
        Image i1 = i.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,800,700);
        add(image);


        JLabel heading = new JLabel("Change Your PIN");
        heading.setBounds(250,70,400,50);
        heading.setFont(new Font("Raleway",Font.BOLD,30));
        heading.setForeground(Color.black);
        image.add(heading);


        JLabel newPinLabel = new JLabel("Enter New PIN : ");
        newPinLabel.setBounds(85,180,200,40);
        newPinLabel.setFont(new Font("Raleway",Font.BOLD,22));
        newPinLabel.setForeground(Color.black);
        image.add(newPinLabel);

        newPinTextField = new JPasswordField();
        newPinTextField.setBounds(380,180,300,40);
        newPinTextField.setBackground(Color.white);
        newPinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(newPinTextField);



        JLabel reEnterPinLabel = new JLabel("Re-Enter New PIN : ");
        reEnterPinLabel.setBounds(85,266,220,40);
        reEnterPinLabel.setFont(new Font("Raleway",Font.BOLD,22));
        reEnterPinLabel.setForeground(Color.black);
        image.add(reEnterPinLabel);

        reEnterPinTextField = new JPasswordField();
        reEnterPinTextField.setBounds(380,266,300,40);
        reEnterPinTextField.setBackground(Color.white);
        reEnterPinTextField.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(reEnterPinTextField);



        next = new JButton("Change");
        next.setBounds(560,366,120,40);
        next.setFont(new Font("Raleway",Font.BOLD,22));
        next.setForeground(Color.black);
        next.setBackground(Color.white);
        image.add(next);
        next.addActionListener(this);


        back = new JButton("Back");
        back.setBounds(560,446,120,40);
        back.setFont(new Font("Raleway",Font.BOLD,22));
        back.setForeground(Color.black);
        back.setBackground(Color.white);
        image.add(back);
        back.addActionListener(this);



        setSize(800,700);
        setLocation(260,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent acEvent){

           if(acEvent.getSource()==next){
               try {
                   String newPin = newPinTextField.getText();
                   String reEnterNewPin = reEnterPinTextField.getText();
                   if(newPin.equals("")){
                       JOptionPane.showMessageDialog(null,"Please enter your new pin");
                       return;
                   }
                   else if(reEnterNewPin.equals("")){
                       JOptionPane.showMessageDialog(null,"please Re-Enter new pin");
                       return;
                   }
                   else if (!newPin.equals(reEnterNewPin)) {
                       JOptionPane.showMessageDialog(null, "New PIN and ReEntered PIN are not same");
                       return;
                   }
                   else{
                       CreateConn connection = new CreateConn();
                       String query1 = "update login set pin = '"+newPin+"' where pin ='"+pin+"'";
                       String query2 = "update transaction set pin = '"+newPin+"' where pin = '"+pin+"'";
                       String query3 = "update signupthree set pin_no = '"+newPin+"' where pin_no = '"+pin+"'";
                       connection.st.executeUpdate(query1);
                       connection.st.executeUpdate(query2);
                       connection.st.executeUpdate(query3);
                       JOptionPane.showMessageDialog(null,"PIN changed successfully");
                       setVisible(false);
                       new Transactions(newPin).setVisible(true);
                   }
               }
               catch (Exception e){
                   System.out.println(e);
               }
           }
           else if(acEvent.getSource()==back){
                   setVisible(false);
                   new Transactions(pin).setVisible(true);
           }


    }


    public static void main(String[] args) {
        new ChangePin("").setVisible(true);
    }
}
