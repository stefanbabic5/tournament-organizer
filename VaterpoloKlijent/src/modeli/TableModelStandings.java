/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import controller.ClientController;
import domain.Tabela;
import domain.Turnir;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stefan
 */
public class TableModelStandings extends AbstractTableModel {

    private ArrayList<Tabela> lista;
    private String[] kolone = {"Tim", "W", "WP", "LP", "L", "GD", "Points"};

    public TableModelStandings() {
        lista = new ArrayList<>();
    }

    public TableModelStandings(Turnir t) {
        try {
            lista = ClientController.getInstance().getAllTabela(t);
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
        Tabela st = lista.get(row);

        switch (column) {
            case 0:
                return st.getTim().getNazivTima();
            case 1:
                return st.getHomeWins() + st.getAwayWins();
            case 2:
                return st.getHomeWinsPenalty() + st.getAwayWinsPenalty();
            case 3:
                return st.getHomeLossesPenalty() + st.getAwayLossesPenalty();
            case 4:
                return st.getHomeLosses() + st.getAwayLosses();
            case 5:
                String goalDifference = (st.getScoredHome() + st.getScoredAway()) + " : " + (st.getAllowedHome() + st.getAllowedAway());
                return goalDifference;
            case 6:
                return st.getPoints();
            default:
                return null;
        }
    }

    public ArrayList<Tabela> getLista() {
        return lista;
    }

    public Tabela getSelectedUtakmica(int row) {
        return lista.get(row);
    }

    public void izmeniUtakmicu(Tabela st, int row) {
        lista.set(row, st);
        fireTableDataChanged();
    }

    public void setLista(ArrayList<Tabela> lista) {
        this.lista = lista;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }
}
