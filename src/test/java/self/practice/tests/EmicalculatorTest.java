package self.practice.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import self.practice.utils.Base;

public class EmicalculatorTest extends Base{
	@BeforeTest
	public void setup() {
//		System.out.println("setup");
	}
	
	@BeforeMethod
	public void preTestcase() {
		driver = initDriver();
	}
	
	@AfterMethod
	public void postTestcase() {
		driver.quit();
	}
	
	@AfterTest
	public void tearDown() {
//		System.out.println("teardown");
	}
	
	@Test
	public void test() {
		driver.get("https://mvnrepository.com/artifact/org.testng/testng/7.10.2");
	}
}
