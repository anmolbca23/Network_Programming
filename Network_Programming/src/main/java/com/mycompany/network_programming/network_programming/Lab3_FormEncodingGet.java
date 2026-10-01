/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Lab 3-7: Form Encoding and GET Requests
 * Unit 3: URLs and URIs
 * Objective: Encode form data and submit it to a server-side program using
 * an HTTP GET request.
 * Key APIs: URLEncoder.encode() / URLDecoder.decode() / x-www-form-urlencoded
 * / query string construction
 */
public class Lab3_FormEncodingGet {

    public static void main(String[] args) throws Exception {
        Map<String, String> formData = new LinkedHashMap<>();
        formData.put("name", "Orchid");
        formData.put("comment", "Hello, world! + special chars? & more");
        formData.put("lang", "en");
        
        // --- Build an x-www-form-urlencoded query string ---
        StringBuilder query = new StringBuilder();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            if (query.length() > 0) query.append('&');
            query.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8))
                .append('=')
                .append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        System.out.println("Encoded query string:");
        System.out.println("  " + query);

        String base = "http://httpbin.org/get";
        String fullUrl = base + "?" + query;
        System.out.println("\nFull GET URL:");
        System.out.println("  " + fullUrl);

        // --- Send the GET request ---
        System.out.println("\nSending GET request...");
        HttpURLConnection conn = (HttpURLConnection) new URL(fullUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        int status = conn.getResponseCode();
        System.out.println("Response code: " + status);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                status < 400 ? conn.getInputStream() : conn.getErrorStream(),
                StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } finally {
            conn.disconnect();
        }

        // --- Decode the query string back into name/value pairs ---
        System.out.println("\nDecoding query string back:");
        for (String pair : query.toString().split("&")) {
            String[] kv = pair.split("=", 2);
            String key = URLDecoder.decode(kv[0], StandardCharsets.UTF_8);
            String value = URLDecoder.decode(kv[1], StandardCharsets.UTF_8);
            System.out.println("  " + key + " = " + value);
        }
    }
}