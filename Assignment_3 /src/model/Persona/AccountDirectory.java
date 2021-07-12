/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author aeloyq
 */
public class AccountDirectory {

    HashMap<String, Profile> accountProfileMap = new HashMap<String, Profile>();
    HashMap<String, java.lang.Class> accountRoleMap = new HashMap<String, java.lang.Class>();
    static AccountDirectory accountDirectory = null;

    public class AccountNameConflictException extends Exception {

        private AccountNameConflictException(String account_Name_Conflict) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    private AccountDirectory() {
    }

    public static AccountDirectory getInstance() {
        if (AccountDirectory.accountDirectory == null) {
            AccountDirectory accountDirectory = new AccountDirectory();
            AccountDirectory.accountDirectory = accountDirectory;
        }
        return AccountDirectory.accountDirectory;
    }

    public boolean isConflict(String userName) {
        return accountProfileMap.containsKey(userName);
    }

    public Profile getProfile(String userName) {
        return accountProfileMap.get(userName);
    }

    public java.lang.Class getProfileClass(String userName) {
        return accountRoleMap.get(userName);
    }

    public <P extends Profile> Account newAccount(String userName, String password, P profile) throws AccountNameConflictException {
        if (!isConflict(userName)) {
            Account newAccount = new Account(userName, password);
            accountProfileMap.put(userName, profile);
            accountRoleMap.put(userName, profile.getClass());
            return newAccount;
        } else {
            throw new AccountNameConflictException("Account Name Conflict");
        }
    }

    public void removeAccount(String userName) {
        if (accountProfileMap.containsKey(userName)) {
            accountProfileMap.remove(userName);
            accountRoleMap.remove(userName);
        }
    }

    public void modifyAccountName(Account account, String newUserName, String newPassword) throws AccountNameConflictException {
        String oldUserName = account.getUserName();
        if (!newUserName.equals(oldUserName) && isConflict(newUserName)) {
            throw new AccountNameConflictException("Account Name Conflict");
        }
        Profile profile = getProfile(oldUserName);
        java.lang.Class profileClass = accountRoleMap.get(oldUserName);
        accountProfileMap.remove(oldUserName);
        accountRoleMap.remove(account.getUserName());
        account.setUserName(newUserName);
        account.setPassword(newPassword);
        accountProfileMap.put(newUserName, profile);
        accountRoleMap.put(newUserName, profile.getClass());
    }
}
