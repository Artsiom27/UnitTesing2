package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualItemTest {


    @Test
    void creatVirtualItms() {
        VirtualItem virt = new VirtualItem();
        virt.setName("Virt");
        virt.setPrice(100);
        virt.setSizeOnDisk(512);

        String expected = "Class: class shop.VirtualItem; Name: Virt; Price: 100.0; Size on disk: 512.0";
        assertEquals(expected, virt.toString());
    }
}