
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

public class Kelahiran extends javax.swing.JFrame {
    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat mformat = new SimpleDateFormat("MM");
    DateFormat yformat = new SimpleDateFormat("yyyy");
    private TableRowSorter sorter;
    DefaultTableModel tb  =new DefaultTableModel(){
            public boolean isCellEditable(int row, int column) {
            return false;
        }
        };
    String agamav, shdrtv, nokk, nikv, namav, tlv, goldarv, ayahv, ibuv, entryv, tgllv, agaman, shdrtn, ketv, noT;
    Integer nov, jkv;
    String monthv, yearv;
    String data; 
    Integer tglc;
   
    public Kelahiran() {
        initComponents();
        Stabel();
        cbagama();
        cbshdrt();
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
        txtnokk.setText("");
        txtnama.setText("");
        cbjk.setSelectedIndex(0);
        txttl.setText("");
        jtgll.setDate(null);
        cbgoldar.setSelectedIndex(0);
        cbagama.setSelectedIndex(0);
        cbshdrt.setSelectedIndex(0);
        txtayah.setText("");
        txtibu.setText("");
        centry.setDate(null);
        txtnik.setText("");
        txtket.setText("");
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
    public void cbagama(){
        try{
            String sql = "select * from agama";
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
            String sql = "select * from shdrt";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                cbshdrt.addItem(res.getString(2));
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
        tb.addColumn("no kk");
        tb.addColumn("nik");
        tb.addColumn("nama");
        tb.addColumn("jk");
        tb.addColumn("tempat lahir");
        tb.addColumn("tgl lahir");
        tb.addColumn("gol darah");
        tb.addColumn("agama");
        tb.addColumn("shdrt");
        tb.addColumn("ayah");
        tb.addColumn("ibu");
        tb.addColumn("tgl entry");
        tb.addColumn("ket");
        tabel.setModel(tb);
    }
    public void tampiltabelp(){
        Integer month, year, hasil; 
        month = txtmonth.getMonth();
        year = txtyear.getYear();
        month += 1;
        String percobaan;
        try{
            String sql = "select * from kelahiran where month(tgl_entry) = '"+month+"' and year(tgl_entry) = '"+year+"'";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                percobaan = res.getString(13);
                if (percobaan == "1000-01-01"){
                    percobaan = "";
                    tb.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),percobaan,res.getString(14)});
                } else {
                    tb.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14)});
                }
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
        String percobaan;
        try{
            String sql = "SELECT * FROM kelahiran order by tgl_entry asc";
            Connection conn = (Connection) DBConfig.getDatabase();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                percobaan = res.getString(13);
                if (percobaan == "1000-01-01"){
                    percobaan = "";
                    tb.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),percobaan,res.getString(14)});
                } else {
                    tb.addRow(new Object[]{res.getString(1), res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14)});
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtyear = new com.toedter.calendar.JYearChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        txtnik = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        txtibu = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbjk = new javax.swing.JComboBox<>();
        txtket = new javax.swing.JTextField();
        jtgll = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        centry = new com.toedter.calendar.JDateChooser();
        txttl = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbshdrt = new javax.swing.JComboBox<>();
        txtcari = new javax.swing.JTextField();
        txtmonth = new com.toedter.calendar.JMonthChooser();
        txtnokk = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtayah = new javax.swing.JTextField();
        cbgoldar = new javax.swing.JComboBox<>();
        cbagama = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        lblwaktu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 324, 1225, 339));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jButton1.setText("Tampil Semua");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(102, 255, 102));
        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kelahiran");

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel10.setText("Nama Ayah");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setText("Jenis Kelamin");

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel11.setText("Nama Ibu");

        txtnama.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        btndelete.setBackground(new java.awt.Color(255, 51, 51));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(102, 153, 255));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        txtnik.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtnik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnikKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel12.setText("tgl entry");

        btnclear.setBackground(new java.awt.Color(255, 255, 51));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        txtibu.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setText("Agama");

        cbjk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Kelamin", "Pria", "Wanita" }));

        jtgll.setDateFormatString("yyyy-MM-dd");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setText("NIK");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setText("No KK");

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel15.setText("Tempat Lahir");

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel14.setText("Cari");

        centry.setDateFormatString("yyyy-MM-dd");

        txttl.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        btncari.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setText("Tanggal Lahir");

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel16.setText("Gol. Darah");

        txtcari.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });

        txtnokk.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtnokk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnokkKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setText("Keterangan");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setText("Nama");

        txtayah.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N

        cbgoldar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plih Gol. Darah", "A", "B", "O", "AB" }));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel8.setText("SHDRT");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btncari)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 562, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnsave, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnupdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btndelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblwaktu)
                                .addGap(40, 40, 40))))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5)
                                .addComponent(jLabel15))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnokk)
                                .addComponent(txtnama)
                                .addComponent(txttl, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnik, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbjk, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel10)
                                .addComponent(jLabel16))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbagama, 0, 135, Short.MAX_VALUE)
                                        .addComponent(cbshdrt, 0, 135, Short.MAX_VALUE)
                                        .addComponent(cbgoldar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtgll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(159, 159, 159)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel9)))
                                .addComponent(txtayah, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtibu)
                                .addComponent(centry, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtket, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 74, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblwaktu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnupdate)
                    .addComponent(btndelete)
                    .addComponent(btnclear))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btncari)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtmonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addGap(29, 29, 29)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtnokk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(txtibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jtgll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel16)
                            .addComponent(cbgoldar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addComponent(centry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel7)
                        .addComponent(cbagama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txtket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cbshdrt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(cbjk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 29, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(txttl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtayah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(78, 78, 78)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1216, 710));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        String text = txtcari.getText();
        if (text.trim().length() == 0) {
           sorter.setRowFilter(null);
        } else {
           sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_txtcariActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        monthv = mformat.format(centry.getDate());
        yearv = yformat.format(centry.getDate());
        agama((String) cbagama.getSelectedItem());
        shdrt((String) cbshdrt.getSelectedItem());
        jkv = cbjk.getSelectedIndex();
        nikv = txtnik.getText();
        nokk = txtnokk.getText();
        ketv = txtket.getText();
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
        if(centry.getDate() == null){
            entryv = "";
        } else {
            data = mformat.format(centry.getDate());
            tglc = Integer.parseInt(data);
            tglc -= 1;
            entryv = format.format(centry.getDate());
        } 
        if (namav.equals("")){
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong"); 
        } else if (tgllv.equals("")){
            JOptionPane.showMessageDialog(null, "tanggal lahir tidak boleh kosong");
        } else if (agamav == null){
            JOptionPane.showMessageDialog(null, "agama tidak boleh kosong");
        } else if (shdrtv == null){
            JOptionPane.showMessageDialog(null, "shdrt tidak boleh kosong");
        } else if (entryv == null){
            JOptionPane.showMessageDialog(null, "tanggal entry tidak boleh kosong");
        } else {
            try {
                String sql = "INSERT INTO kelahiran (no_kk ,nik, nama, jk, tl, tgl_lahir, gol_dar, no_agama, no_shdrt, ayah, ibu, tgl_entry, ket) VALUES ('"+nokk+"','"+nikv+"','"+namav+"','"+jkv+"','"+tlv+"','"+tgllv+"','"+goldarv+"','"+agamav+"','"+shdrtv+"','"+ayahv+"','"+ibuv+"','"+entryv+"','"+ketv+"')";
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
        monthv = mformat.format(centry.getDate());
        yearv = yformat.format(centry.getDate());
        agama((String) cbagama.getSelectedItem());
        shdrt((String) cbshdrt.getSelectedItem());
        jkv = cbjk.getSelectedIndex();
        nikv = txtnik.getText();
        nokk = txtnokk.getText();
        ketv = txtket.getText();
        namav = txtnama.getText();
        tlv = txttl.getText();
        tgllv = format.format(jtgll.getDate());
        goldarv = (String) cbgoldar.getSelectedItem();
        ayahv = txtayah.getText();
        ibuv = txtibu.getText();
        entryv = format.format(centry.getDate());
        if(jtgll.getDate() == null){
            tgllv = "";
        } else {
            tgllv = format.format(jtgll.getDate());
        }
        if (goldarv == "Plih Gol. Darah"){
            goldarv = "";
        }
        if(centry.getDate() == null){
            entryv = "1000-01-01";
        } else {
            entryv = format.format(centry.getDate());
            data = mformat.format(centry.getDate());
            tglc = Integer.parseInt(data);
            tglc -= 1;
        } 
         if (namav.equals("")){
            JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong"); 
        } else if (tgllv.equals("")){
            JOptionPane.showMessageDialog(null, "tanggal lahir tidak boleh kosong");
        } else if (agamav == null){
            JOptionPane.showMessageDialog(null, "agama tidak boleh kosong");
        } else if (shdrtv == null){
            JOptionPane.showMessageDialog(null, "shdrt tidak boleh kosong");
        } else if (entryv == null){
            JOptionPane.showMessageDialog(null, "tanggal entry tidak boleh kosong");
        } else {
            try {
                String sql = "UPDATE kelahiran SET no_kk = '"+nokk+"', nik = '"+nikv+"', nama = '"+namav+"', jk = '"+jkv+"', tl = '"+tlv+"', tgl_lahir = '"+tgllv+"', gol_dar = '"+goldarv+"', no_agama = '"+agamav+"', no_shdrt = '"+shdrtv+"', ayah = '"+ayahv+"', ibu = '"+ibuv+"', tgl_entry = '"+entryv+"', ket = '"+ketv+"' WHERE no = '"+noT+"'";
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
        monthv = mformat.format(centry.getDate());
        yearv = yformat.format(centry.getDate());
        try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                String sql ="delete from kelahiran where no = '"+noT+"'";
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

    private void txtnokkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnokkKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txtnokkKeyTyped

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        String agama, shdrt, jk, goldar;
        String percobaan;
        Date tgll = null;
        Date lapor = null;
        Date mati = null;
        noT = tabel.getValueAt(tabel.getSelectedRow(), 0).toString();
        txtnokk.setText(tabel.getValueAt(tabel.getSelectedRow(), 1).toString());
        txtnik.setText(tabel.getValueAt(tabel.getSelectedRow(), 2).toString());
        txtnama.setText(tabel.getValueAt(tabel.getSelectedRow(), 3).toString());
        jk = (String) tabel.getValueAt(tabel.getSelectedRow(), 4);
        cbjk.setSelectedIndex(Integer.parseInt(jk));
        txttl.setText(tabel.getValueAt(tabel.getSelectedRow(), 5).toString());
        try {
            tgll = new SimpleDateFormat("yyyy-MM-dd").parse(tabel.getValueAt(tabel.getSelectedRow(), 6).toString());
        } catch (ParseException ex) {
            Logger.getLogger(Kelahiran.class.getName()).log(Level.SEVERE, null, ex);
        }
        jtgll.setDate(tgll);
        goldar = (String) tabel.getValueAt(tabel.getSelectedRow(), 7);
        cbgoldar.setSelectedItem(goldar);
        agama = (String) tabel.getValueAt(tabel.getSelectedRow(), 8);
        shdrt = (String) tabel.getValueAt(tabel.getSelectedRow(), 9);
        agama1(agama);
        shdrt1(shdrt);
        cbagama.setSelectedItem(agaman);
        cbshdrt.setSelectedItem(shdrtn);
        txtayah.setText(tabel.getValueAt(tabel.getSelectedRow(), 10).toString());
        txtibu.setText(tabel.getValueAt(tabel.getSelectedRow(), 11).toString());
        percobaan = (String) tabel.getValueAt(tabel.getSelectedRow(), 12);
        if (percobaan == "1000-01-01"){
            centry.setDate(null);
        }else{
            try {
                lapor = new SimpleDateFormat("yyyy-MM-dd").parse(tabel.getValueAt(tabel.getSelectedRow(), 12).toString());
            } catch (ParseException ex) {
                Logger.getLogger(Kelahiran.class.getName()).log(Level.SEVERE, null, ex);
            }
            centry.setDate(lapor);
        } 
        txtket.setText(tabel.getValueAt(tabel.getSelectedRow(), 13).toString());
        kedua();
    }//GEN-LAST:event_tabelMouseClicked

    private void txtnikKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnikKeyTyped
        FilterAngka(evt);
    }//GEN-LAST:event_txtnikKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cleantabel();
        tampiltabel();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox<String> cbshdrt;
    private com.toedter.calendar.JDateChooser centry;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTextField txtket;
    private com.toedter.calendar.JMonthChooser txtmonth;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnik;
    private javax.swing.JTextField txtnokk;
    private javax.swing.JTextField txttl;
    private com.toedter.calendar.JYearChooser txtyear;
    // End of variables declaration//GEN-END:variables
}
