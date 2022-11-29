package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingParameters1 {
	//static WebDriver driver;
	@Parameters({"browsername"})
  @Test
  public void browsercheck(String browsername)
	{ 
		WebDriver driver=null;
		System.out.println("inside browser check");
		if (browsername.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
					}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.close();
  }
	@Parameters({"username","password"})
	@Test
	public void parametercheck(String username,String password)
	{
		System.out.println("username is  "+username);
		System.out.println("password is "+password);
		
	}
	
}


