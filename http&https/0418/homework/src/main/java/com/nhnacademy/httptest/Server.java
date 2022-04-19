package com.nhnacademy.httptest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// 명령어를 만들란 소린가?
public class Server {
    public static void open(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[2]))) {
            System.out.println("서버시작!!");
            Socket socket = serverSocket.accept();
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            System.out.println("client connected!");
            while (true) {
                String msg = is.readUTF();
                System.out.println(msg);
                os.writeUTF(msg);
            }
        }
    }
}
