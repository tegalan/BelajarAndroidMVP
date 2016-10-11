package com.pringstudio.cobamvp.model;

/**
 * Created by sucipto on 10/11/16.
 */

public class BuahModel implements IBuahModel {
    String nama;
    String deskripsi;
    int jumlah;

    public BuahModel(){

    }

    public BuahModel(String nama){
        this.nama = nama;
    }

    @Override
    public void addBuah(BuahModel buahModel) {
        //
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
