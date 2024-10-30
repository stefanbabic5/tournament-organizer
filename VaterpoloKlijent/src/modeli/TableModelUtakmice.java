/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import controller.ClientController;
import domain.Tim;
import domain.Turnir;
import domain.Utakmica;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefan
 */
public class TableModelUtakmice extends AbstractTableModel {

    private ArrayList<Utakmica> lista;
    private String[] kolone;

    public TableModelUtakmice() {
        lista = new ArrayList<>();
    }

    public TableModelUtakmice(Turnir t) {
        try {
            lista = ClientController.getInstance().getAllUtakmica(t);
        } catch (Exception ex) {
            Logger.getLogger(TableModelUtakmice.class.getName()).log(Level.SEVERE, null, ex);
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
        Utakmica u = lista.get(row);

        switch (column) {
            case 0:
                return u.getKolo();
            case 1:
                return u.getRbUtakmice();
            case 2:
                return u.getPrviTim();
            case 3:
                String result;
                if (u.getPenaliPrvi() == 0 && u.getPenaliDrugi() == 0) {
                    return u.getBrojGolovaPrviTim() + " : " + u.getBrojGolovaDrugiTim();
                } else {
                    return u.getBrojGolovaPrviTim() + " (" + u.getPenaliPrvi() + ") : (" + u.getPenaliDrugi() + ") " + u.getBrojGolovaDrugiTim();
                }
            case 4:
                return u.getDrugiTim();
            case 5:
                return u.getPobednik();

            default:
                return null;
        }
    }

    public ArrayList<Utakmica> getLista() {
        return lista;
    }

    public Utakmica getSelectedUtakmica(int row) {
        return lista.get(row);
    }

    public void izmeniUtakmicu(Utakmica u, int row) {
        lista.set(row, u);
        fireTableDataChanged();
    }

    public void setLista(ArrayList<Utakmica> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }

}
