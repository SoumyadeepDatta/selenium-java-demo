package self.practice;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest {
	WebDriver driver;
	static ChromeOptions options = new ChromeOptions();
	static Map<String, Object> prefs = new HashMap<>();
	
	@BeforeClass
	public static void init() {
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");
		
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);
	}

	@Before
	public void setUp() {
		driver = new ChromeDriver(options);
	}

	@Test
	public void shouldAnswerWithTrue() {
		driver.get("https://mvnrepository.com/");
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
