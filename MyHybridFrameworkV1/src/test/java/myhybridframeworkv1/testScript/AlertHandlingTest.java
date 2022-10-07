package myhybridframeworkv1.testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import myhybridframeworkv1.genericLib.BaseClass;

public class AlertHandlingTest extends BaseClass{
	
	@Test
	public void alertHandling() throws EncryptedDocumentException, IOException {
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.linkText("Types of Work")).click();
		driver.findElement(By.id("createBillingTypeDiv")).click();
		driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelSheet("Test Data", 0, 1), Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.ENTER);
		cu.getAccept(driver);
		System.out.println("Title of the Webpage: "+driver.getTitle());
	}
}