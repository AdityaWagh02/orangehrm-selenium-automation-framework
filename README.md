# OrangeHRM Selenium Automation Framework

Project overview
This is a Page Object Model (POM) based automation framework for the OrangeHRM demo application. The framework is built with Java + Selenium WebDriver and is designed to be easy to extend for additional tests and pages.

Tech stack
- Java 11
- Selenium WebDriver 4.x
- TestNG
- Maven
- WebDriverManager
- ExtentReports
- Apache Commons IO
- OpenCSV (data-driven tests)

Repository layout
- src/test/java/pages — Page objects (LoginPage, DashboardPage, EmployeePage, LeavePage)
- src/test/java/tests — Test classes (LoginTest, AddEmployeeTest, SearchEmployeeTest, LogoutTest, LeaveTest)
- src/test/java/utils — Utilities (DriverFactory, ScreenshotUtil, ExtentManager, DataProviders)
- src/test/resources/data — CSV test data (login.csv)
- testng.xml — TestNG suite configuration
- pom.xml — Maven build file
- .github/workflows — CI workflows
- target/ — build/test outputs (reports, screenshots)

What I added
- Data-driven tests using TestNG DataProviders (inline & CSV). See `utils/DataProviders.java`.
- Sample CSV (`src/test/resources/data/login.csv`) for login data.
- Cross-browser DriverFactory with support for Chrome, Firefox, Edge, and headless mode via `-Dbrowser` and `-Dheadless`.
- Leave Management module: `pages/LeavePage` + `tests/LeaveTest`.
- GitHub Actions workflow for cross-browser testing (`.github/workflows/maven-cross-browser.yml`).
- Updated README with usage instructions.

How to run (local)
Prerequisites:
- Java 11+
- Maven
- Browser(s) installed: Chrome, Firefox, Edge (optional)
- Optional: set environment variables or pass system properties

Run tests (default chrome):
- mvn clean test

Run tests for specific browsers:
- mvn clean test -Dbrowser=chrome
- mvn clean test -Dbrowser=firefox
- mvn clean test -Dbrowser=edge

Run headless:
- mvn clean test -Dbrowser=chrome -Dheadless=true

Data-driven tests
- Inline DataProvider example available in `utils/DataProviders.loginDataInline`.
- CSV-based provider expects `src/test/resources/data/login.csv` with each line: username,password
- Example run (CSV provider is used by specifying the test method in code).

CI (GitHub Actions)
- Workflow `.github/workflows/maven-cross-browser.yml` runs tests on push/PR to `main`, using a browser matrix (chrome, firefox), and uploads ExtentReports & screenshots as artifacts.

Extent Reports & Screenshots
- Extent HTML: target/extent-reports/extent.html
- Screenshots on failure: target/screenshots/

Extending the framework
- Add Page Objects under `src/test/java/pages`.
- Add tests under `src/test/java/tests` and register them in `testng.xml`.
- Add data files under `src/test/resources/data` and create DataProviders.

Notes
- Update locators and base URL in page classes if you test a different OrangeHRM instance.
- Edge support in CI may require additional steps — Edge is included for local cross-browser testing.

License
MIT