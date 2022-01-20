
package View;

import DBHelper.DBConfig;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



public class Kematian extends javax.swing.JFrame {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat mformat = new SimpleDateFormat("MM");
    DateFormat yformat = new SimpleDateFormat("yyyy");
    private TableRowSorter sorter;
    DefaultTableModel tb  =new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
            return false;
        }
        };
    String agamav, shdrtv, pekerjaanv, nikv, namav, tlv, goldarv, ayahv, ibuv, laporv, mativ, tgllv, agaman, shdrtn, pekerjaann , noT;
    Integer nov, jkv;
    String data; 
    Integer tglc;
    
   
    public Kematian() {
        initComponents();
        Stabel();
        cbagama();
        cbshdrt();
        cbpekerjaan();
        awal();
    }
    
    public void awal(){
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btnsave.setEnabled(true);
    }
    
    public void kedua(){
        btnupdate.setEnabled(true);
        btndelete.setEnabled(true);
        btnsave.setEnabled(false);
    }
    
    public void bersih(){
        awal();
        txtcari.setText("");
        noT = "";
        txtnik.setText("");
        txtnama.setText("");
        cbjk.setSelectedIndex(0);
        txttl.setText("");
        jtgll.setDate(null);
        cbgoldar.setSelectedIndex(0);
        cbagama.setSelectedIndex(0);
        cbshdrt.setSelectedIndex(0);
        cbpekerjaan.setSelectedIndex(0);
        txtayah.setText("");
        txtibu.setText("");
        ckematian.setDate(null);
        clapor.setDate(null);
    }
    
    public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            JOptionPane.showMessageDialog(null, "Masukan Hanya Angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public String agama1(String agama){
        try{
            String sql = "select * from agama where id_agama = '"+agama+"'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
               agaman = res.getString(2);
            }
        } catch(Exception e){
        }
        return agaman;
    }
    
    public String shdrt1(String shdrt){
        try{
            String sql = "select * from shdrt where id_shdrt = '"+shdrt+"'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
               shdrtn = res.getString(2);
            }
        } catch(Exception e){
        }
        return shdrtn;
    }
    
    public String pekerjaan1(String pekerjaan){
        try{
            String sql = "select * from pekerjaan where id_pekerjaan = '"+pekerjaan+"'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
               pekerjaann = res.getString(2);
            }
        } catch(Exception e){
        }
        return pekerjaann;
    }
    
    public String agama(String agama){
        try{
            String sql = "select * from agama where agama = '"+agama+"'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
               agamav = res.getString(1);
            }
        } catch(Exception e){
        }
        return agamav;
    }
    public String shdrt(String shdrt){
        try{
            String sql = "select * from shdrt where shdrt = '"+shdrt+"'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
               shdrtv = res.getString(1);
            }
        } catch(Exception e){
        }
        return shdrtv;
    }
    public String pekerjaan(String pekerjaan){
        try{
            String sql = "select * from pekerjaan where pekerjaan = '"+pekerjaan+"'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
               pekerjaanv = res.getString(1);
            }
        } catch(Exception e){
        }
        return pekerjaanv;
    }
    public void cbagama(){
        try{
            String sql = "select * from agama order by id_agama asc";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){ 
                cbagama.addItem(res.getString(2));
            }
        } catch(Exception e){
        }
    }
    public void cbshdrt(){
        try{
            String sql = "select * from shdrt order by id_shdrt asc";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                cbshdrt.addItem(res.getString(2));
            }
        } catch(Exception e){
        }
    }
    public void cbpekerjaan(){
        try{
            String sql = "select * from pekerjaan order by id_pekerjaan asc";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                cbpekerjaan.addItem(res.getString(2));
            }
        } catch(Exception e){
        }
    }
    public void cleantabel(){
    DefaultTableModel model = (DefaultTableModel)tabel.getModel();
    while (model.getRowCount() > 0){
        for (int i = 0; i < model.getRowCount(); ++i){
            model.removeRow(i);
        }
    }
    }
    public void Stabel(){
        tb.addColumn("no");
        tb.addColumn("nik");
        tb.addColumn("nama");
        tb.addColumn("jk");
        tb.addColumn("tempat lahir");
        tb.addColumn("tgl lahir");
        tb.addColumn("gol darah");
        tb.addColumn("agama");
        tb.addColumn("shdrt");
        tb.addColumn("pekerjaan");
        tb.addColumn("ayah");
        tb.addColumn("ibu");
        tb.addColumn("tgl kematian");
        tb.addColumn("tgl lapor");
        tabel.setModel(tb);
    }
    public void tampiltabelp(){
        Integer month, year, hasil; 
        month = txtmonth.getMonth();
        year = txtyear.getYear();
        month += 1;
        try{
            String sql = "select * from kematian where month(tgl_lapor) = '"+month+"' and year(tgl_lapor) = '"+year+"'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                tb.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14)});
            }
            tabel.setModel(tb);
            sorter = new TableRowSorter<>(tb);
            tabel.setRowSorter(sorter);
        } catch(Exception e){
        }
    }
    public void tampiltabel(){
        Integer month, year, hasil; 
        month = txtmonth.getMonth();
        year = txtyear.getYear();
        month += 1;
        try{
            String sql = "SELECT * FROM kematian order by tgl_lapor asc";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                tb.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14)});
            }
            tabel.setModel(tb);
            sorter = new TableRowSorter<>(tb);
            tabel.setRowSorter(sorter);
        } catch(Exception e){
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbjk = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbpekerjaan = new javax.swing.JComboBox<>();
        btncari = new javax.swing.JButton();
        clapor = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cbshdrt = new javax.swing.JComboBox<>();
        txttl = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtibu = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtgll = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        txtnik = new javax.swing.JTextField();
        txtmonth = new com.toedter.calendar.JMonthChooser();
        jLabel5 = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtyear = new com.toedter.calendar.JYearChooser();
        txtayah = new javax.swing.JTextField();
        ckematian = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbgoldar = new javax.swing.JComboBox<>();
        cbagama = new javax.swing.JComboBox<>();
        txtnama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        lblwaktu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Tampil Semua");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 301, -1, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("NIK");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 64, -1, -1));

        cbjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Kelamin", "Pria", "Wanita" }));
        jPanel1.add(cbjk, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 143, 140, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setText("Pekerjaan");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 190, -1, -1));

        jPanel1.add(cbpekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 185, 180, -1));

        btncari.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        jPanel1.add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 301, -1, -1));

        clapor.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(clapor, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 143, 140, -1));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel13.setText("tgl kematian");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 106, -1, -1));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel14.setText("Cari");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 300, 32, 41));

        jPanel1.add(cbshdrt, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 143, 180, -1));

        txttl.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jPanel1.add(txttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 188, 252, -1));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setText("tgl lapor");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 148, -1, -1));

        txtibu.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jPanel1.add(txtibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 62, 255, -1));

        btnsave.setBackground(new java.awt.Color(102, 255, 102));
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(807, 221, 63, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel10.setText("Nama Ayah");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 226, -1, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kematian");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 1528, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel11.setText("Nama Ibu");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(779, 64, -1, -1));

        jtgll.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(jtgll, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 221, 120, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setText("SHDRT");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 148, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("Gol. Darah");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 64, -1, -1));

        btnupdate.setBackground(new java.awt.Color(102, 153, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 221, -1, -1));

        btnclear.setBackground(new java.awt.Color(255, 255, 51));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        jPanel1.add(btnclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1079, 221, 67, -1));

        txtnik.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnikKeyTyped(evt);
            }
        });
        jPanel1.add(txtnik, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 62, 252, -1));
        jPanel1.add(txtmonth, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 301, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setText("Tempat Lahir");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 190, -1, -1));

        btndelete.setBackground(new java.awt.Color(255, 51, 51));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(988, 221, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Agama");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 106, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("Jenis Kelamin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, -1, -1));
        jPanel1.add(txtyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 301, -1, -1));

        txtayah.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jPanel1.add(txtayah, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 224, 255, -1));

        ckematian.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(ckematian, new org.netbeans.lib.awtextra.AbsoluteConstraints(864, 106, 140, -1));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel15.setText("Tanggal Lahir");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 225, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("Nama");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 106, -1, -1));

        cbgoldar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plih Gol. Darah", "A", "B", "O", "AB" }));
        jPanel1.add(cbgoldar, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 59, 180, -1));

        jPanel1.add(cbagama, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 101, 180, -1));

        txtnama.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jPanel1.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 104, 252, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 344, 1630, 343));

        txtcari.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        jPanel1.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 310, 173, -1));

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
        jPanel1.add(lblwaktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 20, 50, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1636, 714));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        agama((String) cbagama.getSelectedItem());
        pekerjaan((String) cbpekerjaan.getSelectedItem());
        shdrt((String) cbshdrt.getSelectedItem());
        jkv = cbjk.getSelectedIndex();
        nikv = txtnik.getText();
        namav = txtnama.getText();
        tlv = txttl.getText();
        if(jtgll.getDate() == null){
            tgllv = "";
        } else {
            tgllv = format.format(jtgll.getDate());
        }
        goldarv = (String) cbgoldar.getSelectedItem();
        if (goldarv == "Plih Gol. Darah"){
            goldarv = "";
        }
        ayahv = txtayah.getText();
        ibuv = txtibu.getText();
        if(ckematian.getDate() == null){
            mativ = "";
        } else {
            mativ = format.format(ckematian.getDate());
        }
        if(clapor.getDate() == null){
            laporv = "";
        } else {
            laporv = format.format(clapor.getDate());
            data = mformat.format(clapor.getDate());
            tglc = Integer.parseInt(data);
            tglc -= 1;
        } 
        if (nikv.equals("")){
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong"); 
        } else if (tgllv.equals("")){
            JOptionPane.showMessageDialog(null, "tanggal lahir tidak boleh kosong");
        } else if (agamav == null){
            JOptionPane.showMessageDialog(null, "agama tidak boleh kosong");
        } else if (shdrtv == null){
            JOptionPane.showMessageDialog(null, "shdrt tidak boleh kosong");
        } else if (pekerjaanv == null){
            JOptionPane.showMessageDialog(null, "pekerjaan tidak boleh kosong");
        } else if (mativ.equals("")){
            JOptionPane.showMessageDialog(null, "tgl kematian tidak boleh kosong");
        } else if (laporv.equals("")){
            JOptionPane.showMessageDialog(null, "tgl lapor tidak boleh kosong");
        } else {
            try {
                String sql = "INSERT INTO kematian (nik, nama, jk, tl, tgl_lahir, gol_dar, no_agama, no_shdrt, no_pekerjaan, ayah, ibu, tgl_kematian, tgl_lapor) VALUES ('"+nikv+"','"+namav+"','"+jkv+"','"+tlv+"','"+tgllv+"','"+goldarv+"','"+agamav+"','"+shdrtv+"','"+pekerjaanv+"','"+ayahv+"','"+ibuv+"','"+mativ+"','"+laporv+"')";
                java.sql.Connection conn=(Connection)DBConfig.getDatabase();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
                txtmonth.setMonth(tglc);
                cleantabel();
                tampiltabelp();
                bersih();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        agama((String) cbagama.getSelectedItem());
        pekerjaan((String) cbpekerjaan.getSelectedItem());
        shdrt((String) cbshdrt.getSelectedItem());
        jkv = cbjk.getSelectedIndex();
        nikv = txtnik.getText();
        namav = txtnama.getText();
        tlv = txttl.getText();
        tgllv = format.format(jtgll.getDate());
        goldarv = (String) cbgoldar.getSelectedItem();
        ayahv = txtayah.getText();
        ibuv = txtibu.getText();
        mativ = format.format(ckematian.getDate());
        laporv = format.format(clapor.getDate());
        if(jtgll.getDate() == null){
            tgllv = "";
        } else {
            tgllv = format.format(jtgll.getDate());
        }
        if (goldarv == "Plih Gol. Darah"){
            goldarv = "";
        }
        if(ckematian.getDate() == null){
            mativ = "";
        } else {
            mativ = format.format(ckematian.getDate());
        }
        if(clapor.getDate() == null){
            laporv = "";
        } else {
            laporv = format.format(clapor.getDate());
            data = mformat.format(clapor.getDate());
            tglc = Integer.parseInt(data);
            tglc -= 1;
        } 
         if (nikv.equals("")){
            JOptionPane.showMessageDialog(null, "NIK tidak boleh kosong"); 
        } else if (tgllv.equals("")){
            JOptionPane.showMessageDialog(null, "Tanggal lahir tidak boleh kosong");
        } else if (agamav == null){
            JOptionPane.showMessageDialog(null, "Agama tidak boleh kosong");
        } else if (shdrtv == null){
            JOptionPane.showMessageDialog(null, "shdrt tidak boleh kosong");
        } else if (pekerjaanv == null){
            JOptionPane.showMessageDialog(null, "pekerjaan tidak boleh kosong");
        } else if (mativ.equals("")){
            JOptionPane.showMessageDialog(null, "tgl kematian tidak boleh kosong");
        } else if (laporv.equals("")){
            JOptionPane.showMessageDialog(null, "tgl lapor tidak boleh kosong");
        } else {
            try {
                String sql = "UPDATE kematian SET nik = '"+nikv+"', nama = '"+namav+"', jk = '"+jkv+"', tl = '"+tlv+"', tgl_lahir = '"+tgllv+"', gol_dar = '"+goldarv+"', no_agama = '"+agamav+"', no_shdrt = '"+shdrtv+"', no_pekerjaan = '"+pekerjaanv+"', ayah = '"+ayahv+"', ibu = '"+ibuv+"', tgl_kematian = '"+mativ+"', tgl_lapor = '"+laporv+"' WHERE no = '"+noT+"'";
                java.sql.Connection conn=(Connection)DBConfig.getDatabase();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                pst.execute();
                bersih();
                JOptionPane.showMessageDialog(null, "Update Data Berhasil");
                txtmonth.setMonth(tglc);
                cleantabel();
                tampiltabelp();
                awal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                String sql ="delete from kematian where no = '"+noT+"'";
                java.sql.Connection conn = (java.sql.Connection)DBConfig.getDatabase();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.execute();
                cleantabel();
                tampiltabelp();
                bersih();
                awal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        bersih();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        cleantabel();
        tampiltabelp();
    }//GEN-LAST:event_btncariActionPerformed

    private void txtnikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnikKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txtnikKeyTyped

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        String agama, pekerjaan, shdrt, jk, goldar;
        Date tgll = null;
        Date lapor = null;
        Date mati = null;
        agama = (String) tabel.getValueAt(tabel.getSelectedRow(), 7);
        shdrt = (String) tabel.getValueAt(tabel.getSelectedRow(), 8);
        pekerjaan = (String) tabel.getValueAt(tabel.getSelectedRow(), 9);
        jk = (String) tabel.getValueAt(tabel.getSelectedRow(), 3);
        goldar = (String) tabel.getValueAt(tabel.getSelectedRow(), 6);
        agama1(agama);
        shdrt1(shdrt);
        pekerjaan1(pekerjaan);
        txtnik.setText(tabel.getValueAt(tabel.getSelectedRow(), 1).toString());
        noT = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
        txtnama.setText(tabel.getValueAt(tabel.getSelectedRow(), 2).toString());
        cbgoldar.setSelectedItem(goldar);
        cbjk.setSelectedIndex(Integer.parseInt(jk));
        txttl.setText(tabel.getValueAt(tabel.getSelectedRow(), 4).toString());
        try {
            tgll = new SimpleDateFormat("yyyy-MM-dd").parse(tabel.getValueAt(tabel.getSelectedRow(), 5).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Kematian.class.getName()).log(Level.SEVERE, null, ex);
        }
        jtgll.setDate(tgll);
        txtayah.setText(tabel.getValueAt(tabel.getSelectedRow(), 10).toString());
        txtibu.setText(tabel.getValueAt(tabel.getSelectedRow(), 11).toString());
        try {
            mati = new SimpleDateFormat("yyyy-MM-dd").parse(tabel.getValueAt(tabel.getSelectedRow(), 12).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Kematian.class.getName()).log(Level.SEVERE, null, ex);
        }
        ckematian.setDate(mati);
        try {
            lapor = new SimpleDateFormat("yyyy-MM-dd").parse(tabel.getValueAt(tabel.getSelectedRow(), 13).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Kematian.class.getName()).log(Level.SEVERE, null, ex);
        }
        clapor.setDate(lapor);
        cbagama.setSelectedItem(agaman);
        cbshdrt.setSelectedItem(shdrtn);
        cbpekerjaan.setSelectedItem(pekerjaann);
        kedua();
    }//GEN-LAST:event_tabelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cleantabel();
        tampiltabel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        String text = txtcari.getText();
        if (text.trim().length() == 0) {
           sorter.setRowFilter(null);
        } else {
           sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_txtcariActionPerformed

    private void lblwaktuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblwaktuMouseClicked
        Menu menu = new Menu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblwaktuMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncari;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cbagama;
    private javax.swing.JComboBox<String> cbgoldar;
    private javax.swing.JComboBox<String> cbjk;
    private javax.swing.JComboBox<String> cbpekerjaan;
    private javax.swing.JComboBox<String> cbshdrt;
    private com.toedter.calendar.JDateChooser ckematian;
    private com.toedter.calendar.JDateChooser clapor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jtgll;
    private javax.swing.JLabel lblwaktu;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtayah;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtibu;
    private com.toedter.calendar.JMonthChooser txtmonth;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txttl;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
