/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import controller.ClientController;
import domain.Vaterpolista;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefan
 */
public class TableModelVaterpolisti extends AbstractTableModel implements Runnable {

    private ArrayList<Vaterpolista> lista;
    private String[] kolone;
    private String parametar = "";
    boolean bool = true;

    public TableModelVaterpolisti() {
        try {
            lista = ClientController.getInstance().getAllVaterpolista();
        } catch (Exception ex) {
            Logger.getLogger(TableModelVaterpolisti.class.getName()).log(Level.SEVERE, null, ex);
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
        Vaterpolista v = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (column) {
            case 0:
                return v.getVaterpolistaID();
            case 1:
                return v.getImeVaterpoliste();
            case 2:
                return v.getPrezimeVaterpoliste();
            case 3:
                return sdf.format(v.getDatumRodjenja());

            default:
                return null;
        }
    }

    public Vaterpolista getSelectedVaterpolista(int row) {
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
            Logger.getLogger(TableModelVaterpolisti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllVaterpolista();
            if (!parametar.equals("")) {
                ArrayList<Vaterpolista> novaLista = new ArrayList<>();
                for (Vaterpolista v : lista) {
                    if (v.getImeVaterpoliste().toLowerCase().contains(parametar.toLowerCase())
                            || v.getPrezimeVaterpoliste().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(v);
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
