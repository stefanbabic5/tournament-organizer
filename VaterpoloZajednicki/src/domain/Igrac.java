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
public class Igrac extends AbstractDomainObject {

    private Tim tim;
    private int brojKapice;
    private String pozicija;
    private Vaterpolista vaterpolista;

    public Igrac(Tim tim, int brojKapice, String pozicija, Vaterpolista vaterpolista) {
        this.tim = tim;
        this.brojKapice = brojKapice;
        this.pozicija = pozicija;
        this.vaterpolista = vaterpolista;
    }

    public Igrac() {
    }

    @Override
    public String toString() {
        return vaterpolista.getImeVaterpoliste() + ' ' + vaterpolista.getPrezimeVaterpoliste();
    }

    @Override
    public String nazivTabele() {
        return " Igrac ";
    }

    @Override
    public String alijas() {
        return " i ";
    }

    @Override
    public String join() {
        return " JOIN VATERPOLISTA V ON (V.VATERPOLISTAID = I.VATERPOLISTAID) "
                + "JOIN TIM T ON (T.TIMID = I.TIMID) "
                + "JOIN GRAD G ON (G.GRADID = T.GRADID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Grad g = new Grad(rs.getLong("GradID"), rs.getString("NazivGrada"));
            
            Tim t = new Tim(rs.getLong("TimID"), rs.getString("NazivTima"), g, null);
            
            Vaterpolista v = new Vaterpolista(rs.getLong("VaterpolistaID"),
                    rs.getString("ImeVaterpoliste"), rs.getString("PrezimeVaterpoliste"),
                    rs.getDate("DatumRodjenja"));
            
            Igrac i = new Igrac(t, rs.getInt("brojKapice"), rs.getString("pozicija"), v);

            lista.add(i);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (timID, brojKapice, pozicija, vaterpolistaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TimID = " + tim.getTimID() + " AND BrojKapice = " + brojKapice;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + tim.getTimID() + ", " + brojKapice + ", "
                + " '" + pozicija + "', " + vaterpolista.getVaterpolistaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        if (tim == null) return "";
        return " WHERE T.TIMID = " + tim.getTimID();
    }

    public Tim getTim() {
        return tim;
    }

    public void setTim(Tim tim) {
        this.tim = tim;
    }

    public int getBrojKapice() {
        return brojKapice;
    }

    public void setBrojKapice(int brojKapice) {
        this.brojKapice = brojKapice;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public Vaterpolista getVaterpolista() {
        return vaterpolista;
    }

    public void setVaterpolista(Vaterpolista vaterpolista) {
        this.vaterpolista = vaterpolista;
    }

}
