/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public class Lab3_HttpHeadersDemo {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.oic.edu.np");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        con.setRequestMethod("GET");
        System.out.println("Status code: " + con.getResponseCode());
        System.out.println("Status Msg: " + con.getResponseMessage());
        System.out.println("Content Type: " + con.getContentType());
        
        System.out.println("\nHTTP Response Headers:");
        System.out.println("-------------------------");
        
        for(Map.Entry<String, List<String>> entry:
                con.getHeaderFields().entrySet()){
        
                System.out.println(
                        entry.getKey() + " : " + entry.getValue()
                );
        }
        con.disconnect();
    }
}
