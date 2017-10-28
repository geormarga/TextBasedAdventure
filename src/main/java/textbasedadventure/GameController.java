package textbasedadventure;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    private State state = new State();
    private Game game = new Game();

    @RequestMapping(value = "/game/{command}", method = RequestMethod.GET)
    public String game(@PathVariable("command") String command) {
        return game.getDescription(state, command);
    }

    @RequestMapping("/game/save")
    public String save() {
        return "Game saved successfully!";
    }

    @RequestMapping("/game/load")
    public String load() {
        return "Game loaded successfully!";
    }


}