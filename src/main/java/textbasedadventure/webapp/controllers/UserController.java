package textbasedadventure.webapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import textbasedadventure.webapp.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private List<UserModel> userlist = initUsers();

    private List<UserModel> initUsers() {
        List<UserModel> userModels = new ArrayList<>();
        userModels.add(new UserModel("JohnDoe", "John@Doe.com", "123456aA!"));
        userModels.add(new UserModel("Talos", "Talos@Principle.com", "123456aA!"));
        userModels.add(new UserModel("Token", "John@Doe.com", "123456aA!"));
        userModels.add(new UserModel("EricCartman", "John@Doe.com", "123456aA!"));
        userModels.add(new UserModel("Takis", "John@Doe.com", "123456aA!"));
        userModels.add(new UserModel("Aenaos23", "John@Doe.com", "123456aA!"));
        return userModels;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<? extends String> login(@RequestBody UserModel userModel) {
        List<UserModel> existentUserModel = userlist.stream().filter(x -> x.login(userModel.getUsername(), userModel.getPassword())).collect(Collectors.toList());
        if (!existentUserModel.isEmpty()) {
            return new ResponseEntity<>("Successfully authenticated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong username or password.", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ResponseEntity<? extends String> changePassword(@RequestBody UserModel userModel) {
        List<UserModel> existentUserModel = userlist.stream().filter(x -> x.login(userModel.getUsername(),userModel.getPassword())).collect(Collectors.toList());
        if (!existentUserModel.isEmpty()) {
            userModel.setPassword("");
            return new ResponseEntity<>("Password successfully authenticated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wrong username or password.", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody UserModel userModel) {
        List<UserModel> existentUserModel = userlist.stream()
                .filter(x -> x.usernameExists(userModel.getUsername()))
                .collect(Collectors.toList());
        if (existentUserModel.isEmpty()) {
            userlist.add(userModel);
            return new ResponseEntity<>("User successfully created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Username already exists", HttpStatus.CONFLICT);
        }
    }
}