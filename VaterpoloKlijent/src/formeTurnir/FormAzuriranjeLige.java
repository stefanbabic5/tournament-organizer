/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formeTurnir;

import controller.ClientController;
import domain.BrojKolaHelper;
import domain.Tabela;
import domain.Tim;
import domain.Turnir;
import domain.Utakmica;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import modeli.TableModelUtakmice;

/**
 *
 * @author stefan
 */
public class FormAzuriranjeLige extends javax.swing.JDialog {

    Turnir t;
    ArrayList<Tabela> st;
    Locale jezik;
    boolean isInitialized = false;
    ArrayList<Utakmica> zaIzmenu = new ArrayList<>();
    Utakmica u;
    boolean sim = false;

    Tabela st1;
    Tabela st2;

    /**
     * Creates new form FormAzuriranjeLige
     */
    public FormAzuriranjeLige(JDialog parent, boolean modal, Turnir t, Locale jezik) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        this.t = t;
        this.jezik = jezik;
        this.st = ClientController.getInstance().getAllTabela(this.t);
        this.t.setTabela(st);
        popuniBrojKola();
        namestiJezik();
        postaviModel();
        isInitialized = true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBrojKola = new javax.swing.JLabel();
        cmbBrojKola = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUtakmice = new javax.swing.JTable();
        btnTabela = new javax.swing.JButton();
        btnAzurirajUtakmicu = new javax.swing.JButton();
        btnZavrsiTurnir = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        btnZatvori = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblBrojKola.setText("jLabel1");

        cmbBrojKola.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBrojKola.setFocusable(false);
        cmbBrojKola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBrojKolaActionPerformed(evt);
            }
        });

        tblUtakmice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblUtakmice);

        btnTabela.setText("Prikazi tabelu");
        btnTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTabelaActionPerformed(evt);
            }
        });

        btnAzurirajUtakmicu.setText("Azuriraj utakmicu");
        btnAzurirajUtakmicu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajUtakmicuActionPerformed(evt);
            }
        });

        btnZavrsiTurnir.setText("Zavrsi turnir");
        btnZavrsiTurnir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZavrsiTurnirActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj izmene");

        btnZatvori.setText("Zatvori");
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi turnir");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAzurirajUtakmicu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnZavrsiTurnir, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBrojKola)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbBrojKola, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojKola)
                    .addComponent(cmbBrojKola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTabela))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAzurirajUtakmicu)
                    .addComponent(btnZavrsiTurnir)
                    .addComponent(btnObrisi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZatvori)
                    .addComponent(btnSacuvaj))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTabelaActionPerformed
        new FormStandings(this, true, t, jezik).setVisible(true);
    }//GEN-LAST:event_btnTabelaActionPerformed

    private void cmbBrojKolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBrojKolaActionPerformed
        if (isInitialized)
            if (cmbBrojKola.getSelectedItem() != null)
                popuniUtakmice();
    }//GEN-LAST:event_cmbBrojKolaActionPerformed

    private void btnAzurirajUtakmicuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajUtakmicuActionPerformed
        int row = tblUtakmice.getSelectedRow();

        if (row >= 0) {
            u = ((TableModelUtakmice) tblUtakmice.getModel()).getSelectedUtakmica(row);
            u.setTip("Liga");

            st1 = findTeamStanding(u.getPrviTim());
            st2 = findTeamStanding(u.getDrugiTim());

            if (!(this.u.getPobednik().getTimID() == 0)) {
                st1.setScoredHome(st1.getScoredHome() - this.u.getBrojGolovaPrviTim());
                st1.setAllowedHome(st1.getAllowedHome() - this.u.getBrojGolovaDrugiTim());

                st2.setScoredAway(st2.getScoredAway() - this.u.getBrojGolovaDrugiTim());
                st2.setAllowedAway(st2.getAllowedAway() - this.u.getBrojGolovaPrviTim());

                if (u.getBrojGolovaPrviTim() > u.getBrojGolovaDrugiTim()) {
                    st1.setHomeWins(st1.getHomeWins() - 1);
                    st2.setAwayLosses(st2.getAwayLosses() - 1);
                } else if (u.getBrojGolovaPrviTim() < u.getBrojGolovaDrugiTim()) {
                    st1.setHomeLosses(st1.getHomeLosses() - 1);
                    st2.setAwayWins(st2.getAwayWins() - 1);
                } else {
                    if (u.getPenaliPrvi() > u.getPenaliDrugi()) {
                        st1.setHomeWinsPenalty(st1.getHomeWinsPenalty() - 1);
                        st2.setAwayLossesPenalty(st2.getAwayLossesPenalty() - 1);
                    } else {
                        st1.setHomeLossesPenalty(st1.getHomeLossesPenalty() - 1);
                        st2.setAwayWinsPenalty(st2.getAwayWinsPenalty() - 1);
                    }
                }
            }

            new FormIzmenaUtakmice(this, true, u, jezik).setVisible(true);
        }
    }//GEN-LAST:event_btnAzurirajUtakmicuActionPerformed

    private void btnZavrsiTurnirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZavrsiTurnirActionPerformed
        try {
            simulirajUtakmice();
            t.setUtakmice(zaIzmenu);
            t.setTabela(st);
            ClientController.getInstance().updateTurnir(t);

            st = ClientController.getInstance().getAllTabela(t);
            t.setPobednik(st.get(0).getTim().toString());
            t.setUtakmice(new ArrayList<>());
            t.setTabela(new ArrayList<>());
            ClientController.getInstance().updateTurnir(t);

            FormPretragaTurnira fp = (FormPretragaTurnira) getParent();
            fp.popuniTabele();
            JOptionPane.showMessageDialog(this,
                    ResourceBundle.getBundle("resource/messages").getString("izmenjen_turnir"));
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FormAzuriranjeLige.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnZavrsiTurnirActionPerformed

    private void btnZatvoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZatvoriActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnZatvoriActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int result = JOptionPane.showConfirmDialog(this,
            ResourceBundle.getBundle("resource/messages").getString("brisanje_turnir_potvrda"),
            ResourceBundle.getBundle("resource/messages").getString("konfirmacija"),
            JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().deleteTurnir(t);
                FormPretragaTurnira fp = (FormPretragaTurnira) getParent();
                fp.popuniTabele();
                JOptionPane.showMessageDialog(this,
                    ResourceBundle.getBundle("resource/messages").getString("brisanje_turnir"));
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(FormDetaljiTurnira.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzurirajUtakmicu;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnTabela;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JButton btnZavrsiTurnir;
    private javax.swing.JComboBox cmbBrojKola;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrojKola;
    private javax.swing.JTable tblUtakmice;
    // End of variables declaration//GEN-END:variables

    private void namestiJezik() {
        ResourceBundle bundle = ResourceBundle.getBundle("resource/messages");

        setTitle(bundle.getString("detalji_turnir"));

        lblBrojKola.setText(bundle.getString("kolo"));
        
        btnAzurirajUtakmicu.setText(bundle.getString("azuriraj_utakmicu"));
        btnSacuvaj.setText(bundle.getString("azuriraj_turnir"));
        btnTabela.setText(bundle.getString("prikazi_tabelu"));
        btnObrisi.setText(bundle.getString("obrisi_turnir"));
        btnZatvori.setText(bundle.getString("close"));
        btnZavrsiTurnir.setText(bundle.getString("zavrsi_turnir"));

        String[] kolone = {bundle.getString("kolo"), bundle.getString("rb"), bundle.getString("prvi_tim"),
            bundle.getString("rezultat"), bundle.getString("drugi_tim"), bundle.getString("pobednik")};
        TableModelUtakmice tm = new TableModelUtakmice();
        tm.setKolone(kolone);
        tblUtakmice.setModel(tm);
        popuniUtakmice();

    }

    private void postaviModel() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblUtakmice.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tblUtakmice.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tblUtakmice.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        tblUtakmice.getColumnModel().getColumn(0).setPreferredWidth(20);
        tblUtakmice.getColumnModel().getColumn(1).setPreferredWidth(20);
    }

    private void popuniUtakmice() {
        try {
            TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
            t.setKoloHelper((int) cmbBrojKola.getSelectedItem());
            tm.setLista(ClientController.getInstance().getAllUtakmica(t));
        } catch (Exception ex) {
            Logger.getLogger(FormAzuriranjeTurnira.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniBrojKola() {
        try {
            BrojKolaHelper bkh = new BrojKolaHelper(t, 0);
            int broj = ClientController.getInstance().getBrojKola(bkh);
            cmbBrojKola.removeAllItems();
            for (int i = 1; i <= broj; i++) {
                cmbBrojKola.addItem(i);
            }
            cmbBrojKola.setSelectedIndex(broj - 1);
        } catch (Exception ex) {
            Logger.getLogger(FormAzuriranjeLige.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void izmeniUtakmicu(Utakmica u) {
        izmeniUtakmicuHelper(u);
        popuniBrojKola();
    }

    void izmeniUtakmicuHelper(Utakmica u) {
        TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
        try {
            zaIzmenu.add(u);

            st1.setScoredHome(st1.getScoredHome() + u.getBrojGolovaPrviTim());
            st1.setAllowedHome(st1.getAllowedHome() + u.getBrojGolovaDrugiTim());

            st2.setScoredAway(st2.getScoredAway() + u.getBrojGolovaDrugiTim());
            st2.setAllowedAway(st2.getAllowedAway() + u.getBrojGolovaPrviTim());

            if (u.getBrojGolovaPrviTim() > u.getBrojGolovaDrugiTim()) {
                st1.setHomeWins(st1.getHomeWins() + 1);
                st2.setAwayLosses(st2.getAwayLosses() + 1);
            } else if (u.getBrojGolovaPrviTim() < u.getBrojGolovaDrugiTim()) {
                st1.setHomeLosses(st1.getHomeLosses() + 1);
                st2.setAwayWins(st2.getAwayWins() + 1);
            } else {
                if (u.getPenaliPrvi() > u.getPenaliDrugi()) {
                    st1.setHomeWinsPenalty(st1.getHomeWinsPenalty() + 1);
                    st2.setAwayLossesPenalty(st2.getAwayLossesPenalty() + 1);
                } else {
                    st1.setHomeLossesPenalty(st1.getHomeLossesPenalty() + 1);
                    st2.setAwayWinsPenalty(st2.getAwayWinsPenalty() + 1);
                }
            }
            if (!sim) {
                t.setTabela(st);
                t.setUtakmice(zaIzmenu);

                ClientController.getInstance().updateTurnir(t);

                tm.fireTableDataChanged();
                zaIzmenu.clear();
            } else {
                t.setTabela(st);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormAzuriranjeLige.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Tabela findTeamStanding(Tim tim) {
        for (Tabela tabela : st) {
            if (Objects.equals(tabela.getTim().getTimID(), tim.getTimID())) {
                return tabela;
            }
        }
        return null;
    }

    private void simulirajUtakmice() {
        try {
            sim = true;
            t.setTip("Kup");
            ArrayList<Utakmica> utakmice = ClientController.getInstance().getAllUtakmica(t);
            t.setTip("Liga");

            for (Utakmica utakmica : utakmice) {
                if (utakmica.getPobednik().getTimID() != 0) {
                    continue;
                }
                st1 = findTeamStanding(utakmica.getPrviTim());
                st2 = findTeamStanding(utakmica.getDrugiTim());

                int goloviPrvi = 5 + (int) (Math.random() * 11);
                int goloviDrugi = 5 + (int) (Math.random() * 11);
                utakmica.setBrojGolovaPrviTim(goloviPrvi);
                utakmica.setBrojGolovaDrugiTim(goloviDrugi);

                if (goloviPrvi == goloviDrugi) {
                    int penaliPrvi = (int) (Math.random() * 6);
                    int penaliDrugi = (int) (Math.random() * 6);

                    if (penaliPrvi == penaliDrugi) {
                        if (Math.random() > 0.5) {
                            penaliPrvi++;
                            utakmica.setPobednik(utakmica.getPrviTim());
                        } else {
                            penaliDrugi++;
                            utakmica.setPobednik(utakmica.getDrugiTim());
                        }
                    } else {
                        utakmica.setPobednik(penaliPrvi > penaliDrugi ? utakmica.getPrviTim() : utakmica.getDrugiTim());
                    }

                    utakmica.setPenaliPrvi(penaliPrvi);
                    utakmica.setPenaliDrugi(penaliDrugi);
                } else {
                    utakmica.setPobednik(goloviPrvi > goloviDrugi ? utakmica.getPrviTim() : utakmica.getDrugiTim());
                }

                izmeniUtakmicu(utakmica);
            }

        } catch (Exception ex) {
            Logger.getLogger(FormAzuriranjeLige.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
