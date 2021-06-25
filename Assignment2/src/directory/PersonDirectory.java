package directory;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDirectory {
    private List<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public List<Person> getPersonList() {
        return personList;
    }
    

    public void addPerson(Person person){
        personList.add(person);
    }
    
    




}
