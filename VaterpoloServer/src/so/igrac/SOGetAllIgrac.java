/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.igrac;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Igrac;
import java.util.ArrayList;
import java.util.ResourceBundle;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOGetAllIgrac extends AbstractSO {

    private ArrayList<Igrac> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Igrac)) {
            throw new Exception("nije_instanca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> igraci = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Igrac>) (ArrayList<?>) igraci;
    }

    public ArrayList<Igrac> getLista() {
        return lista;
    }

}
