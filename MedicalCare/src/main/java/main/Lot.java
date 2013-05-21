/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Katia
 */
public class Lot {
    private String numero;
    private String date;

    public Lot(String numero, String date) {
        this.numero = numero;
        this.date = date;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
