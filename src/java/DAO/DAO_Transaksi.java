/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import koneksi.Database;
import model.Transaksi;
import java.math.BigInteger;
/**
 *
 * @author edelweiss
 */
public class DAO_Transaksi {
    
    SimpleDateFormat sql = new SimpleDateFormat("yyyy-MM-dd");
    // SimpleDateFormat show = new SimpleDateFormat("dd-MM-yyyy");

    Connection conn = Database.KoneksiDB();
    String INSERT = "INSERT INTO `Transaksi`(`ID_customer`, `Alamat_pengiriman`, `Telepon`, `Lunas`, `Tanggal_pembelian`,`Tanggal_pengiriman`) VALUES (?,?,?,?,?,?)";
    String UPDATE = "UPDATE `Transaksi` SET Alamat_pengiriman`='?',`Telepon`='?',`Lunas`='?',`Tanggal_pengiriman`='?',`Tabggal_pelunasan`='?' WHERE `ID_transaksi`='?'";
    String SELECT = "SELECT * FROM Transaksi WHERE ID_transaksi = ?";
    String DELETE = "DELETE FROM Transaksi WHERE ID_transaksi = ?";
    String ALL = "SELECT * FROM Transaksi";
    
    public void insert(Transaksi object){
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setString(1, String.valueOf(object.getID_customer()));
            ps.setObject(2, object.getAlamat_pengiriman());
            ps.setObject(3, object.getTelepon());
            ps.setObject(4, 0);
            ps.setObject(5, sql.format(new Date()));
            ps.setObject(6, sql.format(object.getTanggal_pengiriman()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public BigInteger insertAndGetID(Transaksi object){
        BigInteger last_inserted_id = BigInteger.valueOf(0);
        try {
            PreparedStatement ps = conn.prepareStatement(INSERT);
            ps.setString(1, String.valueOf(object.getID_customer()));
            ps.setObject(2, object.getAlamat_pengiriman());
            ps.setObject(3, object.getTelepon());
            ps.setObject(4, 0);
            ps.setObject(5, sql.format(new Date()));
            ps.setObject(6, sql.format(object.getTanggal_pengiriman()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                last_inserted_id = rs.getBigDecimal(1).toBigInteger();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return last_inserted_id;
    }
    
    public void update(Transaksi object){
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE);
            ps.setObject(1, object.getAlamat_pengiriman());
            ps.setObject(2, object.getTelepon());
            ps.setObject(3, object.isLunas());
            ps.setObject(4, object.getTanggal_pengiriman());
            ps.setObject(5, object.getTanggal_pembayaran());
            ps.setObject(6, object.getID_transaksi());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(String id){
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
    
    public ArrayList<Transaksi> getCari(String key) {
        ArrayList<Transaksi> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(SELECT);
            st.setString(1, key);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Transaksi objTransaksi = new Transaksi();
                objTransaksi.setID_transaksi(rs.getBigDecimal("ID_transaksi").toBigInteger());
                objTransaksi.setID_customer(rs.getInt("ID_customer"));
                objTransaksi.setAlamat_pengiriman(rs.getString("Alamat_pengiriman"));
                objTransaksi.setTelepon(rs.getString("Telepon"));
                objTransaksi.setLunas(rs.getBoolean("Lunas"));
                objTransaksi.setHTMLTanggal_pembelian(rs.getString("Tanggal_pembelian"));
                objTransaksi.setHTMLTanggal_pengiriman(rs.getString("Tanggal_pengiriman"));
                objTransaksi.setHTMLTanggal_pembayaran(rs.getString("Tabggal_pelunasan"));
                list.add(objTransaksi);
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> list = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(ALL);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Transaksi objTransaksi = new Transaksi();
                objTransaksi.setID_transaksi(rs.getBigDecimal("ID_transaksi").toBigInteger());
                objTransaksi.setID_customer(rs.getInt("ID_customer"));
                objTransaksi.setAlamat_pengiriman(rs.getString("Alamat_pengiriman"));
                objTransaksi.setTelepon(rs.getString("Telepon"));
                objTransaksi.setLunas(rs.getBoolean("Lunas"));
                objTransaksi.setHTMLTanggal_pembelian(rs.getString("Tanggal_pembelian"));
                objTransaksi.setHTMLTanggal_pengiriman(rs.getString("Tanggal_pengiriman"));
                objTransaksi.setHTMLTanggal_pembayaran(rs.getString("Tabggal_pelunasan"));
                list.add(objTransaksi);
            }
            st.close();
            System.out.println("All data retrieved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
