package domain;

import java.util.List;

public interface People {

    void add(Person person);

    List<Person> withName(String name);

}
