/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author stefan
 */
public class BrojKolaHelper extends AbstractDomainObject {
    private Turnir turnir;
    private int brojKola;

    public BrojKolaHelper() {
    }

    public BrojKolaHelper(Turnir turnir, int brojKola) {
        this.turnir = turnir;
        this.brojKola = brojKola;
    }
    
    @Override
    public String nazivTabele() {
        return "";
    }

    @Override
    public String alijas() {
        return "";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        if (rs.next()) {
            int kolo = rs.getInt("kolo");
            BrojKolaHelper brojKolaHelper = new BrojKolaHelper(turnir, kolo);
            lista.add(brojKolaHelper);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaSelect() {
        return "IFNULL(" +
               "(SELECT CAST(kolo AS UNSIGNED) FROM utakmica WHERE pobednikID = 0 AND turnirID = " + turnir.getTurnirID() + " ORDER BY CAST(kolo AS UNSIGNED) LIMIT 1), " +
               "(SELECT MAX(CAST(kolo AS UNSIGNED)) FROM utakmica WHERE turnirID = " + turnir.getTurnirID() + ")) AS kolo";
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "";
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Turnir getTurnir() {
        return turnir;
    }

    public void setTurnir(Turnir turnir) {
        this.turnir = turnir;
    }

    public int getBrojKola() {
        return brojKola;
    }

    public void setBrojKola(int brojKola) {
        this.brojKola = brojKola;
    }
    
}
