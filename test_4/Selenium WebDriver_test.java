public class ECommerceTests {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testBrowseProducts() {
    driver.get("http://localhost:8080");
    WebElement productLink = driver.findElement(By.linkText("View Products"));
    productLink.click();
    WebElement productName = driver.findElement(By.id("product-name"));
    Assert.assertEquals("Product 1", productName.getText());
    }

    @Test
    public void testAddToCart() {
    driver.get("http://localhost:8080");
    WebElement productLink = driver.findElement(By.linkText("View Products"));
    productLink.click();
    WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
    addToCartButton.click();
    WebElement cartLink = driver.findElement(By.linkText("View Cart"));
    cartLink.click();
    WebElement cartItemName = driver.findElement(By.id("cart-item-name"));
    Assert.assertEquals("Product 1", cartItemName.getText());
}

