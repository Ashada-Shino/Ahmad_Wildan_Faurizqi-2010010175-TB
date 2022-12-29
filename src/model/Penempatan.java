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
public class Penempatan {
    private int id_penempatan;
    private int id_aset;
    private String nama_aset;
    private int id_lokasi;
    private String nama_lokasi;
    
    Aset aset;
    Lokasi lokasi;

    public Penempatan(int id_penempatan, int id_aset, String nama_aset, int id_lokasi, String nama_lokasi) {
        this.id_penempatan = id_penempatan;
        this.id_aset = id_aset;
        this.nama_aset = nama_aset;
        this.id_lokasi = id_lokasi;
        this.nama_lokasi = nama_lokasi;
        this.aset = new Aset(id_aset, nama_aset);
        this.lokasi = new Lokasi(id_lokasi, nama_lokasi);
    }

    public Penempatan() {
    }

    public int getId_penempatan() {
        return id_penempatan;
    }

    public void setId_penempatan(int id_penempatan) {
        this.id_penempatan = id_penempatan;
    }

    public int getId_aset() {
        return id_aset;
    }

    public void setId_aset(int id_aset) {
        this.id_aset = id_aset;
    }


    public int getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(int id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public Aset getAset() {
        return aset;
    }

    public void setAset(Aset aset) {
        this.aset = aset;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }
    
    
}
