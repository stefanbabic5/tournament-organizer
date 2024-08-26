/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author stefan
 */
public class StavkaIzvestaja implements Serializable {
    private Long turnirID;
    private String kolo;
    private String prviTim;
    private String rezultat;
    private String drugiTim;

    public StavkaIzvestaja() {
    }

    public StavkaIzvestaja( String kolo, String prviTim, String rezultat, String drugiTim) {
        
        this.kolo = kolo;
        this.prviTim = prviTim;
        this.rezultat = rezultat;
        this.drugiTim = drugiTim;
    }

    public String getDrugiTim() {
        return drugiTim;
    }

    public void setDrugiTim(String drugiTim) {
        this.drugiTim = drugiTim;
    }

    public String getPrviTim() {
        return prviTim;
    }

    public void setPrviTim(String prviTim) {
        this.prviTim = prviTim;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public Long getTurnirID() {
        return turnirID;
    }

    public void setTurnirID(Long turnirID) {
        this.turnirID = turnirID;
    }

    public String getKolo() {
        return kolo;
    }

    public void setKolo(String kolo) {
        this.kolo = kolo;
    }
    
    
}
