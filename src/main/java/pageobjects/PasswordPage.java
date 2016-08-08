package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import customelements.Button;
import customelements.TextField;
import decorator.Decorator;
import webdriver.WebDriverHashMap;

public class PasswordPage{

	@FindBy(id = "Passwd")
	private TextField passwordField;
	@FindBy(id = "signIn")
	private Button signInButton;

	private static final Logger logger = Logger.getLogger(PasswordPage.class);

	public PasswordPage() {
		PageFactory.initElements(new Decorator(WebDriverHashMap.getDriverInstance()), this);
	}

	public void passwordLogin(String password) {
		passwordField.sendKeys(password);
		logger.info("Set password " + Thread.currentThread().getId());
		signInButton.click();
		logger.info("SingIn " + Thread.currentThread().getId());
		// return new InboxPage();
	}

	public boolean isPasswordFieldPresent() {
		return passwordField.isDisplaied();
	}

	public TextField getPasswordField() {
		return passwordField;
	}

}
