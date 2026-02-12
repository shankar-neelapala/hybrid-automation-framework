package pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='content']//h1")
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group mb-3']//a[.='Logout']")
	WebElement linkLogout;
	
	public boolean isMyAccountPageExists() {
		try {
			return msgHeading.isDisplayed();
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	
	public void clickOnLogout() {
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", linkLogout);
		//linkLogout.click();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(linkLogout)).click();
		
		Actions act = new Actions(driver);
		act.moveToElement(linkLogout).click().perform();
	}

}
