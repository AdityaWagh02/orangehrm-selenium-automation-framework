package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = System.getProperty("browser", "chrome").toLowerCase();
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions fo = new FirefoxOptions();
                    if (headless) fo.addArguments("--headless=new");
                    driver.set(new FirefoxDriver(fo));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions eo = new EdgeOptions();
                    if (headless) eo.addArguments("--headless=new");
                    driver.set(new EdgeDriver(eo));
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions co = new ChromeOptions();
                    if (headless) co.addArguments("--headless=new");
                    driver.set(new ChromeDriver(co));
                    break;
            }
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}