package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import webdriver.WebDriverHashMap;

public class WaitPages {

	public WaitPages() {
		wait = new WebDriverWait(WebDriverHashMap.getDriverInstance(), 10);
	}

	private WebDriverWait wait;

	public void waitPage(ExpectedCondition<WebElement> condition) {
		wait.until(condition);
	}

}
