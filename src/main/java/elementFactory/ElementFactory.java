package elementFactory;

import org.openqa.selenium.WebElement;

public interface ElementFactory {
	public <T> T create(Class<T> containerClass, WebElement wrappedElement);
}
