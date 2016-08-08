package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import properties.PropertiesCreator;
import properties.SimplePropertyCreator;

public class WebDriverHashMap {

	private static ThreadLocal<WebDriver> map = new ThreadLocal<WebDriver>();
	private static WebDriver driver;
	private static final String KEY = "url";
	private static PropertiesCreator property = new SimplePropertyCreator();
	private static String url = property.getProperty(KEY);

	private static final Object someObject = new Object();
	private static int count = 0;

	public static WebDriver getDriverInstance() {

		synchronized (someObject) {
			driver = map.get();
			if (driver != null) {
				return driver;
			}
			if (count >= 5) {
				try {
					someObject.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			count++;
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			map.set(driver);
			return driver;
		}
	}

	public static void stopDriver() {
		synchronized (someObject) {
			WebDriver d = map.get();
			if (d != null) {
				d.quit();
				map.remove();
				count--;
				someObject.notify();
			}
		}
	}

	public static synchronized void loadPage() {
		getDriverInstance().get(url);
	}
}
