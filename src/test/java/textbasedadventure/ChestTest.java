package textbasedadventure;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import textbasedadventure.webapp.game.Map;
import textbasedadventure.webapp.game.actors.OldMan;
import textbasedadventure.webapp.game.items.Elixir;
import textbasedadventure.webapp.game.items.GoldenKey;
import textbasedadventure.webapp.game.items.RustyKey;
import textbasedadventure.webapp.game.items.SilverKey;
import textbasedadventure.webapp.game.items.containers.CommonChest;
import textbasedadventure.webapp.game.items.containers.GoldenChest;
import textbasedadventure.webapp.game.items.containers.Inventory;
import textbasedadventure.webapp.game.items.containers.SilverChest;
import textbasedadventure.webapp.game.rooms.Cave;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication(scanBasePackageClasses = {
        GoldenChest.class,
        GoldenKey.class,
        SilverChest.class,
        SilverKey.class,
        CommonChest.class,
        RustyKey.class,

        OldMan.class,
        Elixir.class,
        Cave.class,
        Map.class})
public class ChestTest {

    @Autowired
    GoldenChest goldenChest;
    @Autowired
    SilverChest silverChest;
    @Autowired
    CommonChest commonChest;
    @Autowired
    GoldenKey goldenKey;
    @Autowired
    SilverKey silverKey;
    @Autowired
    RustyKey rustyKey;

    @Autowired
    private Map map;

    @Autowired
    private Inventory inventory;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        goldenChest = null;
        silverChest = null;
        commonChest = null;
        goldenKey = null;
        silverKey = null;
        rustyKey = null;
        inventory = null;
    }

    @Test
    public void openGoldenChestTest() {
        this.inventory.registerItem("golden key");
        Assert.assertTrue(goldenChest.open(inventory).contains("circular artifact"));
    }

    @Test
    public void openSilverChestTest() {
        this.inventory.registerItem("silver key");
        Assert.assertTrue(silverChest.open(inventory).contains("rectangular artifact"));
    }

    @Test
    public void openCommonChestTest() {
        this.inventory.registerItem("rusty key");
        Assert.assertTrue(commonChest.open(inventory).contains("circular artifact"));
    }
}
