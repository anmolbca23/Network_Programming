/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */
import java.net.*;

public class Lab3c {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("https://example.com/docs/index.html?unit=3#top");

        System.out.println("Scheme: " + uri.getScheme());
        System.out.println("Host: " + uri.getHost());
        System.out.println("Path: " + uri.getPath());
        System.out.println("Query: " + uri.getQuery());
        System.out.println("Fragment: " + uri.getFragment());

        URL url = uri.toURL();
        System.out.println("URL: " + url);
    }
}