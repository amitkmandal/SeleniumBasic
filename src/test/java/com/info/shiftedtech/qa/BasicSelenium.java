package com.info.shiftedtech.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BasicSelenium {
	public WebDriver driver;
	@Before
	public void startUrl() {
		System.setProperty("webdriver.chrome.driver","C://eclipse//SSNB6BasicSelenium//driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/index.html");
		driver.manage().window().maximize();
	}
	@Test
	public void getset(){
		WebElement element = driver.findElement(By.cssSelector("#enterimg"));
		element.click();
		
		WebElement firstName = driver.findElement(By.xpath("//*[@placeholder='First Name']"));
		firstName.sendKeys("Amit");
		
		WebElement lastName = driver.findElement(By.xpath("//*[@placeholder='Last Name']"));
		//lastName.sendKeys("Mandal");
		typeText(lastName, "Mandal"); //used wrapper for clear the text first
		
		driver.findElement(By.xpath("//textarea[@rows='3']")).sendKeys("4601 67th st woodside NY");
		
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("amitcool.8552@gmail.com");
		
		driver.findElement(By.xpath("//*[@type='tel']")).sendKeys("347-771-2249");
		
		WebElement radioButton = driver.findElement(By.xpath("//*[@value='Male']"));
		radioButton.click();
		
		WebElement checkbox = driver.findElement(By.id("checkbox1"));
		if(!checkbox.isSelected())
			checkbox.click();
		try {
			Thread.sleep(3000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement language = driver.findElement(By.id("msdd"));
		language.click();
		driver.findElement(By.linkText("English")).click();
		try {
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Bulgarian")).click(); 
		
		try {
			
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.linkText("Dutch")).click();
		
		
		WebElement selectElement = driver.findElement(By.id("Skills"));
		Select select = new Select(selectElement);
		/*selecting the value by index no.*/
		select.selectByIndex(1); 
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		select.selectByValue("APIs");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		select.selectByVisibleText("C++");
		
		WebElement country = driver.findElement(By.id("countries"));
		Select select2 = new Select(country);
		select2.selectByVisibleText("Nepal");
		
		WebElement selectCountry = driver.findElement(By.id("country"));
		Select select3 = new Select(selectCountry);
		select3.selectByVisibleText("India");
		
		new Select(driver.findElement(By.id("yearbox"))).selectByVisibleText("1984");
		
		new Select(driver.findElement(By.xpath("//*[@placeholder='Month']"))).selectByIndex(9);
		
		new Select(driver.findElement(By.id("daybox"))).selectByIndex(15);
		
		WebElement password = driver.findElement(By.id("firstpassword"));
		password.sendKeys("amitkumar");
		
		WebElement rePassword = driver.findElement(By.id("secondpassword"));
		rePassword.sendKeys("amitkumar");
		
		WebElement refreshButton = driver.findElement(By.id("Button1"));
		refreshButton.click();
	}
	private void typeText(WebElement element, String textToType) {
		element.clear();
		element.click();
		element.sendKeys(textToType);
	}
	@After
	public void tearDown() {
		//driver.close();
		//driver.quit();
	}
	

}
