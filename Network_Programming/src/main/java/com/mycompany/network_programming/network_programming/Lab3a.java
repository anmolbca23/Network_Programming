/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */
import java.net.URI;
import java.util.Scanner;

public class Lab3a {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter base URI (e.g. https://example.com/a/b/): ");
            URI base = new URI(sc.nextLine().trim());

            System.out.println("Enter relative URI (e.g. ../c/): ");
            URI relative = new URI(sc.nextLine().trim());

            URI resolved = base.resolve(relative);

            System.out.println("Base: " + base);
            System.out.println("Relative: " + relative);
            System.out.println("Resolved: " + resolved);

            System.out.println("\nEnter another absolute URI to relativize against base: ");
            URI target = new URI(sc.nextLine().trim());

            System.out.println("Relativized: " + base.relativize(target));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
