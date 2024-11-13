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
public class Vaterpolista extends AbstractDomainObject {

    private Long vaterpolistaID;
    private String imeVaterpoliste;
    private String prezimeVaterpoliste;
    private Date datumRodjenja;

    public Vaterpolista(Long vaterpolistaID, String imeVaterpoliste, String prezimeVaterpoliste, Date datumRodjenja) {
        this.vaterpolistaID = vaterpolistaID;
        this.imeVaterpoliste = imeVaterpoliste;
        this.prezimeVaterpoliste = prezimeVaterpoliste;
        this.datumRodjenja = datumRodjenja;
    }

    public Vaterpolista() {
    }

    @Override
    public String toString() {
        return imeVaterpoliste + " " + prezimeVaterpoliste;
    }
    
    @Override
    public String nazivTabele() {
        return " Vaterpolista ";
    }

    @Override
    public String alijas() {
        return " v ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Vaterpolista v = new Vaterpolista(rs.getLong("VaterpolistaID"),
                    rs.getString("ImeVaterpoliste"), rs.getString("PrezimeVaterpoliste"),
                    rs.getDate("DatumRodjenja"));

            lista.add(v);
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
        return " (ImeVaterpoliste, PrezimeVaterpoliste, DatumRodjenja) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " VaterpolistaID = " + vaterpolistaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imeVaterpoliste + "', '" + prezimeVaterpoliste + "', "
                + "'" + new java.sql.Date(datumRodjenja.getTime()) + "' ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " imeVaterpoliste = '" + imeVaterpoliste + "', "
                + "prezimeVaterpoliste = '" + prezimeVaterpoliste + "', "
                + "datumRodjenja = '" + new java.sql.Date(datumRodjenja.getTime()) + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getVaterpolistaID() {
        return vaterpolistaID;
    }

    public void setVaterpolistaID(Long vaterpolistaID) {
        this.vaterpolistaID = vaterpolistaID;
    }

    public String getImeVaterpoliste() {
        return imeVaterpoliste;
    }

    public void setImeVaterpoliste(String imeVaterpoliste) {
        this.imeVaterpoliste = imeVaterpoliste;
    }

    public String getPrezimeVaterpoliste() {
        return prezimeVaterpoliste;
    }

    public void setPrezimeVaterpoliste(String prezimeVaterpoliste) {
        this.prezimeVaterpoliste = prezimeVaterpoliste;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

}
