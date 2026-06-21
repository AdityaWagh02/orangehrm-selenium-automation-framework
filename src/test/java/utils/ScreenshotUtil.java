package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    public static String takeScreenshot(WebDriver driver, String namePrefix) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String ts = LocalDateTime.now().format(fmt);
        String destDir = "target/screenshots";
        String destPath = destDir + "/" + namePrefix + "_" + ts + ".png";
        try {
            FileUtils.forceMkdir(new File(destDir));
            FileUtils.copyFile(src, new File(destPath));
            return destPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}