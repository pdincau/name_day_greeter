package domain;

public class PeopleService {

    private People people;

    public PeopleService(People repository) {
        this.people = repository;
    }

    public void add(Person person) {
        validate(person);

        people.add(person);
    }

    private void validate(Person person) {
        if (person.name == null || person.email == null) {
            throw new InvalidDataException();
        }
    }
}
