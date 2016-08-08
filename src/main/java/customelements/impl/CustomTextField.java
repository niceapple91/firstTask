package customelements.impl;

import org.openqa.selenium.WebElement;
import customelements.TextField;

public class CustomTextField extends AbstractCustomElement implements TextField {

	public CustomTextField(WebElement element) {
		super(element);
	}

	public void sendKeys(String text) {
		wrappedElement.sendKeys(text);
	}

	public void clear() {
		wrappedElement.clear();
	}

	public void clearAndWrite(String text) {
		wrappedElement.clear();
		wrappedElement.sendKeys(text);
	}
}
