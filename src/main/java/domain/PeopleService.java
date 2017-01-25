package domain;

import java.util.List;

public class PeopleService {

    private People people;
    private Greeter greeter;

    public PeopleService(People people, Greeter greeter) {
        this.people = people;
        this.greeter = greeter;
    }

    public void add(Person person) {
        validate(person);

        people.add(person);
    }

    public void greetPeopleWithName(String name) {
        List<Person> recipients = people.withName(name);
        greeter.sendGreetingsTo(recipients);
    }

    private void validate(Person person) {
        if (person.name == null || person.email == null) {
            throw new InvalidDataException();
        }
    }
}
