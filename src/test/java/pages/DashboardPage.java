package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By welcomeMenu = By.id("welcome");
    private By logoutLink = By.linkText("Logout");
    private By pimMenu = By.id("menu_pim_viewPimModule");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAt() {
        try {
            return driver.findElement(welcomeMenu).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openPIM() {
        driver.findElement(pimMenu).click();
    }

    public void logout() {
        driver.findElement(welcomeMenu).click();
        // small wait to allow menu to expand
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        driver.findElement(logoutLink).click();
    }
}