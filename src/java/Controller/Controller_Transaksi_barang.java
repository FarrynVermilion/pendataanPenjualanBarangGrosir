/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAO_Transaksi_barang;
import DAO.DAO_Barang;
import java.util.ArrayList;
import model.Transaksi_barang;
import model.Barang;
import java.math.BigInteger;

/**
 *
 * @author edelweiss
 */
public class Controller_Transaksi_barang {
    DAO_Transaksi_barang dao = new DAO_Transaksi_barang();
    DAO_Barang dBarang = new DAO_Barang();
    
    public void insert(Transaksi_barang object) {
        dao.insert(object);
        Barang brg = dBarang.getCari(String.valueOf(object.getID_barang())).get(0);
        BigInteger stok = brg.getStok();
        BigInteger jumlahPembelian = BigInteger.valueOf(object.getJumlah_pembelian());
        BigInteger sisa = stok.subtract(jumlahPembelian);
        brg.setStok(sisa);
        dBarang.update(brg);
    }

    public void insertAll(ArrayList<Transaksi_barang> list) {
        for(Transaksi_barang barang :list){
            dao.insert(barang);
            Barang brg = dBarang.getCari(String.valueOf(barang.getID_barang())).get(0);
            BigInteger stok = brg.getStok();
            BigInteger jumlahPembelian = BigInteger.valueOf(barang.getJumlah_pembelian());
            BigInteger sisa = stok.subtract(jumlahPembelian);
            brg.setStok(sisa);
            dBarang.update(brg);
        }
    }
    
    public void delete(String id_transaksi , String id_barang) {
        Barang brg = dBarang.getCari(id_barang).get(0);
        BigInteger stok = brg.getStok();
        BigInteger jumlahPembelian = BigInteger.valueOf(dao.getCari(id_transaksi,id_barang).get(0).getJumlah_pembelian());
        BigInteger sisa = stok.add(jumlahPembelian);
        brg.setStok(sisa);
        dBarang.update(brg);
        dao.delete(id_transaksi , id_barang);
    }
    
    public void deleteAllTransaction(String id_transaksi) {
        ArrayList<Transaksi_barang> listTransaksi = dao.getAllTransaction(id_transaksi);
        for(Transaksi_barang barang:listTransaksi ){
            Barang brg = dBarang.getCari(String.valueOf(barang.getID_barang())).get(0);
            BigInteger stok = brg.getStok();
            BigInteger jumlahPembelian = BigInteger.valueOf(dao.getCari(id_transaksi,String.valueOf(barang.getID_barang())).get(0).getJumlah_pembelian());
            BigInteger sisa = stok.add(jumlahPembelian);
            brg.setStok(sisa);
            dBarang.update(brg);
        }
        dao.deleteTransaction(id_transaksi);
    }
    
    public ArrayList<Transaksi_barang>  getAllTransaction(String id_transaksi) {
        return dao.getAllTransaction(id_transaksi);
    }
    
    public ArrayList<Transaksi_barang>  getAll() {
        return dao.getAll();
    }
    
    public ArrayList<Transaksi_barang> getCari(String Transaksi,String Barang) {
        return dao.getCari(Transaksi,Barang);
    }


}
