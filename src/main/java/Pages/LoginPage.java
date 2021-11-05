package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    By CreateAcBtn = By.xpath("//a[@href='/login']");
    By FirstInput = By.name("email");
    By SecondInput = By.name("password");
    By SubmitBtn = By.xpath("//*[@id=\"signin_form\"]/div[1]/div[3]/button[1]");

    @Step("Click To Login")
    public LoginPage ClickToUser() throws InterruptedException {
        driver.findElement(CreateAcBtn).click();
        Thread.sleep(2000);
        return this;
    }

    @Step("Fill Email: {0}")
    public LoginPage EmailInput(String emailInput) {
        driver.findElement(FirstInput).sendKeys(emailInput);
        return this;
    }

    @Step("Fill Password: {0}")
    public LoginPage PasswordInput(String passwordInput) {
        driver.findElement(SecondInput).sendKeys(passwordInput);
        return this;
    }

    @Step("Click Submit Button")
    public LoginPage ClickToSubmit() throws InterruptedException {
        driver.findElement(SubmitBtn).click();
        Thread.sleep(3000);
        return this;
    }

}
