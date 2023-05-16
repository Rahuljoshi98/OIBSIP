package org.AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class DepositAccount extends JFrame implements ActionListener {
    JTextField amountTextField;
    JButton depositButton,backButton;
    String pin;
    DepositAccount(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon iconImage = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
        Image i2 = iconImage.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,700);
        add(i4);

        JLabel amount = new JLabel("Enter Amount You Want to Deposit : ");
        amount.setBounds(185,80,450,70);
        amount.setFont(new Font("Raleway",Font.BOLD,25));
        amount.setForeground(Color.black);
        i4.add(amount);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway",Font.BOLD,20));
        amountTextField.setBounds(200,180,400,50);
        i4.add(amountTextField);

        depositButton = new JButton("Deposit");
        depositButton.setBounds(500,280,150,50);
        depositButton.setFont(new Font("Raleway",Font.BOLD,20));
        i4.add(depositButton);
        depositButton.addActionListener(this);


        backButton = new JButton("Back");
        backButton.setFont(new Font("Raleway",Font.BOLD,20));
        backButton.setBounds(500,380,150,50);
        i4.add(backButton);
        backButton.addActionListener(this);



        setSize(800,700);
        setLocation(260,0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == depositButton){
              String amount = amountTextField.getText();
              Date date = new Date();       //to check the date in which we deposit the amount
            try {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    CreateConn conn = new CreateConn();
                    String query = "insert into transaction values ('" + pin + "','" + date + "','Deposit','" + amount + "')";
                    conn.st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
              catch (Exception e){
                  System.out.println(e);
              }
        }

        else if(ae.getSource() == backButton){
               setVisible(false);
               new Transactions(pin).setVisible(true);

        }
    }
    public static void main(String[] args) {
        new DepositAccount("");
    }
}
