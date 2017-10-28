package textbasedadventure.webapp;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import textbasedadventure.game.Game;
import textbasedadventure.game.State;

@RestController
public class GameController {
    private State state = new State();
    private Game game = new Game();

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ResponseEntity<CommandModel> game(@RequestBody CommandModel commandModel)
    {
        commandModel.setCommandResult(game.getDescription(state, commandModel.getCommand()));
        return new ResponseEntity<CommandModel>(commandModel, HttpStatus.OK);
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