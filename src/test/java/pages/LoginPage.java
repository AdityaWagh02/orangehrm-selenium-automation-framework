package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("txtUsername");
    private By password = By.id("txtPassword");
    private By loginBtn = By.id("btnLogin");
    private By errorMsg = By.id("spanMessage");

    private String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(baseUrl);
    }

    public void login(String user, String pass) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMsg).getText();
        } catch (Exception e) {
            return "";
        }
    }
}