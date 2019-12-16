package com.my.demo;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemoTest {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		 driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), DesiredCapabilities.chrome());	
		 baseUrl = "https://www.baidu.com/";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws MalformedURLException, InterruptedException {
		
		
		 driver.get(baseUrl);
		 driver.manage().window().maximize();
		 driver.findElement(By.id("kw")).clear();
		 driver.findElement(By.id("kw")).sendKeys("selenium");
		 driver.findElement(By.id("su")).click();
		 Thread.sleep(5000);
		 assertTrue(driver.findElement(By.className("nums_text")).getText().contains("百度为您找到相关结果约"));
		 
			 }
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }


}
