package com.nhnacademy.project.jsontest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class JsonApplication {
    public static void main(String[] args) {
//        JsonVo jsonVo = new JsonVo("hello1", "hello2");
        Map<String, Object> data = new HashMap<>();

        data.put("msg1", "hello");
        data.put("msg2", "hello2");

        try {
            String json;
            json = new ObjectMapper().writeValueAsString(data);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
