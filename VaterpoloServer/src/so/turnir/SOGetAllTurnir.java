/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.turnir;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Turnir;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOGetAllTurnir extends AbstractSO {

    private ArrayList<Turnir> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("nije_instanca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> turniri = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Turnir>) (ArrayList<?>) turniri;
    }

    public ArrayList<Turnir> getLista() {
        return lista;
    }

}
