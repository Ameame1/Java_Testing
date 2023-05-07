public class ProductServiceTests {

    @Test
    public void testAddProduct() {
        ProductService productService = new ProductService();
        Product product = new Product();
        product.setName("Product 1");
        product.setPrice(10.0);
        productService.addProduct(product);
        Assert.assertNotNull(product.getId());
        Assert.assertEquals("Product 1", product.getName());
        Assert.assertEquals(10.0, product.getPrice(), 0.001);
    }

    @Test(expected = ProductNotFoundException.class)
    public void testGetNonexistentProductById() {
        ProductService productService = new ProductService();
        productService.getProductById(1L);
    }

}

public class CartServiceTests {

    @Test
    public void testAddItemToCart() {
        CartService cartService = new CartService();
        Product product = new Product();
        product.setId(1L);
        product.setName("Product 1");
        product.setPrice(10.0);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartService.addItemToCart(cartItem);
        List<CartItem> cartItemList = cartService.getAllItemsInCart();
        Assert.assertEquals(1, cartItemList.size());
        Assert.assertEquals(product, cartItemList.get(0).getProduct());
        Assert.assertEquals(1, cartItemList.get(0).getQuantity());
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveNonexistentItemFromCart() {
        CartService cartService = new CartService();
        cartService.removeItemFromCart(1L);
    }

}
