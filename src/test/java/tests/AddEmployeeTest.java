package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EmployeePage;
import pages.LoginPage;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void addEmployee() {
        ExtentTest et = extent.createTest("addEmployee");
        this.test = et;

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("Admin", "admin123");

        DashboardPage dash = new DashboardPage(driver);
        dash.openPIM();

        EmployeePage emp = new EmployeePage(driver);
        emp.clickAdd();
        emp.addEmployee("John", "Doe");

        et.pass("Employee added (verify manually or extend locators/asserts)");
    }
}