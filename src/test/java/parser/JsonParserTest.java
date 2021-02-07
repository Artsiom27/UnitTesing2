package parser;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import shop.Cart;
import shop.RealItem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {
     private RealItem real;
     private Cart artsiomCart;
     private Cart eugenCart;
     private Parser parser;
    private List<RealItem> realItems;



    @BeforeEach
    public void init() {
        artsiomCart = new Cart("artsiom-cart");
        eugenCart = new Cart("eugen-cart");
        real = new RealItem();
        parser = new JsonParser();
        realItems = new ArrayList<>();

        real.setName("Cart1");
        real.setWeight(20);
        real.setPrice(100.5);
    }

    @Test
    @DisplayName("test of creating a new File json")
    public void testWriteToFile() throws IOException {
        artsiomCart.addRealItem(real);
        parser.writeToFile(artsiomCart);
        Path path = Paths.get("src/main/resources/artsiom-cart.json");
        assertTrue(Files.exists(path));

        try {
            File myFile = new File("src/main/resources/artsiom-cart.json");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                String sss = "{\"cartName\":\"artsiom-cart\",\"realItems\":[{\"weight\":20.0,\"name\":\"Cart1\",\"price\":100.5}],\"virtualItems\":[],\"total\":120.6}";
                assertEquals(sss, data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No such file was founded");
            e.printStackTrace();
        }
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

    @Test
    void readFromJsonFile()  {
        Cart testCart = parser.readFromFile(new File("src/main/resources/eugen-cart.json"));
        artsiomCart.showItems();
        assertAll("eugen-cart",
                () -> assertEquals("eugen-cart", testCart.getCartName()),
                () -> assertEquals(26560.68, testCart.getTotalPrice())
        );
    }
}


