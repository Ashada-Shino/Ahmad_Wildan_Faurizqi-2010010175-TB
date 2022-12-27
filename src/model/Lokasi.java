/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ashada.model;

/**
 *
 * @author Ashada
 */
public class Lokasi {
    private int id_lokasi;
    private String nama_lokasi;

    public Lokasi(int id_lokasi, String nama_lokasi) {
        this.id_lokasi = id_lokasi;
        this.nama_lokasi = nama_lokasi;
    }

    public Lokasi() {
    }

    public int getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(int id_lokasi) {
        this.id_lokasi = id_lokasi;
    }

    public String getNama_lokasi() {
        return nama_lokasi;
    }

    public void setNama_lokasi(String nama_lokasi) {
        this.nama_lokasi = nama_lokasi;
    }
    
}
