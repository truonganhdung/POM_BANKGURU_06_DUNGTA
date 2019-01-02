package bankguru;

public class AbstractPageUI {
	public static final String DYNAMIC_PAGE_LINK = "//a[text()='%s']";

	public static final String DYNAMIC_TEXTBOX = "//td[contains(text(),'%s')]/following-sibling::td/input";
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	
	public static final String DYNAMIC_VERIFY = "//td[text()='%s']/following-sibling::td";
	
}
