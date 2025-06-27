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
import model.Barang;

/**
 *
 * @author edelweiss
 */
public class DAO_Barang {
    Connection conn = Database.KoneksiDB();
    String INSERT = "INSERT INTO `Barang`( `Nama_barang`, `Jenis_barang`, `Stok`, `Harga_barang`, `Lama_garansi`) VALUES (?,?,?,?,?)";
    String UPDATE = "UPDATE `Barang` SET `Nama_barang`='?',`Jenis_barang`='?',`Stok`='?',`Harga_barang`='?',`Lama_garansi`='?' WHERE `ID_barang`='[value-1]'";
    String SELECT = "SELECT * FROM Barang WHERE ID_barang LIKE ?";
    String DELETE = "DELETE FROM Barang WHERE ID_barang = ?";
    String ALL = "SELECT * FROM Barang";


    public void insert(Barang object) {
        try {
            PreparedStatement st = conn.prepareStatement(SELECT);
            st.setString(1, String.valueOf(object.getID_barang()));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("Data sudah ada");
            } else {
                st = conn.prepareStatement(INSERT);
                st.setString(1, object.getNama_barang());
                st.setString(2, object.getJenis_barang());
                st.setString(3, String.valueOf(object.getStok()));
                st.setString(4, String.valueOf(object.getHarga_barang()));
                st.setString(5, String.valueOf(object.getLama_garansi()));
                st.executeUpdate();
                System.out.println("Insert sukses");
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Gagal");
            e.printStackTrace();
        }
    }

    public void update(Barang object) {
        try {
            PreparedStatement st = conn.prepareStatement(UPDATE);
            st.setString(1, object.getNama_barang());

            
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

    public ArrayList<Barang> getCari(String key) {
        ArrayList<Barang> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(SELECT);
            st.setString(1, "%" + key + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Barang objBarang = new Barang();
                objBarang.setID_barang(rs.getInt("ID_barang"));
                objBarang.setNama_barang(rs.getString("Nama_barang"));
                objBarang.setJenis_barang(rs.getString("Jenis_barang"));
                objBarang.setStok(rs.getBigDecimal("Stok").toBigInteger());
                objBarang.setHarga_barang(rs.getBigDecimal("Harga_barang"));
                objBarang.setLama_garansi(rs.getInt("Lama_garansi"));
                list.add(objBarang);
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Barang> getAll() {
        ArrayList<Barang> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(ALL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Barang objBarang = new Barang();
                objBarang.setID_barang(rs.getInt("ID_barang"));
                objBarang.setNama_barang(rs.getString("Nama_barang"));
                objBarang.setJenis_barang(rs.getString("Jenis_barang"));
                objBarang.setStok(rs.getBigDecimal("Stok").toBigInteger());
                objBarang.setHarga_barang(rs.getBigDecimal("Harga_barang"));
                objBarang.setLama_garansi(rs.getInt("Lama_garansi"));
                list.add(objBarang);
            }
            st.close();
            System.out.println("All data retrieved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
