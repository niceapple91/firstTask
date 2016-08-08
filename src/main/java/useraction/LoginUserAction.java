package useraction;

import models.User;
import pageobjects.InboxPage;
import pageobjects.LoginPage;
import pageobjects.PasswordPage;

public class LoginUserAction {

	public void loginService(User user) {
		login(user);
	}

	private void login(User user) {
		LoginPage logiPage = new LoginPage();
		logiPage.setLogin(user.getLogin());
		PasswordPage passwordPage = new PasswordPage();
		passwordPage.passwordLogin(user.getPassword());
	}

	public boolean isLoginService() {
		return isLogin();
	}

	private boolean isLogin() {
		InboxPage inboxPage = new InboxPage();
		return inboxPage.isMessageButtonPresent();
	}

}
