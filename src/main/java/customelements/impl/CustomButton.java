package customelements.impl;

import org.openqa.selenium.WebElement;

import customelements.Button;

public class CustomButton extends AbstractCustomElement implements Button {
	
	public CustomButton(WebElement element){
		super(element);
	}

	
}
