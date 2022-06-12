package org.example;

import java.sql.*;
import java.util.Scanner;

public class reg {
    public static void regs() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Registration");

        System.out.println("new login: ");
        String a = sc.nextLine();

        System.out.println("new password: ");
        String b = sc.nextLine();


        String jbdcURL = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "1234";
        String table_name = "users";

        try {
            Connection conn = DriverManager.getConnection(jbdcURL, username, password);
            Statement st = conn.createStatement();
            st.execute("INSERT INTO " + table_name + " (login, password) VALUES ('" + a + "','" + b + "');");
            System.out.println("You're ready!");
            conn.close();
        } catch (SQLException e) {
            System.err.println("ERROR: failed to connect to database");
            e.printStackTrace();
        }
    }
}
