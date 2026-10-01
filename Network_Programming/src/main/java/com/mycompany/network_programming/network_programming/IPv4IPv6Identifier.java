/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */

// To identify whether a remote server is using IPv4 or IPv6 in Java:

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPv4IPv6Identifier{
	   public static void main(String[] args) {
		String hostName = "www.chatgpt.com";
		try{
			InetAddress inetAddress = InetAddress.getByName(hostName);
			if(inetAddress instanceof Inet4Address){
                            System.out.println("The remote server " + hostName + " is using IPv4.");
                        }else if(inetAddress instanceof Inet6Address){
			    System.out.println("The remote server " + hostName + " is using IPv6.");
			} else {
                            System.out.println("Unknown IP version.");
			}
		} catch(UnknownHostException e){
			System.err.println("Unable to resolve the hostname " + hostName);
			e.printStackTrace();
		}	
	}
    }
