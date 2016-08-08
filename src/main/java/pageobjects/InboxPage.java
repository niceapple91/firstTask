package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import customelements.Button;
import customelements.Link;
import decorator.Decorator;
import webdriver.WebDriverHashMap;

public class InboxPage {

	@FindBy(css = "div.T-I.J-J5-Ji.T-I-KE.L3")
	private Button writeMessageButton;
	@FindBy(css = "a[href*='drafts']")
	private Link draftLink;

	private static final Logger logger = Logger.getLogger(InboxPage.class);

	public InboxPage() {
		PageFactory.initElements(new Decorator(WebDriverHashMap.getDriverInstance()), this);
	}

	public void writeMessage() {
		writeMessageButton.click();
		logger.info("Click write new message " + Thread.currentThread().getId());
	}

	public void openDrafts() {
		draftLink.click();
		logger.info("Click by all Drafts " + Thread.currentThread().getId());
	}

	public boolean isMessageButtonPresent() {
		return writeMessageButton.isDisplaied();
	}

	public Button getWriteMessageButton() {
		return writeMessageButton;
	}

}
