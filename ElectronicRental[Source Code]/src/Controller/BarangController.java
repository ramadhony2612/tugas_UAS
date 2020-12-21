/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.BarangDAO;
import Interface.BarangInterface;
import Model.OperasiCRUD;
import Model.Barang;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author vitky
 */
public class BarangController extends Observable{
    private BarangInterface dao = new BarangDAO();
    private OperasiCRUD c;
    
    private void setDAO(BarangInterface dao){
        this.dao = dao;
    }
    
    public boolean setDml(Barang u, OperasiCRUD c){
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
    
    public List<Barang> getAllBarang(){
        return dao.getAllBarang();
    }
    
}
