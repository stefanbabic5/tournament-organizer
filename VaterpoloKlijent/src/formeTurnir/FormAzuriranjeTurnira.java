/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formeTurnir;

import controller.ClientController;
import domain.Tim;
import domain.Turnir;
import domain.Utakmica;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class FormAzuriranjeTurnira extends javax.swing.JDialog {
    
    Turnir t;
    ArrayList<Utakmica> zaIzmenu = new ArrayList<>();
    ArrayList<Utakmica> ucitane = new ArrayList<>();
    Locale jezik;
    /**
     * Creates new form FormAzuriranjeTurnira
     */
    public FormAzuriranjeTurnira(JDialog parent, boolean modal, Turnir t, Locale jezik) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.t=t;
        ucitane=ClientController.getInstance().getAllUtakmica(t);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txtDatumPocetka.setText(sdf.format(t.getDatumPocetka()));
        txtDatumKraja.setText(sdf.format(t.getDatumKraja()));
        txtNaziv.setText(t.getNazivTurnira());
        lblOpisTxt.setText(t.getTip());
        cmbGrad.getModel().setSelectedItem(t.getGrad());
        cmbGrad.setEnabled(false);
        this.jezik = jezik;
        namestiJezik();
        postaviModel();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTurnir = new javax.swing.JPanel();
        lblGrad = new javax.swing.JLabel();
        lblNaziv = new javax.swing.JLabel();
        lblDP = new javax.swing.JLabel();
        lblDK = new javax.swing.JLabel();
        lblOpis = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        cmbGrad = new javax.swing.JComboBox();
        txtDatumPocetka = new javax.swing.JFormattedTextField();
        txtDatumKraja = new javax.swing.JFormattedTextField();
        pnlUtakmice = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUtakmice = new javax.swing.JTable();
        btnAzurirajUtakmicu = new javax.swing.JButton();
        btnZatvori = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        lblOpisTxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlTurnir.setBorder(javax.swing.BorderFactory.createTitledBorder("Turnir"));

        lblGrad.setText("Grad:");

        lblNaziv.setText("Naziv:");

        lblDP.setText("Datum pocetka:");

        lblDK.setText("Datum kraja:");

        lblOpis.setText("Opis:");

        cmbGrad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDatumPocetka.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        txtDatumKraja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        pnlUtakmice.setBorder(javax.swing.BorderFactory.createTitledBorder("Utakmice"));

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
        tblUtakmice.setMinimumSize(new java.awt.Dimension(60, 60));
        jScrollPane2.setViewportView(tblUtakmice);

        btnAzurirajUtakmicu.setText("Azuriraj utakmicu");
        btnAzurirajUtakmicu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajUtakmicuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUtakmiceLayout = new javax.swing.GroupLayout(pnlUtakmice);
        pnlUtakmice.setLayout(pnlUtakmiceLayout);
        pnlUtakmiceLayout.setHorizontalGroup(
            pnlUtakmiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUtakmiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUtakmiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                    .addGroup(pnlUtakmiceLayout.createSequentialGroup()
                        .addComponent(btnAzurirajUtakmicu, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlUtakmiceLayout.setVerticalGroup(
            pnlUtakmiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUtakmiceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAzurirajUtakmicu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        btnZatvori.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnZatvori.setText("Zatvori");
        btnZatvori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZatvoriActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnObrisi.setText("Obrisi turnir");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnIzmeni.setText("Izmeni turnir");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        lblOpisTxt.setText("jLabel10");

        javax.swing.GroupLayout pnlTurnirLayout = new javax.swing.GroupLayout(pnlTurnir);
        pnlTurnir.setLayout(pnlTurnirLayout);
        pnlTurnirLayout.setHorizontalGroup(
            pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTurnirLayout.createSequentialGroup()
                        .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNaziv)
                            .addComponent(lblGrad)
                            .addComponent(lblDP)
                            .addComponent(lblDK)
                            .addComponent(lblOpis))
                        .addGap(19, 19, 19)
                        .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNaziv)
                            .addComponent(cmbGrad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumPocetka)
                            .addComponent(txtDatumKraja)
                            .addGroup(pnlTurnirLayout.createSequentialGroup()
                                .addComponent(lblOpisTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTurnirLayout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(pnlUtakmice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTurnirLayout.createSequentialGroup()
                        .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTurnirLayout.createSequentialGroup()
                                .addGap(315, 315, 315)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGap(6, 6, 6))
        );
        pnlTurnirLayout.setVerticalGroup(
            pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNaziv)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrad)
                    .addComponent(cmbGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDP)
                    .addComponent(txtDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumKraja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOpis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblOpisTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlUtakmice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnIzmeni)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnZatvori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlTurnir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTurnir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        try {

            if (txtDatumKraja.getText().isEmpty() || txtDatumPocetka.getText().isEmpty() || txtNaziv.getText().isEmpty() ) {
                JOptionPane.showMessageDialog(this, 
                        ResourceBundle.getBundle("resource/messages").getString("polja_msg"));
                return;
            }

            String naziv = txtNaziv.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumPocetka = sdf.parse(txtDatumPocetka.getText());
            Date datumKraja = sdf.parse(txtDatumKraja.getText());

            TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
            tm.setLista(new ArrayList<>(zaIzmenu));

            t.setNazivTurnira(naziv);
            t.setDatumPocetka(datumPocetka);
            t.setDatumKraja(datumKraja);
            cuvanje();
            izbaciPretkolo();
            //t.setUtakmice(tm.getLista());
            
            String pobednik = tm.getLista().get(tm.getLista().size()-1).getPobednik().getNazivTima();
            if (!pobednik.equals("N/A")) {
                t.setPobednik(tm.getLista().get(tm.getLista().size()-1).getPobednik().getNazivTima());
            }

            ClientController.getInstance().updateTurnir(t);
            FormPretragaTurnira fp = (FormPretragaTurnira) getParent();
            fp.popuniTabele();
            JOptionPane.showMessageDialog(this, 
                    ResourceBundle.getBundle("resource/messages").getString("izmenjen_turnir"));
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle("resource.messages").getString(ex.getMessage()));
            //Logger.getLogger(FormDetaljiTurnira.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnAzurirajUtakmicuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajUtakmicuActionPerformed
        int row = tblUtakmice.getSelectedRow();
        
        if (row>=0) {
            Utakmica u = ((TableModelUtakmice) tblUtakmice.getModel()).getSelectedUtakmica(row);
            if (u.getPrviTim().getTimID() == 0L || u.getDrugiTim().getTimID() == 0L) {
                if (u.getKolo().equals("1")) {
                    JOptionPane.showMessageDialog(this, 
                            u.getPobednik().getNazivTima() + ResourceBundle.getBundle("resource/messages").getString("izmena_utakmice_err1"));
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, 
                            ResourceBundle.getBundle("resource/messages").getString("izmena_utakmice_err2"));
                    return;
                }
            }
            new FormIzmenaUtakmice(this, true, u, jezik).setVisible(true);
        }
    }//GEN-LAST:event_btnAzurirajUtakmicuActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzurirajUtakmicu;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JComboBox cmbGrad;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDK;
    private javax.swing.JLabel lblDP;
    private javax.swing.JLabel lblGrad;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblOpisTxt;
    private javax.swing.JPanel pnlTurnir;
    private javax.swing.JPanel pnlUtakmice;
    private javax.swing.JTable tblUtakmice;
    private javax.swing.JFormattedTextField txtDatumKraja;
    private javax.swing.JFormattedTextField txtDatumPocetka;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    void izmeniUtakmicu(Utakmica u) {
        TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
        
        for (int i = 0; i < zaIzmenu.size(); i++) {
            Utakmica utakmica = zaIzmenu.get(i);
            if (utakmica.getKolo().equals(u.getKolo()) && utakmica.getRbUtakmice() == u.getRbUtakmice()) {
                zaIzmenu.set(i, u);
            }
        }
        
        tm.setLista(new ArrayList<>(zaIzmenu));
        tm.fireTableDataChanged();
        
        azurirajPobednike();
        izbaciPretkolo();
    }

    private void azurirajPobednike() {
        TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
        ArrayList<Utakmica> utakmice = tm.getLista();
        
        ArrayList<Tim> pobednici = new ArrayList<>();
        for (Utakmica u : utakmice) {
            pobednici.add(u.getPobednik());
        }
        
        int stepen = (int) Math.floor(Math.log(utakmice.size())/Math.log(2));
        int broj = (int) Math.pow(2, stepen);
        
        for (int i = broj; i < utakmice.size(); i++) {
            utakmice.get(i).setPrviTim(pobednici.get(0));
            pobednici.remove(0);
            utakmice.get(i).setDrugiTim(pobednici.get(0));
            pobednici.remove(0);
        }
        Utakmica finale = utakmice.get(utakmice.size()-1);
        if (!Objects.equals(finale.getBrojGolovaPrviTim(), finale.getBrojGolovaDrugiTim())) {
            finale.setPobednik((finale.getBrojGolovaPrviTim() > finale.getBrojGolovaDrugiTim()) ? finale.getPrviTim() : finale.getDrugiTim());
        }
        
    }

    private void popuniUtakmice() {
        try {
            TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
            tm.setLista(ClientController.getInstance().getAllUtakmica(t));
            zaIzmenu = new ArrayList<>(tm.getLista());
            izbaciPretkolo();
        } catch (Exception ex) {
            Logger.getLogger(FormAzuriranjeTurnira.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void izbaciPretkolo() {
        TableModelUtakmice tm = (TableModelUtakmice) tblUtakmice.getModel();
        ArrayList<Utakmica> skracenaLista = tm.getLista();
        
        for (int i = 0; i < skracenaLista.size(); i++) {
            if (skracenaLista.get(i).getKolo().equals("1") && skracenaLista.get(i).getDrugiTim().getTimID() == 0L) {
                skracenaLista.remove(i);
                i--;
            }
            
        }
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

    private void namestiJezik() {
        ResourceBundle bundle = ResourceBundle.getBundle("resource/messages");
        
        setTitle(bundle.getString("detalji_turnir"));
        
        pnlTurnir.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("turnir")));
        pnlUtakmice.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("utakmice")));
        
        lblDK.setText(bundle.getString("datum_kraja"));
        lblDP.setText(bundle.getString("datum_pocetka"));
        lblGrad.setText(bundle.getString("grad"));
        lblNaziv.setText(bundle.getString("naziv"));
        lblOpis.setText(bundle.getString("tip_turnira"));
        
        btnAzurirajUtakmicu.setText(bundle.getString("azuriraj_utakmicu"));
        btnObrisi.setText(bundle.getString("obrisi_turnir"));
        btnIzmeni.setText(bundle.getString("azuriraj_turnir"));
        btnZatvori.setText(bundle.getString("close"));
        
        String[] kolone = {bundle.getString("kolo"), bundle.getString("rb"), bundle.getString("prvi_tim"),
            bundle.getString("rezultat"), bundle.getString("drugi_tim"), bundle.getString("pobednik")};
        TableModelUtakmice tm = new TableModelUtakmice();
        tm.setKolone(kolone);
        tblUtakmice.setModel(tm);
        popuniUtakmice();
        
    }
    
    private void cuvanje() {
        ArrayList<Utakmica> cuvanje = new ArrayList<>();
        for (int i = 0; i < ucitane.size(); i++) {
            String prvi1 = ucitane.get(i).getPrviTim().getNazivTima();
            String drugi1 = ucitane.get(i).getDrugiTim().getNazivTima();
            String pobednik1 = ucitane.get(i).getPobednik().getNazivTima();
            
            int golovip1 = ucitane.get(i).getBrojGolovaPrviTim();
            int golovid1 = ucitane.get(i).getBrojGolovaDrugiTim();
            int penalip1 = ucitane.get(i).getPenaliPrvi();
            int penalid1 = ucitane.get(i).getPenaliDrugi();
            
            String prvi2 = zaIzmenu.get(i).getPrviTim().getNazivTima();
            String drugi2 = zaIzmenu.get(i).getDrugiTim().getNazivTima();
            String pobednik2 = zaIzmenu.get(i).getPobednik().getNazivTima();
            
            int golovip2 = zaIzmenu.get(i).getBrojGolovaPrviTim();
            int golovid2 = zaIzmenu.get(i).getBrojGolovaDrugiTim();
            int penalip2 = zaIzmenu.get(i).getPenaliPrvi();
            int penalid2 = zaIzmenu.get(i).getPenaliDrugi();
            
            if (!prvi1.equals(prvi2) || !drugi1.equals(drugi2) || !pobednik1.equals(pobednik2) || 
                    golovid1 != golovid2 || golovip1 != golovip2 || penalip1 != penalip2 || penalid1 != penalid2) {
                cuvanje.add(zaIzmenu.get(i));
            }
            
        }
        t.setUtakmice(cuvanje);
        
    }
}
