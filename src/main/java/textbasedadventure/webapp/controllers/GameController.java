package textbasedadventure.webapp.controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import textbasedadventure.webapp.game.Game;
import textbasedadventure.webapp.game.State;
import textbasedadventure.webapp.models.Command;
import textbasedadventure.webapp.models.Save;
import textbasedadventure.webapp.repositories.SaveRepository;

import java.util.List;

@RestController
@Scope("session")
public class GameController {

    @Autowired
    private SaveRepository repository;
    @Autowired
    private State state;
    @Autowired
    private Game game;

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public ResponseEntity<Command> game(@RequestBody Command command) {
        command.setCommandResult(game.getDescription(state, command.getCommand()));
        return new ResponseEntity<>(command, HttpStatus.OK);
    }

    @RequestMapping("/game/save")
    public String save() {
        repository.deleteAll();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String transformedState = gson.toJson(state);
        Save save = new Save("Talos", transformedState);
        repository.save(save);
        return "Game saved successfully!";
    }

    @RequestMapping("/game/getSaves")
    public ResponseEntity<List<Save>> getSaves() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/game/load")
    public String load() {
        Save save = repository.findByUsername("Talos");
        Gson gson = new Gson();
        this.state = gson.fromJson(save.getSave_game(), State.class);
        return "Game loaded successfully!";
    }
}