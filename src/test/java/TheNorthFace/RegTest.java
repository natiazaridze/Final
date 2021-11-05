package TheNorthFace;

import Pages.RegistrationPage;
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

import static DataObject.RegisterData.*;

public class RegTest {
    WebDriver driver;
    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://thenorthface.ge/?");
        Thread.sleep(2000);

    }
    @Test (retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register with valid credentials")
    public void validRegister() throws InterruptedException {
        RegistrationPage home = new RegistrationPage(driver);
        home
                .ClickToUser()
                .ClickToRegister()
                .FirstAndLastName(firstInput)
                .EmailInput(secondInput)
                .PasswordInput(thirdInput)
                .PasswordConfirmInput(fourthInput)
                .ClickToSubmit()
                .LogOut();


    }

    @Test (retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Register with invalid credentials")
    public void invalidRegister() throws InterruptedException {
        RegistrationPage home = new RegistrationPage(driver);
        home
                .ClickToUser()
                .ClickToRegister()
                .FirstAndLastName(firstInput)
                .EmailInput(secondInvalidInput)
                .PasswordInput(thirdInput)
                .PasswordConfirmInput(fourthInput)
                .ClickToSubmit();

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
