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
public class Aset {
    private int id_aset;
    private String nama_aset;

    public Aset(int id_aset, String nama_aset) {
        this.id_aset = id_aset;
        this.nama_aset = nama_aset;
    }

    public Aset() {
    }

    public int getId_aset() {
        return id_aset;
    }

    public void setId_aset(int id_aset) {
        this.id_aset = id_aset;
    }

    public String getNama_aset() {
        return nama_aset;
    }

    public void setNama_aset(String nama_aset) {
        this.nama_aset = nama_aset;
    }
}
