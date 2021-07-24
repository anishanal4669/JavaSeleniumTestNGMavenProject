package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class LoginPage extends BaseTest {

    public WebElement emailField() throws IOException {
        By emailField = By.xpath("//input[@type='text' and @name='email']");
        applyFluent().until(ExpectedConditions.visibilityOfElementLocated(emailField));
        return driver.findElement(emailField);
    }

    public WebElement passwordField() throws IOException {
        By passwordField = By.xpath("//input[@type='password' and @name='password']");
        applyFluent().until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        return driver.findElement(passwordField);
    }

    public WebElement submitButton() throws IOException {
        By submitButton = By.xpath("//div[contains(@class, 'submit button') and text()='Login']");
        applyFluent().until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        return driver.findElement(submitButton);
    }
}
