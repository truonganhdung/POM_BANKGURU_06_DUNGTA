package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AbstractTest {
	WebDriver driverAbstractTest;

	public WebDriver openMultiBrowser(String browserName) {
		if (browserName.equals("firefox")) {
			driverAbstractTest = new FirefoxDriver();
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driverAbstractTest = new ChromeDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\resources\\IEDriver.exe");
			driverAbstractTest = new InternetExplorerDriver();
		} else if (browserName.equals("chromeheadless")) {
			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");

			driverAbstractTest = new InternetExplorerDriver();
		}

		driverAbstractTest.get(Constants.DEV_URL);
		driverAbstractTest.manage().window().maximize();
		driverAbstractTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driverAbstractTest;
	}

	public int randomNumber() {
		Random rand = new Random();
		int random = rand.nextInt(99999) + 1;
		return random;
	}

	protected void closeBrowser(WebDriver driver) {
		try {
			// IE-11
			driver.manage().deleteAllCookies();

			String osName = System.getProperty("os.name").toLowerCase();
			String cmd = "";
			// Quit browser
			driver.quit();

			// Quit process
			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.contains("mac")) {
					cmd = "pkill chromedriver";
				} else {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}

				// Execute process
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

			if (driver.toString().toLowerCase().contains("firefox")) {
				cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			System.out.println("----------- Quit Process -----------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
