package bankguru;

public class DepositPageUI {
	public static final String DYNAMIC_TEXTBOX = "//td[text()='%s']/following-sibling::td/input";
	
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	
	public static final String VERIFY_DEPOSIT = "//p[contains(text(),'Transaction details of Deposit for Account')]";
	public static final String VERIFY_DYNAMIC = "//td[text()='%s']/following-sibling::td";
}
