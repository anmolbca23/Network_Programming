/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Lab3e {
    public static void main(String[] args) {
        String imageUrl = "https://www.oic.edu.np/wp-content/uploads/2020/05/logo.png";
        String outputFile = "orchid.jpg";

        try {
            URL url = new URL(imageUrl);
            InputStream inputStream = url.openStream();
            FileOutputStream outputStream = new FileOutputStream(outputFile);

            int bytesRead;
            byte[] buffer = new byte[4096];

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("Image downloaded successfully");
            System.out.println("Saved as: " + outputFile);
            System.out.println("Absolute path: " + new File(outputFile).getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Download failed: " + e.getMessage());
        }
    }
}