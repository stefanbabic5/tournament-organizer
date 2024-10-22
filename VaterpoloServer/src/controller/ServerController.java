/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Administrator;
import domain.Grad;
import domain.Igrac;
import domain.Tabela;
import domain.Tim;
import domain.Turnir;
import domain.Utakmica;
import domain.Vaterpolista;
import java.util.ArrayList;
import so.administrator.SOGetAllAdministrator;
import so.grad.SOGetAllGrad;
import so.igrac.SOGetAllIgrac;
import so.login.SOLogin;
import so.tabela.SOGetAllTabela;
import so.tim.SOAddTim;
import so.tim.SODeleteTim;
import so.tim.SOGetAllTim;
import so.tim.SOUpdateTim;
import so.turnir.SOAddTurnir;
import so.turnir.SODeleteTurnir;
import so.turnir.SOGetAllTurnir;
import so.turnir.SOUpdateTurnir;
import so.utakmica.SOGetAllUtakmica;
import so.vaterpolista.SOAddVaterpolista;
import so.vaterpolista.SODeleteVaterpolista;
import so.vaterpolista.SOGetAllVaterpolista;
import so.vaterpolista.SOUpdateVaterpolista;

/**
 *
 * @author stefan
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getUlogovani();
    }

    public void addVaterpolista(Vaterpolista vaterpolista) throws Exception {
        (new SOAddVaterpolista()).templateExecute(vaterpolista);
    }
    
    public void addTurnir(Turnir turnir) throws Exception {
        (new SOAddTurnir()).templateExecute(turnir);
    }
    
    public void addTim(Tim tim) throws Exception {
        (new SOAddTim()).templateExecute(tim);
    }

    public void deleteVaterpolista(Vaterpolista vaterpolista) throws Exception {
        (new SODeleteVaterpolista()).templateExecute(vaterpolista);
    }
    
    public void deleteTurnir(Turnir turnir) throws Exception {
        (new SODeleteTurnir()).templateExecute(turnir);
    }
    
    public void deleteTim(Tim tim) throws Exception {
        (new SODeleteTim()).templateExecute(tim);
    }

    public void updateVaterpolista(Vaterpolista vaterpolista) throws Exception {
        (new SOUpdateVaterpolista()).templateExecute(vaterpolista);
    }
    
    public void updateTurnir(Turnir turnir) throws Exception {
        (new SOUpdateTurnir()).templateExecute(turnir);
    }
    
    public void updateTim(Tim tim) throws Exception {
        (new SOUpdateTim()).templateExecute(tim);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<Vaterpolista> getAllVaterpolista() throws Exception {
        SOGetAllVaterpolista so = new SOGetAllVaterpolista();
        so.templateExecute(new Vaterpolista());
        return so.getLista();
    }
    
    public ArrayList<Turnir> getAllTurnir() throws Exception {
        SOGetAllTurnir so = new SOGetAllTurnir();
        so.templateExecute(new Turnir());
        return so.getLista();
    }
    
    public ArrayList<Turnir> getAllTurnir(String parametar) throws Exception {
        SOGetAllTurnir so = new SOGetAllTurnir();
        
        Turnir t = new Turnir();
        t.setNazivTurnira(parametar);
        
        so.templateExecute(t);
        return so.getLista();
    }

    public ArrayList<Tim> getAllTim() throws Exception {
        SOGetAllTim so = new SOGetAllTim();
        so.templateExecute(new Tim());
        return so.getLista();
    }
    
    public ArrayList<Igrac> getAllIgrac() throws Exception {
        SOGetAllIgrac so = new SOGetAllIgrac();
        so.templateExecute(new Igrac());
        return so.getLista();
    }

    public ArrayList<Igrac> getAllIgrac(Tim t) throws Exception {
        SOGetAllIgrac so = new SOGetAllIgrac();
        
        Igrac i = new Igrac();
        i.setTim(t);
        
        so.templateExecute(i);
        return so.getLista();
    }

    public ArrayList<Grad> getAllGrad() throws Exception {
        SOGetAllGrad so = new SOGetAllGrad();
        so.templateExecute(new Grad());
        return so.getLista();
    }

    public ArrayList<Utakmica> getAllUtakmica(Turnir t) throws Exception {
        SOGetAllUtakmica so = new SOGetAllUtakmica();
        
        Utakmica u = new Utakmica();
        u.setTurnir(t);
        
        so.templateExecute(u);
        return so.getLista();
    }
    
    public ArrayList<Tabela> getAllTabela(Turnir t) throws Exception {
        SOGetAllTabela so = new SOGetAllTabela();
        
        Tabela st = new Tabela();
        st.setTurnir(t);
        
        so.templateExecute(st);
        return so.getLista();
    }

}
