package thogakade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThogaKade {

    public static void main(String[] args) {
        String SQL = "SELECT*FROM Customer";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //load class 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ThogaKade", "admin", "12345"); //create connection and assign connection objects address into Connection type variable
            Statement stm = connection.createStatement();
            ResultSet executeQuery = stm.executeQuery(SQL);

            while (executeQuery.next()) {
                System.out.println("" + executeQuery.getString(1) + "-" + executeQuery.getString(2) + "-" + executeQuery.getString("address") + "-" + executeQuery.getString("salary"));
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
