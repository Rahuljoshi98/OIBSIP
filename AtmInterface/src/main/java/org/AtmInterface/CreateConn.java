package org.AtmInterface;
import java.sql.*;
public class CreateConn {
    Connection conn;                  //connection class is used to create the connection

    Statement st;                 //used to create statement

    public CreateConn(){
        try{                   //here we are maintain exception handling because my sql is external entity so there is a possibility of errors

            // Class.forName(com.mysql.cj.jdbc.Driver);          //to register the driver we have a class having name Class and it have forName static method
            //after importing the jar file of mysql-connector-java-8.0.21.jar maven there is no need to write the above statement
            conn = DriverManager.getConnection("jdbc:mysql:///AtmSystem","root","627267");     //by default mysql runs in local host so no need to give the local host address
            st = conn.createStatement();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
