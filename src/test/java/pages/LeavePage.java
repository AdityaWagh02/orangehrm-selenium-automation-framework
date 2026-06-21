package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage {
    private WebDriver driver;
    private By leaveMenu = By.id("menu_leave_viewLeaveModule");
    private By applyLeave = By.id("menu_leave_applyLeave"); // example - update locators if needed

    public LeavePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLeaveModule() {
        driver.findElement(leaveMenu).click();
    }

    public void openApplyLeave() {
        driver.findElement(applyLeave).click();
    }
}