//Main Application Class
@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

}

//Controller Class for Product Catalog
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

}

//Controller Class for Shopping Cart
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public void addItemToCart(@RequestBody CartItem cartItem) {
        cartService.addItemToCart(cartItem);
    }

    @GetMapping("/")
    public List<CartItem> getAllItemsInCart() {
        return cartService.getAllItemsInCart();
    }

    @DeleteMapping("/{itemId}")
    public void removeItemFromCart(@PathVariable Long itemId) {
        cartService.removeItemFromCart(itemId);
    }

}

//Service Class for Product Catalog
@Service
public class ProductService {

    private List<Product> productList = new ArrayList<>();

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(Long productId) {
        return productList.stream()
                .filter(product -> product.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
    }

    public void addProduct(Product product) {
        product.setId(System.currentTimeMillis());
        productList.add(product);
    }

}

//Service Class for Shopping Cart
@Service
public class CartService {

    private List<CartItem> cartItemList = new ArrayList<>();

    public List<CartItem> getAllItemsInCart() {
        return cartItemList;
    }

    public void addItemToCart(CartItem cartItem) {
        cartItemList.add(cartItem);
    }

    public void removeItemFromCart(Long itemId) {
        cartItemList.removeIf(cartItem -> cartItem.getId().equals(itemId));
    }

}

//Model Classes
@Data
public class Product {
    private Long id;
    private String name;
    private double price;
}

@Data
public class CartItem {
    private Long id;
    private Product product;
    private int quantity;
}
