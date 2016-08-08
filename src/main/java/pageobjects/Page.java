package pageobjects;

import org.openqa.selenium.support.PageFactory;
import decorator.Decorator;
import webdriver.WebDriverHashMap;

public class Page {

	public Page() {
		createPageFactory();
	}

	protected void createPageFactory() {
		PageFactory.initElements(new Decorator(WebDriverHashMap.getDriverInstance()), this);
	}

}
