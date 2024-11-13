/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.BrojKolaHelper;
import domain.Tim;
import domain.Turnir;
import domain.Vaterpolista;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import transfer.Request;
import transfer.Response;
import transfer.util.ResponseStatus;
import transfer.util.Operation;

/**
 *
 * @author stefan
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (IOException | ClassNotFoundException e) {
            if (e instanceof SocketException) System.out.println("\nKlijent je ugasio aplikaciju!");
            //e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
            String currentTime = sdf.format(new Date());
            System.out.println("\nVreme: " + currentTime);
            switch (request.getOperation()) {
                case Operation.ADD_TURNIR:
                    ServerController.getInstance().addTurnir((Turnir) request.getData());
                    break;
                case Operation.ADD_VATERPOLISTA:
                    ServerController.getInstance().addVaterpolista((Vaterpolista) request.getData());
                    break;
                case Operation.ADD_TIM:
                    ServerController.getInstance().addTim((Tim) request.getData());
                    break;
                case Operation.DELETE_TURNIR:
                    ServerController.getInstance().deleteTurnir((Turnir) request.getData());
                    break;
                case Operation.DELETE_VATERPOLISTA:
                    ServerController.getInstance().deleteVaterpolista((Vaterpolista) request.getData());
                    break;
                case Operation.DELETE_TIM:
                    ServerController.getInstance().deleteTim((Tim) request.getData());
                    break;
                case Operation.UPDATE_TURNIR:
                    ServerController.getInstance().updateTurnir((Turnir) request.getData());
                    break;
                case Operation.UPDATE_VATERPOLISTA:
                    ServerController.getInstance().updateVaterpolista((Vaterpolista) request.getData());
                    break;
                case Operation.UPDATE_TIM:
                    ServerController.getInstance().updateTim((Tim) request.getData());
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    response.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_GRAD:
                    response.setData(ServerController.getInstance().getAllGrad());
                    break;
                case Operation.GET_ALL_IGRAC:
                    response.setData(ServerController.getInstance().getAllIgrac((Tim) request.getData()));
                    break;
                case Operation.GET_ALL_TIM:
                    response.setData(ServerController.getInstance().getAllTim());
                    break;
                case Operation.GET_ALL_TURNIR:
                    response.setData(ServerController.getInstance().getAllTurnir((String) request.getData()));
                    break;
                case Operation.GET_ALL_UTAKMICA:
                    response.setData(ServerController.getInstance().getAllUtakmica((Turnir) request.getData()));
                    break;
                case Operation.GET_ALL_VATERPOLISTA:
                    response.setData(ServerController.getInstance().getAllVaterpolista());
                    break;
                case Operation.GET_ALL_TABELA:
                    response.setData(ServerController.getInstance().getAllTabela((Turnir) request.getData()));
                    break;
                case Operation.GET_BROJ_KOLA:
                    response.setData(ServerController.getInstance().getBrojKola((BrojKolaHelper) request.getData()));
                    break;
                case Operation.LOGIN:
                    Administrator administrator = (Administrator) request.getData();
                    Administrator ulogovani = ServerController.getInstance().login(administrator);
                    response.setData(ulogovani);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.Error);
            response.setException(e);
        }
        return response;
    }

}
