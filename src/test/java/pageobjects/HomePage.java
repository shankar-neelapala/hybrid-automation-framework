package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='caret']")
    private WebElement linkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement linkRegister;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    private WebElement linkLogin;

    public void clickOnMyAccount() {
        linkMyAccount.click();
    }

    public void clickOnRegister() {
       linkRegister.click();
    }

    public void clickOnLogin() {
    	linkLogin.click();
    }
}
