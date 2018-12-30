package com.bankguru.payment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BalanceEnquiryPageObject;
import pages.DeleteAccountPageObject;
import pages.DeleteCustomerPageObject;
import pages.DepositPageObject;
import pages.EditCustomerPageObject;
import pages.FundTransferPageObject;
import pages.HomePageObject;
import pages.LoginPageObject;
import pages.NewAccountPageObject;
import pages.NewCustomerPageObject;
import pages.WithdrawalPageObject;
import payment.Account;
import payment.BalanceEnquiry;
import payment.Customer;
import payment.Deposit;
import payment.FundTransfer;
import payment.Withdrawal;

import com.bankguru.common.Common_01_CreateUser;
import commons.AbstractTest;
import commons.PageFactoryManager;

public class TC_Review extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLogInPage(driver);

		log.info("---Create new User---");
		loginPage.inputToUserIDTextbox(Common_01_CreateUser.userID);
		loginPage.inputToPasswordTextbox(Common_01_CreateUser.password);

		homePage = loginPage.clickToLoginButton();
		log.info("---End of Before Class---");
	}

	@Test
	public void Payment_TC01_1_CreateNewCustomer() {
		log.info("---Begin of TC01_CreateNewCustomer---");
		newCustomerPage = homePage.openNewCustomerPage(driver);

		log.info("---T01: Create new Customer---");
		newCustomerPage.inputToCustomerNameTextBox(Customer.NewCustomer.CUSTOMER_NAME);
		newCustomerPage.inputToDoBTextBox(Customer.NewCustomer.DATE_OF_BIRTH);
		newCustomerPage.inputToAddressTextArea(Customer.NewCustomer.ADDRESS);
		newCustomerPage.inputToCityTextBox(Customer.NewCustomer.CITY);
		newCustomerPage.inputToStateTextBox(Customer.NewCustomer.STATE);
		newCustomerPage.inputToPinTextBox(Customer.NewCustomer.PIN);
		newCustomerPage.inputToMobileTextBox(Customer.NewCustomer.MOBILE);
		newCustomerPage.inputToEmailTextBox(Customer.NewCustomer.PREFIX_EMAIL);
		newCustomerPage.inputToPasswordTextBox(Customer.NewCustomer.PASSWORD);
		newCustomerPage.clickToSubmitButton();

		log.info("---Get new Customer ID---");
		customerID = newCustomerPage.getCustomerIDText();

		log.info("---End of TC01_CreateNewCustomer---");
	}

	@Test
	public void Payment_TC01_2_VerifyNewCustomer() {
		log.info("---Begin of TC01_VerifyNewCustomer---");

		log.info("---Verify new Customer created successfully---");
		verifyEquals(newCustomerPage.getRegisteredText(), Customer.NewCustomer.VERIFY_CREATE_NEW_CUSTOMER);

		verifyEquals(newCustomerPage.getCustomerNameText(), Customer.NewCustomer.CUSTOMER_NAME);
		verifyEquals(newCustomerPage.getBirthdateText(), Customer.NewCustomer.DATE_OF_BIRTH);
		verifyEquals(newCustomerPage.getAddressText(), Customer.NewCustomer.ADDRESS);
		verifyEquals(newCustomerPage.getCityText(), Customer.NewCustomer.CITY);
		verifyEquals(newCustomerPage.getStateText(), Customer.NewCustomer.STATE);
		verifyEquals(newCustomerPage.getPinText(), Customer.NewCustomer.PIN);
		verifyEquals(newCustomerPage.getMobileNoText(), Customer.NewCustomer.MOBILE);
		log.info("---End of TC01_VerifyNewCustomer---");
	}

	@Test
	public void Payment_TC02_1_EditCustomer() {
		log.info("---Begin of TC02_EditCustomer---");
		editCustomerPage = newCustomerPage.openEditCustomerPage(driver);

		log.info("---Input CustomerID to edit---");
		editCustomerPage.inputToCustomerIdTextBox(customerID);
		editCustomerPage.clickToSubmitButton();

		editCustomerPage = PageFactoryManager.getEditCustomerPage(driver);

		log.info("---Edit Customer---");
		editCustomerPage.editToAddressTextArea(Customer.EditCustomer.EDIT_ADDRESS);
		editCustomerPage.editToCityTextBox(Customer.EditCustomer.EDIT_CITY);
		editCustomerPage.editToStateTextBox(Customer.EditCustomer.EDIT_STATE);
		editCustomerPage.editToPinTextBox(Customer.EditCustomer.EDIT_PIN);
		editCustomerPage.editToMobileTextBox(Customer.EditCustomer.EDIT_MOBILE);
		editCustomerPage.editToEmailTextBox(Customer.EditCustomer.EDIT_PREFIX_EMAIL);
		editCustomerPage.clickToSubmitButton();
		
		log.info("---End of TC02_EditCustomer---");
	}

	@Test
	public void Payment_TC02_2_VerifyEditCustomer() {
		log.info("---Begin of TC02_VerifyEditCustomer---");

		log.info("---Verify Customer editted successfully---");
		verifyEquals(editCustomerPage.getUpdatedText(), Customer.EditCustomer.VERIFY_EDIT_CUSTOMER);

		verifyEquals(editCustomerPage.getAddressText(), Customer.EditCustomer.EDIT_ADDRESS);
		verifyEquals(editCustomerPage.getCityText(), Customer.EditCustomer.EDIT_CITY);
		verifyEquals(editCustomerPage.getStateText(), Customer.EditCustomer.EDIT_STATE);
		verifyEquals(editCustomerPage.getPinText(), Customer.EditCustomer.EDIT_PIN);
		verifyEquals(editCustomerPage.getMobileNoText(), Customer.EditCustomer.EDIT_MOBILE);
		
		log.info("---End of TC02_VerifyEditCustomer---");
	}

	@Test
	public void Payment_TC03_NewAccount_Payers() {
		log.info("---Begin of TC03_NewAccount_Payers---");
		newAccountPage = editCustomerPage.openNewAccountPage(driver);

		log.info("---Create new Account Payers---");
		newAccountPage.inputToCustomerIdTextBox(customerID);
		newAccountPage.selectAccountTypeFromDropdownList(Account.NewAccount.ACCOUNT_TYPE);
		newAccountPage.inputToInitialDepositTextBox(Account.NewAccount.INITIAL_DEPOSIT);
		newAccountPage.clickToSubmitButton();

		log.info("---Verify new Account Payers created---");
		verifyEquals(newAccountPage.getGeneratedSuccessfullyText(), Account.NewAccount.VERIFY_CREATE_ACCOUNT);
		verifyEquals(newAccountPage.getCurrentAmount(), Account.NewAccount.INITIAL_DEPOSIT);

		log.info("---Get new Account Payers ID---");
		accountIDPayers = newAccountPage.getAccountID();

		log.info("---End of TC03_NewAccount_Payers---");
	}

	@Test
	public void Payment_TC04_Deposit() {
		log.info("---Begin of TC04_Deposit---");
		depositPage = newAccountPage.openDepositPage(driver);

		log.info("---Deposit---");
		depositPage.inputToAccountNoTextBox(accountIDPayers);
		depositPage.inputToAmountTextBox(Deposit.AMOUNT);
		depositPage.inputToDescriptionTextBox(Deposit.DESCRIPTION);
		depositPage.clickToSubmitButton();

		log.info("---Verify Deposit successful---");
		String verifyDeposit = "Transaction details of Deposit for Account " + accountIDPayers;
		verifyEquals(depositPage.getTransactionSuccessfullyText(), verifyDeposit);
		verifyEquals(depositPage.getCurrentBalance(), Deposit.CURRENT_BALANCE);

		log.info("---End of TC04_Deposit---");
	}

	@Test
	public void Payment_TC05_Withdrawal() {
		log.info("---Begin of TC05_Withdrawal---");
		withdrawalPage = depositPage.openWithdrawalPage(driver);

		log.info("---Withdrawal---");
		withdrawalPage.inputToAccountNoTextBox(accountIDPayers);
		withdrawalPage.inputToAmountTextBox(Withdrawal.AMOUNT);
		withdrawalPage.inputToDescriptionTextBox(Withdrawal.DESCRIPTION);
		withdrawalPage.clickToSubmitButton();

		log.info("---Verify Withdrawal successful---");
		String verifyWithdrawal = "Transaction details of Withdrawal for Account " + accountIDPayers;
		verifyEquals(withdrawalPage.getTransactionSuccessfullyText(), verifyWithdrawal);
		verifyEquals(withdrawalPage.getCurrentBalance(), Withdrawal.CURRENT_BALANCE);

		log.info("---End of TC05_Withdrawal---");
	}

	@Test
	public void Payment_TC06_1_NewAccount_Payees() {
		log.info("---Begin of TC06_NewAccount_Payers---");
		newAccountPage = withdrawalPage.openNewAccountPage(driver);

		log.info("---Create new Account Payers---");
		newAccountPage.inputToCustomerIdTextBox(customerID);
		newAccountPage.selectAccountTypeFromDropdownList(Account.NewAccount.ACCOUNT_TYPE);
		newAccountPage.inputToInitialDepositTextBox(Account.NewAccount.INITIAL_DEPOSIT);
		newAccountPage.clickToSubmitButton();

		log.info("---Verify new Account Payers created---");
		verifyEquals(newAccountPage.getGeneratedSuccessfullyText(), Account.NewAccount.VERIFY_CREATE_ACCOUNT);
		verifyEquals(newAccountPage.getCurrentAmount(), Account.NewAccount.INITIAL_DEPOSIT);

		log.info("---Get new Account Payers ID---");
		accountIDPayees = newAccountPage.getAccountID();

		log.info("---End of TC06_NewAccount_Payees---");
	}
	
	@Test
	public void Payment_TC06_2_FundTransfer() {
		log.info("---Begin of TC06_FundTransfer---");
		fundTransferPage = newAccountPage.openFundTransferPage(driver);

		log.info("---Fund transfer---");
		fundTransferPage.inputToPayersAccountNoTextBox(accountIDPayers);
		fundTransferPage.inputToPayeesAccountNoTextBox(accountIDPayees);
		fundTransferPage.inputToAmountTextBox(FundTransfer.AMOUNT);
		fundTransferPage.inputToDescriptionTextBox(FundTransfer.DESCRIPTION);
		fundTransferPage.clickToSubmitButton();

		log.info("---Verify Fund transfer successful---");
		verifyEquals(fundTransferPage.getAmount(), FundTransfer.AMOUNT);

		log.info("---End of TC06_FundTransfer---");
	}

	@Test
	public void Payment_TC07_BalanceEnquiry() {
		log.info("---Begin of TC07_BalanceEnquiry---");
		balanceEnquiryPage = fundTransferPage.openBalanceEnquiryPage(driver);

		balanceEnquiryPage.inputToAccountNoTextBox(accountIDPayers);
		balanceEnquiryPage.clickToSubmitButton();
		balanceEnquiryPage = PageFactoryManager.getBalanceEnquiryPage(driver);

		log.info("---Verify Balance Enquiry successful---");
		String Verify_BalanceDetails = "Balance Details for Account " + accountIDPayers;
		verifyEquals(balanceEnquiryPage.getBalanceDetailsText(), Verify_BalanceDetails);
		verifyEquals(balanceEnquiryPage.getBalance(), BalanceEnquiry.BALANCE);

		log.info("---End of TC07_BalanceEnquiry---");
	}

	@Test
	public void Payment_TC08_DeleteAccount_Payers() {
		log.info("---Begin of TC08_DeleteAccount_Payers---");
		deleteAccountPage = balanceEnquiryPage.openDeleteAccountPage(driver);

		log.info("---Delete account Payers---");
		deleteAccountPage.inputToAccountNoTextBox(accountIDPayers);
		deleteAccountPage.clickToSubmitButton();
		acceptAlert(driver);
		acceptAlert(driver, Account.DeleteAccount.VERIFY_DELETE_ACCOUNT);

		log.info("---End of TC08_DeleteAccount_Payers---");
	}

	@Test
	public void Payment_TC08_DeleteAccount_Payees() {
		log.info("---Begin of TC08_DeleteAccount_Payees---");
		deleteAccountPage = homePage.openDeleteAccountPage(driver);

		log.info("---Delete account Payees---");
		deleteAccountPage.inputToAccountNoTextBox(accountIDPayees);
		deleteAccountPage.clickToSubmitButton();
		acceptAlert(driver);
		acceptAlert(driver, Account.DeleteAccount.VERIFY_DELETE_ACCOUNT);

		log.info("---End of TC08_DeleteAccount_Payees---");
	}

	@Test
	public void Payment_TC09_DeleteCustomer() {
		log.info("---Begin of TC09_DeleteCustomer---");
		deleteCustomerPage = deleteAccountPage.openDeleteCustomerPage(driver);

		log.info("---Delete Customer---");
		deleteCustomerPage.inputToCustomerIdTextBox(customerID);
		deleteCustomerPage.clickToSubmitButton();
		acceptAlert(driver);
		acceptAlert(driver, Customer.DeleteCustomer.VERIFY_DELETE_CUSTOMER);

		log.info("---End of TC09_DeleteCustomer---");
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private WithdrawalPageObject withdrawalPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

	public static String customerID = "";
	public static String accountIDPayers = "";
	public static String accountIDPayees = "";

}
