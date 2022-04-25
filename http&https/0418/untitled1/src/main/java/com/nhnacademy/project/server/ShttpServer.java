package com.nhnacademy.project.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.project.jsonfile.Data;
import com.nhnacademy.project.jsonfile.Headers;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class ShttpServer {
    Map<String, Object> argsMap = new LinkedHashMap<>();
    String path;
    String method;
    String httpVersion;
    private DataInputStream in;
    private DataOutputStream out;
    private String accept;
    private String userAgent;
    private String hostIp;
    private String url;
    ObjectMapper objectMapper = new ObjectMapper();

    public void serverToDo1() throws IOException {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(80);
                 Socket socket = serverSocket.accept()) {
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
                System.out.println("클라이언트 연결됨.");

                byte[] bytes = new byte[1024];
                in.read(bytes);
                String temp = new String(bytes);

                String[] reqLine;
                reqLine = temp.split("\n");

                method = reqLine[0].split(" ")[0];
                path = reqLine[0].split(" ")[1];
                httpVersion = reqLine[0].split(" ")[2];
                hostIp = reqLine[1].split(" ")[1];
                url = hostIp + path;

                // args 작업
                if(path.contains("?")) {
                    String argData = path.split("\\?")[1]; // msg1=hello&msg2=world 식으로 들어가있음
                    String[] tempSteList = argData.split("&"); // tempList[0] -> msg1=hello, tempList[1] -> msg2=hello2 형식으로 들어가있음
                    for (String s : tempSteList) {
                        argsMap.put(s.split("=")[0], s.split("=")[1]); // args 넣는곳
                    }
                    path = path.split("\\?")[0];
                }

                userAgent = reqLine[2].split(" ")[1];
                accept = reqLine[3].split(" ")[1];

                InetAddress ip = socket.getInetAddress();

                if (path.equals("/ip")) {
                    sendIpPath(out, httpVersion, ip);
                }
                if (path.equals("/get")) {
                    sendGetPath(out, httpVersion, ip);
                }
            }
        }
    }

    private void sendGetPath(DataOutputStream out, String httpVersion, InetAddress ip)
        throws IOException {
        Headers header = new Headers(accept, hostIp, userAgent);
        Data data = new Data(argsMap, header, ip.toString(), url);
        String res = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

        resHead(out, httpVersion, res);
        out.writeBytes(res);
    }
    private void sendIpPath(DataOutputStream out, String httpVersion, InetAddress ip)
        throws IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("origin", ip);
        String origin = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);

        resHead(out, httpVersion, origin);
        out.writeBytes(origin);
    }
    private void resHead(DataOutputStream out, String httpVersion, String res) throws IOException {
        out.writeBytes(httpVersion + " 200 OK\n");
        out.writeBytes("Content-Type: application/json\n");
        out.writeBytes("Date: " + datePattern() +" GMT\n");
        out.writeBytes("Content-Length: "+ res.length() + "\n");
        this.out.writeBytes("Connection: keep-alive\n");
        this.out.writeBytes("Server: gunicorn/19.9.0\n");
        this.out.writeBytes("Access-Control-Allow-Origin: *\n");
        this.out.writeBytes("Access-Control-Allow-Credentials: true\n");
        this.out.writeBytes("\n"); // 공백라인
    }
    public String datePattern() {
        return LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("E, dd M yyyy hh:mm:ss ").withLocale(
                Locale.ENGLISH));
    }
}

