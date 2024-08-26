/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.turnir;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Turnir;
import domain.Utakmica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOAddTurnir extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("nije_instanca");
        }

        Turnir turnir = (Turnir) ado;

        if (turnir.getUtakmice().size() < 3) {
            throw new Exception("3tima");
        }

        ArrayList<Turnir> turniri = (ArrayList<Turnir>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Turnir turnirUBazi : turniri) {
            if (turnirUBazi.getNazivTurnira().equals(turnir.getNazivTurnira())) {
                throw new Exception("postoji_turnir");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        PreparedStatement ps = DBBroker.getInstance().insert(ado);

        ResultSet tableKeys = ps.getGeneratedKeys();
        tableKeys.next();
        Long turnirID = tableKeys.getLong(1);

        Turnir turnir = (Turnir) ado;
        turnir.setTurnirID(turnirID);

        for (Utakmica utakmica : turnir.getUtakmice()) {
            utakmica.setTurnir(turnir);
            DBBroker.getInstance().insert(utakmica);
        }

    }

}
