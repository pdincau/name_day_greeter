import com.fasterxml.jackson.databind.ObjectMapper;
import com.spotify.apollo.Environment;
import com.spotify.apollo.RequestContext;
import com.spotify.apollo.Response;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;
import domain.InvalidDataException;
import domain.PeopleService;
import domain.Person;
import infrastructure.ConsoleGreeter;
import infrastructure.InMemoryPeople;
import okio.ByteString;

import java.io.IOException;

import static com.spotify.apollo.Status.*;

public class Application {

    private static PeopleService peopleService = new PeopleService(new InMemoryPeople(), new ConsoleGreeter());

    public static void main(String... args) throws LoadingException {
        HttpService.boot(Application::init, "name_day_greeter", args);
    }

    static void init(Environment environment) {
        environment.routingEngine()
                .registerAutoRoute(Route.sync("POST", "/people", Application::addPerson))
                .registerAutoRoute(Route.sync("GET", "/greet", Application::notify))
                .registerAutoRoute(Route.sync("GET", "/", rc -> "Yet another microservice from XPeppers"));
    }

    private static Response addPerson(RequestContext context) {
        String payload = context.request().payload().orElse(ByteString.EMPTY).utf8();
        try {
            Person person = new ObjectMapper().readValue(payload, Person.class);
            peopleService.add(person);
            return Response.forStatus(CREATED);
        } catch (InvalidDataException e) {
            return Response.forStatus(BAD_REQUEST).withPayload(e.getMessage());
        } catch (IOException e) {
            return Response.forStatus(INTERNAL_SERVER_ERROR);
        }
    }

    private static Response notify(RequestContext context) {
        String name = context.request().parameter("name").orElse("");
        peopleService.greetPeopleWithName(name);
        return Response.forStatus(NO_CONTENT);
    }

}
