/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.vaterpolista;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Vaterpolista;
import java.util.Calendar;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author stefan
 */
public class SOUpdateVaterpolista extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Vaterpolista)) {
            throw new Exception("nije_instanca");
        }

        Vaterpolista v = (Vaterpolista) ado;

        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.YEAR, -18);
        
        if (v.getDatumRodjenja().after(cal.getTime())) {
            throw new Exception("punoletan");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
