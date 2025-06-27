/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.DAO_Customer;
import model.Customer;
import java.util.ArrayList;

/**
 *
 * @author edelweiss
 */
public class Controller_Customer {
    DAO_Customer daoCustomer = new DAO_Customer();
    
    public void insert(Customer object) {
        daoCustomer.insert(object);
    }
    
    public void update(Customer object) {
        daoCustomer.update(object);
    }
    
    public void delete(String id) {
        daoCustomer.delete(id);
    }
    
    public ArrayList<Customer> getCari(String key) {
        return daoCustomer.getCari(key);
    }
    
    public ArrayList<Customer> getAll() {
        return daoCustomer.getAll();
    }
    public void insertAll(ArrayList<Customer> list) {
        for (Customer objCustomer : list) {
            insert(objCustomer);
        }
    }
}
