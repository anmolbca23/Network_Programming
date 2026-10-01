/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */
//: 4. Download Web Page Content Using URL
import java.io.*;
import java.net.*;

public class  Lab3d{
    public static void main(String[] args) {
        try {
            URL url = new URL("https://example.com");
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
//                    System.out.println(line);
                        System.out.println(line.replace("><", ">\n<"));

                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}