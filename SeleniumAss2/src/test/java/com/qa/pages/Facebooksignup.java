package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebooksignup {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=null;
		String browser="chrome";
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		}
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.fb.com");
		System.out.println(driver.getCurrentUrl());
	    driver.findElement(By.xpath("(//a[normalize-space()='Create New Account'])[1]")).click();
	    Thread.sleep(3000);
	   String url=driver.getCurrentUrl();
	    if((driver.findElement(By.xpath("//div[@class='mbs _52lq fsl fwb fcb']")).getText()).equalsIgnoreCase("sign up")) {
        System.out.println("Create an account page is loaded");
	    }
         driver.findElement(By.name("firstname")).sendKeys("sri");
         driver.findElement(By.name("lastname")).sendKeys("latha");
         driver.findElement(By.name("reg_email__")).sendKeys("shreenethira25@gmail.com");
         driver.findElement(By.name("reg_email_confirmation__")).sendKeys("shreenethira25@gmail.com");
         driver.findElement(By.name("reg_passwd__")).sendKeys("srilatha@25");
         WebElement date=driver.findElement(By.name("birthday_day"));
         Select seldate= new Select(date);
         seldate.selectByVisibleText("25");
         WebElement month=driver.findElement(By.name("birthday_month"));
         Select selmonth= new Select(month);
         selmonth.selectByVisibleText("Nov");
         WebElement year=driver.findElement(By.name("birthday_year"));
         Select selyear= new Select(year);
         selyear.selectByVisibleText("2000");
         driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
         driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[10]/button[1]")).click();
		Thread.sleep(1000);
		String url1=driver.getCurrentUrl();
		Thread.sleep(3000);
		if(url1!=url)
			System.out.println("Account created successfully");
		
		driver.close();
	}

}
