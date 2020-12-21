/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.BarangInterface;
import Model.Barang;
import Model.Member;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitky
 */
public class BarangDAO implements BarangInterface{

    @Override
    public boolean insert(Barang b) {
        String sql = "INSERT INTO barang(nama, harga) VALUES(?,?)";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setString(1, b.getNama());
            st.setInt(2, b.getHarga());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Barang b) {
        String sql = "UPDATE barang SET nama=?, harga=? WHERE id=?";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setString(1, b.getNama());
            st.setInt(2, b.getHarga());
            st.setInt(3, b.getId());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Barang b) {
        String sql = "DELETE FROM barang WHERE id=?";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setInt(1, b.getId());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Barang> getAllBarang() {
        List<Barang> barangs = new ArrayList<>();
        String sql = "SELECT * FROM barang";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Barang u = new Barang(rs.getInt(1),rs.getString(2),rs.getInt(3));
                barangs.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return barangs;
    }
    
    
}
