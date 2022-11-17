package com.TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class TestngLoadTesting {
  @Test(priority=1,threadPoolSize=3)
  public void f() {
	  System.out.println("thread pool id is " +Thread.currentThread().getId());
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver =new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.get("https://www.google.com");
	  WebElement frame=driver.findElement(By.name("callout"));
	  driver.switchTo().frame(frame);
	  driver.findElement(By.xpath("//button[@jsname='ZUkOIc']")).click();
      String t="Google";
      String title=driver.getTitle();
      Assert.assertEquals(t, title);
      driver.switchTo().defaultContent();
      WebElement search=driver.findElement(By.name("q"));
      String attr=search.getAttribute("title");
      System.out.println(attr);
      System.out.println(search.getDomAttribute("title"));
      driver.quit();
  }
  @Test(priority=1,threadPoolSize=2)
  public void simpletest()
  {
	  System.out.println("thread of second test is "+Thread.currentThread().getId());
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
