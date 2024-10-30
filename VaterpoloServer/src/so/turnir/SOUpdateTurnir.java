/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.turnir;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Tabela;
import domain.Turnir;
import domain.Utakmica;
import java.util.ArrayList;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOUpdateTurnir extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("nije_instanca");
        }

        Turnir turnir = (Turnir) ado;

        ArrayList<Turnir> turniri = (ArrayList<Turnir>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Turnir turnirUBazi : turniri) {
            if (!turnirUBazi.getTurnirID().equals(turnir.getTurnirID())) {
                if (turnirUBazi.getNazivTurnira().equals(turnir.getNazivTurnira())) {
                    throw new Exception("postoji_turnir");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        DBBroker.getInstance().update(ado);

        Turnir t = (Turnir) ado;

        for (Utakmica utakmica : t.getUtakmice()) {
            DBBroker.getInstance().update(utakmica);
        }
        
        for (Tabela st : t.getTabela()) {
            DBBroker.getInstance().update(st);
        }

    }

}
