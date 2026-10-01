/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */
//2. Write a program to Decompose a URL into its component parts and compare two URLs for equality.

import java.net.MalformedURLException;
import java.net.URL;

/**
 *  
 * Lab 2: Splitting and Comparing URLs
 *
 * Key APIs: getProtocol()/getHost()/getPort()/getPath()/getQuery(),
 * URL.equals(), URL.sameFile()
 */
public class Lab2_SplitCompareURLS {

    public static void main(String[] args) throws MalformedURLException {
        String urlA = args.length > 0 ? args[0] : "https://www.example.com:8443/path/page.html?id=42&lang=en";
        String urlB = args.length > 1 ? args[1] : "https://www.example.com:8443/path/page.html?id=42&lang=en#section2";

        URL a = new URL(urlA);
        URL b = new URL(urlB);

        System.out.println("Splitting: " + a);
        printParts(a);

        System.out.println("\nSplitting: " + b);
        printParts(b);

        System.out.println("\nComparison");
        System.out.println("----------------------------------------");
        // equals() resolves hostnames (DNS lookup!) and compares all fields, INCLUDING the ref/fragment.
        System.out.println("a.equals(b):   " + a.equals(b));
        // sameFile() compares everything EXCEPT the ref/fragment - this is usually what
        // you actually want when checking "is this the same resource".
        System.out.println("a.sameFile(b): " + a.sameFile(b));
        System.out.println("(equals() differs from sameFile() only in the fragment portion;");
        System.out.println(" equals() also triggers a DNS lookup to compare hosts by IP address.)");
    }

    private static void printParts(URL url) {
        System.out.println("  Protocol: " + url.getProtocol());
        System.out.println("  Host:     " + url.getHost());
        System.out.println("  Port:     " + (url.getPort() == -1 ? url.getDefaultPort() + " (default)" : url.getPort()));
        System.out.println("  Path:     " + url.getPath());
        System.out.println("  Query:    " + url.getQuery());
        System.out.println("  Ref:      " + url.getRef());
    }
}