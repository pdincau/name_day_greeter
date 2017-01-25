package domain;

public class PeopleService {

    private People people;

    public PeopleService(People people) {
        this.people = people;
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
