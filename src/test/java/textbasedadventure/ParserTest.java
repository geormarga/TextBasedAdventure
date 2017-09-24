package textbasedadventure;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aenaos on 13/4/2017.
 */
public class ParserTest {

    private Parser parser;
    private Method method;
    private CommandList cmdList;
    private List<String> list;
    private Command command;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
        cmdList = new CommandList();
        list = new ArrayList<>();
        command = new Command();
    }

    @After
    public void tearDown() throws Exception {
        parser = null;
        cmdList = null;
        list = null;
    }

    @Test
    public void tempTest() {
        String input = "rectangular artifact circular artifact";
        List<String> xmlValues = new ArrayList<>();
        List<String> attributes = new ArrayList<>();
        xmlValues.add("artifact");
        xmlValues.add("circular artifact");

        for (String attr : xmlValues) {
            if (input.contains(attr)) {
                attributes.add(attr);
                System.out.println("value added: " + attributes.get(attributes.indexOf(attr)));
                input = input.replaceFirst(attr, "").trim();
                System.out.println("current input: " + input);
            }
        }
        attributes.forEach(System.out::println);
    }

    @Test
    public void commandIsNotValid() throws Exception {
        parser.commandIsValid("pickup game", command);
        Assert.assertEquals(null, command.getCommand());
    }

    @Test
    public void commandIsValid() throws Exception {
        parser.commandIsValid("pick up rectangular artifact", command);
        Assert.assertEquals("pick up", command.getCommand());
    }

    @Test
    public void commandWithInvalidAttribute() {
        parser.commandIsValid("start takis", command);
        list.add("takis");
        Assert.assertNotEquals(list, command.getAttributes());
    }

    @Test
    public void commandWithValidAttribute() {
        parser.commandIsValid("start game", command);
        list.add("game");
        Assert.assertEquals(list, command.getAttributes());
    }

    @Test
    public void commandWithInvalidAttributes() {
        parser.commandIsValid("start game takis", command);
        list.add("game");
        list.add("takis");
        Assert.assertNotEquals(list, command.getAttributes());
    }

    @Test
    public void commandWithValidAttributes() {
        parser.commandIsValid("pick up key torch", command);
        list.add("key");
        list.add("torch");
        Assert.assertEquals(list, command.getAttributes());
    }

    @Test
    public void commandWithInvalidMultipleAttributes() {
        boolean test = parser.commandIsValid("pick up restful triangular artifact", command);
        Assert.assertFalse(test);
        //Assert.assertEquals(list, command.getAttributes());
    }

    @Test
    public void commandWithValidMultipleAttributes() {
        parser.commandIsValid("pick up rectangular artifact triangular artifact", command);
        list.add("triangular artifact");
        list.add("rectangular artifact");
        Assert.assertEquals(list, command.getAttributes());
    }

    @Test
    public void isNotCommand() throws Exception {
        method = Parser.class.getDeclaredMethod("isCommand", String.class, CommandList.class);
        method.setAccessible(true);
        String command = "takis";
        boolean test = (boolean) this.method.invoke(parser, command, cmdList);
        Assert.assertEquals(false, test);
    }

    @Test
    public void isCommand() throws Exception {
        method = Parser.class.getDeclaredMethod("isCommand", String.class, CommandList.class);
        method.setAccessible(true);
        String command = "start";
        boolean test = (boolean) this.method.invoke(parser, command, cmdList);
        Assert.assertEquals(true, test);
    }

    @Test
    public void isNotAttribute() throws Exception {
        method = Parser.class.getDeclaredMethod("isAttribute", List.class, CommandList.class);
        method.setAccessible(true);
        list = Arrays.asList("rectangular", "key");
        boolean actual = (boolean) this.method.invoke(parser, list, cmdList);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void isAttribute() throws Exception {
        method = Parser.class.getDeclaredMethod("isAttribute", List.class, CommandList.class);
        method.setAccessible(true);
        list = Arrays.asList("rectangular artifact", "key");
        boolean actual = (boolean) this.method.invoke(parser, list, cmdList);
        Assert.assertEquals(true, actual);
    }
}
