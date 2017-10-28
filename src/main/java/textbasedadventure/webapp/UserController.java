package textbasedadventure.webapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    List<UserModel> userlist = initUsers();

    private List<UserModel> initUsers() {
        List<UserModel> userModels = new ArrayList();
        userModels.add(new UserModel("JohnDoe", "John@Doe.com", "123456aA!"));
        userModels.add(new UserModel("Talos", "Talos@Principle.com", "123456aA!"));
        userModels.add(new UserModel("Token", "John@Doe.com", "123456aA!"));
        userModels.add(new UserModel("EricCartman", "John@Doe.com", "123456aA!"));
        userModels.add(new UserModel("Takis", "John@Doe.com", "123456aA!"));
        userModels.add(new UserModel("Aenaos23", "John@Doe.com", "123456aA!"));
        return userModels;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody UserModel userModel) {
        List<UserModel> existentUserModel = userlist.stream().filter(x -> x.login(userModel.getUsername(), userModel.getPassword())).collect(Collectors.toList());
        if (!existentUserModel.isEmpty()) {
            return new ResponseEntity<>("Successfully authenticated.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Wrong username or password.", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUser() {
        UserModel userModel = userlist.get(0);
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAll() {
        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody UserModel userModel) {
        List<UserModel> playersOfTeam = userlist.stream()
                .filter(x -> x.usernameExists(userModel.getUsername()))
                .collect(Collectors.toList());
        if (playersOfTeam.isEmpty()) {
            userlist.add(userModel);
            return new ResponseEntity("UserModel successfully created", HttpStatus.OK);
        } else {
            return new ResponseEntity("Username already exists", HttpStatus.CONFLICT);
        }
    }

    @RequestMapping("/user")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}