package com.nhnacademy;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 예제 1번 : scurl http://httpbin.org/get
 * 예제 2번 : scurl -X GET http://httpbin.org/get
 * 예제 3번 : scurl -v http://httpbin.org/get
 * 예제 4번 : scurl -v -H "X-Custom-Header: NA" http://httpbin.org/get
 * 예제 5번 : scurl -v -X POST -d {\"hello\" \"world\"} -H "Content-Type: application/json" http://httpbin.org/post
 */

public class HttpPractice {
    private static final int PORT = 10000;
    private final ArrayList<String> header = new ArrayList<>();
    private final ArrayList<String> body = new ArrayList<>();
    Map<String, String> headerMap = new HashMap<>();
    Map<String, Object> postBody = new LinkedHashMap<>();
    private String host;
    private String method = "GET";
    private boolean verbose;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HttpPractice browser = new HttpPractice();

        String[] input;
        System.out.print("$ ");
        input = scanner.nextLine().split(" ");

        browser.parse(input);
        browser.connect();
    }

    private void parse(String[] args)
     {
        if (!args[0].equals("scurl")) {
            return;
        }
        if (args[1].equals("-v")) {
            verbose = true;
        }

        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("-X")) {
                method = args[i + 1];
            }
            if (args[i].equals("-H")) {
                // args[i+1] --> "X-Custom-Header: , args[i+2] : NA"
                args[i + 1] = args[i + 1].replace("\"", "");
                args[i + 2] = args[i + 2].replace("\"", "");
                headerMap.put(args[i + 1].split(":")[0], args[i + 2]);
            }
            if (args[i].equals("-d")) {
                postBody.put(args[i + 1], args[i + 2]);
            }
            if (i == args.length - 1) {
                host = args[i];
            }
        }
    }

    private void connect() throws IOException {
//        URL url = new URL(this.host);
        // 소켓 및 입출력 스트림 준비
        try (Socket socket = new Socket("127.0.0.1", PORT)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());

            // 요청라인
            out.println(method + " " + "url.getPath()" + " HTTP/1.0");

            // 헤더정보
            for (Map.Entry<String, String> param : headerMap.entrySet()) {
                out.println(param.getKey() + ": " + param.getValue());
            }

            // 공백라인
            out.println();

            // data 전송
            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : postBody.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(param.getKey());
                postData.append(':');
                postData.append(param.getValue());
            }
//            System.out.println(postData);
            out.println(postData);

            byte[] postDataBytes = postData.toString().getBytes(StandardCharsets.UTF_8);
//            out.write(postDataBytes);
            out.println();
            out.flush();

            // 응답 내용
            boolean bodyCheck = false;
            String line;
            while ((line = in.readLine()) != null) {
                if (line.equals("")) {
                    bodyCheck = true;
                }
                if (!bodyCheck) {
                    header.add(line);
                } else {
                    body.add(line);
                }
            }
            if (verbose) {
                for (String s : header) {
                    System.out.println(s); // -v 받으면 헤더도 출력
                }
            }
            for (String s : body) {
                System.out.println(s);
            }

            in.close();
            out.close();
        }
    }
}
