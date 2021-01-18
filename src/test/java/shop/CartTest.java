package shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.JsonParser;
import parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    private List<RealItem> realItems;
    private Cart cart3;
    private RealItem testt;

    @BeforeEach
    public void init() {
        cart3 = new Cart("test-cart");
        testt = new RealItem();

        testt.setName("MyCart");
        testt.setPrice(50);
        testt.setWeight(30.5);
        cart3.addRealItem(testt);
    }

    @Test
    public void testGetCartPrice() {

        assertEquals(60.0, cart3.getTotalPrice());
    }

    @Test
    public void deleteFromCart() throws FileNotFoundException {  // maybe this is not the most correct way to test,
        Parser parser = new JsonParser();                       //  but I didn't do anything else normally
        parser.writeToFile(cart3);
        String a = "{\"cartName\":\"test-cart\",\"realItems\":[{\"weight\":30.5,\"name\":\"MyCart\",\"price\":50.0}],\"virtualItems\":[],\"total\":60.0}";

        File myFile = new File("src/main/resources/test-cart.json");
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            assertEquals(a, data);

            cart3.deleteRealItem(testt);

            Parser parser1 = new JsonParser();
            parser1.writeToFile(cart3);
            String b = "{\"cartName\":\"test-cart\",\"realItems\":[],\"virtualItems\":[],\"total\":60.0}";

            File myFile1 = new File("src/main/resources/test-cart.json");
            Scanner myReader1 = new Scanner(myFile1);
            while (myReader1.hasNextLine()) {
                String data1 = myReader1.nextLine();

                assertEquals(b, data1);
            }
        }
    }
}