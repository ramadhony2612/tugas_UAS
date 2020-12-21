/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import Model.User;
import View.HalamanAdmin;
import View.HalamanLogin;
import View.HalamanPetugas;
import java.util.List;
/**
 *
 * @author vitky
 */
public interface UserInteface {
    public boolean insert(User u);
    public boolean update(User u);
    public boolean delete(User u);
    public boolean verifikasi(User u);
    public void login(User u, HalamanLogin hl);
    public void logout(HalamanAdmin ha);
    public void logout(HalamanPetugas hp);
    public List<User> getAllUser();
}
