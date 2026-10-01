/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 * 1. Write a Java program using NetworkInterface to list all active network interfaces 
 * on the local system along with their display names, assigned IP addresses, and MAC addresses.
 */
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class Lab2_NetworkInterface {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface netIf = interfaces.nextElement();
                if (!netIf.isUp()) continue;

                System.out.println("Interface Name: " + netIf.getName());
                System.out.println("Display Name: " + netIf.getDisplayName());

                byte[] mac = netIf.getHardwareAddress();

                if (mac != null) {
                    StringBuilder macStr = new StringBuilder();

                    for (int i = 0; i < mac.length; i++) {
                        macStr.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address: " + macStr.toString());
                } 
//                else {
//                    System.out.println("MAC Address: Not available");
//                }

                Enumeration<InetAddress> addresses = netIf.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    System.out.println(" -> Assigned IP: " + addr.getHostAddress());
                }
                System.out.println("----------------------------------");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
