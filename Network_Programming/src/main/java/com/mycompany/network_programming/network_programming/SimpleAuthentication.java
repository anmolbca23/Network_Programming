/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.network_programming.network_programming;

/**
 *
 * @author ACER
 */

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.Arrays;
public class SimpleAuthentication {
    public static void main(String[] args) throws Exception {
        final PasswordAuthentication[] login =
                new PasswordAuthentication[1];
        // Display the login dialog on the Swing thread.
        SwingUtilities.invokeAndWait(() -> {
            JTextField username = new JTextField(15);
            JPasswordField password = new JPasswordField(15);
            Object[] fields = {
                "Username:", username,
                "Password:", password
            };
            int choice = JOptionPane.showConfirmDialog(
                    null, fields, "Login",
                    JOptionPane.OK_CANCEL_OPTION
            );
            char[] secret = password.getPassword();
            if (choice == JOptionPane.OK_OPTION) {
                login[0] = new PasswordAuthentication(
                        username.getText(), secret);
            }
            Arrays.fill(secret, '\0');
            password.setText("");
        });
        if (login[0] == null) {
            return; // User canceled.
        }
        // Supply credentials when the intended server requests them.
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                if (getRequestorType() == RequestorType.SERVER
                        && "httpbin.org".equalsIgnoreCase(getRequestingHost())
                        && "https".equalsIgnoreCase(getRequestingProtocol())
                        && getRequestingPort() == 443
                        && "basic".equalsIgnoreCase(getRequestingScheme())) {
                    return login[0];
                }
                return null;
            }
        });

        // URL url = new URI(
        //         "https://httpbin.org/basic-auth/user/passwd"
        // ).toURL();
        URL url = new URI(
        "https://httpbin.org/basic-auth/admin/admin"
        ).toURL();

        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}