package bankguru;

public class BalanceEnquiryPageUI {
	public static final String DYNAMIC_TEXTBOX = "//td[contains(text(),'%s')]/following-sibling::td/input";
	
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	
	public static final String VERIFY_BALANCE = "//p[contains(text(),'Balance Details for Account')]";
	public static final String VERIFY_DYNAMIC = "//td[text()='%s']/following-sibling::td";
	
}
