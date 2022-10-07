package myhybridframeworkv1.genericLib;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {

	public Alert alt;
	public WebDriverWait wait;
	public Select s;

	public WebElement getElement(WebDriver driver, By locator) {
		return driver.findElement(locator);
	}

	public int getRandom() {
		Random r = new Random();
		int num = r.nextInt(10000);
		return num;
	}

	public void getExplicitWaitClick(WebDriver driver, WebElement element, long timeouts) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		WebElement elements = null;
		elements = wait.until(ExpectedConditions.elementToBeClickable(element));
		elements.click();
	}

	public void getExplicitWaitVisible(WebDriver driver, long timeouts, String locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	}

	public void getDismiss(WebDriver driver) {
		alt = driver.switchTo().alert();
		alt.dismiss();
	}

	public void getAccept(WebDriver driver) {
		alt = driver.switchTo().alert();
		alt.accept();
	}

	public void getSendKeys(String keysToSend) {
		alt.sendKeys(keysToSend);
	}

	public void getGetText() {
		alt.getText();
	}

	// Actions Class
	public void getActionsWb(WebDriver driver, WebElement webelement, String type) {
		Actions act = new Actions(driver);
		switch (type) {
		case "MoveToElement":
			act.moveToElement(webelement).click().build().perform();
			break;
		case "RightClick":
			act.contextClick(webelement);
			break;
		case "Click":
			act.click(webelement);
			break;
		case "DoubleClick":
			act.doubleClick(webelement);
			break;
		case "ClickAndHold":
			act.clickAndHold(webelement);
			break;
		case "Release":
			act.release(webelement);
			break;
		default:
			System.out.println("Invalid type.");
			break;
		}
	}
	// Actions Class
	public void getActions(WebDriver driver, String type) {
		Actions act = new Actions(driver);
		switch (type) {
		case "Perform":
			act.perform();
			break;
		case "Build":
			act.build();
			break;
		case "Click":
			act.click();
			break;
		case "RightClick":
			act.contextClick();
			break;
		case "DoubleClick":
			act.doubleClick();
			break;
		case "ClickAndHold":
			act.clickAndHold();
			break;
		case "Release":
			act.release();
			break;
		default:
			System.out.println("Invalid type.");
			break;
		}
	}
	// Actions Class
	public void getActionsCo(WebDriver driver, WebElement webelement, String type, int x, int y) {
		Actions act = new Actions(driver);
		switch (type) {
		case "DragAndDrop":
			act.dragAndDrop(webelement, webelement);
			break;
		case "DragAndDropBy":
			act.dragAndDropBy(webelement, x, y);
			break;
		default:
			System.out.println("Invalid type.");
			break;
		}
	}

	// Robot Class
	public void getRobot(String type, int keyCode) throws AWTException {
		Robot r = new Robot();
		switch (type) {
		case "KeyPress":
			r.keyPress(keyCode);
			break;
		case "KeyRelease":
			r.keyRelease(keyCode);
			break;
		default:
			System.out.println("Invalid type. \n1. KeyPress \n2. KeyRelease");
			break;
		}
	}

	// Select Class
	public void getSelectDropdown(WebElement dropdown, String type, String value) {
		Select select = new Select(dropdown);
		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("Entered a wrong type. \n1. index \n2. value \n3. visibletext");
			break;
		}
	}
}