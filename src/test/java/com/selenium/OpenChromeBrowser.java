package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenChromeBrowser {
	
	static WebDriver driver;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver();
		 driver=new ChromeDriver();
		//if not initialized as static
			//OpenChromeBrowser driver=new ChromeDriver();
		driver.get("https://www.facebook.com");


	}

}
