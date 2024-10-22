import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static final String BASE_URL = "https://formy-project.herokuapp.com";
    protected WebDriver driver;

    @BeforeMethod
    public void startTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void finishTest() {
        driver.quit();
    }
}