package frontend;

import backend.ressources.Person;

import java.util.Collection;
import java.util.HashMap;

public class PersonServiceImpl implements UserService{
    private HashMap<String, Person> PersonMap;

    public PersonServiceImpl() {
        PersonMap = new HashMap<>();
    }

    @Override
    public void addPerson(String id, Person person) {
        PersonMap.put(person.getId(), person);
    }

    @Override
    public Collection<Person> getPersons() {
        return PersonMap.values();
    }

    @Override
    public Person getPerson(String id) {
        return PersonMap.get(id);
    }

    @Override
    public Person editPerson(Person forEdit){

            Person toEdit = PersonMap.get(forEdit);
            if (toEdit == null) {//throw }
                if (forEdit.getName() != null) {
                    toEdit.setName(forEdit.getName());
                }
                //add remaining stuff

                return toEdit;
            }

        return toEdit;

    }

    @Override
    public void deletePerson(String id) {
        PersonMap.remove(id);
    }

    @Override
    public boolean PersonExist(String id) {
        return PersonMap.containsKey(id);
    }
}
