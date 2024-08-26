/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tim;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Tim;
import domain.Igrac;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOAddTim extends AbstractSO {
    
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
            if (timUBazi.getNazivTima().equals(tim.getNazivTima())) {
                throw new Exception("postoji_tim");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long timID = tableKeys.getLong(1);

        Tim tim = (Tim) ado;
        tim.setTimID(timID);

        for (Igrac igrac : tim.getIgraci()) {
            igrac.setTim(tim);
            DBBroker.getInstance().insert(igrac);
        }

    }
    
}
