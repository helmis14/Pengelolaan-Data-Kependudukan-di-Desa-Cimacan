
package View;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Menu extends javax.swing.JFrame {
    
    
    public Menu() {
        initComponents();
        tgljam();

    }
    public void tgljam(){
        int hari, bulan, tahun;
        GregorianCalendar date = new GregorianCalendar();
        String namabulan[] = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        hari = date.get(Calendar.DAY_OF_MONTH);
        bulan = date.get(Calendar.MONTH);
        tahun = date.get(Calendar.YEAR);
        lbltgl.setText(hari+" "+namabulan[bulan]+" "+tahun);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblkedatangan = new javax.swing.JLabel();
        lblmenu = new javax.swing.JLabel();
        lblwaktu = new javax.swing.JLabel();
        lbltgl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblpindah = new javax.swing.JLabel();
        lblkelahiran = new javax.swing.JLabel();
        lblexport = new javax.swing.JLabel();
        lblkematian = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblkedatangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kedatangan.png"))); // NOI18N
        lblkedatangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkedatanganMouseClicked(evt);
            }
        });
        jPanel1.add(lblkedatangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        lblmenu.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        lblmenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblmenu.setText("Menu");
        jPanel1.add(lblmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

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
        jPanel1.add(lblwaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        lbltgl.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lbltgl.setText("....................");
        jPanel1.add(lbltgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/master.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, -1));

        lblpindah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pindah.png"))); // NOI18N
        lblpindah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblpindahMouseClicked(evt);
            }
        });
        jPanel1.add(lblpindah, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        lblkelahiran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kelahiran.png"))); // NOI18N
        lblkelahiran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkelahiranMouseClicked(evt);
            }
        });
        jPanel1.add(lblkelahiran, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        lblexport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/export.png"))); // NOI18N
        lblexport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblexportMouseClicked(evt);
            }
        });
        jPanel1.add(lblexport, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        lblkematian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/kematian.png"))); // NOI18N
        lblkematian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblkematianMouseClicked(evt);
            }
        });
        jPanel1.add(lblkematian, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo-cjr.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 160, 180));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel3.setText("Cianjur");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 190, 50));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setText("Desa Cimacan");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 190, 50));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 660, 450);

        setSize(new java.awt.Dimension(639, 485));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblkematianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkematianMouseClicked
        Kematian kematian = new Kematian();
        kematian.setVisible(true);
    }//GEN-LAST:event_lblkematianMouseClicked

    private void lblexportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblexportMouseClicked
        Export export = new Export();
        export.setVisible(true);
    }//GEN-LAST:event_lblexportMouseClicked

    private void lblkelahiranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkelahiranMouseClicked
        Kelahiran kelahiran = new Kelahiran();
        kelahiran.setVisible(true);
    }//GEN-LAST:event_lblkelahiranMouseClicked

    private void lblkedatanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblkedatanganMouseClicked
        Kedatangan kedatangan =  new Kedatangan();
        kedatangan.setVisible(true);
    }//GEN-LAST:event_lblkedatanganMouseClicked

    private void lblpindahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpindahMouseClicked
        Pindah pindah =  new Pindah();
        pindah.setVisible(true);
    }//GEN-LAST:event_lblpindahMouseClicked

    private void lblwaktuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblwaktuMouseClicked
        Login login =  new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblwaktuMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Master master =  new Master();
        master.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblexport;
    private javax.swing.JLabel lblkedatangan;
    private javax.swing.JLabel lblkelahiran;
    private javax.swing.JLabel lblkematian;
    private javax.swing.JLabel lblmenu;
    private javax.swing.JLabel lblpindah;
    private javax.swing.JLabel lbltgl;
    private javax.swing.JLabel lblwaktu;
    // End of variables declaration//GEN-END:variables
}
