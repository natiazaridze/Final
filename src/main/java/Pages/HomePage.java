package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

import static DataObject.LoginData.emailInput;


public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By CreateAcBtn = By.xpath("//a[@href='/login']");
    By FirstInput = By.name("email");
    By SecondInput = By.name("password");
    By SubmitBtn = By.xpath("//*[@id=\"signin_form\"]/div[1]/div[3]/button[1]");
    By SandwichBtn = By.xpath("/html/body/div[5]/div[2]/nav[1]/button");
    By LanguageBtn = By.id("navbarDropdownMenuLink");
    By ChangeLangBtn = By.xpath("//a[@href='/?&lang=2']");
    By SearchFor = By.name("msearch");
    By SearchClick = By.xpath("/html/body/div[5]/div[2]/nav[1]/ul[1]/form/div/button");
    By AddToCart = By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div[1]/div[2]/a");
    By CleanCart = By.xpath("//*[@id=\"shopping_cart\"]/div/div[3]/div[1]/a[2]");
    By ConfirmCleanCart = By.xpath("//*[@id=\"modalConfirm\"]/div/div/div[3]/a");
    By GoToYourCart = By.xpath("//a[@href='/cart']");

        @Step("Click To Login")
        public HomePage ClickToUser () throws InterruptedException {
            driver.findElement(CreateAcBtn).click();
            Thread.sleep(2000);
            return this;
        }

        @Step("Fill Email: {0}")
        public HomePage EmailInput (String emailInput){
            driver.findElement(FirstInput).sendKeys(emailInput);
            return this;
        }

        @Step("Fill Password: {0}")
        public HomePage PasswordInput (String passwordInput){
            driver.findElement(SecondInput).sendKeys(passwordInput);
            return this;
        }

        @Step("Click Submit Button")
        public HomePage ClickToSubmit () throws InterruptedException {
            driver.findElement(SubmitBtn).click();
            Thread.sleep(3000);
            return this;
        }

        @Step("Click Sandwich Button")
        public HomePage ClickToDropDown () throws InterruptedException {
            driver.findElement(SandwichBtn).click();
            Thread.sleep(3000);
            return this;
        }
        @Step("Click GE Button")
        public HomePage ClickToChoose () throws InterruptedException {
            driver.findElement(LanguageBtn).click();
            Thread.sleep(3000);
            return this;
        }

        @Step("Click ENG Button")
        public HomePage ClickToSelect () throws InterruptedException {
            driver.findElement(ChangeLangBtn).click();
            Thread.sleep(3000);
            return this;
        }

        @Step("Click To Input")
        public HomePage ClickToInput () throws InterruptedException {
            if (driver.findElement(SearchFor).isDisplayed()){
                driver.findElement(SearchFor).click();
            }
            return this;
        }

        @Step("Fill Search Input: {0}")
        public HomePage SearchInput (String searchFor){
            driver.findElement(SearchFor).sendKeys(searchFor);
            return this;
        }
        @Step("Click To Search")
        public HomePage ClickToSearch () throws InterruptedException {
            driver.findElement(SearchClick).click();
            Thread.sleep(2000);
            return this;
        }

        @Step("Click to add it in your cart")
        public HomePage ClickToAddToCart() throws InterruptedException {
            driver.findElement(AddToCart).click();
            Thread.sleep(2000);
            return this;
        }
        @Step("Click to add it in your cart")
        public HomePage ClickToCleanCart() throws InterruptedException {
            driver.findElement(CleanCart).click();
            Thread.sleep(2000);
            return this;
    }
        @Step("Click to add it in your cart")
        public HomePage ClickToRemoveEverything() throws InterruptedException {
            driver.findElement(ConfirmCleanCart).click();
            Thread.sleep(2000);
            return this;
    }
        @Step("Click to add it in your cart")
        public HomePage GoToCart() throws InterruptedException {
            driver.findElement(GoToYourCart).click();
            Thread.sleep(2000);
            return this;
    }



}
