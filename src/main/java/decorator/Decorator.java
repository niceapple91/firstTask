package decorator;

import java.lang.reflect.Field;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import elementFactory.CustomElementFactory;
import elementFactory.ElementFactory;

public class Decorator extends DefaultFieldDecorator {
	
	public Decorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }
	
	private WebElement wrappedElement;
	
	public Object decorate(ClassLoader loader, Field field){
		ElementLocator locator = factory.createLocator(field);
		Class<?> cl = getClass(field);
		if (cl == null){
			return super.decorate(loader, field);
		} else {
			wrappedElement = proxyForLocator(loader, locator);
			ElementFactory elFactory = new CustomElementFactory();
			return elFactory.create(cl, wrappedElement);
		}
	}
	
	private Class<?> getClass(Field field){
		Class<?> cl = field.getType();
		try{
			Class<?>[] clr = cl.getInterfaces();
			if (clr[0].getSimpleName().equals("CustomElement")){
				return cl;
			}
		}catch(Exception e){
			return null;
		}
		return null;
	}
	}
	



