package bankguru;

public class WithdrawalPageUI {
	public static final String DYNAMIC_TEXTBOX = "//td[contains(text(),'%s')]/following-sibling::td/input";
	
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	
	public static final String VERIFY_WITHDRAWAL = "//p[contains(text(),'Transaction details of Withdrawal for Account')]";
	public static final String VERIFY_DYNAMIC = "//td[text()='%s']/following-sibling::td";
	
}
