/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {

    static Role role;

    protected Role() {
    }

    public abstract JPanel createWorkArea(JPanel mainWorkArea, UserAccount account);

    public static Role getInstance() {
        return role;
    }

    @Override
    public String toString() {
        return this.getClass().getName().split(".")[-1];
    }
}
