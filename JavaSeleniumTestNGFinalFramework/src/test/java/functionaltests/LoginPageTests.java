package functionaltests;
import helperlib.ReadPropFiles;
import org.junit.Assert;

import org.testng.annotations.Test;
import pagedriver.PageDriver;

import java.io.IOException;

public class LoginPageTests extends PageDriver {

    @Test(priority = 0)
    public void validateEmailFieldTest() throws IOException {
        Assert.assertTrue(loginPage().emailField().isDisplayed());
    }

    @Test(priority = 1)
    public void validatePasswordFieldTest() throws IOException {
        Assert.assertTrue(loginPage().passwordField().isDisplayed());
    }

    @Test(priority = 2)
    public void validateSubmitButtonFieldTest() throws IOException {
        Assert.assertTrue(loginPage().submitButton().isDisplayed());
    }

    @Test(priority = 3)
    public void performLoginTests() throws IOException {
        loginPage().emailField().sendKeys(ReadPropFiles.getPropertyValue("email_address"));
        loginPage().passwordField().sendKeys(ReadPropFiles.getPropertyValue("password"));
        loginPage().submitButton().click();
        Assert.assertTrue(homePage().headerElement().isDisplayed());
    }

}
