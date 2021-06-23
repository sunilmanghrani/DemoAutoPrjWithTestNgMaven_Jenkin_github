package com.org;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SampleSelTest {
	WebDriver driver;

	@Test
	public void TestMethod() throws InterruptedException {
		/*
		 * // Launch firefox browser
		 * System.setProperty("webdriver.gecko.driver",
		 * "/Users/sunilkumarpatro/sel/geckodriver"); driver = new
		 * FirefoxDriver();
		 */
		driver = getDriver();

		// maximize the browser
		driver.manage().window().maximize();

		// Implicit wait, wait for at least some time (10 sec) to identify an
		// element, //if can't find the element with in 10

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// open the url or link
		String url = System.getProperty("user.dir") + "\\htmlpage" + "\\form_html4_9InputTags.html";
		driver.get(url);
		Thread.sleep(1000);

		WebElement username = driver.findElement(By.id("un"));
		username.sendKeys("Sunil");
		Thread.sleep(1000);

		WebElement lastname = driver.findElement(By.name("lnm"));
		lastname.sendKeys("manghrani");
		Thread.sleep(1000);

		WebElement mobile = driver.findElement(By.cssSelector("input#mob1"));
		mobile.sendKeys("988976555");
		Thread.sleep(1000);

		WebElement password = driver.findElement(By.xpath("//input[@name='fpass']"));
		password.sendKeys("pass1234");
		Thread.sleep(1000);

		String un = driver.findElement(By.id("un")).getText();
		Thread.sleep(1000);

		driver.quit();
	}

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\drivers" + "\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");

		driver = new ChromeDriver(options);

		return driver;
	}
}
