package org.example;

import java.sql.*;
import java.util.Scanner;

public class log_in {
    public static void logn(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Log in");

        System.out.println("login: ");
        String a = sc.nextLine();

        System.out.println("password: ");
        String b = sc.nextLine();


        String jbdcURL = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "1234";

        try {
            Connection conn = DriverManager.getConnection(jbdcURL, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users WHERE login = '" + a + "' AND password = '" + b + "';");
           /* while (rs.next())
            {
                System.out.printf("%d - %s - %s - %b\n", rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getBoolean("user_active"));
            }
            */
            if(rs.next()){
                System.out.println("You're ready!");
            } else {
                System.out.println("Account like this, doesn't exist!");
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println("ERROR: failed to connect to database");
            e.printStackTrace();
        }
    }
}
