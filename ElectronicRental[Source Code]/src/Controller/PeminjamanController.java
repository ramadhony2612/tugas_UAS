/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PeminjamanDAO;
import Interface.PeminjamanInterface;
import Model.OperasiCRUD;
import Model.Peminjaman;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author vitky
 */
public class PeminjamanController extends Observable{
    private PeminjamanInterface dao = new PeminjamanDAO();
    private OperasiCRUD c;
    
    private void setDAO(PeminjamanInterface dao){
        this.dao = dao;
    }
    
    public boolean setDml(Peminjaman u, OperasiCRUD c){
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
    
    public List<Peminjaman> getAllPeminjaman(){
        return dao.getAllPeminjaman();
    }
    
}
