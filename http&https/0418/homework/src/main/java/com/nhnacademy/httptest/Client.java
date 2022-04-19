package com.nhnacademy.httptest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void start(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket(args[1], Integer.parseInt(args[2]))) {
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            System.out.println("server connected!!");

            while (true) {
                System.out.print("$ ");
                String msg = scanner.nextLine();
                os.writeUTF(msg);
                System.out.println(is.readUTF());
            }
        }
    }
}
