package bankguru;

public class NewAccountPageUI {
	public static final String DYNAMIC_TEXTBOX = "//td[contains(text(),'%s')]/following-sibling::td/input";
	
	public static final String ACCOUNT_TYPE = "//select[@name='selaccount']";
	
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	
	public static final String VERIFY_CREATE_ACCOUNT = "//p[text()='Account Generated Successfully!!!']";
	public static final String VERIFY_DYNAMIC = "//td[text()='%s']/following-sibling::td";
	
}
