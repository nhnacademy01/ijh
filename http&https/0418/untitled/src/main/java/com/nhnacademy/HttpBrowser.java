package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 예제 1번 : scurl http://httpbin.org/get
 * 예제 2번 : scurl -X GET http://httpbin.org/get
 * 예제 3번 : scurl -v http://httpbin.org/get
 * 예제 4번 : scurl -v -H "X-Custom-Header: NA" http://httpbin.org/get
 * 예제 5번 : scurl -v -X POST -d {"hello" "world"} -H "Content-Type: application/json" http://httpbin.org/post
 */

public class HttpBrowser {
    Map<String, String> headerMap = new HashMap<>();
    Map<String, Object> postBody = new LinkedHashMap<>();
    private boolean verbose;
    private String method = "GET";
    private String url;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HttpBrowser httpBrowser = new HttpBrowser();
        String[] input;
        System.out.print("$ ");
        input = scanner.nextLine().split(" ");

        httpBrowser.parse(input);
        httpBrowser.sendReq(httpBrowser.url, httpBrowser.method);
    }

    private void parse(String[] args) {
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
                // args[i+1] : "X-Custom-Header: , args[i+2] : NA"
                args[i + 1] = args[i + 1].replace("\"", "");
                args[i + 2] = args[i + 2].replace("\"", "");
                headerMap.put(args[i + 1].split(":")[0], args[i + 2]);
            }
            if (args[i].equals("-d")) {
                postBody.put(args[i + 1], args[i + 2]);
            }
            if (i == args.length - 1) {
                url = args[i];
            }
        }
    }
    private void sendReq(String urlString, String method) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        /*
          header setting
          headerMap.forEach(con::setRequestProperty) << 이거랑 밑에 foreach 문이랑 같음 이해하기 어려움..
         */
        for (Map.Entry<String, String> param : headerMap.entrySet()) {
            con.setRequestProperty(param.getKey(), param.getValue());
        }

        con.setRequestMethod(method);
        if (method.equals("POST")) sendPost(con);

        // header print
        if (verbose) {
            Map<String, List<String>> map = con.getHeaderFields();
            map.keySet().stream().map(key -> "< " + key + ": " + map.get(key))
                .forEach(System.out::println);
        }

        // body print
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),
            StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
    private void sendPost(HttpURLConnection con) throws IOException {
        StringBuilder postData = new StringBuilder();

        for (Map.Entry<String, Object> param : postBody.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(param.getKey());
            postData.append(':');
            postData.append(param.getValue());
        }

        byte[] postDataBytes = postData.toString().getBytes(StandardCharsets.UTF_8);

        con.setDoOutput(true);
        con.getOutputStream().write(postDataBytes);
    }
}