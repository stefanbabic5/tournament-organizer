/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tim;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Tim;
import java.util.ArrayList;
import java.util.ResourceBundle;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOGetAllTim extends AbstractSO {

    private ArrayList<Tim> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tim)) {
            throw new Exception("nije_instanca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> timovi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Tim>) (ArrayList<?>) timovi;
    }

    public ArrayList<Tim> getLista() {
        return lista;
    }

}
