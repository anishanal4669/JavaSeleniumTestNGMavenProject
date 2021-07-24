package functionaltests;

import helperlib.ReadPropFiles;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pagedriver.PageDriver;

import java.io.IOException;
import java.util.List;

public class HomePageTests extends PageDriver {

    public static final String[] EXPECTED_MENU_ICONS = {"Home", "Calendar", "Contacts", "Companies", "Deals",
            "Tasks", "Cases", "Calls", "Documents", "Email", "Campaigns", "Forms"};

    @BeforeClass
    public void performLoginTests() throws IOException {
        loginPage().emailField().sendKeys(ReadPropFiles.getPropertyValue("email_address"));
        loginPage().passwordField().sendKeys(ReadPropFiles.getPropertyValue("password"));
        loginPage().submitButton().click();
        Assert.assertTrue(homePage().headerElement().isDisplayed());
    }

    @Test
    public void validateMenuIcons() throws IOException {
        List<WebElement> menuElements = homePage().menuIcons();
        for (int i = 0; i < menuElements.size(); i++) {
            Assert.assertEquals(menuElements.get(i).getText(), EXPECTED_MENU_ICONS[i]);
        }
    }
}
