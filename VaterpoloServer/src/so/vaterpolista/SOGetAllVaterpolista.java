/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vaterpolista;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Vaterpolista;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOGetAllVaterpolista extends AbstractSO {

    private ArrayList<Vaterpolista> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Vaterpolista)) {
            throw new Exception("nije_instanca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> listaVaterpolista = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Vaterpolista>) (ArrayList<?>) listaVaterpolista;
    }

    public ArrayList<Vaterpolista> getLista() {
        return lista;
    }

}
