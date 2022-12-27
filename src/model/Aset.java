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
public class Aset {
    private String id_aset;
    private String nama_aset;

    public Aset(String id_aset, String nama_aset) {
        this.id_aset = id_aset;
        this.nama_aset = nama_aset;
    }

    public Aset() {
    }

    public String getId_aset() {
        return id_aset;
    }

    public void setId_aset(String id_aset) {
        this.id_aset = id_aset;
    }

    public String getNama_aset() {
        return nama_aset;
    }

    public void setNama_aset(String nama_aset) {
        this.nama_aset = nama_aset;
    }
}
