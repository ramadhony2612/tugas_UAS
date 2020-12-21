/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Model.Barang;
import java.util.List;
/**
 *
 * @author vitky
 */
public interface BarangInterface {
    public boolean insert(Barang b);
    public boolean update(Barang b);
    public boolean delete(Barang b);
    public List<Barang> getAllBarang();
}
