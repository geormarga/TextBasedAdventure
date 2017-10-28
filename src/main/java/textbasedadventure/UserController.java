package textbasedadventure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

    HashMap<String, String> usernames = new HashMap<>();
    HashMap<String, String> passwords = new HashMap<>();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping("/register")
    public String register() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/user")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}