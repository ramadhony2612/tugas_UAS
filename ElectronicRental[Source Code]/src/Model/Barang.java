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
public class Barang {
    private int id;
    private String nama;
    private int harga;
    
    public Barang(int id, String nama, int harga){
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }
    
    public Barang(String nama, int harga){
        this.nama = nama;
        this.harga = harga;
    }
    
    public Barang(int id){
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public void setHarga(int harga){
        this.harga = harga;
    }
    
    public int getHarga(){
        return this.harga;
    }
}
