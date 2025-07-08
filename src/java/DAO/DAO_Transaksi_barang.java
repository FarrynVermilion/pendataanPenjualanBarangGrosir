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
import model.Transaksi_barang;

/**
 *
 * @author edelweiss
 */
public class DAO_Transaksi_barang {
    Connection conn = Database.KoneksiDB();
    String INSERT = "INSERT INTO `Transaksi_barang`(`ID_barang`, `ID_transaksi`, `Lama_garansi`, `Jumlah_pembelian`, `Harga_satuan`) VALUES (?,?,?,?,?)";
    // String UPDATE = "UPDATE `Transaksi_barang` SET `Lama_garansi`='?',`Jumlah_pembelian`='?',`Harga_satuan`='?' WHERE `ID_Transaksi`='?' AND `ID_barang`='?'";
    String SELECT = "SELECT * FROM Transaksi_barang WHERE ID_Transaksi LIKE ? AND ID_barang LIKE ? ";
    String DELETE = "DELETE FROM Transaksi_barang WHERE ID_Transaksi = ? AND ID_barang = ?";
    String ALL = "SELECT * FROM Transaksi_barang";
    String DELETE_TRANSACTION = "DELETE FROM Transaksi_barang WHERE ID_Transaksi = ?";
    String ALL_TRANSACTION = "SELECT * FROM Transaksi_barang WHERE ID_Transaksi = ?";
    
    public void insert(Transaksi_barang object){
        try {
            PreparedStatement st = conn.prepareStatement(SELECT);
            st.setString(1, String.valueOf(object.getID_transaksi()));
            st.setString(2, String.valueOf(object.getID_barang()));
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("Data sudah ada");
            } else {
                st = conn.prepareStatement(INSERT);
                st.setString(1, String.valueOf(object.getID_barang()));
                st.setString(2, String.valueOf(object.getID_transaksi()));
                st.setString(3, String.valueOf(object.getLama_garansi()));
                st.setString(4, String.valueOf(object.getJumlah_pembelian()));
                st.setString(5, String.valueOf(object.getHarga_satuan()));
                st.executeUpdate();
                System.out.println("Insert sukses");
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Gagal");
            e.printStackTrace();
        }
    }
    
    // public void update(Transaksi_barang object){
    //     try {
    //         PreparedStatement ps = conn.prepareStatement(UPDATE);
    //         ps.setObject(1, object.getLama_garansi());
    //         ps.setObject(2, object.getJumlah_pembelian());
    //         ps.setObject(3, object.getHarga_satuan());
    //         ps.setObject(4, object.getID_transaksi());
    //         ps.setObject(5, object.getID_barang());
    //         ps.executeUpdate();
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
    
    public void delete(String id_transaksi , String id_barang) {
        try {
            PreparedStatement st = conn.prepareStatement(DELETE);
            st.setString(1, id_transaksi);
            st.setString(2, id_barang);
            st.executeUpdate();
            st.close();
            System.out.println("Hapus sukses");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTransaction(String id_transaksi) {
        try {
            PreparedStatement st = conn.prepareStatement(DELETE_TRANSACTION);
            st.setString(1, id_transaksi);
            st.executeUpdate();
            st.close();
            System.out.println("Hapus sukses");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Transaksi_barang> getCari(String transaksi,String barang) {
        ArrayList<Transaksi_barang> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(SELECT);
            st.setString(1, transaksi);
            st.setString(2, barang);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Transaksi_barang objTransaksi_barang = new Transaksi_barang();
                objTransaksi_barang.setID_transaksi(rs.getBigDecimal("ID_transaksi").toBigInteger());
                objTransaksi_barang.setID_barang(rs.getInt("ID_barang"));
                objTransaksi_barang.setLama_garansi(rs.getInt("Lama_garansi"));
                objTransaksi_barang.setJumlah_pembelian(rs.getInt("Jumlah_pembelian"));
                objTransaksi_barang.setHarga_satuan(rs.getBigDecimal("Harga_satuan"));
                list.add(objTransaksi_barang);
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Transaksi_barang>  getAll() {
        ArrayList<Transaksi_barang> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(ALL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Transaksi_barang objTransaksi_barang = new Transaksi_barang();
                objTransaksi_barang.setID_transaksi(rs.getBigDecimal("ID_transaksi").toBigInteger());
                objTransaksi_barang.setID_barang(rs.getInt("ID_barang"));
                objTransaksi_barang.setLama_garansi(rs.getInt("Lama_garansi"));
                objTransaksi_barang.setJumlah_pembelian(rs.getInt("Jumlah_pembelian"));
                objTransaksi_barang.setHarga_satuan(rs.getBigDecimal("Harga_satuan"));
                list.add(objTransaksi_barang);
            }
            st.close();
            System.out.println("All data retrieved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<Transaksi_barang>  getAllTransaction(String id_transaksi) {
        ArrayList<Transaksi_barang> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(ALL_TRANSACTION);
            st.setString(1, id_transaksi);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Transaksi_barang objTransaksi_barang = new Transaksi_barang();
                objTransaksi_barang.setID_transaksi(rs.getBigDecimal("ID_transaksi").toBigInteger());
                objTransaksi_barang.setID_barang(rs.getInt("ID_barang"));
                objTransaksi_barang.setLama_garansi(rs.getInt("Lama_garansi"));
                objTransaksi_barang.setJumlah_pembelian(rs.getInt("Jumlah_pembelian"));
                objTransaksi_barang.setHarga_satuan(rs.getBigDecimal("Harga_satuan"));
                list.add(objTransaksi_barang);
            }
            st.close();
            System.out.println("All data retrieved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
