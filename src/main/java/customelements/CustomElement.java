package customelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public interface CustomElement {
	void click();
	boolean isDisplaied();
	ExpectedCondition<WebElement> isReady();

}
