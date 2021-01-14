package parser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class JsonParserTest {

    Cart artsiomCart = new Cart("artsiom-cart");
    //private List<RealItem> realItems;
    RealItem real = new RealItem();
    //RealItem item;
    Parser parser = new JsonParser();
    Cart cart;
    File File1 = new File("src/main/resources/artsiom-cart");
    File File2 = new File("arsiom-cart.json");
    File File3 = new File("artsiom-cart");
    File File4 = new File(String.valueOf(artsiomCart));
    File File5 = new File(String.valueOf(cart));
    String one = "src/main/resources/artsiom-cart";

    @Test
    @DisplayName("test of creating a new File json")
    public void testWriteToFile() {
        artsiomCart.addRealItem(real);
        parser.writeToFile(artsiomCart);
        Path path = Paths.get("src/main/resources/artsiom-cart.json");
        assertTrue(Files.exists(path));
    }

    @Disabled("Don't need this test at this level")
    @Test
    @DisplayName("is instantiated with new RealItem()")
    void isInstantiated() {
        assertNotNull(artsiomCart);
    }

    @ParameterizedTest
    //  I'm not sure what is passed as  source of arguments to the method
    @ValueSource(strings = {"src/main/resources/artsiom-cart", "arsiom-cart.json", "artsiom-cart"})
    @DisplayName("checking exception")
    void testReadFromFile() { // and what is used as a parameter of this void
        Exception exception = assertThrows(NoSuchFileException.class, () -> parser.readFromFile(new File(String.valueOf(File1))));
        //Cart artsiomCart2 = parser.readFromFile(new File(String.valueOf(File2)));
        //Cart artsiomCart3 = parser.readFromFile(new File(String.valueOf(File3)));
        //Cart artsiomCart4 = parser.readFromFile(new File(String.valueOf(File4)));
        //Cart artsiomCart5 = parser.readFromFile(new File(String.valueOf(File5)));
        //assertEquals("File "+File1+".json not found!", exception.getMessage());
        //assertEquals("File src/main/resources/"+File1+" not found!", exception.getMessage());
        assertNotNull(exception.getMessage());
    }

    }


