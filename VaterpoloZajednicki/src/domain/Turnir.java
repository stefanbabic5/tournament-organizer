/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author stefan
 */
public class Turnir extends AbstractDomainObject {

    private Long turnirID;
    private String nazivTurnira;
    private Date datumPocetka;
    private Date datumKraja;
    private String tip;
    private String pobednik;
    private Grad grad;
    private Administrator administrator;
    private ArrayList<Utakmica> utakmice;
    private ArrayList<Tabela> tabela;
    
    private int koloHelper;

    public void setKoloHelper(int koloHelper) {
        this.koloHelper = koloHelper;
    }

    public int getKoloHelper() {
        return koloHelper;
    }

    public Turnir(Long turnirID, String nazivTurnira, Date datumPocetka, Date datumKraja, String tip, String pobednik, Grad grad, Administrator administrator, ArrayList<Utakmica> utakmice, ArrayList<Tabela> tabela) {
        this.turnirID = turnirID;
        this.nazivTurnira = nazivTurnira;
        this.datumPocetka = datumPocetka;
        this.datumKraja = datumKraja;
        this.tip = tip;
        this.pobednik = pobednik;
        this.grad = grad;
        this.administrator = administrator;
        this.utakmice = utakmice;
        this.tabela = tabela;
    }

    public Turnir() {
    }

    @Override
    public String nazivTabele() {
        return " Turnir ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return " JOIN GRAD G ON (T.GRADID = G.GRADID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = T.ADMINISTRATORID)";
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
                    rs.getDate("datumPocetka"), rs.getDate("datumKraja"), rs.getString("tipTurnira"),
                    rs.getString("pobednik"),g, a, null, null);

            lista.add(t);
        }

        rs.close();
        return lista;
    }
    
    @Override
    public String koloneZaSelect() {
        return " * FROM ";
    }

    @Override
    public String koloneZaInsert() {
        return " (nazivTurnira, datumPocetka, datumKraja, tipTurnira, gradID, AdministratorID, pobednik) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " turnirID = " + turnirID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivTurnira + "', '" + new java.sql.Date(datumPocetka.getTime()) + "', "
                + "'" + new java.sql.Date(datumKraja.getTime()) + "', '" + tip + "', "
                + "" + grad.getGradID() + ", " + administrator.getAdministratorID() + ", '" + pobednik + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivTurnira = '" + nazivTurnira + "', "
                + "datumPocetka = '" + new java.sql.Date(datumPocetka.getTime()) + "', "
                + "datumKraja = '" + new java.sql.Date(datumKraja.getTime()) + "', "
                + "tipTurnira = '" + tip + "', " + "Pobednik = '" + pobednik + "'";
    }

    @Override
    public String uslov() {
        if (nazivTurnira == null || nazivTurnira.isEmpty()) return "";
        else return " WHERE nazivturnira COLLATE utf8_general_ci LIKE '%" + nazivTurnira + "%' ";
    }

    public Long getTurnirID() {
        return turnirID;
    }

    public void setTurnirID(Long turnirID) {
        this.turnirID = turnirID;
    }

    public String getNazivTurnira() {
        return nazivTurnira;
    }

    public void setNazivTurnira(String nazivTurnira) {
        this.nazivTurnira = nazivTurnira;
    }

    public Date getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(Date datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public Date getDatumKraja() {
        return datumKraja;
    }

    public void setDatumKraja(Date datumKraja) {
        this.datumKraja = datumKraja;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public ArrayList<Utakmica> getUtakmice() {
        return utakmice;
    }

    public void setUtakmice(ArrayList<Utakmica> utakmice) {
        this.utakmice = utakmice;
    }

    public String getPobednik() {
        return pobednik;
    }

    public void setPobednik(String pobednik) {
        this.pobednik = pobednik;
    }

    public ArrayList<Tabela> getTabela() {
        return tabela;
    }

    public void setTabela(ArrayList<Tabela> tabela) {
        this.tabela = tabela;
    }


}
