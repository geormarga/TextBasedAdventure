package textbasedadventure.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import textbasedadventure.webapp.models.User;
import textbasedadventure.webapp.repositories.UserRepository;

import java.util.List;

@RestController
@Scope("session")
public class UserController {

    @Autowired
    private UserRepository repository;

    private void initUsers() {
        repository.save(new User("JohnDoe", "John@Doe.com", "123456aA!"));
        repository.save(new User("Talos", "Talos@Principle.com", "123456aA!"));
        repository.save(new User("Token", "John@Doe.com", "123456aA!"));
        repository.save(new User("Eric", "John@Doe.com", "123456aA!"));
        repository.save(new User("Takis", "John@Doe.com", "123456aA!"));
        repository.save(new User("Aenaos23", "John@Doe.com", "123456aA!"));
    }

    @RequestMapping("/")
    public String init(){
        repository.deleteAll();
        initUsers();
        return "initialized";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<User> getUser() {
        User user = repository.findByUsername("Talos");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody User user) {
        User existentUser = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existentUser != null) {
            return new ResponseEntity<>("Successfully authenticated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong username or password.", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ResponseEntity<String> changePassword(@RequestBody User user) {
        User existentUser = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existentUser != null) {
            user.setPassword("");
            return new ResponseEntity<>("Password successfully authenticated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong username or password.", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody User user) {
        User existentUser = repository.findByUsername(user.getUsername());
        if (existentUser == null) {
            repository.save(user);
            return new ResponseEntity<>("User successfully created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
        }
    }
}