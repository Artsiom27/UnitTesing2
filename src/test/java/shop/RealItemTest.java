package shop;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RealItemTest {

    RealItem weight = new RealItem();

    @Test
    void getWeight() {
        assertNotNull(weight);
        System.out.println(weight);
    }
}