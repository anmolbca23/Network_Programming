/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab3f {
    public static void main(String[] args) {
        String website = "www.oic.edu.np";

        String[] blacklists = {
                "zen.spamhaus.org",
                "bl.spamcop.net"
        };

        try {
            InetAddress websiteAddress = InetAddress.getByName(website);
            String ip = websiteAddress.getHostAddress();

            System.out.println("Website: " + website);
            System.out.println("IP Address: " + ip);

            String[] parts = ip.split("\\.");
            String reversedIP = parts[3] + "." + parts[2] + "." + parts[1] + "." + parts[0];

            boolean blacklisted = false;

            for (String blacklist : blacklists) {
                String query = reversedIP + "." + blacklist;

                try {
                    InetAddress.getByName(query);
                    System.out.println("Listed on: " + blacklist);
                    blacklisted = true;
                } catch (UnknownHostException e) {
                    System.out.println("Not listed on: " + blacklist);
                }
            }

            if (blacklisted) {
                System.out.println("Result: Website IP is blacklisted.");
            } else {
                System.out.println("Result: Website IP is not blacklisted.");
            }

        } catch (UnknownHostException e) {
            System.out.println("Unable to find the IP address of the website.");
        }
    }
}
