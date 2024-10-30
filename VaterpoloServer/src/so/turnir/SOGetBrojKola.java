/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.turnir;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Turnir;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOGetBrojKola extends AbstractSO {
    
    private int broj;
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Turnir)) {
            throw new Exception("nije_instanca");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Turnir t = (Turnir) ado;
        broj = DBBroker.getInstance().getBrojKola(t);
    }

    public int getBroj() {
        return broj;
    }
    
}
