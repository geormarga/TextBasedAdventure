package textbasedadventure;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import textbasedadventure.webapp.game.items.containers.Inventory;
import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.actors.OldMan;
import textbasedadventure.webapp.game.items.Elixir;
import textbasedadventure.webapp.game.rooms.Cave;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackageClasses = {
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
    @Autowired
    private Inventory inventory;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        cave = null;
        oldMan = null;
        elixir = null;
        inventory = null;
    }

    @Test
    public void saveOldManTest() {
        this.inventory.registerItem("elixir");
        System.out.println(oldMan.getDescription());
        System.out.println(inventory.show());
        System.out.println(oldMan.give(inventory, elixir));
        System.out.println(inventory.show());
        Assert.assertFalse(inventory.show().contains("elixir"));
        Assert.assertTrue(inventory.show().contains("golden key"));
    }

    @Test
    public void killOldManTest() {
        System.out.println(oldMan.getDescription());
        System.out.println(oldMan.hit(cave));
        System.out.println(oldMan.examine(inventory));
        Assert.assertTrue(inventory.show().contains("golden key"));
    }
}
