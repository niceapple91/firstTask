package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import customelements.Link;
import decorator.Decorator;
import webdriver.WebDriverHashMap;

public class DraftPage{

	@FindBy(xpath = "//div[@class='BltHke nH oy8Mbf']/div[4]/div[1]/div[1]/table/tbody/tr")
	private Link draftMessageLink;
	@FindBy(xpath = "//div[@class='BltHke nH oy8Mbf']/div[4]/div[1]/div[1]/table/tbody/tr/td[6]/div/div/div/span[1]")
	private Link draftMessageThema;

	private static final Logger logger = Logger.getLogger(DraftPage.class);

	public DraftPage() {
		PageFactory.initElements(new Decorator(WebDriverHashMap.getDriverInstance()), this);
	}

	public String getThemaDraftMessage() {
		return draftMessageThema.getText();
	}

	public boolean isDraftMessageLinkPresent() {
		return draftMessageLink.isDisplaied();
	}

	public Link getDraftMessageLink() {
		return draftMessageLink;
	}

	public void openDraftMessage() {
		draftMessageLink.click();
		logger.info("Open first draft message " + Thread.currentThread().getId());
		// return new MessageWindow();

	}

}
