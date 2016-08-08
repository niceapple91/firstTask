package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import customelements.Button;
import customelements.TextField;
import decorator.Decorator;
import webdriver.WebDriverHashMap;

public class LoginPage{

	private static final Logger logger = Logger.getLogger(LoginPage.class);

	@FindBy(id = "Email")
	private TextField emailField;
	@FindBy(id = "next")
	private Button nextButton;

	public LoginPage() {
		PageFactory.initElements(new Decorator(WebDriverHashMap.getDriverInstance()), this);
	}

	public void setLogin(String login) {
		WebDriverHashMap.loadPage();
		logger.info("Get URL " + Thread.currentThread().getId());
		emailField.sendKeys(login);
		logger.info("Set Email " + Thread.currentThread().getId());
		nextButton.click();
		logger.info("Click Next button " + Thread.currentThread().getId());
	}

	public boolean isEmailPresent() {
		return emailField.isDisplaied();
	}

	public TextField getEmailField() {
		return emailField;
	}

	public PasswordPage getUrl() {
		WebDriverHashMap.loadPage();
		logger.info("Get URL " + Thread.currentThread().getId());
		return new PasswordPage();
	}

}
