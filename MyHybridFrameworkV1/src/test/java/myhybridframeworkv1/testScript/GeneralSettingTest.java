package myhybridframeworkv1.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import myhybridframeworkv1.genericLib.BaseClass;


public class GeneralSettingTest extends BaseClass{
	
	@Test
	public void generalSetting() {
		driver.findElement(By.className("popup_menu_button_settings")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'Manage system settings & configure actiTIME')]")).click();
		WebElement dropdown = cu.getElement(driver, By.id("firstHierarchyLevelCodeSelect"));
		cu.getSelectDropdown(dropdown, "visibletext", "Product");
		System.out.println("Title of the Webpage: "+cu.getElement(driver, By.id("FormModifiedTextCell")).getText());
	}
}