package infrastructure;

import domain.People;
import domain.Person;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InMemoryPeople implements People {

    private List<Person> people = new ArrayList<>();

    @Override
    public void add(Person person) {
        people.add(person);
    }

    @Override
    public List<Person> withName(String name) {
        return people.stream()
                .filter(p -> p.hasName(name))
                .collect(toList());
    }

}
