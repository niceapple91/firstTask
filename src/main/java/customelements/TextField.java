package customelements;

public interface TextField extends CustomElement {
	void sendKeys(String text);
	void clear();
	void clearAndWrite(String text);
}
