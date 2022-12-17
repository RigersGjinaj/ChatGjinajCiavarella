package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GestioneClient extends Thread {

    private Socket s;
    private List<GestioneClient> collegati;
    private static ArrayList<Utente> utenti = new ArrayList<>();
    private boolean controllo = false;

    PrintWriter pr;
    BufferedReader br;

    public GestioneClient(Socket s, List<GestioneClient> collegati) {
        this.s = s;
        this.collegati = collegati;
        try {
            pr = new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {

        try {
            String risposta = br.readLine();
            ObjectMapper om = new ObjectMapper();
            Utente u = om.readValue(risposta, Utente.class);

            if (u.getAccesso() == 1) {
                for (int i = 0; i < utenti.size(); i++) {
                    if (utenti.get(i).getNomeUtente().equals(u.getNomeUtente())
                            && utenti.get(i).getPassword().equals(u.getPassword())) {
                        controllo = true;
                        this.setName(u.getNomeUtente());
                        break;
                    } else {
                        pr.println("Accesso negato,nome utente o password sbagliare, riavviare il client");
                        s.close();
                    }
                }
            } else if (u.getAccesso() == 2) {
                if (utenti.size() == 0) {
                    Utente nuovo = new Utente();
                    nuovo.setNomeUtente(u.getNomeUtente());
                    this.setName(u.getNomeUtente());
                    nuovo.setPassword(u.getPassword());
                    utenti.add(nuovo);
                    controllo = true;
                } else {
                    Boolean condition = true;
                    while (condition) {
                        for (int i = 0; i < utenti.size(); i++) {
                            if (utenti.get(i).getNomeUtente().equalsIgnoreCase(u.getNomeUtente())) {
                                pr.println("Registrazione negato,nome utente già esistente, riavviare il client");
                                s.close();
                            } else {
                                condition = false;
                                break;
                            }
                        }

                        if (condition == false) {
                            Utente nuovo = new Utente();
                            nuovo.setNomeUtente(u.getNomeUtente());
                            this.setName(u.getNomeUtente());
                            nuovo.setPassword(u.getPassword());
                            utenti.add(nuovo);
                            controllo = true;
                        }
                    }
                }
            }

            while (controllo) {
                String messaggio = br.readLine();
                Messaggio m = om.readValue(messaggio, Messaggio.class);

                if (m.getRicevente().equals("all")) {
                    for (GestioneClient collegato : collegati) {
                        if (!collegato.getName().equals(this.getName())) {
                            collegato.pr.println(this.getName() + ":" + m.getContenuto());
                        }
                    }
                }
                if (!m.getRicevente().equals("all")) {
                    for (int i = 0; i < collegati.size(); i++) {
                        if (collegati.get(i).getName().equals(m.getRicevente())) {
                            collegati.get(i).pr.println(this.getName() + ":" + m.getContenuto());
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
