import com.spotify.apollo.Environment;
import com.spotify.apollo.RequestContext;
import com.spotify.apollo.Response;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;

import static com.spotify.apollo.Status.CREATED;

public class Application {

    public static void main(String... args) throws LoadingException {
        HttpService.boot(Application::init, "name_day_greeter", args);
    }

    static void init(Environment environment) {
        environment.routingEngine()
                .registerAutoRoute(Route.sync("POST", "/people", Application::addPerson))
                .registerAutoRoute(Route.sync("GET", "/", rc -> "Yet another microservice from XPeppers"));
    }

    private static Response addPerson(RequestContext context) {
        return Response.forStatus(CREATED);
    }

}
