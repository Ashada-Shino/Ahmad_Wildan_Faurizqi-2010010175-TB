/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import db.Koneksi;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.ashada.model.Aset;
import com.ashada.model.Lokasi;
import model.Model_Card;
import javax.swing.ImageIcon;

/**
 *
 * @author Ashada
 */
public class Aplikasi extends javax.swing.JFrame {
    
    Aset aset;
    Lokasi lokasi;

    /**
     * Creates new form home
     */
    public Aplikasi() {
        initComponents();
        
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/stock.png")), "Aset","4", "Total Jumlah Aset"));
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/profit.png")), "Aset Masuk", "15", "Total Jumlah Aset Masuk"));
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/com/raven/icon/flag.png")), "Aset Keluar", "30", "Total Jumlah Aset Keluar"));
        
        setLocationRelativeTo(null);
        
        subAsetMasuk.setVisible(false);
        subAsetKeluar.setVisible(false);
        subDataPenempatan.setVisible(false);
        subDataAset.setVisible(false);
        subDataLokasi.setVisible(false);
        subLaporanMasuk.setVisible(false);
        subLaporanKeluar.setVisible(false);
        
        resetTable("");
        resetTableLokasi("");
        
        tDM.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        tDM.getTableHeader().setOpaque(false);
        tDM.getTableHeader().setBackground(new Color(45,129,255));
        tDM.getTableHeader().setForeground(new Color(255, 255, 255));
        
        tDK.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        tDK.getTableHeader().setOpaque(false);
        tDK.getTableHeader().setBackground(new Color(232,56,95));
        tDK.getTableHeader().setForeground(new Color(255, 255, 255));
        
                
        tAset.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        tAset.getTableHeader().setOpaque(false);
        tAset.getTableHeader().setBackground(new Color(45,129,255));
        tAset.getTableHeader().setForeground(new Color(255, 255, 255));
        
        tLokasi.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 12));
        tLokasi.getTableHeader().setOpaque(false);
        tLokasi.getTableHeader().setBackground(new Color(45,129,255));
        tLokasi.getTableHeader().setForeground(new Color(255, 255, 255));
        
    }
            /* Tampilkan data ke tabel aset */
    public ArrayList<Aset> getAsetList(String keyword){
        ArrayList<Aset> asetList = new ArrayList<Aset>();
        Koneksi koneksi = new Koneksi();
        Connection connection = koneksi.getConnection();
        
        String query = "SELECT * FROM tbl_aset "+keyword;
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                aset = new Aset(
                        rs.getString("id_aset"),
                        rs.getString("nama_aset")
                        );
                asetList.add(aset);
            }
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Koneksi Null gagal");
        }
        return asetList;
    }
    public void selectAset(String keyword){
        ArrayList<Aset> list = getAsetList(keyword);
        DefaultTableModel model = (DefaultTableModel)tAset.getModel();
        Object[] row = new Object[3];
        
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId_aset();
            row[1] = list.get(i).getNama_aset();

            model.addRow(row);
        }
    }
    public final void resetTable (String keyword){
    DefaultTableModel model = (DefaultTableModel)tAset.getModel();
    model.setRowCount(0);
    selectAset (keyword);
    }
            /* Tampilkan data ke tabel lokasi */
    public ArrayList<Lokasi> getLokasiList(String keyword){
        ArrayList<Lokasi> lokasiList = new ArrayList<Lokasi>();
        Koneksi koneksi = new Koneksi();
        Connection connection = koneksi.getConnection();
        
        String query = "SELECT * FROM tbl_lokasi "+keyword;
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                lokasi = new Lokasi(
                        rs.getInt("id_lokasi"),
                        rs.getString("nama_lokasi")
                        );
                lokasiList.add(lokasi);
            }
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Koneksi Null gagal");
        }
        return lokasiList;
    }
    public void selectLokasi(String keyword){
        ArrayList<Lokasi> list = getLokasiList(keyword);
        DefaultTableModel model = (DefaultTableModel)tLokasi.getModel();
        Object[] row = new Object[3];
        
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId_lokasi();
            row[1] = list.get(i).getNama_lokasi();

            model.addRow(row);
        }
    }
    public final void resetTableLokasi (String keyword){
    DefaultTableModel model = (DefaultTableModel)tLokasi.getModel();
    model.setRowCount(0);
    selectLokasi (keyword);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navbarPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        sub = new javax.swing.JPanel();
        dashboardLabel = new javax.swing.JLabel();
        navbarData = new javax.swing.JPanel();
        dataLabel = new javax.swing.JLabel();
        subDataAset = new javax.swing.JPanel();
        asetLabel = new javax.swing.JLabel();
        subDataLokasi = new javax.swing.JPanel();
        lokasiLabel = new javax.swing.JLabel();
        navbarTransaksi = new javax.swing.JPanel();
        transaksiLabel = new javax.swing.JLabel();
        subDataPenempatan = new javax.swing.JPanel();
        penempatanLabel = new javax.swing.JLabel();
        subAsetMasuk = new javax.swing.JPanel();
        masukLabel = new javax.swing.JLabel();
        subAsetKeluar = new javax.swing.JPanel();
        keluarLabel = new javax.swing.JLabel();
        navbarLaporan = new javax.swing.JPanel();
        lapLabel = new javax.swing.JLabel();
        subLaporanMasuk = new javax.swing.JPanel();
        lapMasukLabel = new javax.swing.JLabel();
        subLaporanKeluar = new javax.swing.JPanel();
        lapKeluarLabel = new javax.swing.JLabel();
        img = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        navbarComing1 = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        mainDashboard = new javax.swing.JPanel();
        panel = new javax.swing.JLayeredPane();
        card1 = new GUI.Card();
        card2 = new GUI.Card();
        card3 = new GUI.Card();
        mainDataAset = new javax.swing.JPanel();
        dmPanelHeader3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        actionAsetPanel = new javax.swing.JPanel();
        btnTambahAset = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnEditAset = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnHapusAset = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btnResetAset = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        eCariAset = new javax.swing.JTextField();
        btnCariAset = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tAset = new javax.swing.JTable();
        mainDataLokasi = new javax.swing.JPanel();
        dmPanelHeader5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnTambahLokasi = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnEditLokasi = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnHapusLokasi = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        btnResetLokasi = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        eCariLokasi = new javax.swing.JTextField();
        btnCariLokasi = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tLokasi = new javax.swing.JTable();
        mainDataPenempatan = new javax.swing.JPanel();
        dmPanelHeader6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        btnTambahDM3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        btnEditDM3 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnHapusDM3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tPenempatan = new javax.swing.JTable();
        mainDataMasuk = new javax.swing.JPanel();
        dmPanelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTambahDM = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnEditDM = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnHapusDM = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDM = new javax.swing.JTable();
        mainDataKeluar = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnTambahDK = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnEditDK = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnHapusDK = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tDK = new javax.swing.JTable();
        mainLapMasuk = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        mainLapKeluar = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Inventaris Aset");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS));

        navbarPanel.setBackground(new java.awt.Color(255, 255, 255));

        menuPanel.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT);
        flowLayout1.setAlignOnBaseline(true);
        menuPanel.setLayout(flowLayout1);

        sub.setBackground(new java.awt.Color(255, 255, 255));
        sub.setPreferredSize(new java.awt.Dimension(183, 40));
        sub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subMouseClicked(evt);
            }
        });

        dashboardLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        dashboardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard.png"))); // NOI18N
        dashboardLabel.setText("Dashboard");

        javax.swing.GroupLayout subLayout = new javax.swing.GroupLayout(sub);
        sub.setLayout(subLayout);
        subLayout.setHorizontalGroup(
            subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subLayout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addComponent(dashboardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subLayout.setVerticalGroup(
            subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuPanel.add(sub);

        navbarData.setBackground(new java.awt.Color(255, 255, 255));
        navbarData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navbarDataMouseClicked(evt);
            }
        });

        dataLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        dataLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data.png"))); // NOI18N
        dataLabel.setText("Data");

        javax.swing.GroupLayout navbarDataLayout = new javax.swing.GroupLayout(navbarData);
        navbarData.setLayout(navbarDataLayout);
        navbarDataLayout.setHorizontalGroup(
            navbarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
        );
        navbarDataLayout.setVerticalGroup(
            navbarDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuPanel.add(navbarData);

        subDataAset.setBackground(new java.awt.Color(255, 255, 255));
        subDataAset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subDataAsetMouseClicked(evt);
            }
        });

        asetLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        asetLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data_in.png"))); // NOI18N
        asetLabel.setText(" Data Aset");

        javax.swing.GroupLayout subDataAsetLayout = new javax.swing.GroupLayout(subDataAset);
        subDataAset.setLayout(subDataAsetLayout);
        subDataAsetLayout.setHorizontalGroup(
            subDataAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subDataAsetLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(asetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subDataAsetLayout.setVerticalGroup(
            subDataAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(asetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        menuPanel.add(subDataAset);

        subDataLokasi.setBackground(new java.awt.Color(255, 255, 255));
        subDataLokasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subDataLokasiMouseClicked(evt);
            }
        });

        lokasiLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lokasiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data_in.png"))); // NOI18N
        lokasiLabel.setText(" Data Lokasi");

        javax.swing.GroupLayout subDataLokasiLayout = new javax.swing.GroupLayout(subDataLokasi);
        subDataLokasi.setLayout(subDataLokasiLayout);
        subDataLokasiLayout.setHorizontalGroup(
            subDataLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subDataLokasiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lokasiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subDataLokasiLayout.setVerticalGroup(
            subDataLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subDataLokasiLayout.createSequentialGroup()
                .addComponent(lokasiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuPanel.add(subDataLokasi);

        navbarTransaksi.setBackground(new java.awt.Color(255, 255, 255));
        navbarTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navbarTransaksiMouseClicked(evt);
            }
        });

        transaksiLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        transaksiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data.png"))); // NOI18N
        transaksiLabel.setText("Transaksi");

        javax.swing.GroupLayout navbarTransaksiLayout = new javax.swing.GroupLayout(navbarTransaksi);
        navbarTransaksi.setLayout(navbarTransaksiLayout);
        navbarTransaksiLayout.setHorizontalGroup(
            navbarTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarTransaksiLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(transaksiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navbarTransaksiLayout.setVerticalGroup(
            navbarTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transaksiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuPanel.add(navbarTransaksi);

        subDataPenempatan.setBackground(new java.awt.Color(255, 255, 255));
        subDataPenempatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subDataPenempatanMouseClicked(evt);
            }
        });

        penempatanLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        penempatanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data_in.png"))); // NOI18N
        penempatanLabel.setText("Penempatan");

        javax.swing.GroupLayout subDataPenempatanLayout = new javax.swing.GroupLayout(subDataPenempatan);
        subDataPenempatan.setLayout(subDataPenempatanLayout);
        subDataPenempatanLayout.setHorizontalGroup(
            subDataPenempatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subDataPenempatanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(penempatanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subDataPenempatanLayout.setVerticalGroup(
            subDataPenempatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(penempatanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuPanel.add(subDataPenempatan);

        subAsetMasuk.setBackground(new java.awt.Color(255, 255, 255));
        subAsetMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subAsetMasukMouseClicked(evt);
            }
        });

        masukLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        masukLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data_in.png"))); // NOI18N
        masukLabel.setText("Aset Masuk");

        javax.swing.GroupLayout subAsetMasukLayout = new javax.swing.GroupLayout(subAsetMasuk);
        subAsetMasuk.setLayout(subAsetMasukLayout);
        subAsetMasukLayout.setHorizontalGroup(
            subAsetMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subAsetMasukLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(masukLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subAsetMasukLayout.setVerticalGroup(
            subAsetMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(masukLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuPanel.add(subAsetMasuk);

        subAsetKeluar.setBackground(new java.awt.Color(255, 255, 255));
        subAsetKeluar.setPreferredSize(new java.awt.Dimension(183, 30));
        subAsetKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subAsetKeluarMouseClicked(evt);
            }
        });

        keluarLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        keluarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data_out.png"))); // NOI18N
        keluarLabel.setText(" Aset Keluar");

        javax.swing.GroupLayout subAsetKeluarLayout = new javax.swing.GroupLayout(subAsetKeluar);
        subAsetKeluar.setLayout(subAsetKeluarLayout);
        subAsetKeluarLayout.setHorizontalGroup(
            subAsetKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subAsetKeluarLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(keluarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subAsetKeluarLayout.setVerticalGroup(
            subAsetKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(keluarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuPanel.add(subAsetKeluar);

        navbarLaporan.setBackground(new java.awt.Color(255, 255, 255));
        navbarLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navbarLaporanMouseClicked(evt);
            }
        });

        lapLabel.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        lapLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        lapLabel.setText("Laporan");

        javax.swing.GroupLayout navbarLaporanLayout = new javax.swing.GroupLayout(navbarLaporan);
        navbarLaporan.setLayout(navbarLaporanLayout);
        navbarLaporanLayout.setHorizontalGroup(
            navbarLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLaporanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lapLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        navbarLaporanLayout.setVerticalGroup(
            navbarLaporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lapLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        menuPanel.add(navbarLaporan);

        subLaporanMasuk.setBackground(new java.awt.Color(255, 255, 255));
        subLaporanMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subLaporanMasukMouseClicked(evt);
            }
        });

        lapMasukLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lapMasukLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data_in.png"))); // NOI18N
        lapMasukLabel.setText("Aset Masuk");

        javax.swing.GroupLayout subLaporanMasukLayout = new javax.swing.GroupLayout(subLaporanMasuk);
        subLaporanMasuk.setLayout(subLaporanMasukLayout);
        subLaporanMasukLayout.setHorizontalGroup(
            subLaporanMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subLaporanMasukLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lapMasukLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subLaporanMasukLayout.setVerticalGroup(
            subLaporanMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lapMasukLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuPanel.add(subLaporanMasuk);

        subLaporanKeluar.setBackground(new java.awt.Color(255, 255, 255));
        subLaporanKeluar.setPreferredSize(new java.awt.Dimension(183, 30));
        subLaporanKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subLaporanKeluarMouseClicked(evt);
            }
        });

        lapKeluarLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lapKeluarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/data_out.png"))); // NOI18N
        lapKeluarLabel.setText(" Aset Keluar");

        javax.swing.GroupLayout subLaporanKeluarLayout = new javax.swing.GroupLayout(subLaporanKeluar);
        subLaporanKeluar.setLayout(subLaporanKeluarLayout);
        subLaporanKeluarLayout.setHorizontalGroup(
            subLaporanKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subLaporanKeluarLayout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(lapKeluarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        subLaporanKeluarLayout.setVerticalGroup(
            subLaporanKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lapKeluarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        menuPanel.add(subLaporanKeluar);

        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N

        user.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        user.setText("Administrator");

        navbarComing1.setBackground(new java.awt.Color(255, 255, 255));
        navbarComing1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                navbarComing1MouseClicked(evt);
            }
        });

        logout.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        logout.setText("Logout");

        javax.swing.GroupLayout navbarComing1Layout = new javax.swing.GroupLayout(navbarComing1);
        navbarComing1.setLayout(navbarComing1Layout);
        navbarComing1Layout.setHorizontalGroup(
            navbarComing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarComing1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navbarComing1Layout.setVerticalGroup(
            navbarComing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarComing1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout navbarPanelLayout = new javax.swing.GroupLayout(navbarPanel);
        navbarPanel.setLayout(navbarPanelLayout);
        navbarPanelLayout.setHorizontalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(navbarComing1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        navbarPanelLayout.setVerticalGroup(
            navbarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(img)
                .addGap(1, 1, 1)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navbarComing1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(navbarPanel);

        mainPanel.setLayout(new java.awt.CardLayout());

        mainDashboard.setBackground(new java.awt.Color(255, 255, 255));

        panel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        panel.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        panel.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        panel.add(card3);

        javax.swing.GroupLayout mainDashboardLayout = new javax.swing.GroupLayout(mainDashboard);
        mainDashboard.setLayout(mainDashboardLayout);
        mainDashboardLayout.setHorizontalGroup(
            mainDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainDashboardLayout.setVerticalGroup(
            mainDashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDashboardLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        mainPanel.add(mainDashboard, "dashboard");

        mainDataAset.setBackground(new java.awt.Color(255, 255, 255));
        mainDataAset.setForeground(new java.awt.Color(204, 255, 255));

        dmPanelHeader3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel12.setText("Data Aset");

        javax.swing.GroupLayout dmPanelHeader3Layout = new javax.swing.GroupLayout(dmPanelHeader3);
        dmPanelHeader3.setLayout(dmPanelHeader3Layout);
        dmPanelHeader3Layout.setHorizontalGroup(
            dmPanelHeader3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dmPanelHeader3Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 312, Short.MAX_VALUE))
        );
        dmPanelHeader3Layout.setVerticalGroup(
            dmPanelHeader3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dmPanelHeader3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        actionAsetPanel.setBackground(new java.awt.Color(255, 255, 255));
        actionAsetPanel.setPreferredSize(new java.awt.Dimension(343, 200));

        btnTambahAset.setBackground(new java.awt.Color(45, 129, 255));
        btnTambahAset.setAlignmentY(0.0F);
        btnTambahAset.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTambahAset.setPreferredSize(new java.awt.Dimension(132, 35));
        btnTambahAset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahAsetMouseClicked(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah_data.png"))); // NOI18N
        jLabel6.setText("Tambah");
        jLabel6.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnTambahAsetLayout = new javax.swing.GroupLayout(btnTambahAset);
        btnTambahAset.setLayout(btnTambahAsetLayout);
        btnTambahAsetLayout.setHorizontalGroup(
            btnTambahAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnTambahAsetLayout.setVerticalGroup(
            btnTambahAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnEditAset.setBackground(new java.awt.Color(255, 204, 45));
        btnEditAset.setAlignmentY(0.0F);
        btnEditAset.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditAset.setPreferredSize(new java.awt.Dimension(132, 35));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_data.png"))); // NOI18N
        jLabel10.setText("Edit");
        jLabel10.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnEditAsetLayout = new javax.swing.GroupLayout(btnEditAset);
        btnEditAset.setLayout(btnEditAsetLayout);
        btnEditAsetLayout.setHorizontalGroup(
            btnEditAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnEditAsetLayout.setVerticalGroup(
            btnEditAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnHapusAset.setBackground(new java.awt.Color(232, 56, 95));
        btnHapusAset.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHapusAset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusAsetMouseClicked(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hapus_data.png"))); // NOI18N
        jLabel19.setText("Hapus");

        javax.swing.GroupLayout btnHapusAsetLayout = new javax.swing.GroupLayout(btnHapusAset);
        btnHapusAset.setLayout(btnHapusAsetLayout);
        btnHapusAsetLayout.setHorizontalGroup(
            btnHapusAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnHapusAsetLayout.setVerticalGroup(
            btnHapusAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnResetAset.setBackground(new java.awt.Color(204, 204, 255));
        btnResetAset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetAsetMouseClicked(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset.png"))); // NOI18N
        jLabel8.setText("Reset");

        javax.swing.GroupLayout btnResetAsetLayout = new javax.swing.GroupLayout(btnResetAset);
        btnResetAset.setLayout(btnResetAsetLayout);
        btnResetAsetLayout.setHorizontalGroup(
            btnResetAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnResetAsetLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnResetAsetLayout.setVerticalGroup(
            btnResetAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnResetAsetLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        eCariAset.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        eCariAset.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eCariAsetKeyReleased(evt);
            }
        });

        btnCariAset.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCariAset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnCariAset.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout actionAsetPanelLayout = new javax.swing.GroupLayout(actionAsetPanel);
        actionAsetPanel.setLayout(actionAsetPanelLayout);
        actionAsetPanelLayout.setHorizontalGroup(
            actionAsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionAsetPanelLayout.createSequentialGroup()
                .addComponent(btnTambahAset, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditAset, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapusAset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResetAset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(eCariAset, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCariAset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        actionAsetPanelLayout.setVerticalGroup(
            actionAsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionAsetPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(actionAsetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eCariAset)
                    .addComponent(btnHapusAset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTambahAset, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnEditAset, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnResetAset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCariAset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tAset.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode Aset", "Nama Aset"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tAset.setIntercellSpacing(new java.awt.Dimension(10, 2));
        tAset.setRowHeight(25);
        tAset.setSelectionBackground(new java.awt.Color(127, 178, 255));
        tAset.setShowHorizontalLines(false);
        jScrollPane3.setViewportView(tAset);
        if (tAset.getColumnModel().getColumnCount() > 0) {
            tAset.getColumnModel().getColumn(0).setResizable(false);
            tAset.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(actionAsetPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(actionAsetPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainDataAsetLayout = new javax.swing.GroupLayout(mainDataAset);
        mainDataAset.setLayout(mainDataAsetLayout);
        mainDataAsetLayout.setHorizontalGroup(
            mainDataAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataAsetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainDataAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainDataAsetLayout.createSequentialGroup()
                        .addComponent(dmPanelHeader3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainDataAsetLayout.setVerticalGroup(
            mainDataAsetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataAsetLayout.createSequentialGroup()
                .addComponent(dmPanelHeader3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(mainDataAset, "dataAset");

        mainDataLokasi.setBackground(new java.awt.Color(255, 255, 255));

        dmPanelHeader5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel14.setText("Data Lokasi");

        javax.swing.GroupLayout dmPanelHeader5Layout = new javax.swing.GroupLayout(dmPanelHeader5);
        dmPanelHeader5.setLayout(dmPanelHeader5Layout);
        dmPanelHeader5Layout.setHorizontalGroup(
            dmPanelHeader5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dmPanelHeader5Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 214, Short.MAX_VALUE))
        );
        dmPanelHeader5Layout.setVerticalGroup(
            dmPanelHeader5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dmPanelHeader5Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(343, 200));

        btnTambahLokasi.setBackground(new java.awt.Color(45, 129, 255));
        btnTambahLokasi.setAlignmentY(0.0F);
        btnTambahLokasi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTambahLokasi.setPreferredSize(new java.awt.Dimension(132, 35));
        btnTambahLokasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahLokasiMouseClicked(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah_data.png"))); // NOI18N
        jLabel9.setText("Tambah");
        jLabel9.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnTambahLokasiLayout = new javax.swing.GroupLayout(btnTambahLokasi);
        btnTambahLokasi.setLayout(btnTambahLokasiLayout);
        btnTambahLokasiLayout.setHorizontalGroup(
            btnTambahLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnTambahLokasiLayout.setVerticalGroup(
            btnTambahLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnEditLokasi.setBackground(new java.awt.Color(255, 204, 45));
        btnEditLokasi.setAlignmentY(0.0F);
        btnEditLokasi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditLokasi.setPreferredSize(new java.awt.Dimension(132, 35));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_data.png"))); // NOI18N
        jLabel15.setText("Edit");
        jLabel15.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnEditLokasiLayout = new javax.swing.GroupLayout(btnEditLokasi);
        btnEditLokasi.setLayout(btnEditLokasiLayout);
        btnEditLokasiLayout.setHorizontalGroup(
            btnEditLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnEditLokasiLayout.setVerticalGroup(
            btnEditLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnHapusLokasi.setBackground(new java.awt.Color(232, 56, 95));
        btnHapusLokasi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHapusLokasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusLokasiMouseClicked(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hapus_data.png"))); // NOI18N
        jLabel29.setText("Hapus");

        javax.swing.GroupLayout btnHapusLokasiLayout = new javax.swing.GroupLayout(btnHapusLokasi);
        btnHapusLokasi.setLayout(btnHapusLokasiLayout);
        btnHapusLokasiLayout.setHorizontalGroup(
            btnHapusLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnHapusLokasiLayout.setVerticalGroup(
            btnHapusLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnResetLokasi.setBackground(new java.awt.Color(204, 204, 255));
        btnResetLokasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetLokasiMouseClicked(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset.png"))); // NOI18N
        jLabel30.setText("Reset");

        javax.swing.GroupLayout btnResetLokasiLayout = new javax.swing.GroupLayout(btnResetLokasi);
        btnResetLokasi.setLayout(btnResetLokasiLayout);
        btnResetLokasiLayout.setHorizontalGroup(
            btnResetLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnResetLokasiLayout.createSequentialGroup()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnResetLokasiLayout.setVerticalGroup(
            btnResetLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnResetLokasiLayout.createSequentialGroup()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        eCariLokasi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        eCariLokasi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                eCariLokasiKeyReleased(evt);
            }
        });

        btnCariLokasi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCariLokasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnCariLokasi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(btnTambahLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapusLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnResetLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(eCariLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCariLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eCariLokasi)
                    .addComponent(btnHapusLokasi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTambahLokasi, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnEditLokasi, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnResetLokasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCariLokasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tLokasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Lokasi", "Nama Lokasi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tLokasi.setIntercellSpacing(new java.awt.Dimension(10, 2));
        tLokasi.setRowHeight(25);
        tLokasi.setSelectionBackground(new java.awt.Color(127, 178, 255));
        tLokasi.setShowHorizontalLines(false);
        jScrollPane7.setViewportView(tLokasi);
        if (tLokasi.getColumnModel().getColumnCount() > 0) {
            tLokasi.getColumnModel().getColumn(0).setResizable(false);
            tLokasi.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainDataLokasiLayout = new javax.swing.GroupLayout(mainDataLokasi);
        mainDataLokasi.setLayout(mainDataLokasiLayout);
        mainDataLokasiLayout.setHorizontalGroup(
            mainDataLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataLokasiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainDataLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainDataLokasiLayout.createSequentialGroup()
                        .addComponent(dmPanelHeader5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainDataLokasiLayout.setVerticalGroup(
            mainDataLokasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataLokasiLayout.createSequentialGroup()
                .addComponent(dmPanelHeader5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(mainDataLokasi, "dataLokasi");

        mainDataPenempatan.setBackground(new java.awt.Color(153, 255, 255));

        dmPanelHeader6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel21.setText("Data Penempatan Aset");

        javax.swing.GroupLayout dmPanelHeader6Layout = new javax.swing.GroupLayout(dmPanelHeader6);
        dmPanelHeader6.setLayout(dmPanelHeader6Layout);
        dmPanelHeader6Layout.setHorizontalGroup(
            dmPanelHeader6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dmPanelHeader6Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(0, 149, Short.MAX_VALUE))
        );
        dmPanelHeader6Layout.setVerticalGroup(
            dmPanelHeader6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dmPanelHeader6Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(343, 200));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel25.setText("Nama Lokasi");

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel26.setText("ID Lokasi");

        jTextField15.setColumns(5);
        jTextField15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jTextField15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(127, 178, 255)));

        jTextField16.setColumns(5);
        jTextField16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jTextField16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(127, 178, 255)));

        btnTambahDM3.setBackground(new java.awt.Color(45, 129, 255));
        btnTambahDM3.setAlignmentY(0.0F);
        btnTambahDM3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTambahDM3.setPreferredSize(new java.awt.Dimension(132, 35));
        btnTambahDM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahDM3MouseClicked(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah_data.png"))); // NOI18N
        jLabel22.setText("Tambah");
        jLabel22.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnTambahDM3Layout = new javax.swing.GroupLayout(btnTambahDM3);
        btnTambahDM3.setLayout(btnTambahDM3Layout);
        btnTambahDM3Layout.setHorizontalGroup(
            btnTambahDM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnTambahDM3Layout.setVerticalGroup(
            btnTambahDM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnEditDM3.setBackground(new java.awt.Color(255, 204, 45));
        btnEditDM3.setAlignmentY(0.0F);
        btnEditDM3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditDM3.setPreferredSize(new java.awt.Dimension(132, 35));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_data.png"))); // NOI18N
        jLabel27.setText("Edit");
        jLabel27.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnEditDM3Layout = new javax.swing.GroupLayout(btnEditDM3);
        btnEditDM3.setLayout(btnEditDM3Layout);
        btnEditDM3Layout.setHorizontalGroup(
            btnEditDM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnEditDM3Layout.setVerticalGroup(
            btnEditDM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btnHapusDM3.setBackground(new java.awt.Color(232, 56, 95));
        btnHapusDM3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hapus_data.png"))); // NOI18N
        jLabel28.setText("Hapus");

        javax.swing.GroupLayout btnHapusDM3Layout = new javax.swing.GroupLayout(btnHapusDM3);
        btnHapusDM3.setLayout(btnHapusDM3Layout);
        btnHapusDM3Layout.setHorizontalGroup(
            btnHapusDM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnHapusDM3Layout.setVerticalGroup(
            btnHapusDM3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField15, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(jTextField16)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btnTambahDM3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditDM3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusDM3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jTextField16, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addGap(113, 113, 113))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnHapusDM3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTambahDM3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditDM3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tPenempatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Lokasi", "Nama Lokasi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPenempatan.setIntercellSpacing(new java.awt.Dimension(10, 2));
        tPenempatan.setRowHeight(25);
        tPenempatan.setSelectionBackground(new java.awt.Color(127, 178, 255));
        tPenempatan.setShowHorizontalLines(false);
        jScrollPane8.setViewportView(tPenempatan);
        if (tPenempatan.getColumnModel().getColumnCount() > 0) {
            tPenempatan.getColumnModel().getColumn(0).setResizable(false);
            tPenempatan.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainDataPenempatanLayout = new javax.swing.GroupLayout(mainDataPenempatan);
        mainDataPenempatan.setLayout(mainDataPenempatanLayout);
        mainDataPenempatanLayout.setHorizontalGroup(
            mainDataPenempatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataPenempatanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainDataPenempatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainDataPenempatanLayout.createSequentialGroup()
                        .addComponent(dmPanelHeader6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainDataPenempatanLayout.setVerticalGroup(
            mainDataPenempatanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataPenempatanLayout.createSequentialGroup()
                .addComponent(dmPanelHeader6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(mainDataPenempatan, "dataPenempatan");

        mainDataMasuk.setBackground(new java.awt.Color(255, 255, 255));

        dmPanelHeader.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("Data Aset Masuk");

        javax.swing.GroupLayout dmPanelHeaderLayout = new javax.swing.GroupLayout(dmPanelHeader);
        dmPanelHeader.setLayout(dmPanelHeaderLayout);
        dmPanelHeaderLayout.setHorizontalGroup(
            dmPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dmPanelHeaderLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dmPanelHeaderLayout.setVerticalGroup(
            dmPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dmPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnTambahDM.setBackground(new java.awt.Color(45, 129, 255));
        btnTambahDM.setAlignmentY(0.0F);
        btnTambahDM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTambahDM.setPreferredSize(new java.awt.Dimension(132, 35));
        btnTambahDM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahDMMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah_data.png"))); // NOI18N
        jLabel2.setText("Tambah");
        jLabel2.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnTambahDMLayout = new javax.swing.GroupLayout(btnTambahDM);
        btnTambahDM.setLayout(btnTambahDMLayout);
        btnTambahDMLayout.setHorizontalGroup(
            btnTambahDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnTambahDMLayout.setVerticalGroup(
            btnTambahDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnEditDM.setBackground(new java.awt.Color(255, 204, 45));
        btnEditDM.setAlignmentY(0.0F);
        btnEditDM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditDM.setPreferredSize(new java.awt.Dimension(132, 35));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_data.png"))); // NOI18N
        jLabel4.setText("Edit");
        jLabel4.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnEditDMLayout = new javax.swing.GroupLayout(btnEditDM);
        btnEditDM.setLayout(btnEditDMLayout);
        btnEditDMLayout.setHorizontalGroup(
            btnEditDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnEditDMLayout.setVerticalGroup(
            btnEditDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnHapusDM.setBackground(new java.awt.Color(232, 56, 95));
        btnHapusDM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hapus_data.png"))); // NOI18N
        jLabel16.setText("Hapus");

        javax.swing.GroupLayout btnHapusDMLayout = new javax.swing.GroupLayout(btnHapusDM);
        btnHapusDM.setLayout(btnHapusDMLayout);
        btnHapusDMLayout.setHorizontalGroup(
            btnHapusDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnHapusDMLayout.setVerticalGroup(
            btnHapusDMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jTextField2.setText("Search");
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(127, 178, 255)));

        tDM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tDM.setForeground(new java.awt.Color(255, 255, 255));
        tDM.setModel(new javax.swing.table.DefaultTableModel(
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
        tDM.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tDM.setGridColor(new java.awt.Color(0, 0, 0));
        tDM.setRowHeight(25);
        tDM.setSelectionBackground(new java.awt.Color(127, 178, 255));
        tDM.setShowHorizontalLines(false);
        tDM.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tDM);

        javax.swing.GroupLayout mainDataMasukLayout = new javax.swing.GroupLayout(mainDataMasuk);
        mainDataMasuk.setLayout(mainDataMasukLayout);
        mainDataMasukLayout.setHorizontalGroup(
            mainDataMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataMasukLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainDataMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dmPanelHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainDataMasukLayout.createSequentialGroup()
                        .addGroup(mainDataMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
                            .addGroup(mainDataMasukLayout.createSequentialGroup()
                                .addComponent(btnTambahDM, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditDM, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHapusDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        mainDataMasukLayout.setVerticalGroup(
            mainDataMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataMasukLayout.createSequentialGroup()
                .addComponent(dmPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainDataMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainDataMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnHapusDM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTambahDM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditDM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(mainDataMasuk, "dataMasuk");

        mainDataKeluar.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel3.setText("Data Aset Keluar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(621, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnTambahDK.setBackground(new java.awt.Color(45, 129, 255));
        btnTambahDK.setAlignmentY(0.0F);
        btnTambahDK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTambahDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahDKMouseClicked(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tambah_data.png"))); // NOI18N
        jLabel17.setText("Tambah");
        jLabel17.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnTambahDKLayout = new javax.swing.GroupLayout(btnTambahDK);
        btnTambahDK.setLayout(btnTambahDKLayout);
        btnTambahDKLayout.setHorizontalGroup(
            btnTambahDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnTambahDKLayout.setVerticalGroup(
            btnTambahDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btnEditDK.setBackground(new java.awt.Color(255, 204, 45));
        btnEditDK.setAlignmentY(0.0F);
        btnEditDK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditDK.setPreferredSize(new java.awt.Dimension(132, 35));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit_data.png"))); // NOI18N
        jLabel5.setText("Edit");
        jLabel5.setAlignmentY(0.0F);

        javax.swing.GroupLayout btnEditDKLayout = new javax.swing.GroupLayout(btnEditDK);
        btnEditDK.setLayout(btnEditDKLayout);
        btnEditDKLayout.setHorizontalGroup(
            btnEditDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnEditDKLayout.setVerticalGroup(
            btnEditDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        btnHapusDK.setBackground(new java.awt.Color(232, 56, 95));
        btnHapusDK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hapus_data.png"))); // NOI18N
        jLabel18.setText("Hapus");

        javax.swing.GroupLayout btnHapusDKLayout = new javax.swing.GroupLayout(btnHapusDK);
        btnHapusDK.setLayout(btnHapusDKLayout);
        btnHapusDKLayout.setHorizontalGroup(
            btnHapusDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );
        btnHapusDKLayout.setVerticalGroup(
            btnHapusDKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jTextField3.setText("Search");

        tDK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tDK.setForeground(new java.awt.Color(255, 255, 255));
        tDK.setModel(new javax.swing.table.DefaultTableModel(
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
        tDK.setGridColor(new java.awt.Color(0, 0, 0));
        tDK.setIntercellSpacing(new java.awt.Dimension(1, 10));
        tDK.setRowHeight(25);
        tDK.setSelectionBackground(new java.awt.Color(241, 140, 163));
        tDK.setShowHorizontalLines(false);
        tDK.getTableHeader().setReorderingAllowed(false);
        tDK.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(tDK);

        javax.swing.GroupLayout mainDataKeluarLayout = new javax.swing.GroupLayout(mainDataKeluar);
        mainDataKeluar.setLayout(mainDataKeluarLayout);
        mainDataKeluarLayout.setHorizontalGroup(
            mainDataKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainDataKeluarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainDataKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(mainDataKeluarLayout.createSequentialGroup()
                        .addComponent(btnTambahDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditDK, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        mainDataKeluarLayout.setVerticalGroup(
            mainDataKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainDataKeluarLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainDataKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainDataKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(mainDataKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTambahDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(mainDataKeluar, "dataKeluar");

        mainLapMasuk.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainLapMasukLayout = new javax.swing.GroupLayout(mainLapMasuk);
        mainLapMasuk.setLayout(mainLapMasukLayout);
        mainLapMasukLayout.setHorizontalGroup(
            mainLapMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLapMasukLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainLapMasukLayout.setVerticalGroup(
            mainLapMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLapMasukLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(mainLapMasuk, "laporanMasuk");

        mainLapKeluar.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 926, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainLapKeluarLayout = new javax.swing.GroupLayout(mainLapKeluar);
        mainLapKeluar.setLayout(mainLapKeluarLayout);
        mainLapKeluarLayout.setHorizontalGroup(
            mainLapKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLapKeluarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainLapKeluarLayout.setVerticalGroup(
            mainLapKeluarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLapKeluarLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(mainLapKeluar, "laporanKeluar");

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahDMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDMMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "addForm");
    }//GEN-LAST:event_btnTambahDMMouseClicked

    private void btnTambahDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDKMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "addForm");
    }//GEN-LAST:event_btnTambahDKMouseClicked

    private void btnTambahAsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahAsetMouseClicked
        // TODO add your handling code here:
        AsetTambahData asetTambahData = new AsetTambahData();
        asetTambahData.setVisible(true);
    }//GEN-LAST:event_btnTambahAsetMouseClicked

    private void btnTambahDM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahDM3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahDM3MouseClicked

    private void navbarComing1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbarComing1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_navbarComing1MouseClicked

    private void navbarLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbarLaporanMouseClicked
        // TODO add your handling code here:
        if (subLaporanMasuk.isVisible()) {
            subLaporanMasuk.setVisible(false);
            subLaporanKeluar.setVisible(false);

        }else{
            subLaporanMasuk.setVisible(true);
            subLaporanKeluar.setVisible(true);
        }
    }//GEN-LAST:event_navbarLaporanMouseClicked

    private void subAsetKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subAsetKeluarMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "dataKeluar");
    }//GEN-LAST:event_subAsetKeluarMouseClicked

    private void subAsetMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subAsetMasukMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "dataMasuk");
    }//GEN-LAST:event_subAsetMasukMouseClicked

    private void subDataPenempatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subDataPenempatanMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "dataPenempatan");
    }//GEN-LAST:event_subDataPenempatanMouseClicked

    private void navbarTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbarTransaksiMouseClicked
        // TODO add your handling code here:
        if (subAsetMasuk.isVisible()) {
            subAsetMasuk.setVisible(false);
            subAsetKeluar.setVisible(false);
            subDataPenempatan.setVisible(false);

        }else{
            subAsetMasuk.setVisible(true);
            subAsetKeluar.setVisible(true);
            subDataPenempatan.setVisible(true);
        }
    }//GEN-LAST:event_navbarTransaksiMouseClicked

    private void subDataLokasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subDataLokasiMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "dataLokasi");
    }//GEN-LAST:event_subDataLokasiMouseClicked

    private void subDataAsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subDataAsetMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "dataAset");
    }//GEN-LAST:event_subDataAsetMouseClicked

    private void navbarDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_navbarDataMouseClicked
        // TODO add your handling code here:
        if (subDataAset.isVisible()) {
            subDataAset.setVisible(false);
            subDataLokasi.setVisible(false);

        }else{
            subDataAset.setVisible(true);
            subDataLokasi.setVisible(true);
        }
    }//GEN-LAST:event_navbarDataMouseClicked

    private void subMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "dashboard");
    }//GEN-LAST:event_subMouseClicked

    private void subLaporanMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subLaporanMasukMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "laporanMasuk");
    }//GEN-LAST:event_subLaporanMasukMouseClicked

    private void subLaporanKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subLaporanKeluarMouseClicked
        // TODO add your handling code here:
        CardLayout c1 = (CardLayout)(mainPanel.getLayout());
        c1.show(mainPanel, "laporanKeluar");
    }//GEN-LAST:event_subLaporanKeluarMouseClicked

    private void btnResetAsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetAsetMouseClicked
        // TODO add your handling code here:
        resetTable("");
    }//GEN-LAST:event_btnResetAsetMouseClicked

    private void eCariAsetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eCariAsetKeyReleased
        // TODO add your handling code here:
        resetTable(" WHERE id_aset like '%"+eCariAset.getText()+"%' OR"
                + " nama_aset like '%"+eCariAset.getText()+"%'");
    }//GEN-LAST:event_eCariAsetKeyReleased

    private void btnHapusAsetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusAsetMouseClicked
        // TODO add your handling code here:
        int i = tAset.getSelectedRow();
                int pilihan = JOptionPane.showConfirmDialog(
                        null,
                        "Yakin mau hapus ?",
                        "Konfirmasi hapus",
                        JOptionPane.YES_NO_OPTION);
                if (pilihan==0) {
                    if (i>=0) {
                        try {
                            TableModel model = tAset.getModel();
                            Koneksi koneksi = new Koneksi();
                            Connection con = koneksi.getConnection();
                            String executeQuery = "DELETE FROM tbl_aset WHERE id_aset =?";
                            PreparedStatement ps = con.prepareStatement(executeQuery);
                            ps.setString(1, model.getValueAt(i, 0).toString());
                            ps.executeUpdate();
                        } catch (SQLException ex) {
                            System.err.println("ex");
                        }
                    }else{
                        JOptionPane.showMessageDialog(
                                null,
                                "Pilih data yang ingin dihapus"
                                );
                    }
                }
                resetTable("");
    }//GEN-LAST:event_btnHapusAsetMouseClicked

    private void btnTambahLokasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahLokasiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahLokasiMouseClicked

    private void btnHapusLokasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusLokasiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusLokasiMouseClicked

    private void btnResetLokasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetLokasiMouseClicked
        // TODO add your handling code here:
        resetTableLokasi("");
    }//GEN-LAST:event_btnResetLokasiMouseClicked

    private void eCariLokasiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eCariLokasiKeyReleased
        // TODO add your handling code here:
        resetTable(" WHERE id_lokasi like '%"+eCariLokasi.getText()+"%' OR"
                + " nama_lokasi like '%"+eCariLokasi.getText()+"%'");
    }//GEN-LAST:event_eCariLokasiKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplikasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplikasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionAsetPanel;
    private javax.swing.JLabel asetLabel;
    private javax.swing.JLabel btnCariAset;
    private javax.swing.JLabel btnCariLokasi;
    private javax.swing.JPanel btnEditAset;
    private javax.swing.JPanel btnEditDK;
    private javax.swing.JPanel btnEditDM;
    private javax.swing.JPanel btnEditDM3;
    private javax.swing.JPanel btnEditLokasi;
    private javax.swing.JPanel btnHapusAset;
    private javax.swing.JPanel btnHapusDK;
    private javax.swing.JPanel btnHapusDM;
    private javax.swing.JPanel btnHapusDM3;
    private javax.swing.JPanel btnHapusLokasi;
    private javax.swing.JPanel btnResetAset;
    private javax.swing.JPanel btnResetLokasi;
    private javax.swing.JPanel btnTambahAset;
    private javax.swing.JPanel btnTambahDK;
    private javax.swing.JPanel btnTambahDM;
    private javax.swing.JPanel btnTambahDM3;
    private javax.swing.JPanel btnTambahLokasi;
    private GUI.Card card1;
    private GUI.Card card2;
    private GUI.Card card3;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JPanel dmPanelHeader;
    private javax.swing.JPanel dmPanelHeader3;
    private javax.swing.JPanel dmPanelHeader5;
    private javax.swing.JPanel dmPanelHeader6;
    private javax.swing.JTextField eCariAset;
    private javax.swing.JTextField eCariLokasi;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel keluarLabel;
    private javax.swing.JLabel lapKeluarLabel;
    private javax.swing.JLabel lapLabel;
    private javax.swing.JLabel lapMasukLabel;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel lokasiLabel;
    private javax.swing.JPanel mainDashboard;
    private javax.swing.JPanel mainDataAset;
    private javax.swing.JPanel mainDataKeluar;
    private javax.swing.JPanel mainDataLokasi;
    private javax.swing.JPanel mainDataMasuk;
    private javax.swing.JPanel mainDataPenempatan;
    private javax.swing.JPanel mainLapKeluar;
    private javax.swing.JPanel mainLapMasuk;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel masukLabel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel navbarComing1;
    private javax.swing.JPanel navbarData;
    private javax.swing.JPanel navbarLaporan;
    private javax.swing.JPanel navbarPanel;
    private javax.swing.JPanel navbarTransaksi;
    private javax.swing.JLayeredPane panel;
    private javax.swing.JLabel penempatanLabel;
    private javax.swing.JPanel sub;
    private javax.swing.JPanel subAsetKeluar;
    private javax.swing.JPanel subAsetMasuk;
    private javax.swing.JPanel subDataAset;
    private javax.swing.JPanel subDataLokasi;
    private javax.swing.JPanel subDataPenempatan;
    private javax.swing.JPanel subLaporanKeluar;
    private javax.swing.JPanel subLaporanMasuk;
    private javax.swing.JTable tAset;
    private javax.swing.JTable tDK;
    private javax.swing.JTable tDM;
    private javax.swing.JTable tLokasi;
    private javax.swing.JTable tPenempatan;
    private javax.swing.JLabel transaksiLabel;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
