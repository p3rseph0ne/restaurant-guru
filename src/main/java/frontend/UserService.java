package frontend;

import backend.ressources.Person;

import java.util.Collection;

public interface UserService {
    public void addPerson(String id, Person Person);

    public Collection<Person> getPersons();

    public Person getPerson(String id);

    public Person editPerson(Person Person);

    public void deletePerson(String id);

    public boolean PersonExist(String id);
}
