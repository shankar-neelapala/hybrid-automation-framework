package testbase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@SuppressWarnings("deprecation")
public class BaseClass {

	public WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	@Parameters({"os", "browser"})
	public void setUp(String os, String browser) throws IOException {
		
		logger=(Logger) LogManager.getLogger(this.getClass());
		
		switch (browser.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver();logger.info("Executing on chrome");break;
		case "edge" : driver = new EdgeDriver();logger.info("Executing on edge");break;
		default:logger.info("Invalid Browser");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//loading properties file
		Properties prop = new Properties();
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		prop.load(file);
		driver.get(prop.getProperty("appurl"));//reading url from properties file
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String getRandomString() {
		return RandomStringUtils.randomAlphabetic(5).toUpperCase();
	}
	
	public String getRandomAlphaNumeric() {
	    String letters = RandomStringUtils.randomAlphabetic(5);
	    String digit = RandomStringUtils.randomNumeric(1);
	    return letters + digit;
	}

}
