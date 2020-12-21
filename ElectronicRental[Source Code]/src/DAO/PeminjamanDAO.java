/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.PeminjamanInterface;
import Model.Barang;
import Model.Peminjaman;
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
public class PeminjamanDAO implements PeminjamanInterface{

    @Override
    public boolean insert(Peminjaman p) {
        String sql = "INSERT INTO peminjaman(id_barang, id_member, durasi, pinjam, kembali, biaya, dp, status_pinjam, status_bayar, status_dp) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setInt(1, p.getIdBarang());
            st.setInt(2, p.getIdUser());
            st.setInt(3, p.getDurasi());
            st.setString(4, p.getTglPinjam());
            st.setString(5, p.getTglKemabli());
            st.setInt(6, p.getBiaya());
            st.setInt(7, p.getDp());
            st.setInt(8, p.getStatusPinjam());
            st.setInt(9, p.getStatusBayar());
            st.setInt(10, p.getStatusDP());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Peminjaman p) {
        String sql = "UPDATE peminjaman SET id_barang=?, id_member=?, durasi=?, pinjam=?, kembali=?, biaya=?, dp=?, status_pinjam=?, status_bayar=?, status_dp=? WHERE id=?";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setInt(1, p.getIdBarang());
            st.setInt(2, p.getIdUser());
            st.setInt(3, p.getDurasi());
            st.setString(4, p.getTglPinjam());
            st.setString(5, p.getTglKemabli());
            st.setInt(6, p.getBiaya());
            st.setInt(7, p.getDp());
            st.setInt(8, p.getStatusPinjam());
            st.setInt(9, p.getStatusBayar());
            st.setInt(10, p.getStatusDP());
            st.setInt(11, p.getId());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Peminjaman p) {
        String sql = "DELETE FROM peminjaman WHERE id=?";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setInt(1, p.getId());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Peminjaman> getAllPeminjaman() {
        List<Peminjaman> peminjamans = new ArrayList<>();
        String sql = "SELECT * FROM peminjaman";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Peminjaman p = new Peminjaman(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
                peminjamans.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return peminjamans;
    }
    
}
