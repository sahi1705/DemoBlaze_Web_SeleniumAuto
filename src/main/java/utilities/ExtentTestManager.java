package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static final ThreadLocal<ExtentTest> TL_TEST = new ThreadLocal<>();

    public static ExtentTest startTest(String testName, String description) {
        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest(testName, description);
        TL_TEST.set(test);
        return test;
    }

    public static ExtentTest getTest() {
        return TL_TEST.get();
    }

    public static void endTest() {
        TL_TEST.remove();
    }
}

