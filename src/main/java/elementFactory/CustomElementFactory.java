package elementFactory;

import org.openqa.selenium.WebElement;
import properties.PropertiesCreator;
import properties.SimplePropertyCreator;

public class CustomElementFactory implements ElementFactory{
	
	public <T> T create(Class<T> containerClass, WebElement wrappedElement){
           T element;
           try {
                  element = findImplementingClass(containerClass)
                               .getDeclaredConstructor(WebElement.class)
                               .newInstance(wrappedElement);
           }
           catch (Exception e) {throw new RuntimeException(e);}
           return element;
    }



    @SuppressWarnings("unchecked")
	private <T> Class<? extends T> findImplementingClass (final Class<T> elementClass){
    	PropertiesCreator property = new SimplePropertyCreator();
		String implClassName = property.getProperty(elementClass.getSimpleName());
           if (implClassName == null) throw new RuntimeException("No implementation found for interface "+elementClass.getSimpleName());
           try {
                  return (Class<? extends T>) Class.forName(implClassName);
           } catch (ClassNotFoundException e) {
                  throw new RuntimeException("Unable to load class for "+implClassName,e);
           }

    }
    }

