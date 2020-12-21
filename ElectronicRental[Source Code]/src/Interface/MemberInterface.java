/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Member;
import java.util.List;

/**
 *
 * @author vitky
 */
public interface MemberInterface {
    public boolean insert(Member u);
    public boolean update(Member u);
    public boolean delete(Member u);
    public List<Member> getAllMember();
}
