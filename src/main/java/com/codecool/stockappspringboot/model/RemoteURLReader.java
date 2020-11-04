package com.codecool.stockappspringboot.model;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Component
public class RemoteURLReader {

    public String readFromUrl(String endpoint) throws IOException {
        URL url = new URL("https://owlbot.info/api/v4/dictionary/hornbill?format=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "Token d9babcf6a7b2f35f7cf176123956ef6dbe4b5585");
        conn.setRequestProperty("Content-Type", "text/x-json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        String lines = reader.lines().collect(Collectors.joining("\n"));
        System.out.println(lines);
        reader.close();
        return lines;
    }
}
