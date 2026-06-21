package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EmployeePage;
import pages.LoginPage;

public class SearchEmployeeTest extends BaseTest {

    @Test
    public void searchEmployee() {
        ExtentTest et = extent.createTest("searchEmployee");
        this.test = et;

        LoginPage login = new LoginPage(driver);
        login.open();
        login.login("Admin", "admin123");

        DashboardPage dash = new DashboardPage(driver);
        dash.openPIM();

        EmployeePage emp = new EmployeePage(driver);
        emp.searchEmployee("John Doe");

        et.pass("Employee search performed (add assertions based on table if needed)");
    }
}