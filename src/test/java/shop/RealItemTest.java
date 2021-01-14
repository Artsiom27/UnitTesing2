package shop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RealItemTest {

    RealItem real = new RealItem();

    @Test
    void creatRealItms() {
        real.setName("Test");
        real.setPrice(744);
        real.setWeight(56);

        String expected = "Class: class shop.RealItem; Name: Test; Price: 744.0; Weight: 56.0";
        Assert.assertEquals(expected, real.toString());

    }
}