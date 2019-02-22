package sef.module13.sample;
//Needs to be completed
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionSample {
    //    This source code tries to establish a connection to a MySQL server
    //    and displays a message concerning the error if connection fails
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost/activity";
            String user = "root";
            String pass = "123456";

            //1 - Load the driver

            //2 - Obtain a connection using DriverManager class
            Connection cn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connection successfully established! \n");
            Statement mystatement =cn.createStatement();
            ResultSet rs = mystatement.executeQuery("Select * from employee");


            while(rs.next()) {
                System.out.print(rs.getInt(1));
                System.out.println(rs.getString(2));
            }

            //Closing the connection
            cn.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

