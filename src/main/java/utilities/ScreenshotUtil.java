package utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(String methodName) {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver == null) return null;

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String dir = System.getProperty("user.dir") + "/test-output/screenshots";
            Files.createDirectories(Path.of(dir));

            String path = dir + "/" + methodName + "_" + time + ".png";
            Files.copy(src.toPath(), Path.of(path));
            return path;
        } catch (Exception e) {
            return null;
        }
    }
}

