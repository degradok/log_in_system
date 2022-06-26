package org.example;

import static org.example.log_in.logn;
import static org.example.reg.regs;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you have an account?");
        String res = sc.nextLine();

        if(res.equals("yes")){
            logn();
        }else if(res.equals("no")){
            regs();
        } else{
            System.out.println("Пошел нахуй! Пиши нормально");
        }
    }
}