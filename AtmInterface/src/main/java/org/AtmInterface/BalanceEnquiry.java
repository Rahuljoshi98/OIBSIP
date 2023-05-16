package org.AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton backButton;
    String pin;
    BalanceEnquiry(String pin){
        this.pin=pin;
        setLayout(null);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("background.jpg"));
        Image i = image.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(0,0,800,700);
        add(i3);


        backButton = new JButton("Back");
        backButton.setBounds(560,446,120,40);
        backButton.setFont(new Font("Raleway",Font.BOLD,22));
        backButton.setBackground(Color.white);
        backButton.setForeground(Color.black);
        i3.add(backButton);
        backButton.addActionListener(this);

        CreateConn connect = new CreateConn();
        int balance = 0;
        try{
            ResultSet r = connect.st.executeQuery("select * from transaction where pin ='"+pin+"'");

            while(r.next()){
                if(r.getString("type_of_transaction").equals("Deposit")){
                    balance += Integer.parseInt(r.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(r.getString("amount"));
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        JLabel balLabel = new JLabel("Your Current Account Balance is Rs : " + balance);
        balLabel.setBounds(85,150,500,40);
        balLabel.setFont(new Font("Raleway",Font.BOLD,22));
        balLabel.setForeground(Color.black);
        i3.add(balLabel);

        setSize(800,700);
        setLocation(260,0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent actEvent){
            setVisible(false);                     //this function will be called when user click on back button
            new Transactions(pin).setVisible(true);

    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
