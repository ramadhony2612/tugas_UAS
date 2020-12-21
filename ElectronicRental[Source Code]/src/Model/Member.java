/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author vitky
 */
public class Member {
    private int id;
    private String nik;
    private String nama;
    private String tempat;
    private String tanggal;
    private String jk;
    
    public Member(int id, String nik, String nama, String tempat, String tanggal, String jk){
        this.id = id;
        this.nik = nik;
        this.nama = nama;
        this.tempat = tempat;
        this.tanggal = tanggal;
        this.jk = jk;
    }
    
    public Member(String nik, String nama, String tempat, String tanggal, String jk){
        this.nik = nik;
        this.nama = nama;
        this.tempat = tempat;
        this.tanggal = tanggal;
        this.jk = jk;
    }
    
    public Member(int id){
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNIK(String nik){
        this.nik = nik;
    }
    
    public String getNIK(){
        return this.nik;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public void setTempat(String tempat){
        this.tempat = tempat;
    }
    
    public String getTempat(){
        return this.tempat;
    }
    
    public void setTanggal(String tanggal){
        this.tanggal = tanggal;
    }
    
    public String getTanggal(){
        return this.tanggal;
    }
    
    public void setJK(String jk){
        this.jk = jk;
    }
    
    public String getJK(){
        return this.jk;
    }
}
