import com.spotify.apollo.Environment;
import com.spotify.apollo.httpservice.HttpService;
import com.spotify.apollo.httpservice.LoadingException;
import com.spotify.apollo.route.Route;

public class Application {

    public static void main(String... args) throws LoadingException {
        HttpService.boot(Application::init, "name_day_greeter", args);
    }

    static void init(Environment environment) {
        environment.routingEngine()
                .registerAutoRoute(Route.sync("GET", "/", rc -> "Yet another microservice from XPeppers"));
    }

}
