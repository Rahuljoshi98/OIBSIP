package org.AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CashWithdrawl extends JFrame implements ActionListener {
    JTextField amountTextField;
    JButton cashWithdrawlButton,backButton;
    String pin;
    CashWithdrawl(String pin){
        this.pin = pin;
        setLayout(null);

        ImageIcon iconImage = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
        Image i2 = iconImage.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,700);
        add(i4);

        JLabel amount = new JLabel("Enter Amount You Want to Withdraw : ");
        amount.setBounds(185,80,500,70);
        amount.setFont(new Font("Raleway",Font.BOLD,25));
        amount.setForeground(Color.black);
        i4.add(amount);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway",Font.BOLD,20));
        amountTextField.setBounds(200,180,400,50);
        i4.add(amountTextField);

        cashWithdrawlButton = new JButton("Withdraw");
        cashWithdrawlButton.setBounds(500,280,150,50);
        cashWithdrawlButton.setFont(new Font("Raleway",Font.BOLD,20));
        i4.add(cashWithdrawlButton);
        cashWithdrawlButton.addActionListener(this);


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
        if(ae.getSource() == cashWithdrawlButton){
            String amount = amountTextField.getText();
            Date date = new Date();       //to check the date in which we deposit the amount
            int balance = 0;
            int a = Integer.parseInt(amount);

            try {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
                } else {
                    CreateConn conn = new CreateConn();

                    ResultSet r = conn.st.executeQuery("select * from transaction where pin ='" + pin + "'");
                    while (r.next()) {
                        if (r.getString("type_of_transaction").equals("Deposit")) {
                            balance += Integer.parseInt(r.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(r.getString("amount"));
                        }
                    }
                    if(a<=0){
                        JOptionPane.showMessageDialog(null,"Please enter valid amount");
                        return;
                    }
                    if( a>balance ) {
                         JOptionPane.showMessageDialog(null,"Insufficient Balance");
                         setVisible(false);
                         new Transactions(pin).setVisible(true);
                    }
                    else {
                        String query = "insert into transaction values ('" + pin + "','" + date + "','Withdrawl','" + amount + "')";
                        conn.st.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdraw Successfully");
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }
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
        new CashWithdrawl("");
    }
}
