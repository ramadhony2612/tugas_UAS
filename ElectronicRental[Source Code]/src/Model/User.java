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
public class User {
    private int id;
    private String uname;
    private String password;
    private int role;
    
    public User(int id, String uname, String password, int role){
        this.id = id;
        this.uname = uname;
        this.password = password;
        this.role = role;
    }
    
    public User(String uname, String password, int role){
        this.uname = uname;
        this.password = password;
        this.role = role;
    }
    
    public User(String uname, String password){
        this.uname = uname;
        this.password = password;
    }
    
    public User(int id){
        this.id = id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setUname(String uname){
        this.uname = uname;
    }
    
    public String getUname(){
        return this.uname;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return this.password;
    }    
    
    public void setRole(int role){
        this.role = role;
    }
    
    public int getRole(){
        return this.role;
    }
}
