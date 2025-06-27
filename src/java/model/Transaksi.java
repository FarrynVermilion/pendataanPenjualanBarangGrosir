/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author edelweiss
 */
public class Transaksi {
    protected static final SimpleDateFormat sql = new SimpleDateFormat("yyyy-MM-dd");
    protected static final SimpleDateFormat show = new SimpleDateFormat("dd-MM-yyyy");

    protected BigInteger ID_transaksi;
    protected int ID_customer;
    protected String Alamat_pengiriman;
    protected String Telepon;
    protected boolean Lunas;
    protected Date Tanggal_pembelian;
    protected Date Tanggal_pengiriman;
    protected Date Tanggal_pembayaran;
    
//    Data dsimpan dalam bentuk dateformat di DB YYYY_MM_DD sama kayak html
//    Buat tunjukin string ambil printVar kalo set setHTMLVar
    public String printTanggal_pembelian(){
        return show.format(Tanggal_pembelian);
    }
    public String printTanggal_pengiriman(){
        return show.format(Tanggal_pengiriman);
    }
    public String printTanggal_pembayaran(){
        return show.format(Tanggal_pembayaran);
    }
    public void setHTMLTanggal_pembelian(String Tanggal_pembelian){
        try {
            this.Tanggal_pembelian = sql.parse(Tanggal_pembelian);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            this.Tanggal_pembelian = null;
        }
    }
    public void setHTMLTanggal_pengiriman(String Tanggal_pengiriman){
        try {
            this.Tanggal_pengiriman = sql.parse(Tanggal_pengiriman);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            this.Tanggal_pengiriman = null;
        }
    }
    public void setHTMLTanggal_pembayaran(String Tanggal_pembayaran){
    if (Tanggal_pembayaran == null || Tanggal_pembayaran.isEmpty()) {
        this.Tanggal_pembayaran = null;
        return;
    }
    try {
        this.Tanggal_pembayaran = sql.parse(Tanggal_pembayaran);
    } catch (ParseException e) {
        this.Tanggal_pembayaran = null;
        // Optional: log error
    }
    }

    public void setID_transaksi(BigInteger ID_transaksi) {
        this.ID_transaksi = ID_transaksi;
    }

    public void setID_customer(int ID_customer) {
        this.ID_customer = ID_customer;
    }

    public void setAlamat_pengiriman(String Alamat_pengiriman) {
        this.Alamat_pengiriman = Alamat_pengiriman;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

    public void setLunas(boolean Lunas) {
        this.Lunas = Lunas;
    }

    public void setTanggal_pembelian(Date Tanggal_pembelian) {
        this.Tanggal_pembelian = Tanggal_pembelian;
    }

    public void setTanggal_pengiriman(Date Tanggal_pengiriman) {
        this.Tanggal_pengiriman = Tanggal_pengiriman;
    }

    public void setTanggal_pembayaran(Date Tanggal_pembayaran) {
        this.Tanggal_pembayaran = Tanggal_pembayaran;
    }
    
    public BigInteger getID_transaksi() {
        return ID_transaksi;
    }

    public int getID_customer() {
        return ID_customer;
    }

    public String getAlamat_pengiriman() {
        return Alamat_pengiriman;
    }

    public String getTelepon() {
        return Telepon;
    }

    public boolean isLunas() {
        return Lunas;
    }

    public Date getTanggal_pembelian() {
        return Tanggal_pembelian;
    }

    public Date getTanggal_pengiriman() {
        return Tanggal_pengiriman;
    }

    public Date getTanggal_pembayaran() {
        return Tanggal_pembayaran;
    }

    
    
}
