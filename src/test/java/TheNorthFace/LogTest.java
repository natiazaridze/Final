package TheNorthFace;

import Pages.LoginPage;
import Utils.Retry;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static DataObject.LoginData.*;
public class LogTest {
    WebDriver driver;
    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://thenorthface.ge/?");
        Thread.sleep(3000);
    }
    @Test (retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Log In with valid credentials")
    public void validLogin() throws InterruptedException {
        LoginPage home = new LoginPage(driver);
        home
                .ClickToUser()
                .EmailInput(emailInput)
                .PasswordInput(passwordInput)
                .ClickToSubmit();

    }

    @Test (retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Log In with valid credentials")
    public void InvalidLogin() throws InterruptedException {
        LoginPage home = new LoginPage(driver);
        home
                .ClickToUser()
                .EmailInput(invalidEmailInput)
                .PasswordInput(passwordInput)
                .ClickToSubmit();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
