package org.AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;


public class FastCash extends JFrame implements ActionListener {
    JButton fiveDepositButton,hundredDepositButton,thousandDepositButton,twoThousandDepositButton,fiveThousandDepositButton,tenThousandDepositButton,backButton;
    String transactionPin;
    FastCash(String transactionPin){
        this.transactionPin=transactionPin;
        setLayout(null);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("Background.jpg"));
        Image i2 = image.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel i4 = new JLabel(i3);
        i4.setBounds(0,0,800,700);
        add(i4);


        JLabel text = new JLabel("Select Amount You Want to Withdraw");
        text.setBounds(180,70,500,50);
        text.setFont(new Font("Raleway",Font.BOLD,25));
        text.setForeground(Color.black);
        i4.add(text);


        hundredDepositButton = new JButton("Rs 100");
        hundredDepositButton.setBounds(90,200,150,30);
        hundredDepositButton.setFont(new Font("Raleway",Font.BOLD,20));
        hundredDepositButton.setBackground(Color.LIGHT_GRAY);
        hundredDepositButton.setForeground(Color.black);
        i4.add(hundredDepositButton);

        hundredDepositButton.addActionListener(this);


        fiveDepositButton = new JButton("Rs 500");
        fiveDepositButton.setBounds(560,200,150,30);
        fiveDepositButton.setFont(new Font("Raleway",Font.BOLD,20));
        fiveDepositButton.setBackground(Color.LIGHT_GRAY);
        fiveDepositButton.setForeground(Color.black);
        i4.add(fiveDepositButton);

        fiveDepositButton.addActionListener(this);


        thousandDepositButton = new JButton("Rs 1000");
        thousandDepositButton.setBounds(90,300,150,30);
        thousandDepositButton.setFont(new Font("Raleway",Font.BOLD,20));
        thousandDepositButton.setBackground(Color.LIGHT_GRAY);
        thousandDepositButton.setForeground(Color.black);
        i4.add(thousandDepositButton);

        thousandDepositButton.addActionListener(this);


        twoThousandDepositButton = new JButton("Rs 2000");
        twoThousandDepositButton.setBounds(560,300,150,30);
        twoThousandDepositButton.setFont(new Font("Raleway",Font.BOLD,20));
        twoThousandDepositButton.setBackground(Color.LIGHT_GRAY);
        twoThousandDepositButton.setForeground(Color.black);
        i4.add(twoThousandDepositButton);

        twoThousandDepositButton.addActionListener(this);


        fiveThousandDepositButton = new JButton("Rs 5000");
        fiveThousandDepositButton.setBounds(90,400,150,30);
        fiveThousandDepositButton.setFont(new Font("Raleway",Font.BOLD,20));
        fiveThousandDepositButton.setBackground(Color.LIGHT_GRAY);
        fiveThousandDepositButton.setForeground(Color.black);
        i4.add(fiveThousandDepositButton);

        fiveThousandDepositButton.addActionListener(this);


        tenThousandDepositButton = new JButton("Rs 10000");
        tenThousandDepositButton.setBounds(560,400,150,30);
        tenThousandDepositButton.setFont(new Font("Raleway",Font.BOLD,20));
        tenThousandDepositButton.setBackground(Color.LIGHT_GRAY);
        tenThousandDepositButton.setForeground(Color.black);
        i4.add(tenThousandDepositButton);

        tenThousandDepositButton.addActionListener(this);


        backButton = new JButton("Back");
        backButton.setBounds(560,500,150,30);
        backButton.setFont(new Font("Raleway",Font.BOLD,20));
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.black);
        i4.add(backButton);

        backButton.addActionListener(this);

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


    public void actionPerformed(ActionEvent acEvent){
        if(acEvent.getSource()==backButton){
            setVisible(false);
            new Transactions(transactionPin).setVisible(true);
        }
        else {
            String amount =((JButton)acEvent.getSource()).getText().substring(3);        //ae.getSource returns an object. So we have to typecast it into JButton and to get the text of JButton
            //we are using getText() which returns the text( rs 500) but we only require the amount which is 500 so by using substring(3) we get 500 only

            CreateConn con = new CreateConn();
            try{
                ResultSet rs = con.st.executeQuery("select * from transaction where pin = '"+transactionPin+"'");
                int balance = 0;
                while(rs.next()){        //rs.next() will give all the values of the ResultSet
                    if(rs.getString("type_Of_Transaction").equals("Deposit")){     //check the values from the database
                        balance += Integer.parseInt(rs.getString("amount"));   //Integer.parseInt is used to convert string into int values
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(acEvent.getSource() != backButton && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into transaction values('" + transactionPin + "','" + date + "','Withdrawl','" +amount+ "')";
                con.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount+" Debited Successfully");
                setVisible(false);
                new Transactions(transactionPin).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");

    }

}
