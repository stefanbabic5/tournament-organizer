/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.grad;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Grad;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOGetAllGrad extends AbstractSO {

    private ArrayList<Grad> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Grad)) {
            throw new Exception("nije_instanca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> gradovi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Grad>) (ArrayList<?>) gradovi;
        lista.remove(0);
    }

    public ArrayList<Grad> getLista() {
        return lista;
    }

}
