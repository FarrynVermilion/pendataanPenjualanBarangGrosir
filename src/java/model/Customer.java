/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author edelweiss
 */
public class Customer {
    int ID_customer;
    String Nama_customer;
    String Alamat_penagihan;
    String Telepon;

    public void setID_customer(int ID_customer) {
        this.ID_customer = ID_customer;
    }

    public void setNama_customer(String Nama_customer) {
        this.Nama_customer = Nama_customer;
    }

    public void setAlamat_penagihan(String Alamat_penagihan) {
        this.Alamat_penagihan = Alamat_penagihan;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

    public int getID_customer() {
        return ID_customer;
    }

    public String getNama_customer() {
        return Nama_customer;
    }

    public String getAlamat_penagihan() {
        return Alamat_penagihan ;
    }


    public String getTelepon() {
        return Telepon;
    }
}
