package FormyPO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FormPage {

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By JOB_TITLE_INPUT = By.id("job-title");
    public static final By RADIO_BUTTON_2 = By.id("radio-button-2");
    public static final By CHECKBOX_2 = By.id("checkbox-2");
    public static final By DROPDOWN_OPTION_1 = By.cssSelector("option[value='1']");
    public static final By DATE_PICKER = By.id("datepicker");
    public static final By SUBMIT_BUTTON = By.cssSelector(".btn.btn-lg.btn-primary");

    public void submitForm(WebDriver driver) {

        driver.findElement(FIRST_NAME_INPUT).sendKeys("John");
        driver.findElement(LAST_NAME_INPUT).sendKeys("Doe");
        driver.findElement(JOB_TITLE_INPUT).sendKeys("QA Engineer");
        driver.findElement(RADIO_BUTTON_2).click();
        driver.findElement(CHECKBOX_2).click();
        driver.findElement(DROPDOWN_OPTION_1).click();
        driver.findElement(DATE_PICKER).sendKeys("05/28/2019", Keys.RETURN);
        driver.findElement(SUBMIT_BUTTON).click();
    }
}
