/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAO_Transaksi;
import DAO.DAO_Transaksi_barang;
import java.util.ArrayList;
import model.Transaksi;
import model.Transaksi_barang;
import java.math.BigInteger;
import Controller.Controller_Transaksi_barang;

/**
 *
 * @author edelweiss
 */
public class Controller_Transaksi {
    DAO_Transaksi daoTransaksi = new DAO_Transaksi();
    DAO_Transaksi_barang daoTransaksiBarang = new DAO_Transaksi_barang();
    Controller_Transaksi_barang controllerTransaksiBarang = new Controller_Transaksi_barang();
    public ArrayList<Transaksi> getAll(){
        return daoTransaksi.getAll();
    }
    public ArrayList<Transaksi> getCari(String key){
        return daoTransaksi.getCari(key);
    }
    public void insertNewTransaksiDanTransaksiBarang(Transaksi object, ArrayList<Transaksi_barang> list){
        BigInteger id = daoTransaksi.insertAndGetID(object);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setID_transaksi(id);
            daoTransaksiBarang.insert(list.get(i));
        }
    }
    public void update(Transaksi object){
        daoTransaksi.update(object);
    }
    public void delete(String id){
        daoTransaksi.delete(id);
        controllerTransaksiBarang.deleteAllTransaction(id);
    }
}
