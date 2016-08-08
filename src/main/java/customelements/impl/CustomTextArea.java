package customelements.impl;

import org.openqa.selenium.WebElement;
import customelements.TextArea;

public class CustomTextArea extends AbstractCustomElement implements TextArea {

	public CustomTextArea(final WebElement element) {
		super(element);
	}

	public void clickAndWrite(String text) {
		wrappedElement.click();
		wrappedElement.sendKeys(text);
	}

	public void clear() {
		wrappedElement.clear();
	}

	public void clickClearAndWrite(String text) {
		wrappedElement.click();
		wrappedElement.clear();
		wrappedElement.sendKeys(text);
	}
}
