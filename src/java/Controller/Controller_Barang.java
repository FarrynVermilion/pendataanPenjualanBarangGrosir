/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAO_Barang;
import java.util.ArrayList;
import model.Barang;

/**
 *
 * @author edelweiss
 */
public class Controller_Barang {
    DAO_Barang daoBarang = new DAO_Barang();
    
    public ArrayList<Barang> getAll() {
        return daoBarang.getAll();
    }
    
    public ArrayList<Barang> getCari(String key) {
        return daoBarang.getCari(key);
    }
    
    public void delete(String id) {
        daoBarang.delete(id);
    }
    
    public void update(Barang objBarang) {
        daoBarang.update(objBarang);
    }
    
    public void insert(Barang objBarang) {
        daoBarang.insert(objBarang);
    }
    
    public void insertAll(ArrayList<Barang> list) {
        for (Barang objBarang : list) {
            insert(objBarang);
        }
    }
    
}
