package com.academy.webmelnyk;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ReqBodyToString {
    public static String getBody(HttpServletRequest request) {
        StringBuilder bodyBuilder = new StringBuilder();
        try (InputStream inputStream = request.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            char[] charBuffer = new char[128];
            int bytesRead;
            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                bodyBuilder.append(charBuffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            System.err.println("Cannot read body");
        }
        return bodyBuilder.toString();
    }

    public static Map<String, Object> jsonToMap(HttpServletRequest request) throws IOException {
        String json = getBody(request);
        ObjectMapper mapper = new ObjectMapper();
        com.fasterxml.jackson.core.type.TypeReference<HashMap<String, Object>> typeRef
                = new com.fasterxml.jackson.core.type.TypeReference<HashMap<String, Object>>() {
        };
        Map<String, Object> kvMap = mapper.readValue(json, typeRef);

        String content = (String) kvMap.get("content");
    }
}

