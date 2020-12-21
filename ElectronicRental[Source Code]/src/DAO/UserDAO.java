/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interface.UserInteface;
import Model.User;
import View.HalamanLogin;
import View.HalamanAdmin;
import View.HalamanPetugas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vitky
 */
public class UserDAO implements UserInteface{
    
    @Override
    public boolean insert(User u) {
        String sql = "INSERT INTO user(uname, password, role) VALUES(?,?,?)";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setString(1, u.getUname());
            st.setString(2, u.getPassword());
            st.setInt(3, u.getRole());
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(User u) {
        String sql = "UPDATE user SET uname=?, password=?, role=? WHERE id=?";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setString(1, u.getUname());
            st.setString(2, u.getPassword());
            st.setInt(3, u.getRole());
            st.setInt(4, u.getId());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(User u) {
        String sql = "DELETE FROM user WHERE id=?";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            st.setInt(1, u.getId());
            System.out.print(st);
            int hasil = st.executeUpdate();
            if(hasil>0){
                return true;
            }
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void login(User u, HalamanLogin hl) {
        hl.dispose();
        if(u.getRole() == 1){
            HalamanAdmin ha = new HalamanAdmin();
            ha.setVisible(true);
        }else{
            HalamanPetugas hp = new HalamanPetugas();
            hp.setVisible(true);
        }
    }

    @Override
    public boolean verifikasi(User u) {
        String sql = "SELECT * FROM user WHERE uname='"+u.getUname()+"' AND password='"+u.getPassword()+"'";
        try {
            Statement st = Koneksi.openKoneksi().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                String id = rs.getString("id");
                u.setId(Integer.valueOf(id));
                u.setRole(Integer.valueOf(rs.getString("role")));
                return true;
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;        
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user";
        try {
            PreparedStatement st = Koneksi.openKoneksi().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3), rs.getInt(4));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public void logout(HalamanAdmin ha) {
        ha.dispose();
        HalamanLogin hl = new HalamanLogin();
        hl.setVisible(true);
    }

    @Override
    public void logout(HalamanPetugas hp) {
        hp.dispose();
        HalamanLogin hl = new HalamanLogin();
        hl.setVisible(true);
    }

}
