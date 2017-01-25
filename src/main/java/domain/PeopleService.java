package domain;

public class PeopleService {

    public void add(Person person) {
        validate(person);
    }

    private void validate(Person person) {
        if (person.name == null || person.email == null) {
            throw new InvalidDataException();
        }
    }
}
