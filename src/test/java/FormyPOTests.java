import FormyPageObjects.ConfirmationPage;
import FormyPageObjects.FormPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class FormyPOTests extends BaseTest {
    @Test
    public void formTest() {

        driver.get(BASE_URL + "/form");

        FormPage formPage = new FormPage();
        formPage.submitForm(driver);

        ConfirmationPage confirmationPage = new ConfirmationPage();
        confirmationPage.waitForAlertBanner(driver);

        assertEquals(confirmationPage.getAlertBannerText(driver), "The form was successfully submitted!");
    }
}
