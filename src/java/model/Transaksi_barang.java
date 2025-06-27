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
public class Transaksi_barang {
    BigInteger ID_transaksi;
    int ID_barang;
    BigDecimal Harga_satuan;
    int Jumlah_pembelian;
    int Lama_garansi;
    public void setID_transaksi(BigInteger ID_transaksi) {
        this.ID_transaksi = ID_transaksi;
    }

    public void setID_barang(int ID_barang) {
        this.ID_barang = ID_barang;
    }

    public void setHarga_satuan(BigDecimal Harga_satuan) {
        this.Harga_satuan = Harga_satuan;
    }

    public void setJumlah_pembelian(int Jumlah_pembelian) {
        this.Jumlah_pembelian = Jumlah_pembelian;
    }

    public void setLama_garansi(int Lama_garansi) {
        this.Lama_garansi = Lama_garansi;
    }
    
    public BigInteger getID_transaksi() {
        return ID_transaksi;
    }

    public int getID_barang() {
        return ID_barang;
    }

    public BigDecimal getHarga_satuan() {
        return Harga_satuan;
    }

    public int getJumlah_pembelian() {
        return Jumlah_pembelian;
    }

    public int getLama_garansi() {
        return Lama_garansi;
    }
    
    
}
