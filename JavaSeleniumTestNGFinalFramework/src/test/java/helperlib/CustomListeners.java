package helperlib;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class CustomListeners implements ITestListener {

    public static final String SCREENSHOT_DIRECTORY = "//src//test//resources//screenshots";

    HelperLibrary library = new HelperLibrary();

    @Override
    public void onTestFailure(ITestResult iTestResult){
        System.out.println("On Test Failure");
        String fileName = iTestResult.getName();
        library.captureScreenshot(fileName);
    }

    @Override
    public void onStart(ITestContext iTestContext){
        System.out.println("Clearing Cache");
        try {
            FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + SCREENSHOT_DIRECTORY));
        }catch(IOException e){
            e.printStackTrace();
        }
        }

}
