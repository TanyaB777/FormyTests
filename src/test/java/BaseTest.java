import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static final String BASE_URL = "https://formy-project.herokuapp.com";
    protected WebDriver driver;

    public void startRemoteTest() throws MalformedURLException {
        final String USERNAME = "YOUR_USERNAME";
        final String ACCESS_KEY = "YOUR_ACCESS_KEY";
        final String SAUCE_URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        caps.setCapability("platformName", "macOS 10.12");  // Замена 'platform'
        caps.setCapability("browserVersion", "66.0");       // Замена 'version'

//        caps.setCapability("sauce:options", Map.of(
//                "name", "Remote WebDriver Test",
//                "build", "Build-1"
//        ));

        driver = new RemoteWebDriver(new URL(SAUCE_URL), caps);
    }

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