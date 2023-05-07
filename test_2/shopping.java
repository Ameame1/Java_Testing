import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Arrays;

public class ShoppingCartTest {

    @Test
    public void testAddItemToCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("book", 10));
        Assert.assertEquals(1, cart.getNumItems());
    }

    @Test
    public void testRemoveItemFromCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("book", 10);
        cart.addItem(item);
        cart.removeItem(item);
        Assert.assertEquals(0, cart.getNumItems());
    }

    @Test
    public void testGetTotalPriceOfCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("book", 10);
        Item item2 = new Item("DVD", 20);
        cart.addItem(item1);
        cart.addItem(item2);
        Assert.assertEquals(30, cart.getTotalPrice(), 0);
    }

    @Test
    public void testGetItemsInCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("book", 10);
        Item item2 = new Item("DVD", 20);
        cart.addItem(item1);
        cart.addItem(item2);
        ArrayList<Item> expectedItems = new ArrayList<>(Arrays.asList(item1, item2));
        Assert.assertEquals(expectedItems, cart.getItems());
    }

    @Test
    public void testClearCart() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("book", 10));
        cart.addItem(new Item("DVD", 20));
        cart.clearCart();
        Assert.assertEquals(0, cart.getNumItems());
        Assert.assertEquals(0, cart.getTotalPrice(), 0);
    }

    @Test
    public void testAddSameItemToCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("book", 10);
        cart.addItem(item);
        cart.addItem(item);
        Assert.assertEquals(2, cart.getNumItems());
        Assert.assertEquals(20, cart.getTotalPrice(), 0);
    }

    @Test
    public void testRemoveNonexistentItemFromCart() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item("book", 10);
        Item item2 = new Item("DVD", 20);
        cart.addItem(item1);
        cart.removeItem(item2);
        Assert.assertEquals(1, cart.getNumItems());
        Assert.assertEquals(10, cart.getTotalPrice(), 0);
    }

}
