package utilities;

public class ExtentLogger {
    public static void info(String msg) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info(msg);
        }
    }
    public static void pass(String msg) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().pass(msg);
        }
    }
    public static void fail(String msg) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().fail(msg);
        }
    }
    public static void warn(String msg) {
        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().warning(msg);
        }
    }
}

