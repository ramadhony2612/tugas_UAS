/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MemberDAO;
import Interface.MemberInterface;
import Model.OperasiCRUD;
import Model.Member;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author vitky
 */
public class MemberController extends Observable{
    private MemberInterface dao = new MemberDAO();
    private OperasiCRUD c;
    
    private void setDAO(MemberInterface dao){
        this.dao = dao;
    }
    
    public boolean setDml(Member u, OperasiCRUD c){
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
    
    public List<Member> getAllMember(){
        return dao.getAllMember();
    }
}
