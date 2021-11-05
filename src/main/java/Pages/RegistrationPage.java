package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By CreateAcBtn = By.xpath("//a[@href='/login']");
    By CreateAccBtn1 = By.xpath("//a[@href='#register_content']");
    By FirstInput = By.name("reg_username");
    By SecondInput = By.name("reg_email");
    By ThirdInput = By.name("reg_password");
    By FourthInput = By.name("reg_passwordretype");
    By SubmitBtn = By.name("reg_submit");
    By LogOutBtn = By.xpath("//a[@href='?logout']");

    @Step("Click To Register")
    public RegistrationPage ClickToUser() throws InterruptedException {
        driver.findElement(CreateAcBtn).click();
        Thread.sleep(2000);
        return this;
    }

    @Step("Click SignUp Button")
    public RegistrationPage ClickToRegister() throws InterruptedException {
        driver.findElement(CreateAccBtn1).click();
        Thread.sleep(2000);
        return this;
    }

    @Step("Fill First And Last Name: {0}")
    public RegistrationPage FirstAndLastName(String firstInput) {
        driver.findElement(FirstInput).sendKeys(firstInput);
        return this;
    }

    @Step("Fill Email: {0}")
    public RegistrationPage EmailInput(String secondInput) {
        driver.findElement(SecondInput).sendKeys(secondInput);
        return this;
    }

    @Step("Fill Password: {0}")
    public RegistrationPage PasswordInput(String thirdInput) {
        driver.findElement(ThirdInput).sendKeys(thirdInput);
        return this;
    }

    @Step("Fill Confirm Password: {0}")
    public RegistrationPage PasswordConfirmInput(String fourthInput) {
        driver.findElement(FourthInput).sendKeys(fourthInput);
        return this;

    }

    @Step("Click Submit Button")
    public RegistrationPage ClickToSubmit() throws InterruptedException {
        driver.findElement(SubmitBtn).click();
        Thread.sleep(2000);
        return this;
    }

    @Step("Click Log Out Button")
    public RegistrationPage LogOut() throws InterruptedException {
        driver.findElement(LogOutBtn).click();
        Thread.sleep(2000);
        return this;
    }

}
