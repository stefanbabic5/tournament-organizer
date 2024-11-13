/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Administrator;
import domain.BrojKolaHelper;
import domain.Grad;
import domain.Igrac;
import domain.StavkaIzvestaja;
import domain.Tabela;
import domain.Tim;
import domain.Turnir;
import domain.Utakmica;
import domain.Vaterpolista;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author stefan
 */
public class ClientController {

    private static ClientController instance;

    private ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception {
        return (Administrator) sendRequest(Operation.LOGIN, administrator);
    }

    public void addVaterpolista(Vaterpolista vaterpolista) throws Exception {
        sendRequest(Operation.ADD_VATERPOLISTA, vaterpolista);
    }

    public void addTurnir(Turnir turnir) throws Exception {
        sendRequest(Operation.ADD_TURNIR, turnir);
    }

    public void addTim(Tim tim) throws Exception {
        sendRequest(Operation.ADD_TIM, tim);
    }

    public void deleteTurnir(Turnir turnir) throws Exception {
        sendRequest(Operation.DELETE_TURNIR, turnir);
    }

    public void deleteVaterpolista(Vaterpolista vaterpolista) throws Exception {
        sendRequest(Operation.DELETE_VATERPOLISTA, vaterpolista);
    }

    public void deleteTim(Tim tim) throws Exception {
        sendRequest(Operation.DELETE_TIM, tim);
    }

    public void updateVaterpolista(Vaterpolista vaterpolista) throws Exception {
        sendRequest(Operation.UPDATE_VATERPOLISTA, vaterpolista);
    }

    public void updateTurnir(Turnir turnir) throws Exception {
        sendRequest(Operation.UPDATE_TURNIR, turnir);
    }

    public void updateTim(Tim tim) throws Exception {
        sendRequest(Operation.UPDATE_TIM, tim);
    }

    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        return (ArrayList<Administrator>) sendRequest(Operation.GET_ALL_ADMINISTRATOR, null);
    }

    public ArrayList<Turnir> getAllTurnir() throws Exception {
        return (ArrayList<Turnir>) sendRequest(Operation.GET_ALL_TURNIR, null);
    }

    public ArrayList<Turnir> getAllTurnir(String parametar) throws Exception {
        return (ArrayList<Turnir>) sendRequest(Operation.GET_ALL_TURNIR, parametar);
    }

    public ArrayList<Vaterpolista> getAllVaterpolista() throws Exception {
        return (ArrayList<Vaterpolista>) sendRequest(Operation.GET_ALL_VATERPOLISTA, null);
    }

    public ArrayList<Tim> getAllTim() throws Exception {
        return (ArrayList<Tim>) sendRequest(Operation.GET_ALL_TIM, null);
    }

    public ArrayList<Igrac> getAllIgrac() throws Exception {
        return (ArrayList<Igrac>) sendRequest(Operation.GET_ALL_IGRAC, null);
    }

    public ArrayList<Igrac> getAllIgrac(Tim t) throws Exception {
        return (ArrayList<Igrac>) sendRequest(Operation.GET_ALL_IGRAC, t);
    }

    public ArrayList<Grad> getAllGrad() throws Exception {
        return (ArrayList<Grad>) sendRequest(Operation.GET_ALL_GRAD, null);
    }

    public ArrayList<Utakmica> getAllUtakmica(Turnir t) throws Exception {
        return (ArrayList<Utakmica>) sendRequest(Operation.GET_ALL_UTAKMICA, t);
    }

    public ArrayList<Tabela> getAllTabela(Turnir t) throws Exception {
        return (ArrayList<Tabela>) sendRequest(Operation.GET_ALL_TABELA, t);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request request = new Request(operation, data);

        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(request);

        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response response = (Response) in.readObject();

        if (response.getResponseStatus().equals(ResponseStatus.Error)) {
            throw response.getException();
        } else {
            return response.getData();
        }

    }

    public int getBrojKola(BrojKolaHelper bkh) throws Exception {
        return (int) sendRequest(Operation.GET_BROJ_KOLA, bkh);
    }

}
