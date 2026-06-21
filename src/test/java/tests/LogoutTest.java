package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logout() {
        ExtentTest et = extent.createTest("logout");
        this.test = et;

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("Admin", "admin123");

        DashboardPage dash = new DashboardPage(driver);
        dash.logout();

        // After logout the login page should be visible again
        Assert.assertTrue(driver.getCurrentUrl().contains("auth/login") || driver.getTitle().contains("OrangeHRM"), "Should be back to login");
        et.pass("Logout validated");
    }
}