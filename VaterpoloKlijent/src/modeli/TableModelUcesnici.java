/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import controller.ClientController;
import domain.Tim;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefan
 */
public class TableModelUcesnici extends AbstractTableModel{
    private ArrayList<Tim> lista;
    private String[] kolone;
    private String parametar = "";

    public TableModelUcesnici() {
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

    
    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllTim();
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

    public Tim obrisiTim(int row) {
        Tim t = lista.get(row);
        lista.remove(row);
        fireTableDataChanged();
        return t;
    }

    public void dodajTim(Tim t) {
        lista.add(t);
        fireTableDataChanged();
    }

    public ArrayList<Tim> getLista() {
        return lista;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }

    public void setLista(ArrayList<Tim> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public Tim vratiTim(int row) {
        return lista.get(row);
    }

    public void dodajNaPoziciju(Tim t, int i) {
        lista.add(i, t);
        fireTableDataChanged();
    }
    
}
