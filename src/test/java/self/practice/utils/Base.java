package self.practice.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public final int PAGE_LOAD_TIMEOUT = 10;
	public final int IMPLICIT_WAIT_TIMEOUT = 10;

	public static WebDriver driver;
	public static Properties props = new Properties();

	public Base() {
		String filepath = System.getProperty("user.dir") + "/config/browser.properties";
		try {
			props.load(new FileInputStream(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver initDriver() {
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();

//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");

		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_TIMEOUT));

		return driver;
	}
}
