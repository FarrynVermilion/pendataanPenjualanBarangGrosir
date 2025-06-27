/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author edelweiss
 */
public class Barang {

    int ID_barang;
    String Nama_barang;
    String Jenis_barang;
    BigInteger Stok;
    BigDecimal Harga_barang;
    int Lama_garansi;

    public void setID_barang(int ID_barang) {
        this.ID_barang = ID_barang;
    }

    public void setNama_barang(String Nama_barang) {
        this.Nama_barang = Nama_barang;
    }

    public void setJenis_barang(String Jenis_barang) {
        this.Jenis_barang = Jenis_barang;
    }

    public void setStok(BigInteger Stok) {
        this.Stok = Stok;
    }

    public void setHarga_barang(BigDecimal Harga_barang) {
        this.Harga_barang = Harga_barang;
    }

    public void setLama_garansi(int Lama_garansi) {
        this.Lama_garansi = Lama_garansi;
    }

    public int getID_barang() {
        return ID_barang;
    }

    public String getNama_barang() {
        return Nama_barang;
    }

    public String getJenis_barang() {
        return Jenis_barang;
    }

    public BigInteger getStok() {
        return Stok;
    }

    public BigDecimal getHarga_barang() {
        return Harga_barang;
    }

    public int getLama_garansi() {
        return Lama_garansi;
    }

}
