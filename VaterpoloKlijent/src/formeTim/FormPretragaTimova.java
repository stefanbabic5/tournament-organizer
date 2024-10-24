/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formeTim;

import domain.Tim;
import java.util.Locale;
import java.util.ResourceBundle;
import modeli.TableModelTimovi;

/**
 *
 * @author stefan
 */
public class FormPretragaTimova extends javax.swing.JDialog {

    Locale jezik;
    /**
     * Creates new form FormPretragaTimova
     */
    public FormPretragaTimova(java.awt.Frame parent, boolean modal, Locale jezik) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.jezik = jezik;
        namestiJezik();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPretraga = new javax.swing.JTextField();
        btnDetalji = new javax.swing.JButton();
        lblPretraga = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimovi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        btnDetalji.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDetalji.setText("Detalji tima");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        lblPretraga.setText("Pretraga (naziv tima):");

        tblTimovi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTimovi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblPretraga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretraga))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPretraga))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetalji)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        String param = txtPretraga.getText();
        ((TableModelTimovi) tblTimovi.getModel()).setParametar(param);
    }//GEN-LAST:event_txtPretragaKeyReleased

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed

        int row = tblTimovi.getSelectedRow();

        if (row >= 0) {
            Tim t = ((TableModelTimovi) tblTimovi.getModel()).getSelectedTim(row);
            new FormDetaljiTima(this, rootPaneCheckingEnabled, t, jezik).setVisible(true);
        }

    }//GEN-LAST:event_btnDetaljiActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        TableModelTimovi tm = (TableModelTimovi) tblTimovi.getModel();
        tm.zaustavi();
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPretraga;
    private javax.swing.JTable tblTimovi;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    void refreshTable() {
        TableModelTimovi tm = (TableModelTimovi) tblTimovi.getModel();
        tm.refreshTable();
    }

    private void namestiJezik() {
        ResourceBundle bundle = ResourceBundle.getBundle("resource/messages");
        
        setTitle(bundle.getString("pretraga_timova"));
        
        lblPretraga.setText(bundle.getString("search_tim"));
        
        btnDetalji.setText(bundle.getString("detalji_tim"));
        
        String[] kolone = {"ID:", bundle.getString("naziv"), bundle.getString("grad")};
        TableModelTimovi model = new TableModelTimovi();
        model.setKolone(kolone);
        Thread th = new Thread(model);
        th.start();
        tblTimovi.setModel(model);
    }
    
}
