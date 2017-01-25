package domain;

public class Person {

    public String name;
    public String email;

    public Person() {
    }

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }
}
