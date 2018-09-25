package com.dice;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		// opens the window
		WebDriver driver = new ChromeDriver();
		
		//FULLSCREEN
		driver.manage().window().maximize();
		
		// set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// goes to web page
		driver.get("https://dice.com");
		
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("PASSED");
		}else {
			System.out.println("FAILED");
			throw new RuntimeException("Step Fail. FAILED");
		}
		
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys("java developer");
		
		
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys("94109");
		
		driver.findElement(By.id("findTechJobs")).click(); 
		
		String count=driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		
		int countResult=Integer.parseInt(count.replace(",", ""));
		
		if(countResult>0) {
			System.out.println("Step PASSED: Keyword : "+" java developer"+" search returned "+
		countResult+" results in "+" 94109");
		}else {
			System.out.println("Step Failed: Keyword: "+" java developer "+" search returned "+
		countResult+" results in San Francisco");
		}
		
		driver.close();
		
		
		
		
		
		
		
	}

}
