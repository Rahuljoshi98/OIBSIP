package org.AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton exitButton,balanceEnquiryButton,depositButton,cashWithDrawlButton,fastWithDrawlButton,accMiniStatementButton,pinChangeButton;
    String transactionPin;
    Transactions(String transactionPin){
        this.transactionPin=transactionPin;
        setLayout(null);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
        Image i2 = image.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,700);
        add(i4);


        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(200,70,400,50);
        text.setFont(new Font("Raleway",Font.BOLD,25));
        text.setForeground(Color.black);
        i4.add(text);


        depositButton = new JButton("Deposit");
        depositButton.setBounds(90,200,150,30);
        depositButton.setFont(new Font("Raleway",Font.BOLD,20));
        depositButton.setBackground(Color.LIGHT_GRAY);
        depositButton.setForeground(Color.black);
        i4.add(depositButton);

        depositButton.addActionListener(this);


        cashWithDrawlButton = new JButton("Cash Withdrawl");
        cashWithDrawlButton.setBounds(510,200,200,30);
        cashWithDrawlButton.setFont(new Font("Raleway",Font.BOLD,20));
        cashWithDrawlButton.setBackground(Color.LIGHT_GRAY);
        cashWithDrawlButton.setForeground(Color.black);
        i4.add(cashWithDrawlButton);

        cashWithDrawlButton.addActionListener(this);


        fastWithDrawlButton = new JButton("Fast Cash");
        fastWithDrawlButton.setBounds(90,300,150,30);
        fastWithDrawlButton.setFont(new Font("Raleway",Font.BOLD,20));
        fastWithDrawlButton.setBackground(Color.LIGHT_GRAY);
        fastWithDrawlButton.setForeground(Color.black);
        i4.add(fastWithDrawlButton);

        fastWithDrawlButton.addActionListener(this);


        accMiniStatementButton = new JButton("Mini Statement");
        accMiniStatementButton.setBounds(510,300,200,30);
        accMiniStatementButton.setFont(new Font("Raleway",Font.BOLD,20));
        accMiniStatementButton.setBackground(Color.LIGHT_GRAY);
        accMiniStatementButton.setForeground(Color.black);
        i4.add(accMiniStatementButton);

        accMiniStatementButton.addActionListener(this);


        pinChangeButton = new JButton("Pin Change");
        pinChangeButton.setBounds(90,400,150,30);
        pinChangeButton.setFont(new Font("Raleway",Font.BOLD,20));
        pinChangeButton.setBackground(Color.LIGHT_GRAY);
        pinChangeButton.setForeground(Color.black);
        i4.add(pinChangeButton);

        pinChangeButton.addActionListener(this);


        balanceEnquiryButton = new JButton("Balance Enquiry");
        balanceEnquiryButton.setBounds(510,400,200,30);
        balanceEnquiryButton.setFont(new Font("Raleway",Font.BOLD,20));
        balanceEnquiryButton.setBackground(Color.LIGHT_GRAY);
        balanceEnquiryButton.setForeground(Color.black);
        i4.add(balanceEnquiryButton);

        balanceEnquiryButton.addActionListener(this);


        exitButton = new JButton("Exit");
        exitButton.setBounds(560,500,100,30);
        exitButton.setFont(new Font("Raleway",Font.BOLD,20));
        exitButton.setBackground(Color.LIGHT_GRAY);
        exitButton.setForeground(Color.black);
        i4.add(exitButton);

        exitButton.addActionListener(this);

        JLabel bottom = new JLabel("Welcome to the BOB World");
        bottom.setBounds(230,580,400,50);
        bottom.setFont(new Font("Raleway",Font.BOLD,25));
        bottom.setForeground(Color.black);
        i4.add(bottom);




        setSize(800,700);
        setLocation(260,0);
        setUndecorated(true);
        setVisible(true);
        getContentPane().setBackground(Color.PINK);




    }


    public void actionPerformed(ActionEvent actione){
           if(actione.getSource()==exitButton){
               System.exit(0);
           }
           else if(actione.getSource() == depositButton){
               setVisible(false);
               new DepositAccount(transactionPin).setVisible(true);
           }
           else if(actione.getSource() == cashWithDrawlButton){
               setVisible(false);
               new CashWithdrawl(transactionPin).setVisible(true);
           }
           else if(actione.getSource() == fastWithDrawlButton){
               setVisible(false);
               new FastCash(transactionPin).setVisible(true);
           }
           else if(actione.getSource() == pinChangeButton){
               setVisible(false);
               new ChangePin(transactionPin).setVisible(true);
           }
           else if(actione.getSource()==balanceEnquiryButton){
               setVisible(false);
               new BalanceEnquiry(transactionPin).setVisible(true);
           }
    }

    public static void main(String[] args) {
        new Transactions("");

    }

}
