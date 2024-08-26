/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tim;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Tim;
import domain.Igrac;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOUpdateTim extends AbstractSO {
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("nije_instanca");
        }
        
        Tim tim = (Tim) ado;

        if (tim.getIgraci().size() < 2) {
            throw new Exception("2igraca");
        }
        
        int brojGolmana = 0;
        for (Igrac igrac : tim.getIgraci()) {
            if (igrac.getPozicija().equals("Golman")) brojGolmana++;
        }
        if (brojGolmana!=1) {
            throw new Exception("golman");
        }

        ArrayList<Tim> timovi = (ArrayList<Tim>) (ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Tim timUBazi : timovi) {
            if (!timUBazi.getTimID().equals(tim.getTimID())) {
                if (timUBazi.getNazivTima().equals(tim.getNazivTima())) {
                    throw new Exception("postoji_tim");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        
        Tim t = (Tim) ado;
        DBBroker.getInstance().update(t);        
        
        if (!t.getObrisani().isEmpty()) {
            for (Igrac igrac : t.getObrisani()) {
                igrac.setTim(t);
                DBBroker.getInstance().delete(igrac);
            }
        }
        
        if (!t.getDodati().isEmpty()) {
            for (Igrac igrac : t.getDodati()) {
                igrac.setTim(t);
                DBBroker.getInstance().insert(igrac);
            }
        }
        
        
        
//        if (!t.getIzmenjeni().isEmpty()) {
//            for (Igrac igrac : t.getIzmenjeni()) {
//                igrac.setTim(t);
//                DBBroker.getInstance().update(igrac);
//            }
//        }
    }
    
}
