/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formeTurnir;

import controller.ClientController;
import domain.Tabela;
import domain.Turnir;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import modeli.TableModelStandings;
import modeli.TableModelUtakmice;

/**
 *
 * @author stefan
 */
public class FormDetaljiLige extends javax.swing.JDialog {

    Turnir t;
    Locale jezik;

    /**
     * Creates new form FormDetaljiLige
     */
    public FormDetaljiLige(JDialog parent, boolean modal, Turnir t, Locale jezik) throws Exception {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.t = t;
        TableModelStandings tm = new TableModelStandings(t);
        tblTabela.setModel(tm);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txtDatumPocetka.setText(sdf.format(t.getDatumPocetka()));
        txtDatumKraja.setText(sdf.format(t.getDatumKraja()));
        txtNaziv.setText(t.getNazivTurnira());
        lblOpistxt.setText(t.getTip());
        lblPobedniktxt.setText(t.getPobednik());
        this.jezik = jezik;
        namestiJezik();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTurnir = new javax.swing.JPanel();
        lblNaziv = new javax.swing.JLabel();
        lblDP = new javax.swing.JLabel();
        lblDK = new javax.swing.JLabel();
        lblOpis = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtDatumPocetka = new javax.swing.JFormattedTextField();
        txtDatumKraja = new javax.swing.JFormattedTextField();
        pnlTabela = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTabela = new javax.swing.JTable();
        btnZatvori = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        lblOpistxt = new javax.swing.JLabel();
        lblPobednik = new javax.swing.JLabel();
        lblPobedniktxt = new javax.swing.JLabel();
        btnIzvestaj = new javax.swing.JButton();
        btnPrikaziUtakmice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlTurnir.setBorder(javax.swing.BorderFactory.createTitledBorder("Turnir"));

        lblNaziv.setText("Naziv:");

        lblDP.setText("Datum pocetka:");

        lblDK.setText("Datum kraja:");

        lblOpis.setText("Opis:");

        txtDatumPocetka.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        txtDatumKraja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        pnlTabela.setBorder(javax.swing.BorderFactory.createTitledBorder("Utakmice"));

        tblTabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblTabela);

        javax.swing.GroupLayout pnlTabelaLayout = new javax.swing.GroupLayout(pnlTabela);
        pnlTabela.setLayout(pnlTabelaLayout);
        pnlTabelaLayout.setHorizontalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTabelaLayout.setVerticalGroup(
            pnlTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTabelaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        lblOpistxt.setText("jLabel10");

        lblPobednik.setText("Pobednik");

        lblPobedniktxt.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        lblPobedniktxt.setText("jLabel7");

        btnIzvestaj.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnIzvestaj.setText("Kreiraj izvestaj");
        btnIzvestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzvestajActionPerformed(evt);
            }
        });

        btnPrikaziUtakmice.setText("Prikazi Utakmice");
        btnPrikaziUtakmice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziUtakmiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTurnirLayout = new javax.swing.GroupLayout(pnlTurnir);
        pnlTurnir.setLayout(pnlTurnirLayout);
        pnlTurnirLayout.setHorizontalGroup(
            pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTurnirLayout.createSequentialGroup()
                        .addComponent(lblPobednik, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlTurnirLayout.createSequentialGroup()
                        .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTurnirLayout.createSequentialGroup()
                                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNaziv)
                                    .addComponent(lblDP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblOpis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOpistxt, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDatumKraja, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlTurnirLayout.createSequentialGroup()
                                        .addComponent(lblPobedniktxt, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPrikaziUtakmice))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTurnirLayout.createSequentialGroup()
                                .addGap(0, 5, Short.MAX_VALUE)
                                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pnlTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTurnirLayout.createSequentialGroup()
                                        .addComponent(btnIzvestaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnZatvori, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))))
                        .addGap(6, 6, 6))))
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
                    .addComponent(lblDP)
                    .addComponent(txtDatumPocetka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDatumKraja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpis)
                    .addComponent(lblOpistxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPobednik)
                    .addComponent(lblPobedniktxt)
                    .addComponent(btnPrikaziUtakmice))
                .addGap(21, 21, 21)
                .addComponent(pnlTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIzvestaj, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTurnirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnZatvori)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnIzmeni)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

            if (txtDatumKraja.getText().isEmpty() || txtDatumPocetka.getText().isEmpty() || txtNaziv.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        ResourceBundle.getBundle("resource/messages").getString("polja_msg"));
                return;
            }

            String naziv = txtNaziv.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumPocetka = sdf.parse(txtDatumPocetka.getText());
            Date datumKraja = sdf.parse(txtDatumKraja.getText());

            if (!datumPocetka.before(datumKraja)) {
                JOptionPane.showMessageDialog(this,
                        ResourceBundle.getBundle("resource.messages").getString("dpdk"));
                return;
            }

            if (datumKraja.after(new Date())) {
                JOptionPane.showMessageDialog(this,
                        ResourceBundle.getBundle("resource.messages").getString("datum_gotov_err"));
                return;
            }

            //TableModelUtakmice tm = (TableModelUtakmice) tblTabela.getModel();

            t.setNazivTurnira(naziv);
            t.setDatumPocetka(datumPocetka);
            t.setDatumKraja(datumKraja);
            t.setUtakmice(new ArrayList<>());
            t.setTabela(new ArrayList<>());
            //t.setUtakmice(tm.getLista());

            ClientController.getInstance().updateTurnir(t);
            FormPretragaTurnira fp = (FormPretragaTurnira) getParent();
            fp.popuniTabele();
            JOptionPane.showMessageDialog(this,
                    ResourceBundle.getBundle("resource/messages").getString("izmenjen_turnir"));
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle("resource.messages").getString(ex.getMessage()));
            Logger.getLogger(FormDetaljiTurnira.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnIzvestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzvestajActionPerformed
//        try {
//            ArrayList<StavkaIzvestaja> lista = new ArrayList<>();
//            TableModelUtakmice tm = (TableModelUtakmice) tblTabela.getModel();
//            for (Utakmica u : tm.getLista()) {
//                String rezultat;
//                if (u.getDrugiTim().getTimID() == 0 && u.getKolo().equals("1")) {
//                    rezultat = "Slobodan prolaz";
//                } else if (u.getPobednik().getTimID() == 0) {
//                    rezultat = "TBD";
//                } else if (u.getBrojGolovaPrviTim() == u.getBrojGolovaDrugiTim()) {
//                    rezultat = u.getBrojGolovaPrviTim() + " (" + u.getPenaliPrvi() + ") : ("
//                            + u.getPenaliDrugi() + ") " + u.getBrojGolovaDrugiTim();
//                } else {
//                    rezultat = u.getBrojGolovaPrviTim() + " : " + u.getBrojGolovaDrugiTim();
//                }
//                StavkaIzvestaja si = new StavkaIzvestaja(u.getKolo(), u.getPrviTim().getNazivTima(), rezultat, u.getDrugiTim().getNazivTima());
//                lista.add(si);
//            }
//
//            //JasperReport izvestaj = JasperCompileManager.compileReport("./src/resource/izvestaj.jrxml");
//            HashMap<String, Object> mapa = new HashMap<>();
//            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//            String datumi = sdf.format(t.getDatumPocetka()) + " - " + sdf.format(t.getDatumKraja());
//            mapa.put("datumi", datumi);
//            mapa.put("naziv", t.getNazivTurnira());
//            mapa.put("grad", t.getGrad().getNazivGrada());
//            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
//            JasperPrint print = JasperFillManager.fillReport("./src/resource/izvestaj.jasper", mapa, ds);
//
//            JasperViewer.viewReport(print, false);
//            FormPretragaTurnira fp = (FormPretragaTurnira) getParent();
//            fp.dispose();
//            this.dispose();
//        } catch (Exception ex) {
//            Logger.getLogger(FormDetaljiTurnira.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnIzvestajActionPerformed

    private void btnPrikaziUtakmiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziUtakmiceActionPerformed
        new FormUtakmiceLige(this, true, t, jezik).setVisible(true);
    }//GEN-LAST:event_btnPrikaziUtakmiceActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnIzvestaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPrikaziUtakmice;
    private javax.swing.JButton btnZatvori;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDK;
    private javax.swing.JLabel lblDP;
    private javax.swing.JLabel lblNaziv;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblOpistxt;
    private javax.swing.JLabel lblPobednik;
    private javax.swing.JLabel lblPobedniktxt;
    private javax.swing.JPanel pnlTabela;
    private javax.swing.JPanel pnlTurnir;
    private javax.swing.JTable tblTabela;
    private javax.swing.JFormattedTextField txtDatumKraja;
    private javax.swing.JFormattedTextField txtDatumPocetka;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables


    private void namestiJezik() {
        ResourceBundle bundle = ResourceBundle.getBundle("resource/messages");
        
        setTitle(bundle.getString("detalji_turnir"));
        
        pnlTurnir.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("turnir")));
        //pnlUtakmice.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("utakmice")));
        
        lblDK.setText(bundle.getString("datum_kraja"));
        lblDP.setText(bundle.getString("datum_pocetka"));
        lblNaziv.setText(bundle.getString("naziv"));
        lblOpis.setText(bundle.getString("opis"));
        lblPobednik.setText(bundle.getString("pobednik_turnir"));
        
        btnIzvestaj.setText(bundle.getString("kreiraj_izvestaj"));
        btnObrisi.setText(bundle.getString("obrisi_turnir"));
        btnIzmeni.setText(bundle.getString("azuriraj_turnir"));
        btnZatvori.setText(bundle.getString("close"));
        
//        String[] kolone = {bundle.getString("kolo"), bundle.getString("rb"), bundle.getString("prvi_tim"),
//            bundle.getString("rezultat"), bundle.getString("drugi_tim"), bundle.getString("pobednik")};
//        TableModelUtakmice tm = new TableModelUtakmice(t);
//        tm.setKolone(kolone);
//        tblTabela.setModel(tm);
        
    }
    
}