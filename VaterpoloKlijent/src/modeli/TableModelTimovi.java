/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import controller.ClientController;
import domain.Tim;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefan
 */
public class TableModelTimovi extends AbstractTableModel implements Runnable {
    
    private ArrayList<Tim> lista;
    private String[] kolone;
    private String parametar = "";
    boolean bool = true;

    public TableModelTimovi() {
        try {
            lista = ClientController.getInstance().getAllTim();
            lista.remove(0);
        } catch (Exception ex) {
            Logger.getLogger(TableModelTurniri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Tim t = lista.get(row);

        switch (column) {
            case 0:
                return t.getTimID();
            case 1:
                return t.getNazivTima();
            case 2:
                return t.getGrad();

            default:
                return null;
        }
    }

    public Tim getSelectedTim(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (bool) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelTurniri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllTim();
            lista.remove(0);
            if (!parametar.equals("")) {
                ArrayList<Tim> novaLista = new ArrayList<>();
                for (Tim t : lista) {
                    if (t.getNazivTima().toLowerCase().contains(parametar.toLowerCase())
                            || t.getNazivTima().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(t);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void zaustavi() {
        bool = false;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }
    
}
