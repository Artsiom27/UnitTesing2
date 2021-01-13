package parser;

import org.junit.jupiter.api.*;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class JsonParserTest {

    Cart artsiomCart = new Cart("artsiom-cart");
    private List<RealItem> realItems;
    RealItem real = new RealItem();
    RealItem item;
    Parser parser = new JsonParser();
    Cart cart;
    File File1 = new File("src/main/resources/artsiom-cart");
    File File2 = new File("arsiom-cart.json");
    File File3 = new File("artsiom-cart");
    File File4 = new File(String.valueOf(artsiomCart));
    File File5 = new File(String.valueOf(cart));


    @Test
    @BeforeAll
    @DisplayName("groupedAssertions of RealItems")
    void createNewRealItm() {
        real.setName("Test");
        real.setPrice(744);
        real.setWeight(56);

        assertAll("RealItems",
                () -> assertEquals("Test", real.getName()),
                () -> assertEquals(744.0, real.getPrice()),
                () -> assertEquals(56.0, real.getWeight())
        );
    }

    // I made tests for RealItems, the same can be done for VirtualItems

    @Test
    @AfterEach
    public void testWriteToFile() {
        artsiomCart.addRealItem(real);
        parser.writeToFile(artsiomCart);
        //new File("src/main/resources/artsiom5-cart.json").isFile();
        Path path = Paths.get("src/main/resources/artsiom-cart.json");
        String expected = "src/main/resources/artsiom-cart.json";
        if (Files.exists(path)) {
            assertEquals(expected, path);
        }
    }

    @Disabled("Don't need this test at this level")
    @Test
    @DisplayName("is instantiated with new RealItem()")
    void isInstantiated() {
        assertNotNull(artsiomCart);
    }

    @Test
    @AfterAll
    @DisplayName("checking exception")
    void testReadFromFile() {
        Exception exception = assertThrows(NoSuchFileException.class, () ->
                Cart artsiomCart1 = parser.readFromFile(new File(String.valueOf(File1)));
        Cart artsiomCart2 = parser.readFromFile(new File(String.valueOf(File2)));
        Cart artsiomCart3 = parser.readFromFile(new File(String.valueOf(File3)));
        Cart artsiomCart4 = parser.readFromFile(new File(String.valueOf(File4)));
        Cart artsiomCart5 = parser.readFromFile(new File(String.valueOf(File5)));
        assertEquals("File %s.json not found!", exception.getMessage());
    }

    @Test
    @DisplayName("item is empty")
    void isEmpty() {
        artsiomCart.showItems();
        assertNull(item);
        //assertEquals(cart,artsiomCart);
    }

    @Test
    @AfterAll
    void DeleteFile() {
        File file6 = new File("src/main/resources/artsiom-cart.json");
        file6.delete();
    }
}


