package com;

public class Utente {

    private String nomeUtente;
    private String password;
    private int accesso;

    public Utente(String nomeUtente, String password, int accesso) {

        this.nomeUtente = nomeUtente;
        this.password = password;
        this.accesso = accesso;

    }

    public Utente() {
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccesso() {
        return accesso;
    }

    public void setAccesso(int accesso) {
        this.accesso = accesso;
    }
}
