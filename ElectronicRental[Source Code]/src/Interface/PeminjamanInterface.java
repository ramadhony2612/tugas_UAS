/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Model.Peminjaman;
import java.util.List;
/**
 *
 * @author vitky
 */
public interface PeminjamanInterface {
    public boolean insert(Peminjaman p);
    public boolean update(Peminjaman p);
    public boolean delete(Peminjaman p);
    public List<Peminjaman> getAllPeminjaman();    
}
