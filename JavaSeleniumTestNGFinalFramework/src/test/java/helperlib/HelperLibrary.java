package helperlib;

import base.BaseTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class HelperLibrary extends BaseTest {

    public static final String SCREENSHOT_FOLDER = "//src//test//resources//screenshots//";

    public void captureScreenshot(String fileName){
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+SCREENSHOT_FOLDER+fileName+".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
