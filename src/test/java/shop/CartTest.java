package shop;

import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.*;

public class CartTest {
    Cart cart3 = new Cart("hhh");
    RealItem testt = new RealItem();
    private List<RealItem> realItems;


    @Test
    @DisplayName("with groupedAssertions")
    public void testGetCartName() {
        testt.setName("MyCart");
        testt.setPrice(50);
        testt.setWeight(30.5);

        cart3.addRealItem(testt);
        assertNotNull(testt);

        cart3.deleteRealItem(testt);

        assertAll("realItems",
                () -> assertNull(realItems),
                () -> assertEquals(60.0, cart3.getTotalPrice()));
    }
}