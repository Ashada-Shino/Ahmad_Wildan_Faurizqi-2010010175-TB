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
public class Aset_Masuk {
    private int id_masuk;
    private String tanggal_masuk;
    private int id_aset;
    private String nama_aset;
    
    Aset aset;

    public Aset_Masuk() {
    }

    public Aset_Masuk(int id_masuk, String tanggal_masuk, int id_aset, String nama_aset) {
        this.id_masuk = id_masuk;
        this.tanggal_masuk = tanggal_masuk;
        this.id_aset = id_aset;
        this.nama_aset = nama_aset;
        this.aset = new Aset(id_aset, nama_aset);
    }

    public int getId_masuk() {
        return id_masuk;
    }

    public void setId_masuk(int id_masuk) {
        this.id_masuk = id_masuk;
    }

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
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
