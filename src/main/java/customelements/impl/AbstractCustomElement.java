package customelements.impl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import customelements.CustomElement;

public abstract class AbstractCustomElement implements CustomElement{
	
	protected WebElement wrappedElement;
	
	
	protected AbstractCustomElement(WebElement element){
		wrappedElement = element;
	}
	
	
	public void click(){
		wrappedElement.click();
	}
	
	public boolean isDisplaied(){
		return wrappedElement.isDisplayed();
	}
	
	public ExpectedCondition<WebElement> isReady() {
        return ExpectedConditions.elementToBeClickable(this.wrappedElement);
 }

}
