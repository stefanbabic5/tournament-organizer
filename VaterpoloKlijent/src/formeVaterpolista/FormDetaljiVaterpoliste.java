/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package formeVaterpolista;

import controller.ClientController;
import domain.Vaterpolista;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author stefan
 */
public class FormDetaljiVaterpoliste extends javax.swing.JDialog {

    private Vaterpolista v;

    public FormDetaljiVaterpoliste(JDialog parent, boolean modal, Vaterpolista v, Locale jezik) {
        super(parent, modal);
        initComponents();
        this.v = v;
        setLocationRelativeTo(null);
        txtIme.setText(v.getImeVaterpoliste());
        txtPrezime.setText(v.getPrezimeVaterpoliste());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txtDatumRodjenja.setText(sdf.format(v.getDatumRodjenja()));
        Locale.setDefault(jezik);
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

        lblIme = new javax.swing.JLabel();
        lblPrezime = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        btnOtkazi = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        lblDatum = new javax.swing.JLabel();
        txtDatumRodjenja = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIme.setText("Ime:");

        lblPrezime.setText("Prezime:");

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi vaterpolistu");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni vaterpolistu");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        lblDatum.setText("Datum rodjenja:");

        txtDatumRodjenja.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                            .addComponent(lblIme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIme)
                            .addComponent(txtPrezime)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDatum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnIzmeni, btnObrisi, btnOtkazi});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIme))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrezime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatum)
                    .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni)
                    .addComponent(btnOtkazi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int result = JOptionPane.showConfirmDialog(this, 
                ResourceBundle.getBundle("resource/messages").getString("brisanje_vtp_potvrda"), 
                ResourceBundle.getBundle("resource/messages").getString("konfirmacija"), 
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().deleteVaterpolista(v);
                FormPretragaVaterpoliste fp = (FormPretragaVaterpoliste) getParent();
                fp.refreshTable();
                JOptionPane.showMessageDialog(this, 
                        ResourceBundle.getBundle("resource/messages").getString("brisanje_vtp"));
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, 
                        ResourceBundle.getBundle("resource/messages").getString("brisanje_vtp_err"));
                //Logger.getLogger(FormDetaljiVaterpoliste.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        try {

            if (txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty()
                    || txtDatumRodjenja.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                        ResourceBundle.getBundle("resource/messages").getString("polja_msg"));
                return;
            }

            String ime = txtIme.getText();
            String prezime = txtPrezime.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumRodjenja = sdf.parse(txtDatumRodjenja.getText());

            v.setImeVaterpoliste(ime);
            v.setPrezimeVaterpoliste(prezime);
            v.setDatumRodjenja(datumRodjenja);

            ClientController.getInstance().updateVaterpolista(v);
            FormPretragaVaterpoliste fp = (FormPretragaVaterpoliste) getParent();
            fp.refreshTable();
            JOptionPane.showMessageDialog(this, 
                    ResourceBundle.getBundle("resource/messages").getString("izmenjen_vtp"));
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle("resource.messages").getString(ex.getMessage()));
            //Logger.getLogger(FormDetaljiVaterpoliste.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JFormattedTextField txtDatumRodjenja;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtPrezime;
    // End of variables declaration//GEN-END:variables

    private void namestiJezik() {
        ResourceBundle bundle = ResourceBundle.getBundle("resource/messages");
        
        setTitle(bundle.getString("detalji_vtp"));
        
        lblDatum.setText(bundle.getString("datum_rodjenja"));
        lblIme.setText(bundle.getString("ime"));
        lblPrezime.setText(bundle.getString("prezime"));
        
        btnIzmeni.setText(bundle.getString("izmeni_vtp"));
        btnObrisi.setText(bundle.getString("obrisi_vtp"));
        btnOtkazi.setText(bundle.getString("cancel"));
    }

}