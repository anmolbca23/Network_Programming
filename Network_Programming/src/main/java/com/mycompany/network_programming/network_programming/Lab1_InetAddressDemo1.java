/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.network_programming.network_programming;
/*
Lab1-a wap in java using InetAddress to determine the ip address,
host name and reachability status of a target 
remote host(eg. [www.google.com](https://www.google.com)) 
as well as the local machine.
*/
/**
 *
 * @author ACER
 */
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab1_InetAddressDemo1 {
    public static void main(String[] args) {
        try {
            // Local host information
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(":-Local Host Name: " + localHost.getHostName());
            System.out.println(":-Local Host Address: " + localHost.getHostAddress());

            // Remote host information
            String domain = "www.google.com";
            InetAddress remoteHost = InetAddress.getByName(domain);
            System.out.println("\nRemote Host Name: " + remoteHost.getHostName());
            System.out.println("Remote Host Address: " + remoteHost.getHostAddress());
            System.out.println("Is Reachable(3s timeout)? " + remoteHost.isReachable(3000));

            // All IP addresses for the domain
            System.out.println("\nAll IP addresses for " + domain + ":");
            InetAddress[] addresses = InetAddress.getAllByName(domain);

            for (InetAddress addr : addresses) {
                System.out.println("- " + addr.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.err.println("Error: Host could not be resolved - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O Error checking host reachability - " + e.getMessage());
        }
    }
}