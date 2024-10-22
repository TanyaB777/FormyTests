import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.Assert.*;

public class FormyElementTests extends BaseTest {

    final String INPUT_NAME = "Meaghan Lewis";

    @Test
    public void keyboardAndMouseInputTest() {

        driver.get(BASE_URL + "/keypress");

        WebElement nameInput = driver.findElement(By.id("name"));
        nameInput.click();
        nameInput.sendKeys(INPUT_NAME);

        WebElement buttonSubmit = driver.findElement(By.id("button"));
        buttonSubmit.click();

        assertEquals(nameInput.getAttribute("value"), INPUT_NAME);
        assertTrue(buttonSubmit.isDisplayed());
    }

    @Test
    public void scrollToElementTest() {

        driver.get(BASE_URL + "/scroll");

        WebElement nameInput = driver.findElement(By.id("name"));

        Actions actions = new Actions(driver);
        actions.moveToElement(nameInput);
        nameInput.sendKeys(INPUT_NAME);

        WebElement datePicker = driver.findElement(By.id("date"));
        datePicker.sendKeys("01/01/2020");

        assertEquals(nameInput.getAttribute("value"), INPUT_NAME);
        assertEquals(datePicker.getAttribute("value"), "01/01/2020");
    }

    @Test
    public void switchToActiveWindowTest() {

        driver.get(BASE_URL + "/switch-window");

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String originalHandle = driver.getWindowHandle();

        for (String nextHandle : driver.getWindowHandles()) {
            driver.switchTo().window(nextHandle);
            assertEquals(driver.getWindowHandle(), nextHandle);
        }

        driver.switchTo().window(originalHandle);
        assertEquals(driver.getWindowHandle(), originalHandle);
    }

    @Test
    public void SwitchToAlertTest() {

        driver.get(BASE_URL + "/switch-window");

        WebElement alertButton = driver.findElement(By.id("alert-button"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        assertEquals(alertText, "This is a test alert!");

        alert.accept();

        assertTrue(alertButton.isDisplayed());
    }

    @Test
    public void executeJavascriptTest() {

        driver.get(BASE_URL + "/modal");

        WebElement modalButton = driver.findElement(By.id("modal-button"));
        modalButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("modal-title"))
        );

        assertEquals(modalTitle.getText(), "Modal title");

        WebElement closeButton = driver.findElement(By.id("close-button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);

        boolean isModalClosed = wait.until(
                ExpectedConditions.invisibilityOfElementLocated(By.className("modal-title"))
        );

        assertTrue(isModalClosed);
    }

    @Test
    public void dragAndDropTest() {

        driver.get(BASE_URL + "/dragdrop");

        WebElement image = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(image, box).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("image")));

        WebElement boxItem = box.findElement(By.tagName("p"));

        assertEquals(boxItem.getText(), "Dropped!");
    }

    @Test
    public void radioButtonsTest() {

        driver.get(BASE_URL + "/radiobutton");

        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();

        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();

        WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
        radioButton3.click();

        assertTrue(radioButton3.isSelected());
    }

    @Test
    public void datePickerTest() {

        driver.get(BASE_URL + "/datepicker");

        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("03/03/2020");
        datePicker.sendKeys(Keys.RETURN);

        assertEquals(datePicker.getAttribute("value"), "03/03/2020");
    }

    @Test
    public void dropDownMenu() {

        driver.get(BASE_URL + "/dropdown");

        WebElement dropDownMenu = driver.findElement(By.id("dropdownMenuButton"));
        dropDownMenu.click();

        WebElement autocompleteItem = driver.findElement(By.id("autocomplete"));
        autocompleteItem.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("form-group")));

        WebElement autoCompleteText = driver.findElement(By.tagName("h1"));
        assertEquals(autoCompleteText.getText(), "Autocomplete");
    }

    @Test
    public void fileUploadTest() {

        final String FILE_TO_UPLOAD= "file-to-upload.png";
        driver.get(BASE_URL + "/fileupload");

        WebElement fileUploadField = driver.findElement(By.id("file-upload-field"));
        fileUploadField.sendKeys(FILE_TO_UPLOAD);

        assertEquals(fileUploadField.getAttribute("value"), FILE_TO_UPLOAD);
    }
}
