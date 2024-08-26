/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.utakmica;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Utakmica;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOGetAllUtakmica extends AbstractSO {

    private ArrayList<Utakmica> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Utakmica)) {
            throw new Exception("nije_instanca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> utakmice = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Utakmica>) (ArrayList<?>) utakmice;
    }

    public ArrayList<Utakmica> getLista() {
        return lista;
    }

}
