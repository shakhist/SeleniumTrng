package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenChromeBrowser {
	
	static WebDriver driver;
	int a=10;
	public void f(int b)
	{
		this.a=b;
		System.out.println("a is " +a);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();;
		 driver=new ChromeDriver();
		//if not initialized as static
			//OpenChromeBrowser driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		OpenChromeBrowser obj=new OpenChromeBrowser();
		obj.f(20);


	}

}
