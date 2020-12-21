/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Interface.UserInteface;
import Model.OperasiCRUD;
import Model.User;
import View.HalamanAdmin;
import View.HalamanLogin;
import View.HalamanPetugas;
import java.util.List;
//import View.HalamanUtama;
import java.util.Observable;
/**
 *
 * @author vitky
 */
public class UserController extends Observable{
    private UserInteface dao = new UserDAO();
    private OperasiCRUD c;
    
    private void setDAO(UserInteface dao){
        this.dao = dao;
    }
    
    public boolean setDml(User u, OperasiCRUD c){
        boolean hasil = false;
        this.c = c;
        switch(c){
            case INSERT : hasil = dao.insert(u); break;
            case UPDATE : hasil = dao.update(u); break;
            case DELETE : hasil = dao.delete(u); break;
        }
        setChanged();
        if(hasil){
            notifyObservers(u);
        }else{
            notifyObservers();
        }
        return hasil;
    }
    
    public void login(User u, HalamanLogin hl){
        if(dao.verifikasi(u)) dao.login(u, hl);
        else System.out.println("Login Gagal");
    }
    
    public List<User> getAllUser(){
        return dao.getAllUser();
    }
    
    public void logout(HalamanAdmin ha){
        dao.logout(ha);
    }
    
    public void logout(HalamanPetugas hp){
        dao.logout(hp);
    }
}
