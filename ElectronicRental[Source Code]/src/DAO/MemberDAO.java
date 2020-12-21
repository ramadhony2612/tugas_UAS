/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.MemberInterface;
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
public class MemberDAO implements MemberInterface{ 

    @Override
    public boolean insert(Member m) {
        String sql = "INSERT INTO member(nik, nama, tempat, tanggal, jk) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setString(1, m.getNIK());
            st.setString(2, m.getNama());
            st.setString(3, m.getTempat());
            st.setString(4, m.getTanggal());
            st.setString(5, m.getJK());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(Member m) {
        String sql = "UPDATE member SET nik=?, nama=?, tempat=?, tanggal=?, jk=? WHERE id=?";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setString(1, m.getNIK());
            st.setString(2, m.getNama());
            st.setString(3, m.getTempat());
            st.setString(4, m.getTanggal());
            st.setString(5, m.getJK());
            st.setInt(6, m.getId());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(Member m) {
        
        String sql = "DELETE FROM member WHERE id=?";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setInt(1, m.getId());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Member> getAllMember() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM member";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Member u = new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                members.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return members;
    }
    
}
