package myhybridframeworkv1.testScript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import myhybridframeworkv1.genericLib.BaseClass;

public class CustomerCreationTest extends BaseClass {

	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.className("plusIcon")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		String expected = du.getDataFromExcelSheet("Test Data", 0, 1) + cu.getRandom();
		driver.findElement(By.className("inputNameField")).sendKeys(expected);
		driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']"))
				.sendKeys(du.getDataFromExcelSheet("Test Data", 4, 1));
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("titleEditButtonContainer"),
				du.getDataFromExcelSheet("Test Data", 0, 1)));
		String actual = driver.findElement(By.className("titleEditButtonContainer")).getText();
		Assert.assertEquals(actual, expected);
	}
}