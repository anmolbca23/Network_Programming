/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Lab3_FormEncoding_mine {
    public static void main(String[] args) {
        try {
            String name = "Anmol";
            String course = "BCA";

            // Form Encoding
            String data = "name=" + URLEncoder.encode(name, "UTF-8")
                    + "&course=" + URLEncoder.encode(course, "UTF-8");

            // GET Request
            URL url = new URL("https://httpbin.org/get?" + data);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            System.out.println("Encoded Data: " + data);
            System.out.println("Response Code: " + con.getResponseCode());

            con.disconnect();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}