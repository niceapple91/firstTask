package customelements.impl;

import org.openqa.selenium.WebElement;
import customelements.Link;

public class CustomLink extends AbstractCustomElement implements Link {
	
	public CustomLink(WebElement element){
		super(element);
	}
	
	public String getAttribute(String value){
		return wrappedElement.getAttribute(value);
	}
	
	public String getText(){
		return wrappedElement.getText();
	}

}
