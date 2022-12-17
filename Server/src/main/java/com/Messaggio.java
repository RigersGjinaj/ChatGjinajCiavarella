package com;

public class Messaggio {
    private String ricevente;
    private String mandante;
    private String contenuto;

    public String getContenuto() {
        return contenuto;
    }

    public String getRicevente() {
        return ricevente;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public void setRicevente(String ricevente) {
        this.ricevente = ricevente;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public Messaggio() {

    }

    public Messaggio(String r, String c, String m) {
        ricevente = r;
        contenuto = c;
        mandante = m;
    }
}