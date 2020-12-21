/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vitky
 */
public class Koneksi {
    private static Connection kon;
    private static final String URL = "jdbc:mysql://localhost/electronic_rental";
    private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    public static Connection openKoneksi(){
        if(kon==null){
            try {
                Class.forName(DRIVERNAME);                
                try {
                    kon = (com.mysql.jdbc.Connection)DriverManager.getConnection(URL, USERNAME, PASSWORD);
                } catch (SQLException ex1) {
                    System.out.println("TERHUBUNG");
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("DRIVER TIDAK DITEMUKAN "+ex);
            }            
        }
        return kon;
    }
    
    public static Connection tutupKoneksi(){
        if(kon==null){
            try {
                kon.close();
            } catch (SQLException ex) {
                System.out.println("ERROR : "+ex);
            }
        }
        return kon;
    }
    
    public static void main(String[] args){
        new Koneksi();
    }
}
