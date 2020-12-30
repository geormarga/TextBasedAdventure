package textbasedadventure;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.actors.OldMan;
import textbasedadventure.webapp.game.items.Elixir;
import textbasedadventure.webapp.game.rooms.Cave;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackageClasses= {
        OldMan.class,
        Elixir.class,
        Cave.class,
        Map.class})
public class OldManTest {

    @Autowired
    OldMan oldMan;
    @Autowired
    Elixir elixir;
    @Autowired
    private Map map;
    @Autowired
    private Cave cave;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        cave = null;
        oldMan = null;
        elixir = null;
    }

    @Test
    public void tempTest() {
        System.out.println(oldMan.getDescription());
        oldMan.give(cave, elixir);
    }
}
