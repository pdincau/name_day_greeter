package infrastructure;

import domain.Greeter;
import domain.Person;

import java.util.List;

public class ConsoleGreeter implements Greeter {

    @Override
    public void sendGreetingsTo(List<Person> recipients) {
        for (Person recipient : recipients) {
            System.out.println("recipient email: " + recipient.email);
        }

    }
}
