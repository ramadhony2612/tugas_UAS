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
public class Peminjaman {
    private int id;
    private String tglPinjam;
    private String tglKembali;
    private int idBarang;
    private int idUser;
    private int durasi;
    private int biaya;
    private int dp;
    private int statusBayar;
    private int statusPinjam;
    private int statusDP;
    
    public Peminjaman(int id, int idBarang, int idUser, int durasi, String tglPinjam, String tglKembali, int biaya, int dp, int statusPinjam, int statusBayar, int statusDP){
        this.id = id;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.idBarang = idBarang;
        this.idUser = idUser;
        this.durasi = durasi;
        this.biaya = biaya;
        this.dp = dp;
        this.statusBayar = statusBayar;
        this.statusPinjam = statusPinjam;
        this.statusDP = statusDP;
    }
    
    public Peminjaman(int idBarang, int idUser, int durasi, String tglPinjam, String tglKembali, int biaya, int dp, int statusPinjam, int statusBayar, int statusDP){
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.idBarang = idBarang;
        this.idUser = idUser;
        this.durasi = durasi;
        this.biaya = biaya;
        this.dp = dp;
        this.statusBayar = statusBayar;
        this.statusPinjam = statusPinjam;
        this.statusDP = statusDP;
    }
    
    public Peminjaman(int id){
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setTglPinjam(String tglPinjam){
        this.tglPinjam = tglPinjam;
    }
    
    public String getTglPinjam(){
        return this.tglPinjam;
    }
    
    public void setTglKembali(String tglKembali){
        this.tglKembali = tglKembali;
    }
    
    public String getTglKemabli(){
        return this.tglKembali;
    }

    public void setIdBarang(int idBarang){
        this.idBarang = idBarang;
    }
    
    public int getIdBarang(){
        return this.idBarang;
    }
    
    public void setIdUser(int idUser){
        this.idUser = idUser;
    }
    
    public int getIdUser(){
        return this.idUser;
    }
    
    public void setDurasi(int durasi){
        this.durasi = durasi;
    }
    
    public int getDurasi(){
        return this.durasi;
    }

    public void setBiaya(int biaya){
        this.biaya = biaya;
    }
    
    public int getBiaya(){
        return this.biaya;
    }
    
    public void setDp(int dp){
        this.dp = dp;
    }
    
    public int getDp(){
        return this.dp;
    }
    
    public void setStatusBayar(int statusBayar){
        this.statusBayar = statusBayar;
    }
    
    public int getStatusBayar(){
        return this.statusBayar;
    }
    
    public void setStatusPinjam(int statusPinjam){
        this.statusPinjam = statusPinjam;
    }
    
    public int getStatusPinjam(){
        return this.statusPinjam;
    }
    
    public void setStatusDP(int statusDP){
        this.statusDP = statusDP;
    }
    
    public int getStatusDP(){
        return this.statusDP;
    }
}
