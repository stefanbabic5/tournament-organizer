/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import controller.ClientController;
import domain.Tim;
import domain.Igrac;
import domain.Vaterpolista;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefan
 */
public class TableModelIgraci extends AbstractTableModel {
    
    private ArrayList<Igrac> lista;
    private String[] kolone;

    public TableModelIgraci() {
        lista = new ArrayList<>();
    }

    public TableModelIgraci(Tim t) {
        try {
            lista = ClientController.getInstance().getAllIgrac(t);
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
        Igrac i = lista.get(row);

        switch (column) {
            case 0:
                return i.getBrojKapice();
            case 1:
                return i.getVaterpolista();
            case 2:
                return i.getPozicija();

            default:
                return null;
        }
    }

    public ArrayList<Igrac> getLista() {
        return lista;
    }

    public void dodajIgraca(Igrac i) {
        lista.add(i);
        fireTableDataChanged();
    }

    public Vaterpolista obrisiIgraca(int row) {
        Vaterpolista v = lista.get(row).getVaterpolista();
        lista.remove(row);
        fireTableDataChanged();
        return v;
    }

    public boolean postojiBrojKapice(int brojKapice) {
        for (Igrac igrac : lista) {
            if (igrac.getBrojKapice()==brojKapice) return true;
        }
        return false;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }
    
}
