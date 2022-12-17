package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 3000);
        ServerConnection serverConn = new ServerConnection(s);
        serverConn.start();
        boolean devoFareAccesso = true;
        String nome = "";

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        boolean controllo = true;
        while (controllo) {
            while (devoFareAccesso) {
                String comando = "";
                Utente u = new Utente();
                do {
                    System.out.println("vuoi accedere o registrarti? (a/r)");
                    comando = keyboard.readLine();
                } while (!(comando.equalsIgnoreCase("a") || comando.equalsIgnoreCase("r")));
                if (comando == "a") {
                    ObjectMapper om = new ObjectMapper();
                    u.setAccesso(1);
                    System.out.println("Utente:");
                    u.setNomeUtente(keyboard.readLine());
                    System.out.println("Password:");
                    u.setPassword(keyboard.readLine());
                    String utente = om.writeValueAsString(u);
                    devoFareAccesso = false;
                    out.println(utente);
                    nome = keyboard.readLine();
                } else {
                    ObjectMapper om = new ObjectMapper();
                    u.setAccesso(2);
                    System.out.println("Utente:");
                    u.setNomeUtente(keyboard.readLine());
                    System.out.println("Password:");
                    u.setPassword(keyboard.readLine());
                    String utente = om.writeValueAsString(u);
                    devoFareAccesso = false;
                    out.println(utente);
                    nome = keyboard.readLine();
                }
            }

            Messaggio m = new Messaggio();
            ObjectMapper om = new ObjectMapper();
            m.setMandante(nome);
            System.out.println("Dimmi il nome del destinatario:");
            m.setRicevente(keyboard.readLine());
            System.out.println("Contenuto:");
            m.setContenuto(keyboard.readLine());
            System.out.println("                                    io:" + m.getContenuto());
            String messaggio = om.writeValueAsString(m);
            out.println(messaggio);

        }
        out.close();
        s.close();
    }
}
