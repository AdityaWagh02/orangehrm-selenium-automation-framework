package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeavePage;
import pages.LoginPage;

public class LeaveTest extends BaseTest {

    @Test
    public void openLeaveModule() {
        ExtentTest et = extent.createTest("openLeaveModule");
        this.test = et;

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("Admin", "admin123");

        DashboardPage dash = new DashboardPage(driver);
        // depending on nav flow, you may need to navigate differently
        dash.openPIM();

        LeavePage leave = new LeavePage(driver);
        leave.openLeaveModule();

        et.pass("Opened Leave module (expand with apply/verify flows)");
    }
}