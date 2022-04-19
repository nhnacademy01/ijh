package com.nhnacademy.httptest;
import java.io.IOException;
import java.util.Scanner;

public class Snc {
    public static void main(String[] args) throws IOException {
        String[] arg;
        Scanner scanner = new Scanner(System.in);

        System.out.print("$ ");
        String str = scanner.nextLine();
        arg = str.split(" ");

        if(arg[1].equals("-l")) {
            Server.open(arg);
        } else {
            Client.start(arg);
        }
    }
}
