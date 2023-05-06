package org.AtmInterface;

import javax.swing.*;
import java.awt.*;       //color class is in java.awt package
import java.util.*;      //random function is in java util package
import com.toedter.calendar.JDateChooser;         //used to add calender JDateChooser is the class where these things exist

public class SignUpFirst extends JFrame {

    SignUpFirst(){
        setLayout(null);
        Random random = new Random();
        long randomNo = Math.abs((random.nextLong() % 8000L) + 1100L);    //math.abs is used to convert the no into positive if it is negative


        JLabel formNo = new JLabel("APPLICATION NO : " + randomNo);      //random no is added to provide different application no to different applications
        formNo.setFont(new Font("Raleway",Font.BOLD,28));
        formNo.setBounds(230,30,700,50);
        add(formNo);


        JLabel userdetail = new JLabel("page 1 : Personal Details");
        add(userdetail);
        userdetail.setBounds(278,70,400,50);
        userdetail.setFont(new Font("Raleway",Font.BOLD,18));


        JLabel username = new JLabel("Name : ");
        add(username);
        username.setBounds(85,146,80,40);
        username.setFont(new Font("Raleway",Font.BOLD,17));


        JTextField nametextfield = new JTextField();
        nametextfield.setFont(new Font("Areal",Font.ITALIC,14));
        nametextfield.setBounds(280,153,350,25);
        add(nametextfield);


        JLabel ufn = new JLabel("Father's Name : ");
        add(ufn);
        ufn.setBounds(85,186,200,40);
        ufn.setFont(new Font("Raleway",Font.BOLD,17));


        JTextField fathernameTextfield = new JTextField();
        fathernameTextfield.setFont(new Font("Areal",Font.ITALIC,14));
        fathernameTextfield.setBounds(280,193,350,25);
        add(fathernameTextfield);


        JLabel udob = new JLabel("Date Of Birth : ");
        add(udob);
        udob.setBounds(85,226,200,40);
        udob.setFont(new Font("Raleway",Font.BOLD,17));

        JDateChooser udatechooser = new JDateChooser();            //class to add calender
        udatechooser.setBounds(280,233,350,25);
        add(udatechooser);
        udatechooser.setForeground(Color.BLACK);

        JLabel gender = new JLabel("Gender : ");
        add(gender);
        gender.setBounds(85,266,200,40);
        gender.setFont(new Font("Raleway",Font.BOLD,17));


        JRadioButton genderMaleRadioButton = new JRadioButton("Male");
        genderMaleRadioButton.setBounds(280,273,80,25);
        genderMaleRadioButton.setBackground(Color.WHITE);
        add(genderMaleRadioButton);

        JRadioButton genderFemaleRadioButton = new JRadioButton("Female");
        genderFemaleRadioButton.setBounds(420,273,80,25);
        genderFemaleRadioButton.setBackground(Color.white);
        add(genderFemaleRadioButton);


        JRadioButton genderOtherRadioButton = new JRadioButton("Others");
        genderOtherRadioButton.setBounds(560,273,80,25);
        genderOtherRadioButton.setBackground(Color.white);
        add(genderOtherRadioButton);


        ButtonGroup radioGenderGroup = new ButtonGroup();      //ButtonGroup is used to add functionality to the radio button i.e., on click only one statement will select
        radioGenderGroup.add(genderFemaleRadioButton);
        radioGenderGroup.add(genderMaleRadioButton);
        radioGenderGroup.add(genderOtherRadioButton);


        JLabel userEmail = new JLabel("Email Id : ");
        add(userEmail);
        userEmail.setBounds(85,306,200,40);
        userEmail.setFont(new Font("Raleway",Font.BOLD,17));

        JTextField emailtextfield = new JTextField();
        emailtextfield.setFont(new Font("Areal",Font.ITALIC,14));
        emailtextfield.setBounds(280,313,350,25);
        add(emailtextfield);


        JLabel userMaritalStatus = new JLabel("Marital Status : ");
        add(userMaritalStatus);
        userMaritalStatus.setBounds(85,346,200,40);
        userMaritalStatus.setFont(new Font("Raleway",Font.BOLD,17));

        JRadioButton marriedMaritalButton = new JRadioButton("Married");
        marriedMaritalButton.setBounds(280,351,80,25);
        marriedMaritalButton.setBackground(Color.white);
        add(marriedMaritalButton);

        JRadioButton unmarriedMaritalButton = new JRadioButton("Unmarried");
        unmarriedMaritalButton.setBounds(420,351,120,25);
        unmarriedMaritalButton.setBackground(Color.white);
        add(unmarriedMaritalButton);

        JRadioButton otherMaritalButton = new JRadioButton("Others");
        otherMaritalButton.setBounds(560,351,120,25);
        otherMaritalButton.setBackground(Color.white);
        add(otherMaritalButton);

        ButtonGroup maritalRadioButton = new ButtonGroup();
        maritalRadioButton.add(unmarriedMaritalButton);
        maritalRadioButton.add(marriedMaritalButton);
        maritalRadioButton.add(otherMaritalButton);

        JLabel userAddress = new JLabel("Address : ");
        add(userAddress);
        userAddress.setBounds(85,387,200,40);
        userAddress.setFont(new Font("Raleway",Font.BOLD,17));

        JTextField addTextField = new JTextField();
        addTextField.setFont(new Font("Areal",Font.ITALIC,14));
        addTextField.setBounds(280,395,350,25);
        add(addTextField);


        JLabel city = new JLabel("City : ");
        add(city);
        city.setBounds(85,426,200,40);
        city.setFont(new Font("Raleway",Font.BOLD,17));

        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Areal",Font.ITALIC,14));
        cityTextField.setBounds(280,433,350,25);
        add(cityTextField);


        JLabel state = new JLabel("State : ");
        add(state);
        state.setBounds(85,466,200,40);
        state.setFont(new Font("Raleway",Font.BOLD,17));

        JTextField stateTextField = new JTextField();
        stateTextField.setFont(new Font("Areal",Font.ITALIC,14));
        stateTextField.setBounds(280,473,350,25);
        add(stateTextField);


        JLabel pinCode = new JLabel("Pin Code : ");
        add(pinCode);
        pinCode.setBounds(85,506,200,40);
        pinCode.setFont(new Font("Raleway",Font.BOLD,17));

        JTextField pinTextField = new JTextField();
        pinTextField.setFont(new Font("Areal",Font.ITALIC,14));
        pinTextField.setBounds(280,513,350,25);
        add(pinTextField);

        JButton nextpage = new JButton("Next");
        nextpage.setBackground(Color.BLACK);
        nextpage.setForeground(Color.white);
        nextpage.setFont(new Font("Raleway",Font.BOLD,14));
        nextpage.setBounds(560,560,70,25);
        add(nextpage);


        setSize(800,660);
        setLocation(260,10);
        setVisible(true);
        setTitle("ENTER YOUR DETAILS");
        getContentPane().setBackground(Color.white);


    }
    public static void main(String[] args) {
        new SignUpFirst();
    }
}
