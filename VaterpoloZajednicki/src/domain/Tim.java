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
public class Tim extends AbstractDomainObject {

    private Long timID;
    private String nazivTima;
    private Grad grad;
    private ArrayList<Igrac> igraci;

    public Tim(Long timID, String nazivTima, Grad grad, ArrayList<Igrac> igraci) {
        this.timID = timID;
        this.nazivTima = nazivTima;
        this.grad = grad;
        this.igraci = igraci;
    }

    public Tim() {
    }
    
    @Override
    public String toString() {
        return nazivTima;
    }

    @Override
    public String nazivTabele() {
        return " Tim ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return " JOIN GRAD G ON (G.GRADID = T.GRADID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            
            Grad g = new Grad(rs.getLong("GradID"), rs.getString("NazivGrada"));
            
            Tim t = new Tim(rs.getLong("TimID"), rs.getString("NazivTima"), g, null);

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
        return " (nazivTima, GradID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TimID = " + timID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivTima + "', " + grad.getGradID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivTima = '" + nazivTima + "', "
                + "gradID = " + grad.getGradID();
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getTimID() {
        return timID;
    }

    public void setTimID(Long timID) {
        this.timID = timID;
    }

    public String getNazivTima() {
        return nazivTima;
    }

    public void setNazivTima(String nazivTima) {
        this.nazivTima = nazivTima;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public ArrayList<Igrac> getIgraci() {
        return igraci;
    }

    public void setIgraci(ArrayList<Igrac> igraci) {
        this.igraci = igraci;
    }
    
    private ArrayList<Igrac> dodati;
    private ArrayList<Igrac> obrisani;
//    private ArrayList<Igrac> izmenjeni;

    public ArrayList<Igrac> getDodati() {
        return dodati;
    }

    public void setDodati(ArrayList<Igrac> dodati) {
        this.dodati = dodati;
    }

    public ArrayList<Igrac> getObrisani() {
        return obrisani;
    }

    public void setObrisani(ArrayList<Igrac> obrisani) {
        this.obrisani = obrisani;
    }

//    public ArrayList<Igrac> getIzmenjeni() {
//        return izmenjeni;
//    }
//
//    public void setIzmenjeni(ArrayList<Igrac> izmenjeni) {
//        this.izmenjeni = izmenjeni;
//    }

}
