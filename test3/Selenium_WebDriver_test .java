public class SocialMediaTests {

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
    public void testCreateUserProfile() {
        driver.get("http://localhost:8080");
        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement ageInput = driver.findElement(By.id("age"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        nameInput.sendKeys("John Doe");
        ageInput.sendKeys("30");
        submitButton.click();
        WebElement successMessage = driver.findElement(By.id("success-message"));
        Assert.assertEquals("User profile created successfully!", successMessage.getText());
    }

    @Test
    public void testViewUserProfile() {
        driver.get("http://localhost:8080"); WebElement userLink = driver.findElement(By.linkText("View User Profile")); userLink.click(); WebElement name = driver.findElement(By.id("name")); WebElement age = driver .findElement(By.id("age")); Assert.assertEquals("John Doe", name.getText()); Assert.assertEquals("30", age.getText()); }

}
