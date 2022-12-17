package com;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<GestioneClient> collegati = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("Server in ascolto");
            for (;;) {
                Socket s = ss.accept();
                System.out.println("Client connesso");
                GestioneClient g = new GestioneClient(s, collegati);
                collegati.add(g);
                g.start();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}