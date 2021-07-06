/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona;

/**
 *
 * @author aeloyq
 */
public class Profile {
    protected Person person;
    protected Account account;

    public Profile() {
    }

    public Profile(Person person) {
        this.person = person;
    }

    public Profile(Person person, Account account) {
        this.person = person;
        this.account = account;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public boolean isAuthorized(String password) {
        return password.equals(account.getPassword());
    }
}
