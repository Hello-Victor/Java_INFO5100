/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Persona;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {

    HashMap<String, Person> personMap = new HashMap<String, Person>();
    static PersonDirectory personDirectory = null;

    private PersonDirectory() {
    }

    public static PersonDirectory getInstance() {
        if (PersonDirectory.personDirectory == null) {
            PersonDirectory personDirectory = new PersonDirectory();
            PersonDirectory.personDirectory = personDirectory;
        }
        return PersonDirectory.personDirectory;
    }

    public Person newPerson() {
        Person p = new Person();
        personMap.put(p.getId(), p);
        return p;
    }

    public Person findPerson(String id) {
        return personMap.get(id); //not found after going through the whole list
    }

    public void removePerson(String id) {
        personMap.remove(id);
    }

    public HashMap<String, Person> getPersonMap() {
        return personMap;
    }

}
