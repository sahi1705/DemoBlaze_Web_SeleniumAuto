package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        // Initialize once per suite (lazy init in ExtentManager)
        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String desc = result.getMethod().getDescription();
        ExtentTestManager.startTest(testName, desc == null ? "" : desc);
        ExtentLogger.info("Starting test: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail("Test failed: " + result.getThrowable());

        // Screenshot on failure
        String methodName = result.getMethod().getMethodName();
        String ssPath = ScreenshotUtil.captureScreenshot(methodName);
        if (ssPath != null) {
            try {
                ExtentTestManager.getTest().addScreenCaptureFromPath(ssPath);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.warn("Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush once at the end of the suite
        ExtentReports extent = ExtentManager.getInstance();
        extent.flush();
        ExtentTestManager.endTest();
    }
}

