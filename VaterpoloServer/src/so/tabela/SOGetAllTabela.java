/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.tabela;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Tabela;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOGetAllTabela extends AbstractSO {

    private ArrayList<Tabela> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Tabela)) {
            throw new Exception("nije_instanca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> tabele = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Tabela>) (ArrayList<?>) tabele;
    }

    public ArrayList<Tabela> getLista() {
        return lista;
    }
}
