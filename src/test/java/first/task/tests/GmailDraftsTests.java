package first.task.tests;

import org.testng.annotations.Test;

import models.Message;
import models.User;
import parser.ObjectCreator;
import useraction.LoginUserAction;
import useraction.MessagesUserAction;
import webdriver.WebDriverHashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class GmailDraftsTests {

	private static String USER_PROPERTIES_FILE = "src/test/resources/userInfo.xls";
	private String MESSAGE_PROPERTIES_FILE = "src/test/resources/messageInfo.xls";
	private static final Logger logger = Logger.getLogger(GmailDraftsTests.class);



	@Test(dataProvider = "users", threadPoolSize = 5)
	public void verifyDraftMessageWithOpenThema(User user) {
		logger.info("------In thread pool--------");
			ObjectCreator objCr = new ObjectCreator();
			LoginUserAction loginUser = new LoginUserAction();
			MessagesUserAction messagesUser = new MessagesUserAction();
			Message message = (Message) objCr.createObjectService(new Message(), MESSAGE_PROPERTIES_FILE).iterator()
					.next()[0];
			loginUser.loginService(user);
			messagesUser.writeNewLetterService(message);
			messagesUser.openDraftsService();
			messagesUser.getThemaDraftMessageService();
			String subjectMessage = messagesUser.getSubjectDraftMessageService();
			messagesUser.sendMessgeService();
			Assert.assertEquals(subjectMessage, message.getSubject());
	}

	@BeforeClass
	public void beforeClass() {
		DOMConfigurator.configure("src/test/resources/log4j.xml");
	}

	@DataProvider(name = "users", parallel = true)
	public Iterator<Object[]> createUsers() {
		ObjectCreator objCr = new ObjectCreator();
		return objCr.createObjectService(new User(), USER_PROPERTIES_FILE).iterator();
	}

	@AfterMethod
	public void afterClass() {
		WebDriverHashMap.stopDriver();
	}

}
