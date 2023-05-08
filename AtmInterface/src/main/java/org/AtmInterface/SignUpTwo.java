package org.AtmInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener {

     JComboBox religionCombo,categoryCombo,incomeCombo,QualificationCombo,occupationCombo;
     JTextField userPanTextField,userAadharField;

     JRadioButton accInfoRadioNo,seniorNo,accInfoRadioYes,seniorYes;

     JButton nextPage2;
     String formNo;
    SignUpTwo(String formNo){
        this.formNo=formNo;
        setLayout(null);

        JLabel additionalDetails =  new JLabel("PAGE 2 : Additional Details");
        additionalDetails.setBounds(278,70,400,50);
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,18));
        add(additionalDetails);


        JLabel rel = new JLabel("Religion : ");
        rel.setFont(new Font("Raleway",Font.BOLD,17));
        rel.setBounds(85,146,160,40);
        add(rel);

        String religionVal[] = {"Hindu","Muslim","Sikh","Christen","Other"};
        //in JComboBox we have to pass the array of strings so ve create a array of religionVal[] and pass it to JComboBox

        religionCombo = new JComboBox(religionVal);      //JComboBox() is used to create a dropDown box
        add(religionCombo);
        religionCombo.setBounds(280,153,350,25);
        religionCombo.setBackground(Color.white);




        JLabel category = new JLabel("Category : ");
        category.setBounds(85,186,200,40);
        category.setFont(new Font("Raleway",Font.BOLD,17));
        add(category);

        String categoryVal[] = {"General","OBC","SC","ST","Other"};
        categoryCombo = new JComboBox(categoryVal);
        categoryCombo.setBackground(Color.white);
        categoryCombo.setBounds(280,193,350,25);
        add(categoryCombo);



        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway",Font.BOLD,17));
        income.setBounds(85,226,200,40);
        add(income);

        String incomeVal[] = {"Null","<1,50,000","<3,50,000","<5,50,000","upto 10,00,000","more than 10,00,000"};
        incomeCombo = new JComboBox(incomeVal);
        incomeCombo.setBackground(Color.white);
        incomeCombo.setBounds(280,233,350,25);
        add(incomeCombo);



        JLabel eduQualification = new JLabel("Educational");
        eduQualification.setBounds(85,266,200,40);
        eduQualification.setFont(new Font("Raleway",Font.BOLD,17));
        add(eduQualification);

        JLabel eduQual = new JLabel("Qualification : ");
        eduQual.setBounds(85,286,200,40);
        eduQual.setFont(new Font("Raleway",Font.BOLD,17));
        add(eduQual);

        String Qualification[] = {"Matric Pass","HighSchool","Intermediate","Graduate","Post Graduation","Doctorate","Other"};
        QualificationCombo = new JComboBox( Qualification);
        QualificationCombo.setBackground(Color.white);
        QualificationCombo.setBounds(280,273,350,25);
        add(QualificationCombo);



        JLabel userOccupation = new JLabel("Occupation");
        userOccupation.setFont(new Font("Raleway",Font.BOLD,17));
        userOccupation.setBounds(85,326,200,40);
        add(userOccupation);

        String occupation[] = {"Self-Employed","Government Employee","Business","Student","Retired","Other"};
        occupationCombo = new JComboBox(occupation);
        occupationCombo.setBackground(Color.white);
        occupationCombo.setBounds(280,333,350,25);
        add(occupationCombo);



        JLabel userPan = new JLabel("PAN Number");
        userPan.setFont(new Font("Raleway",Font.BOLD,17));
        userPan.setBounds(85,366,200,40);
        add(userPan);

        userPanTextField = new JTextField();
        userPanTextField.setBounds(280,373,350,25);
        add(userPanTextField);
        userPanTextField.setFont(new Font("Areal",Font.ITALIC,14));



        JLabel userAadhar = new JLabel("Aadhar No");
        userAadhar.setBounds(85,406,200,40);
        userAadhar.setFont(new Font("Raleway",Font.BOLD,17));
        add(userAadhar);

        userAadharField = new JTextField();
        userAadharField.setBounds(280,413,350,25);
        add(userAadharField);
        userAadharField.setFont(new Font("Areal",Font.ITALIC,14));



        JLabel seniorCategory = new JLabel("Senior Citizen");
        seniorCategory.setFont(new Font("Raleway",Font.BOLD,17));
        seniorCategory.setBounds(85,446,200,40);
        add(seniorCategory);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(280,455,80,25);
        seniorYes.setBackground(Color.white);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(420,455,80,25);
        seniorNo.setBackground(Color.white);
        add(seniorNo);

        ButtonGroup seniorRadioGroup = new ButtonGroup();
        seniorRadioGroup.add(seniorNo);
        seniorRadioGroup.add(seniorYes);



        JLabel accInfo = new JLabel("Existing Account");
        accInfo.setBounds(85,486,200,40);
        accInfo.setFont(new Font("Raleway",Font.BOLD,17));
        add(accInfo);

        accInfoRadioYes = new JRadioButton("Yes");
        accInfoRadioYes.setBounds(280,495,80,25);
        accInfoRadioYes.setBackground(Color.WHITE);
        add(accInfoRadioYes);

        accInfoRadioNo = new JRadioButton("NO");
        accInfoRadioNo.setBounds(420,495,80,25);
        accInfoRadioNo.setBackground(Color.white);
        add(accInfoRadioNo);

        ButtonGroup accountRadioGroup = new ButtonGroup();
        accountRadioGroup.add(accInfoRadioNo);
        accountRadioGroup.add(accInfoRadioYes);


        nextPage2 = new JButton("Next");
        nextPage2.setBackground(Color.black);
        nextPage2.setForeground(Color.white);
        nextPage2.setBounds(560,540,70,25);
        nextPage2.setFont(new Font("Raleway",Font.BOLD,14));
        add(nextPage2);

        nextPage2.addActionListener(this);


        setSize(800,660);
        setLocation(260,10);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent act2){
              String religion = (String) religionCombo.getSelectedItem();          //to pick the value from dropDown box we user getSelectedItem() function is used
                                                                                    //and this function returns the object so we have to type cast it into string
              String category = (String) categoryCombo.getSelectedItem();
              String income =(String) incomeCombo.getSelectedItem();
              String edu = (String) QualificationCombo.getSelectedItem();
              String occupation =(String) occupationCombo.getSelectedItem();

              String seniorStatus = null;
              if(seniorNo.isSelected()){
                  seniorStatus="No";
              }
              else if(seniorYes.isSelected()){
                  seniorStatus="Yes";
              }

              String accStatus = null;
              if(accInfoRadioYes.isSelected()){
                  accStatus="Yes";
              }
              else if(accInfoRadioNo.isSelected()){
                  accStatus="No";
              }

              String panNO = userPanTextField.getText();
              String aadharNo = userAadharField.getText();

              try{
                  if(panNO.equals("")){
                      JOptionPane.showMessageDialog(null,"Enter Your Pan No");
                  }
                  else if(aadharNo.equals("")){
                      JOptionPane.showMessageDialog(null,"Enter your Aadhar no ");
                  }
                  else{
                      CreateConn connect = new CreateConn();
                      String query = "insert into SignUpTwo values ('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+edu+"','"+occupation+"','"+panNO+"','"+aadharNo+"','"+seniorStatus+"','"+accStatus+"')";
                      connect.st.executeUpdate(query);

                  }
              }
              catch (Exception e){
                  System.out.println(e);
              }

    }
    public static void main(String[] args) {

        new SignUpTwo("");           //here we pass the empty string because there is no default constructor in the
        // above class so we have to pass empty string to make it parametric
    }
}
