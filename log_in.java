package org.example;

import java.sql.*;
import java.util.Scanner;

public class log_in {
    public static void logn() {
        String jbdcURL = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "1234";
        String login = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("Log in");

        try {
            Connection conn = DriverManager.getConnection(jbdcURL, username, password);
            Statement st = conn.createStatement();
            boolean process_log = true;
            while (process_log) {
                System.out.println("login: ");
                login = sc.nextLine();
                ResultSet rs = st.executeQuery("SELECT * FROM users WHERE login = '" + login + "';");
                if (!rs.next()){
                    System.out.println("Account like this, doesn't exist! Try again");
                } else {
                    process_log = false;
                }
            }
            process_log = true;
            while(process_log) {
                System.out.println("password: ");
                String passw = sc.nextLine();
                ResultSet rs = st.executeQuery("SELECT * FROM users WHERE password = '" + passw + "';");
                if(!rs.next()){
                    System.out.println("Wrong password! Try again");
                } else {
                    process_log = false;
                }
            }
            System.out.println("You're ready");
            conn.close();

        } catch (SQLException e) {
            System.err.println("ERROR: failed to connect to database");
            e.printStackTrace();
        }
    }
}
