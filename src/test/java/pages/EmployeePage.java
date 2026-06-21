package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {
    private WebDriver driver;
    private By addButton = By.id("btnAdd");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By saveBtn = By.id("btnSave");
    private By empSearchName = By.id("empsearch_employee_name_empName");
    private By searchBtn = By.id("searchBtn");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAdd() {
        driver.findElement(addButton).click();
    }

    public void addEmployee(String fName, String lName) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(saveBtn).click();
    }

    public void searchEmployee(String name) {
        driver.findElement(empSearchName).clear();
        driver.findElement(empSearchName).sendKeys(name);
        driver.findElement(searchBtn).click();
    }
}