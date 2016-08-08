package pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import customelements.Button;
import customelements.Link;
import customelements.TextArea;
import decorator.Decorator;
import webdriver.WebDriverHashMap;

public class MessageWindow{

	@FindBy(xpath = "//div[@class='wO nr l1']/textarea")
	private TextArea toMessage;
	@FindBy(xpath = "//div[@class='aoD az6']/input")
	private TextArea subjectMessage;
	@FindBy(xpath = "//td[@class='Ap']/div[2]/div")
	private TextArea textMessage;
	@FindBy(xpath = "//td[@class='Hm']/img[3]")
	private Button closeWindow;

	@FindBy(xpath = "//div[@class='vR']/input")
	private Link toDraftMessage;
	@FindBy(xpath = "//td[@class='I5']/form/input[3]")
	private Link subjectDraftMessage;
	@FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
	private Button sendButton;

	private static final Logger logger = Logger.getLogger(MessageWindow.class);

	public MessageWindow() {
		PageFactory.initElements(new Decorator(WebDriverHashMap.getDriverInstance()), this);
	}

	public void setToMessage(String to) {
		toMessage.clickClearAndWrite(to);
		logger.info("Set info in To field " + Thread.currentThread().getId());
	}

	public void setSubjectMessage(String subject) {
		subjectMessage.clickClearAndWrite(subject);
		logger.info("Set subject field " + Thread.currentThread().getId());
	}

	public void setTextMessage(String text) {
		textMessage.clickClearAndWrite(text);
		logger.info("Write some message");
	}

	public void closeMessageWindow() {
		closeWindow.click();
		logger.info("Close new Message window " + Thread.currentThread().getId());
	}

	public String getToDraftMessage() {
		logger.info("Verify To field Draft message " + Thread.currentThread().getId());
		return toDraftMessage.getAttribute("value");
	}

	public String getSubjectDraftMessage() {
		logger.info("Verify Subject field Draft message " + Thread.currentThread().getId());
		return subjectDraftMessage.getAttribute("value");
	}

	public void sendMessage() {
		sendButton.click();
		logger.info("Send message, that was in draft " + Thread.currentThread().getId());
	}

}
