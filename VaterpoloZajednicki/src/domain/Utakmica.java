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
public class Utakmica extends AbstractDomainObject {

    private Turnir turnir;
    private int rbUtakmice;
    private String kolo;
    private Integer brojGolovaPrviTim;
    private Integer brojGolovaDrugiTim;
    private Tim prviTim;
    private Tim drugiTim;
    private Tim pobednik;
    private Integer penaliPrvi;
    private Integer penaliDrugi;

    public Utakmica() {
    }

    public Utakmica(Turnir turnir, int rbUtakmice, String kolo, Integer brojGolovaPrviTim, Integer brojGolovaDrugiTim, Tim prviTim, Tim drugiTim, Tim pobednik, Integer penaliPrvi, Integer penaliDrugi) {
        this.turnir = turnir;
        this.rbUtakmice = rbUtakmice;
        this.kolo = kolo;
        this.brojGolovaPrviTim = brojGolovaPrviTim;
        this.brojGolovaDrugiTim = brojGolovaDrugiTim;
        this.prviTim = prviTim;
        this.drugiTim = drugiTim;
        this.pobednik = pobednik;
        this.penaliPrvi = penaliPrvi;
        this.penaliDrugi = penaliDrugi;
    }

    @Override
    public String nazivTabele() {
        return " Utakmica ";
    }

    @Override
    public String alijas() {
        return " u ";
    }

    @Override
    public String join() {
        return " JOIN TURNIR T ON (T.TURNIRID = U.TURNIRID) "
                + "JOIN GRAD G ON (T.GRADID = G.GRADID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID) "
                + "JOIN TIM PRVITIM ON (PRVITIM.TIMID = U.PRVITIMID) "
                + "JOIN GRAD PRVIGRAD ON (PRVIGRAD.GRADID = PRVITIM.GRADID) "
                + "JOIN TIM DRUGITIM ON (DRUGITIM.TIMID = U.DRUGITIMID) "
                + "JOIN GRAD DRUGIGRAD ON (DRUGIGRAD.GRADID = DRUGITIM.GRADID) "
                + "JOIN TIM POBEDNIK ON (POBEDNIK.TIMID = U.POBEDNIKID) "
                + "JOIN GRAD POBEDNIKGRAD ON (POBEDNIKGRAD.GRADID = POBEDNIK.GRADID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            Grad g = new Grad(rs.getLong("GradID"), rs.getString("NazivGrada"));

            Turnir t = new Turnir(rs.getLong("turnirID"), rs.getString("nazivTurnira"),
                    rs.getDate("datumPocetka"), rs.getDate("datumKraja"), rs.getString("slobodanProlaz"),
                    rs.getString("pobednik"), g, a, null);

            Grad prviGrad = new Grad(rs.getLong("prviGrad.GradID"),
                    rs.getString("prviGrad.NazivGrada"));

            Tim prviTim = new Tim(rs.getLong("prviTim.TimID"),
                    rs.getString("prviTim.NazivTima"), prviGrad, null);

            Grad drugiGrad = new Grad(rs.getLong("drugiGrad.GradID"),
                    rs.getString("drugiGrad.NazivGrada"));

            Tim drugiTim = new Tim(rs.getLong("drugiTim.TimID"),
                    rs.getString("drugiTim.NazivTima"), drugiGrad, null);
            
            Grad pobednikGrad = new Grad(rs.getLong("pobednikGrad.GradID"),
                    rs.getString("pobednikGrad.NazivGrada"));
            
            Tim pobednik = new Tim(rs.getLong("pobednik.TimID"),
                    rs.getString("pobednik.NazivTima"), pobednikGrad, null);

            Utakmica u = new Utakmica(t, rs.getInt("rbUtakmice"), rs.getString("kolo"),
                    rs.getInt("brojGolovaPrviTim"), rs.getInt("brojGolovaDrugiTim"),
                    prviTim, drugiTim, pobednik, rs.getInt("penaliPrvi"), rs.getInt("penaliDrugi"));

            lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (turnirID, rbUtakmice, kolo, prviTimID, brojGolovaPrviTim, brojGolovaDrugiTim, drugiTimID, pobednikID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " turnirID = " + turnir.getTurnirID() + " and kolo = '" + kolo + "' and rbUtakmice = " + rbUtakmice;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + turnir.getTurnirID() + ", " + rbUtakmice + ", "
                + " '" + kolo + "', " + prviTim.getTimID() + ", " + brojGolovaPrviTim + 
                ", " + brojGolovaDrugiTim + ", " + drugiTim.getTimID() + ", " + pobednik.getTimID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "PrviTimID = " + prviTim.getTimID() + ", BrojGolovaPrviTim = " + brojGolovaPrviTim + 
                ", BrojGolovaDrugiTim = " + brojGolovaDrugiTim + ", DrugiTimID = " + drugiTim.getTimID() +
                ", PobednikID = " + pobednik.getTimID() + ", PenaliPrvi = " + penaliPrvi + ", PenaliDrugi = " + penaliDrugi;
    }

    @Override
    public String uslov() {
        return " WHERE T.TURNIRID = " + turnir.getTurnirID() + " ORDER BY u.turnirid, u.kolo, u.rbutakmice";
    }

    public String getKolo() {
        return kolo;
    }

    public void setKolo(String kolo) {
        this.kolo = kolo;
    }

    public Tim getPobednik() {
        return pobednik;
    }

    public void setPobednik(Tim pobednik) {
        this.pobednik = pobednik;
    }

    public Turnir getTurnir() {
        return turnir;
    }

    public void setTurnir(Turnir turnir) {
        this.turnir = turnir;
    }

    public int getRbUtakmice() {
        return rbUtakmice;
    }

    public void setRbUtakmice(int rbUtakmice) {
        this.rbUtakmice = rbUtakmice;
    }

    public Integer getBrojGolovaPrviTim() {
        return brojGolovaPrviTim;
    }

    public void setBrojGolovaPrviTim(Integer brojGolovaPrviTim) {
        this.brojGolovaPrviTim = brojGolovaPrviTim;
    }

    public Integer getBrojGolovaDrugiTim() {
        return brojGolovaDrugiTim;
    }

    public void setBrojGolovaDrugiTim(Integer brojGolovaDrugiTim) {
        this.brojGolovaDrugiTim = brojGolovaDrugiTim;
    }

    public Tim getPrviTim() {
        return prviTim;
    }

    public void setPrviTim(Tim prviTim) {
        this.prviTim = prviTim;
    }

    public Tim getDrugiTim() {
        return drugiTim;
    }

    public void setDrugiTim(Tim drugiTim) {
        this.drugiTim = drugiTim;
    }

    public Integer getPenaliPrvi() {
        return penaliPrvi;
    }

    public void setPenaliPrvi(Integer penaliPrvi) {
        this.penaliPrvi = penaliPrvi;
    }

    public Integer getPenaliDrugi() {
        return penaliDrugi;
    }

    public void setPenaliDrugi(Integer penaliDrugi) {
        this.penaliDrugi = penaliDrugi;
    }

    
}
