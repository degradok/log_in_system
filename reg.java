package org.example;

import java.sql.*;
import java.util.Scanner;

public class reg {
    public static void regs() {
        String jbdcURL = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "1234";
        Scanner sc = new Scanner(System.in);

        System.out.println("Registration");

        try {
            Connection conn = DriverManager.getConnection(jbdcURL, username, password);
            Statement st = conn.createStatement();
            boolean process_registr = true;
            String login = "";
            while (process_registr) {
                System.out.println("new login: ");
                login = sc.nextLine();
                ResultSet rs = st.executeQuery("SELECT * FROM users WHERE login = '" + login + "';");

                if (rs.next()) {
                    System.out.println("Try new username");
                } else {
                    process_registr = false;
                }
            }
            System.out.println("new password: ");
            String passw = sc.nextLine();
            st.execute("INSERT INTO users (login, password) VALUES ('" + login + "','" + passw +"');");

            System.out.println("You're ready!");

            conn.close();
        } catch (SQLException e) {
            System.err.println("ERROR: failed to connect to database");
            e.printStackTrace();
        }
       sc.close();
    }
}
