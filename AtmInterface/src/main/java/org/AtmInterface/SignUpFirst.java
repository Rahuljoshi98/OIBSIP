package org.AtmInterface;

import javax.swing.*;
import java.awt.*;       //color class is in java.awt package
import java.util.*;      //random function is in java util package
import com.toedter.calendar.JDateChooser;         //used to add calender JDateChooser is the class where these things exist
import java.awt.event.*;
public class SignUpFirst extends JFrame implements ActionListener {
    long randomNo;
    JTextField nametextfield,fathernameTextfield,emailtextfield,addTextField,cityTextField,stateTextField,pinTextField;
    JButton nextpage;
    JRadioButton genderMaleRadioButton,genderFemaleRadioButton,genderOtherRadioButton,marriedMaritalButton,unmarriedMaritalButton,otherMaritalButton;
    JDateChooser udatechooser;
    SignUpFirst(){
        setLayout(null);
        Random random = new Random();
        randomNo = Math.abs((random.nextLong() % 8000L) + 1100L);    //math.abs is used to convert the no into positive if it is negative


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


        nametextfield = new JTextField();
        nametextfield.setFont(new Font("Areal",Font.ITALIC,14));
        nametextfield.setBounds(280,153,350,25);
        add(nametextfield);


        JLabel ufn = new JLabel("Father's Name : ");
        add(ufn);
        ufn.setBounds(85,186,200,40);
        ufn.setFont(new Font("Raleway",Font.BOLD,17));


        fathernameTextfield = new JTextField();
        fathernameTextfield.setFont(new Font("Areal",Font.ITALIC,14));
        fathernameTextfield.setBounds(280,193,350,25);
        add(fathernameTextfield);


        JLabel udob = new JLabel("Date Of Birth : ");
        add(udob);
        udob.setBounds(85,226,200,40);
        udob.setFont(new Font("Raleway",Font.BOLD,17));

        udatechooser = new JDateChooser();            //class to add calender
        udatechooser.setBounds(280,233,350,25);
        add(udatechooser);
        udatechooser.setForeground(Color.BLACK);

        JLabel gender = new JLabel("Gender : ");
        add(gender);
        gender.setBounds(85,266,200,40);
        gender.setFont(new Font("Raleway",Font.BOLD,17));


        genderMaleRadioButton = new JRadioButton("Male");
        genderMaleRadioButton.setBounds(280,273,80,25);
        genderMaleRadioButton.setBackground(Color.WHITE);
        add(genderMaleRadioButton);

        genderFemaleRadioButton = new JRadioButton("Female");
        genderFemaleRadioButton.setBounds(420,273,80,25);
        genderFemaleRadioButton.setBackground(Color.white);
        add(genderFemaleRadioButton);


        genderOtherRadioButton = new JRadioButton("Other");
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

        emailtextfield = new JTextField();
        emailtextfield.setFont(new Font("Areal",Font.ITALIC,14));
        emailtextfield.setBounds(280,313,350,25);
        add(emailtextfield);


        JLabel userMaritalStatus = new JLabel("Marital Status : ");
        add(userMaritalStatus);
        userMaritalStatus.setBounds(85,346,200,40);
        userMaritalStatus.setFont(new Font("Raleway",Font.BOLD,17));

        marriedMaritalButton = new JRadioButton("Married");
        marriedMaritalButton.setBounds(280,351,80,25);
        marriedMaritalButton.setBackground(Color.white);
        add(marriedMaritalButton);

        unmarriedMaritalButton = new JRadioButton("Unmarried");
        unmarriedMaritalButton.setBounds(420,351,120,25);
        unmarriedMaritalButton.setBackground(Color.white);
        add(unmarriedMaritalButton);

        otherMaritalButton = new JRadioButton("Other");
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

        addTextField = new JTextField();
        addTextField.setFont(new Font("Areal",Font.ITALIC,14));
        addTextField.setBounds(280,395,350,25);
        add(addTextField);


        JLabel city = new JLabel("City : ");
        add(city);
        city.setBounds(85,426,200,40);
        city.setFont(new Font("Raleway",Font.BOLD,17));

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Areal",Font.ITALIC,14));
        cityTextField.setBounds(280,433,350,25);
        add(cityTextField);


        JLabel state = new JLabel("State : ");
        add(state);
        state.setBounds(85,466,200,40);
        state.setFont(new Font("Raleway",Font.BOLD,17));

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Areal",Font.ITALIC,14));
        stateTextField.setBounds(280,473,350,25);
        add(stateTextField);


        JLabel pinCode = new JLabel("Pin Code : ");
        add(pinCode);
        pinCode.setBounds(85,506,200,40);
        pinCode.setFont(new Font("Raleway",Font.BOLD,17));

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Areal",Font.ITALIC,14));
        pinTextField.setBounds(280,513,350,25);
        add(pinTextField);

        nextpage = new JButton("Next");
        nextpage.setBackground(Color.BLACK);
        nextpage.setForeground(Color.white);
        nextpage.setFont(new Font("Raleway",Font.BOLD,14));
        nextpage.setBounds(560,560,70,25);
        add(nextpage);

        nextpage.addActionListener(this);


        setSize(800,660);
        setLocation(260,10);
        setVisible(true);
        setTitle("ENTER YOUR DETAILS");
        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent act){
        //to store data in database we perform the following tasks

                String formNumber = ""+ randomNo;     //to convert random which is long into string we add a null string with random
                String uname = nametextfield.getText();      //to extract a value from nametextfield we use getText() fuction
                String uFather = fathernameTextfield.getText();
                String userDob =((JTextField)udatechooser.getDateEditor().getUiComponent()).getText();     //getUIComponent return a text field so we have to concate it with JtextField so we write JtextField in beginning
                String findGender = null;
                if(genderMaleRadioButton.isSelected()){        //isSelected is the function used to know which radio button is selected
                    findGender = "Male";
                }
                else if(genderFemaleRadioButton.isSelected()){
                    findGender = "Female";
                }
                else if (genderOtherRadioButton.isSelected()){
                    findGender="Other";
                }

                String uemail =  emailtextfield.getText();

                String uMaritalSta = null;
                if(marriedMaritalButton.isSelected()){
                    uMaritalSta = "Married";
                }
                else if(unmarriedMaritalButton.isSelected()){
                    uMaritalSta = "Unmarried";
                }
                else if(otherMaritalButton.isSelected()){
                    uMaritalSta = "Other";
                }

                String Uaddress = addTextField.getText();
                String Ucity = cityTextField.getText();
                String Ustate = stateTextField.getText();
                String pin = pinTextField.getText();

                //database is an external entity so we have to do exception handling
                try{
                    if(uname.equals("")){
                        JOptionPane.showMessageDialog(null,"please enter your name ");    // JOptionPane.showMessageDialog create a dialog box if name is empty
                    }
                    else if(uFather.equals("")){
                        JOptionPane.showMessageDialog(null,"please enter Father's name");
                    }
                    else if(uemail.equals("")){
                        JOptionPane.showMessageDialog(null,"please enter email");
                    }
                    else if(Uaddress.equals("")){
                        JOptionPane.showMessageDialog(null,"please enter your address");
                    }
                    else if(Ucity.equals("")){
                        JOptionPane.showMessageDialog(null,"please enter your city");
                    }
                    else if(Ustate.equals("")){
                        JOptionPane.showMessageDialog(null,"pleases enter your state ");
                    }
                    else if(pin.equals("")){
                        JOptionPane.showMessageDialog(null,"please enter pin code");
                    }

                    //after running all the above statements the data will go in SignUp table in mySql because we are using  String query = "insert into SignUp values......." in else statement
                    else{
                           CreateConn conob = new CreateConn();
                           String query = "insert into SignUpOne values ('"+formNumber+"','"+uname+"','"+uFather+"','"+userDob+"','"+findGender+"','"+uemail+"','"+uMaritalSta+"','"+Uaddress+"','"+Ucity+"','"+Ustate+"','"+pin+"')";
                           conob.st.executeUpdate(query);     //using st reference to insert the value in database and executeUpdate(query) update the table in mysql
                           setVisible(false);
                           new SignUpTwo(formNumber).setVisible(true);
                    }
                }

                catch (Exception e){
                    System.out.println(e);
                }
    }
    public static void main(String[] args) {

        new SignUpFirst();
    }
}
