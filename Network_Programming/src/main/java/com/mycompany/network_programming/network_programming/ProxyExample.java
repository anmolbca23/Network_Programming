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
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
//Proxy sample lab
public class ProxyExample {

    public static void main(String[] args) {
        try {
            // Replace with your actual proxy hostname or IP and port.
            SocketAddress address =
                    new InetSocketAddress("proxy.google.com", 8080);

            Proxy proxy = new Proxy(Proxy.Type.HTTP, address);

            // Connect to the target URL through the proxy.
            URL url = new URI("http://google.com").toURL();
            URLConnection conn = url.openConnection(proxy);

            conn.setConnectTimeout(10000);
            conn.setReadTimeout(10000);

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            conn.getInputStream(),
                            StandardCharsets.UTF_8))) {

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
