/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import koneksi.Database;
import model.Customer;

/**
 *
 * @author edelweiss
 */
public class DAO_Customer {
    Connection conn = Database.KoneksiDB();
    String INSERT = "INSERT INTO `Transaksi`(`Nama_customer`, `Alamat_penagihan`, `Telepon`) VALUES ('?','?','?')";
    String UPDATE = "UPDATE `Customer` SET `Nama_customer`='?',`Alamat_penagihan`='?',`Telepon`='?' WHERE `ID_customer`='?'";
    String SELECT = "SELECT * FROM Customer WHERE ID_customer LIKE ?";
    String DELETE = "DELETE FROM Customer WHERE ID_customer = ?";
    String ALL = "SELECT * FROM Customer";

    public void insert(Customer object) {
        try {
            PreparedStatement st = conn.prepareStatement(SELECT);
            st.setString(1, String.valueOf(object.getID_customer()));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("Data sudah ada");
            } else {
                st = conn.prepareStatement(INSERT);
                st.setString(1, object.getNama_customer());
                st.setString(2, object.getAlamat_penagihan());
                st.setString(3, object.getTelepon());
                st.executeUpdate();
                System.out.println("Insert sukses");
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Gagal");
            e.printStackTrace();
        }
    }

    public void update(Customer object) {
        try {
            PreparedStatement st = conn.prepareStatement(UPDATE);
            st.setString(1, object.getNama_customer());
            st.setString(2, object.getAlamat_penagihan());
            st.setString(3, object.getTelepon());
            st.setString(4, String.valueOf(object.getID_customer()));
            
            st.executeUpdate();
            System.out.println("Data berhasil diubah");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            PreparedStatement st = conn.prepareStatement(DELETE);
            st.setString(1, id);
            st.executeUpdate();
            st.close();
            System.out.println("Hapus sukses");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Customer> getCari(String key) {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(SELECT);
            st.setString(1, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer objCustomer = new Customer();
                objCustomer.setID_customer(rs.getInt("ID_customer"));
                objCustomer.setNama_customer(rs.getString("Nama_customer"));
                objCustomer.setAlamat_penagihan(rs.getString("Alamat_penagihan"));
                list.add(objCustomer);
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Customer> getAll() {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(ALL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer objCustomer = new Customer();
                objCustomer.setID_customer(rs.getInt("ID_customer"));
                objCustomer.setNama_customer(rs.getString("Nama_customer"));
                objCustomer.setAlamat_penagihan(rs.getString("Alamat_penagihan"));
                objCustomer.setTelepon(rs.getString("Telepon"));
                list.add(objCustomer);
            }
            st.close();
            System.out.println("All data retrieved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
