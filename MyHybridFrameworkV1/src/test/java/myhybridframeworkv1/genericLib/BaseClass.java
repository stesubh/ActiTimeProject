package myhybridframeworkv1.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import myhybridframeworkv1.elementRepository.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public DataUtility du = new DataUtility();
	public CommonUtility cu = new CommonUtility();

	@BeforeClass
	public void setUp() throws IOException {
		switch (du.getDataFromPropertiesFile("browser")) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void login() throws IOException {
		LoginPage lp = new LoginPage(driver);
		driver.get(du.getDataFromPropertiesFile("URL"));
		lp.loggingIN(du.getDataFromPropertiesFile("Id"), du.getDataFromPropertiesFile("Pass"));
	}

	@AfterMethod
	public void logOut() {
		driver.findElement(By.id("logoutLink")).click();
	}

	@AfterClass
	public void closebrowser() {
		driver.close();
	}
}