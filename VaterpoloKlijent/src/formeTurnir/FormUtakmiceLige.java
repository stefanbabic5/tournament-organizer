/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formeTurnir;

import controller.ClientController;
import domain.Turnir;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import modeli.TableModelUtakmice;

/**
 *
 * @author stefan
 */
public class FormUtakmiceLige extends javax.swing.JDialog {

    Turnir t;
    Locale jezik;
    boolean isInitialized = false;
    
    /**
     * Creates new form FormUtakmiceLige
     */
    public FormUtakmiceLige(JDialog parent, boolean modal, Turnir t, Locale jezik) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.t = t;
        this.jezik = jezik;
        popuniBrojKola();
        namestiJezik();
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBrojKola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBrojKola, 0, 521, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbBrojKola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBrojKola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbBrojKolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBrojKolaActionPerformed
        if (isInitialized)
            if (cmbBrojKola.getSelectedItem() != null)
                popuniUtakmice();
    }//GEN-LAST:event_cmbBrojKolaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbBrojKola;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBrojKola;
    private javax.swing.JTable tblUtakmice;
    // End of variables declaration//GEN-END:variables

    private void namestiJezik() {
        ResourceBundle bundle = ResourceBundle.getBundle("resource/messages");

        setTitle(bundle.getString("detalji_turnir"));

        String[] kolone = {bundle.getString("kolo"), bundle.getString("rb"), bundle.getString("prvi_tim"),
            bundle.getString("rezultat"), bundle.getString("drugi_tim"), bundle.getString("pobednik")};
        TableModelUtakmice tm = new TableModelUtakmice();
        tm.setKolone(kolone);
        tblUtakmice.setModel(tm);
        popuniUtakmice();

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
            int broj = ClientController.getInstance().getBrojKola(t);
            cmbBrojKola.removeAllItems();
            for (int i = 1; i <= broj; i++) {
                cmbBrojKola.addItem(i);
            }
            cmbBrojKola.setSelectedIndex(broj - 1);
        } catch (Exception ex) {
            Logger.getLogger(FormAzuriranjeLige.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
