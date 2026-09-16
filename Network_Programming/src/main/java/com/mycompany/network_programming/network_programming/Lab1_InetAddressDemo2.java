/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 * lab1-b write a program in java using InetAddress to determine the IP address,
   host name,interface name and mac address.
 
 * 
 */
import java.net.NetworkInterface;
import java.net.InetAddress;
import java.util.Enumeration;

public class Lab1_InetAddressDemo2 {
    public static void main(String[] args) {
        try{
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while(interfaces.hasMoreElements()){
                NetworkInterface netIf = interfaces.nextElement();
                if(!netIf.isUp()) continue;
                
                System.out.println("Interface Name: "+ netIf.getName());
                System.out.println("Display Name: "+ netIf.getDisplayName());
                
                byte[] mac = netIf.getHardwareAddress();
                if (mac != null){
                    StringBuilder macStr = new StringBuilder();
                    for(int i=0; i< mac.length; i++){
                        macStr.append(String.format("%02X%s", mac[i], (i < mac.length -1)? "-": ""));
                    }
                    System.out.println("MAC Address: "+ macStr.toString());
                    
                    Enumeration<InetAddress> addresses = netIf.getInetAddresses();
                    while(addresses.hasMoreElements()){
                        InetAddress addr = addresses.nextElement();
                        System.out.println(" -> Assigned IP: "+ addr.getHostAddress());
                    }
                    System.out.println("------------------------------------------------");   
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
// for output only 3 is sufficient:)
