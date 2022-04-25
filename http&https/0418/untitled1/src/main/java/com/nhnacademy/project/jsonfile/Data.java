package com.nhnacademy.project.jsonfile;

import java.util.Map;

public class Data {
    Map<String, Object> args;
    Headers headers;
    String origin;
    String url;

    public Data(Map<String, Object> args, Headers headers, String origin, String url) {
        this.args = args;
        this.headers = headers;
        this.origin = origin;
        this.url = url;
    }

    public Map<String, Object> getArgs() {

        return args;
    }

    public Headers getHeaders() {
        return headers;
    }

    public String getOrigin() {
        return origin;
    }

    public String getUrl() {
        return url;
    }
}