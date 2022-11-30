package com.TestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class ValidatingAlerts {
	WebDriver driver;
	int a;
	  @Test(priority=0)
	 	  public void Titlecheck() {
	
		  System.out.println("Inside title check");
		  String st1=driver.getTitle();
		  Assert.assertEquals(st1, "ToolsQA");
		  System.out.println("title is correct");
		  System.out.println(Thread.currentThread().getId());
		  
	  }
  @Test(priority=1)
  @Parameters({"b"})
  public void Alertbutton() {
	 // this.a=b;
	  System.out.println("a is "+a);
	  System.out.println("Inside alert button function");
	  driver.findElement(By.id("alertButton")).click();
	  Alert al1=driver.switchTo().alert();
	  String alertText=al1.getText();
	  Assert.assertEquals(alertText, "You clicked a button");
	  al1.accept();
	  
  }
  @Test(priority=2)
  public void timerAlert()
  {
	  System.out.println("Inside timer alert button");
	  driver.findElement(By.id("timerAlertButton")).click();
		// Explicit wait : applicable for one webElement .
		// It will wait until Expected condition is satisfied until specified time
		// duration
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert al1=driver.switchTo().alert();
	  String timerAlertText=al1.getText();
	  Assert.assertEquals(timerAlertText, "This alert appeared after 5 seconds");
	 al1.accept();
	  
  }
  @Test(priority=3)
  public void confirmAlert()
  {
	  System.out.println("Inside confirm alert");
	  driver.findElement(By.id("confirmButton")).click();
	
	  Alert al1=driver.switchTo().alert();
	  String timerAlertText=al1.getText();
	  SoftAssert objsftassert=new SoftAssert();
	  objsftassert.assertEquals(timerAlertText, "Do you confirm action?");
	 al1.dismiss();
	 String str1=driver.findElement(By.id("confirmResult")).getText();
	// objsftassert.assertEquals(str1, "You selected Cancel");
	// objsftassert.assertAll();
  }
  @Test(priority=4)
  public void promptAlert() throws InterruptedException
  {
	  System.out.println("Inside prompt alert");
	 // Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.elementToBeClickable(By.id("promtButton")));
	  driver.findElement(By.id("promtButton")).click();
	
	  Alert al1=driver.switchTo().alert();
	  String timerAlertText=al1.getText();
	  SoftAssert objsftassert=new SoftAssert();
	  objsftassert.assertEquals(timerAlertText, "Please enter your name");
	al1.sendKeys("shakhi");
al1.accept();
String str2=driver.findElement(By.id("promptResult")).getText();
objsftassert.assertEquals(str2, "You entered shakhi");

  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside after test");
	//  driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside before suite");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://demoqa.com/alerts");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

  @AfterSuite
  public void afterSuite() {
  }

}
