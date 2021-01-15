package parser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.Test;
import shop.Cart;
import shop.RealItem;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class JsonParserTest {

    Cart artsiomCart = new Cart("artsiom-cart");
    RealItem real = new RealItem();
    Parser parser = new JsonParser();
    //Cart cart;
    //File File1 = new File("src/main/resources/artsiom-cart");
    //File File2 = new File("arsiom-cart.json");
    //File File3 = new File("artsiom-cart");
    //File File4 = new File(String.valueOf(artsiomCart));
    //File File5 = new File(String.valueOf(cart));


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
    @DisplayName("checking exception when wrong path")
    @MethodSource("getPath")
    void testOfExcepion(String path) {
        Exception exception = assertThrows(NoSuchFileException.class, () -> parser.readFromFile(new File(path)));
        assertNotNull(exception.getMessage());
    }

    static Stream<String> getPath() {
        return Stream.of("src/main/resources/artsiom-cart", "arsiom-cart.json", "artsiom-cart", "resources/artsiom-cart", "artsion cart");
    }
}


