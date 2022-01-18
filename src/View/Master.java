
package View;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class Master extends javax.swing.JFrame {
    
    
    public Master() {
        initComponents();
        tgljam();

    }
    public void tgljam(){
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblshdrt = new javax.swing.JLabel();
        lblmenu = new javax.swing.JLabel();
        lblpetugas = new javax.swing.JLabel();
        lblpekerjaan = new javax.swing.JLabel();
        lbldesa = new javax.swing.JLabel();
        lblagama = new javax.swing.JLabel();
        lblwaktu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblshdrt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/shdrt.png"))); // NOI18N
        lblshdrt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblshdrtMouseClicked(evt);
            }
        });
        jPanel1.add(lblshdrt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lblmenu.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lblmenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmenu.setText("Data Master");
        jPanel1.add(lblmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 9, -1, -1));

        lblpetugas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/petugas.png"))); // NOI18N
        lblpetugas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblpetugasMouseClicked(evt);
            }
        });
        jPanel1.add(lblpetugas, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        lblpekerjaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pekerjaan.png"))); // NOI18N
        lblpekerjaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblpekerjaanMouseClicked(evt);
            }
        });
        jPanel1.add(lblpekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        lbldesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/desa.png"))); // NOI18N
        lbldesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbldesaMouseClicked(evt);
            }
        });
        jPanel1.add(lbldesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        lblagama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agama.png"))); // NOI18N
        lblagama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblagamaMouseClicked(evt);
            }
        });
        jPanel1.add(lblagama, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, -1));

        lblwaktu.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lblwaktu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblwaktu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logout.png"))); // NOI18N
        lblwaktu.setToolTipText("");
        lblwaktu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblwaktu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblwaktuMouseClicked(evt);
            }
        });
        jPanel1.add(lblwaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 50, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 550, 320);

        setSize(new java.awt.Dimension(552, 341));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblagamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblagamaMouseClicked
        Agama agama = new Agama();
        agama.setVisible(true);
    }//GEN-LAST:event_lblagamaMouseClicked

    private void lblpekerjaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpekerjaanMouseClicked
        Pekerjaan pekerjaan = new Pekerjaan();
        pekerjaan.setVisible(true);
    }//GEN-LAST:event_lblpekerjaanMouseClicked

    private void lblshdrtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblshdrtMouseClicked
        SHDRT shdrt = new SHDRT();
        shdrt.setVisible(true);
    }//GEN-LAST:event_lblshdrtMouseClicked

    private void lblpetugasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpetugasMouseClicked
        Petugas petugas = new Petugas();
        petugas.setVisible(true);
    }//GEN-LAST:event_lblpetugasMouseClicked

    private void lbldesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbldesaMouseClicked
        Desa desa = new Desa();
        desa.setVisible(true);
    }//GEN-LAST:event_lbldesaMouseClicked

    private void lblwaktuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblwaktuMouseClicked
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblwaktuMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblagama;
    private javax.swing.JLabel lbldesa;
    private javax.swing.JLabel lblmenu;
    private javax.swing.JLabel lblpekerjaan;
    private javax.swing.JLabel lblpetugas;
    private javax.swing.JLabel lblshdrt;
    private javax.swing.JLabel lblwaktu;
    // End of variables declaration//GEN-END:variables
}
