package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RealItemTest {


    @Test
    void creatRealItms() {
        RealItem real = new RealItem();
        real.setName("Test");
        real.setPrice(744);
        real.setWeight(56);

        String expected = "Class: class shop.RealItem; Name: Test; Price: 744.0; Weight: 56.0";
        assertEquals(expected, real.toString());

    }
}