package com.info.shiftedtech.qa;


import java.awt.List;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class SeleniumTest {
	private WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","C://eclipse//SSNB6BasicSelenium//driver//chromedriver.exe");
		driver = new ChromeDriver();
		/*
		 * by using the driver.navigate().to() method we can go backward, forward and refresh.
		 */
		driver.navigate().to("http://heatclinic.shiftedtech.com/"); 
		
		//driver.navigate().to(new URL("http://heatclinic.shiftedtech.com/"));
		//URL heatClinic = new URL("http://heatclinic.shiftedtech.com/");
		//driver.navigate().to(heatClinic);
		
		//driver.get("http://heatclinic.shiftedtech.com/");
		driver.manage().window().maximize();
		
		
		
	}
	
	@Test
	public void test1() {
		//String title = driver.getTitle();
		//Assert.assertEquals("Broadleaf Demo - Heat Clinic", title);

		java.util.List<WebElement> titleTags = driver.findElements(By.tagName("title"));
		String title = "";
		if (titleTags.size() > 1) {
			title = titleTags.get(1).getAttribute("text");
		}
		else {
			title = titleTags.get(0).getAttribute("text");
		}
		Assert.assertEquals("Broadleaf Demo - Heat Clinic", title);
		
		driver.findElement(By.linkText("Login")).click();
		
		WebElement userNameTextBox = driver.findElement(By.name("j_username"));
		userNameTextBox.clear();
		userNameTextBox.sendKeys("shiftqa01@gmail.com");
		
		WebElement userPassWord = driver.findElement(By.name("j_password"));
		userPassWord.clear();
		userPassWord.sendKeys("shiftedtech");
		WebElement loginButton = driver.findElement(By.cssSelector("input.login_button.big.red"));
		loginButton.click();
		
		WebElement myAccount = driver.findElement(By.cssSelector("a.my-account"));
		String myText = myAccount.getText();
		Assert.assertEquals("Shift", myText);
		
	}
	
	@After
	public void tearDown() {
		
	}

}
