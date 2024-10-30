/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import controller.ClientController;
import domain.Turnir;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefan
 */
public class TableModelTurniri extends AbstractTableModel {

    private ArrayList<Turnir> lista;
    private String[] kolone;
    private String parametar = "";
    private boolean evidentiran;
    
    public TableModelTurniri() {
        lista = new ArrayList<>();
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
        Turnir t = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (column) {
            case 0:
                return t.getTurnirID();
            case 1:
                return t.getNazivTurnira();
            case 2:
                return t.getTip();
            case 3:
                return sdf.format(t.getDatumPocetka());
            case 4:
                return sdf.format(t.getDatumKraja());
            case 5:
                return t.getPobednik();
            default:
                return null;
        }
    }

    public Turnir getSelectedTurnir(int row) {
        return lista.get(row);
    }

    public void dodaj(Turnir t) {
        lista.add(t);
        fireTableDataChanged();
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }
    
    public void clear() {
        lista.clear();
        fireTableDataChanged();
    }
    
}
