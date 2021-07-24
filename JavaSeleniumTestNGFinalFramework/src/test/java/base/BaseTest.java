package base;

import helperlib.ReadPropFiles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public void initSetup() throws IOException {
        //System.setProperty("webdriver.chrome.driver", ReadPropFiles.getPropertyValue("browser_driver_path"));
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ReadPropFiles.getPropertyValue("application_under_test"));
        applyFluent().until(ExpectedConditions.titleIs("Cogmento CRM"));
    }

    public static FluentWait<WebDriver> applyFluent() throws IOException {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(Long.parseLong(ReadPropFiles.getPropertyValue("fluent_wait_time"))))
                .pollingEvery(Duration.ofSeconds(Long.parseLong(ReadPropFiles.getPropertyValue("fluent_wait_frequency_time")))).ignoring(Exception.class);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }





}

