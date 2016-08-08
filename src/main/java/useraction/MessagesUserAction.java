package useraction;

import models.Message;
import pageobjects.DraftPage;
import pageobjects.InboxPage;
import pageobjects.MessageWindow;

public class MessagesUserAction {

	public void writeNewLetterService(Message message) {
		writeNewLetter(message);
	}

	private void writeNewLetter(Message message) {
		MessageWindow messageWindow = new MessageWindow();
		InboxPage inboxPage = new InboxPage();
		inboxPage.writeMessage();
		messageWindow.setToMessage(message.getTo());
		messageWindow.setSubjectMessage(message.getSubject());
		messageWindow.setTextMessage(message.getText());
		messageWindow.closeMessageWindow();
	}

	public void openDraftsService() {
		openDrafts();
	}

	private void openDrafts() {
		InboxPage inboxPage = new InboxPage();
		inboxPage.openDrafts();
	}

	public boolean isDraftsOpenService() {
		return isDraftsOpen();
	}

	private boolean isDraftsOpen() {
		DraftPage draftPage = new DraftPage();
		return draftPage.isDraftMessageLinkPresent();
	}

	public String getToDraftMessageService() {
		return getToDraftMessage();
	}

	private String getToDraftMessage() {
		MessageWindow messageWindow = new MessageWindow();
		return messageWindow.getToDraftMessage();
	}

	public String getSubjectDraftMessageService() {
		return getSubjectDraftMessage();
	}

	private String getSubjectDraftMessage() {
		MessageWindow messageWindow = new MessageWindow();
		return messageWindow.getSubjectDraftMessage();
	}

	public String getThemaDraftMessageService() {
		return getThemaDraftMessage();
	}

	private String getThemaDraftMessage() {
		DraftPage draftPage = new DraftPage();
		String thema = draftPage.getThemaDraftMessage();
		draftPage.openDraftMessage();
		return thema;
	}

	public void sendMessgeService() {
		sendMessge();
	}

	private void sendMessge() {
		MessageWindow messageWindow = new MessageWindow();
		messageWindow.sendMessage();
	}

}
