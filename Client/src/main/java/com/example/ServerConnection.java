package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection extends Thread {

    private Socket s;
    BufferedReader in;

    public ServerConnection(Socket s) {
        this.s = s;
        try {
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        String risposta = "";
        boolean controllo = true;
        while (controllo) {
            try {
                risposta = in.readLine();
                System.out.println("                                    " + risposta);
            } catch (Exception e) {
                System.out.println(risposta);
                controllo = false;
            }
        }
    }

}