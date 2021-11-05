package TheNorthFace;

import Pages.HomePage;
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

import static DataObject.HomeData.searchFor;
import static DataObject.HomeData.searchForInvalid;
import static DataObject.LoginData.emailInput;
import static DataObject.LoginData.passwordInput;

public class HomeTest {
    WebDriver driver;

    @BeforeMethod(description = "Configure browser before tests")
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://thenorthface.ge/?");
        Thread.sleep(4000);
    }
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search For Item Valid")
    public void ValidSearch() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home
                .ClickToDropDown()
                .ClickToChoose()
                .ClickToSelect()
                .ClickToUser()
                .EmailInput(emailInput)
                .PasswordInput(passwordInput)
                .ClickToSubmit()
                .ClickToInput()
                .SearchInput(searchFor)
                .ClickToSearch()
                .ClickToAddToCart()
                .ClickToCleanCart()
                .ClickToRemoveEverything()
                .GoToCart();

    }
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Search For Item Valid")
    public void InvalidSearch() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home
                .ClickToDropDown()
                .ClickToChoose()
                .ClickToSelect()
                .ClickToUser()
                .EmailInput(emailInput)
                .PasswordInput(passwordInput)
                .ClickToSubmit()
                .ClickToInput()
                .SearchInput(searchForInvalid)
                .ClickToSearch();
    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}