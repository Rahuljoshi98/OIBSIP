package org.AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThird extends JFrame implements ActionListener {
    JRadioButton accTypeRadioSaving,accTypeRadioCurrent,accTypeRadioFix,accTypeRadioRec;
    JCheckBox atmCheckbox,internetCheckbox,mobileCheckbox,emailCheckbox,chequeCheckbox,eStatementCheckbox,declarationCheckbox;
    JButton submit,cancel;
    String formNo;
    SignUpThird(String formNo){
        this.formNo=formNo;

        setLayout(null);
        JLabel last = new JLabel("Page 3 : Account Details");
        last.setFont(new Font("Raleway",Font.BOLD,18));
        last.setBounds(278,70,400,50);
        add(last);


        JLabel accType = new JLabel("Account Type : ");
        accType.setBounds(85,146,160,40);
        accType.setFont(new Font("Raleway",Font.BOLD,17));
        add(accType);


        accTypeRadioSaving = new JRadioButton("Saving");
        accTypeRadioSaving.setBounds(290,153,80,25);
        accTypeRadioSaving.setBackground(Color.white);
        add(accTypeRadioSaving);

        accTypeRadioCurrent = new JRadioButton("Current");
        accTypeRadioCurrent.setBounds(290,183,80,25);
        accTypeRadioCurrent.setBackground(Color.white);
        add(accTypeRadioCurrent);

        accTypeRadioFix = new JRadioButton("Fixed Deposit Account");
        accTypeRadioFix.setBackground(Color.white);
        accTypeRadioFix.setBounds(470,153,200,25);
        add(accTypeRadioFix);

        accTypeRadioRec = new JRadioButton("Recurring Deposit Account");
        accTypeRadioRec.setBackground(Color.white);
        accTypeRadioRec.setBounds(470,183,200,25);
        add(accTypeRadioRec);

        ButtonGroup buttonAcc = new ButtonGroup();
        buttonAcc.add(accTypeRadioSaving);
        buttonAcc.add(accTypeRadioCurrent);
        buttonAcc.add(accTypeRadioFix);
        buttonAcc.add(accTypeRadioRec);



        JLabel cardNo = new JLabel("Card No : ");
        cardNo.setFont(new Font("Raleway",Font.BOLD,17));
        cardNo.setBounds(85,223,400,50);
        add(cardNo);

        JLabel cardNoLabel = new JLabel("XXXX-XXXX-XXXX-1487");
        cardNoLabel.setBounds(295,223,400,50);
        cardNoLabel.setFont(new Font("Raleway",Font.BOLD,17));
        add(cardNoLabel);

        JLabel cardInfo = new JLabel("(your 16 digit card no)");
        cardInfo.setBounds(85,260,400,20);
        cardInfo.setFont(new Font("Raleway",Font.BOLD,12));
        add(cardInfo);


        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("Raleway",Font.BOLD,17));
        pin.setBounds(85,283,400,50);
        add(pin);

        JLabel pinNoLabel = new JLabel("XXXX");
        pinNoLabel.setBounds(295,283,400,50);
        pinNoLabel.setFont(new Font("Raleway",Font.BOLD,17));
        add(pinNoLabel);

        JLabel pinInfo = new JLabel("(your 4 digit pin)");
        pinInfo.setBounds(85,317,400,20);
        pinInfo.setFont(new Font("Raleway",Font.BOLD,12));
        add(pinInfo);



        JLabel serviceOpt = new JLabel("Services Required : ");
        serviceOpt.setBounds(85,343,400,50);
        serviceOpt.setFont(new Font("Raleway",Font.BOLD,17));
        add(serviceOpt);

        atmCheckbox = new JCheckBox("ATM Card");
        atmCheckbox.setBackground(Color.white);
        atmCheckbox.setBounds(294,357,150,25);
        add(atmCheckbox);

        internetCheckbox = new JCheckBox("Internet Banking");
        internetCheckbox.setBackground(Color.white);
        internetCheckbox.setBounds(474,357,150,25);
        add(internetCheckbox);

        mobileCheckbox = new JCheckBox("Mobile Banking");
        mobileCheckbox.setBackground(Color.white);
        mobileCheckbox.setBounds(294,397,150,25);
        add(mobileCheckbox);

        emailCheckbox = new JCheckBox("Email & SMS Alerts");
        emailCheckbox.setBackground(Color.white);
        emailCheckbox.setBounds(474,397,150,25);
        add(emailCheckbox);

        chequeCheckbox = new JCheckBox("Cheque Book");
        chequeCheckbox.setBackground(Color.white);
        chequeCheckbox.setBounds(294,437,150,25);
        add(chequeCheckbox);

        eStatementCheckbox = new JCheckBox("E-Statement");
        eStatementCheckbox.setBackground(Color.white);
        eStatementCheckbox.setBounds(474,437,150,25);
        add(eStatementCheckbox);

        declarationCheckbox = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        declarationCheckbox.setBounds(85,497,650,25);
        declarationCheckbox.setBackground(Color.white);
        add(declarationCheckbox);

        submit = new JButton("Submit");
        submit.setBounds(300,547,90,25);
        submit.setBackground(Color.black);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setForeground(Color.white);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(440,547,80,25);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setForeground(Color.white);
        add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);


        setSize(800,660);
        setLocation(260,10);
        setVisible(true);
        setTitle("Account Details");
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent acEvent){
        if(acEvent.getSource() == submit){
               String accountType = null;
               if(accTypeRadioSaving.isSelected()){
                   accountType="Saving Account";
               }
               else if(accTypeRadioCurrent.isSelected()){
                   accountType="Current Account";
               }
               else if(accTypeRadioFix.isSelected()){
                   accountType="Fixed Deposit Account";
               }
               else if(accTypeRadioRec.isSelected()){
                   accountType="Recurring Deposit Account";
               }

               Random random = new Random();
               String userCardNo =""+ Math.abs((random.nextLong()%900000000L) +5638967200000000L );

               String userPinNo = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

               String facility = "";
               if(atmCheckbox.isSelected()){
                      facility = facility + "ATM Card";
               }
               if(internetCheckbox.isSelected()){
                   facility = facility + ", Internet Banking";
               }
               if(mobileCheckbox.isSelected()){
                   facility = facility + ", Mobile Banking";
               }
               if(emailCheckbox.isSelected()){
                   facility = facility + ", Email & SMS Alert";
               }
               if(chequeCheckbox.isSelected()){
                   facility = facility + ", Cheque Book";
               }
               if(eStatementCheckbox.isSelected()){
                   facility = facility + ", E statement";
               }

               try {

                       CreateConn connn = new CreateConn();
                       String query1 = "insert into SignUpThree values ('" + formNo + "','" + accountType + "','" + userCardNo + "','" + userPinNo + "','" + facility + "')";
                       String query2 = "insert into Login values ('" + formNo + "','" + userCardNo + "','" + userPinNo + "')";
                       connn.st.executeUpdate(query1);
                       connn.st.executeUpdate(query2);

                       JOptionPane.showMessageDialog(null, "Form NO : " + formNo + "\n Card no : " + userCardNo + "\n PIN : " + userPinNo);
                       setVisible(false);
                       new LoginPage().setVisible(true);

               }
               catch (Exception e){
                   System.out.println(e);
               }
        }
        else if(acEvent.getSource() ==  cancel){

        }
    }
    public static void main(String[] args) {
        new SignUpThird("");
    }
}
