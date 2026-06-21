package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        ExtentTest et = extent.createTest("validLogin");
        this.test = et;

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("Admin", "admin123");

        DashboardPage dash = new DashboardPage(driver);
        Assert.assertTrue(dash.isAt(), "Dashboard should be visible after valid login");
        et.pass("Valid login passed");
    }

    @Test
    public void invalidLogin() {
        ExtentTest et = extent.createTest("invalidLogin");
        this.test = et;

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("wrong", "wrong");
        String err = login.getErrorMessage();
        Assert.assertTrue(err.toLowerCase().contains("invalid") || !err.isEmpty(), "Should show login error");
        et.pass("Invalid login validated");
    }

    @Test
    public void emptyUsername() {
        ExtentTest et = extent.createTest("emptyUsername");
        this.test = et;

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("", "admin123");
        String err = login.getErrorMessage();
        Assert.assertTrue(!err.isEmpty(), "Error should be shown for empty username");
        et.pass("Empty username validated");
    }

    @Test
    public void emptyPassword() {
        ExtentTest et = extent.createTest("emptyPassword");
        this.test = et;

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("Admin", "");
        String err = login.getErrorMessage();
        Assert.assertTrue(!err.isEmpty(), "Error should be shown for empty password");
        et.pass("Empty password validated");
    }
}