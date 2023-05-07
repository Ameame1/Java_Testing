import org.junit.Test;
import org.junit.Assert;
import java.util.List;
import java.util.ArrayList;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("Banana", 0.99);
        cart.addItem(item);
        Assert.assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("Apple", 1.49);
        cart.addItem(item);
        cart.removeItem(item);
        Assert.assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testGetTotal() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("Milk", 3.49);
        Item item2 = new Item("Bread", 2.99);
        cart.addItem(item1);
        cart.addItem(item2);
        Assert.assertEquals(6.48, cart.getTotal(), 0.01);
    }

    @Test
    public void testGetItems() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("Eggs", 2.99);
        Item item2 = new Item("Cheese", 4.99);
        cart.addItem(item1);
        cart.addItem(item2);
        List<Item> expectedItems = new ArrayList<Item>();
        expectedItems.add(item1);
        expectedItems.add(item2);
        Assert.assertEquals(expectedItems, cart.getItems());
    }

}
