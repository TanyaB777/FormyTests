package FormyPO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {

    public static final By ALERT_FIELD = By.className("alert");

    public void waitForAlertBanner(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_FIELD));
    }

    public String getAlertBannerText(WebDriver driver) {
        return driver.findElement(ALERT_FIELD).getText();
    }
}