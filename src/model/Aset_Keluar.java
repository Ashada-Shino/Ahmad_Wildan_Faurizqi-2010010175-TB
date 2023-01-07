/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ashada
 */
public class Aset_Keluar {
    private int id_keluar;
    private String tanggal_keluar;
    private int id_aset;
    private String nama_aset;
    
    Aset aset;

    public Aset_Keluar() {
    }

    public Aset_Keluar(int id_keluar, String tanggal_keluar, int id_aset, String nama_aset) {
        this.id_keluar = id_keluar;
        this.tanggal_keluar = tanggal_keluar;
        this.id_aset = id_aset;
        this.nama_aset = nama_aset;
        this.aset = new Aset(id_aset, nama_aset);
    }

    public int getId_keluar() {
        return id_keluar;
    }

    public void setId_keluar(int id_keluar) {
        this.id_keluar = id_keluar;
    }

    public String getTanggal_keluar() {
        return tanggal_keluar;
    }

    public void setTanggal_keluar(String tanggal_keluar) {
        this.tanggal_keluar = tanggal_keluar;
    }

    public int getId_aset() {
        return id_aset;
    }

    public void setId_aset(int id_aset) {
        this.id_aset = id_aset;
    }
    
    public Aset getAset() {
        return aset;
    }

    public void setAset(Aset aset) {
        this.aset = aset;
    }
}

