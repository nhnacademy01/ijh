package com.nhnacademy.project.jsonfile;

public class Headers {
    String accept;
    String host;
    String userAgent;
    String contentType="";
    String contentLength="";

    public String getContentType() {
        return contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public Headers(String accept, String host, String userAgent) {
        this.accept = accept;
        this.host = host;
        this.userAgent = userAgent;
    }

    public String getHost() {
        return host;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getAccept() {
        return accept;
    }
}