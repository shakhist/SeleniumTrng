package com.TestNG;

import org.testng.annotations.Test;

import com.pages.MouseOperations;
import com.utility.Library;

import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import java.awt.Window;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class VerifyMouseOperations extends Library{
@Test(priority=1,groups= {"functional"})
  public void MouseOperationsrightClick() {
	  System.out.println("inside mouse rightclick method");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	  driver.get(objProperties.getProperty("mouseOpeartionRightClick"));
	  String str=driver.getTitle();
	  Assert.assertEquals(str, objProperties.getProperty("JQeryTitle"));
	  
  }
  @Test(priority=2,groups= {"sanity"})
  public void rightClick() throws InterruptedException
  {
	  Actions ac=new Actions(driver);
	  System.out.println("Thread is "+Thread.currentThread().getId());
	  Thread.sleep(3000);
	 WebElement rc=driver.findElement(MouseOperations.rightClick);
	 ac.contextClick(rc).build().perform();
	 driver.findElement(MouseOperations.clickEdit).click();
	 Alert al=driver.switchTo().alert();
	 System.out.println("Edit Alert text is "+al.getText());
	 al.accept();
	 WebElement rc1=driver.findElement(MouseOperations.rightClick);
	 ac.contextClick(rc1).build().perform();
	 driver.findElement(MouseOperations.clickQuit).click();
	 al=driver.switchTo().alert();
	 System.out.println("Quit Alert text is "+al.getText());
	 al.accept();
  }
  @Test(priority=3,groups= {"sanity"})
  public void doubleClick() throws InterruptedException
  {
	  Thread.sleep(3000);
System.out.println("Thread is "+Thread.currentThread().getId());
	  System.out.println("Inside double click operation");
	  driver.get(objProperties.getProperty("mouseOpeartionDoubleClick"));
	  String gtitle=driver.getTitle();
	  Assert.assertEquals(gtitle, objProperties.getProperty("doubleClickTitle"));
  }
  @Test(priority=4,groups= {"functional"})
  public void doubleClick1() throws InterruptedException
  {
	  Thread.sleep(3000);
System.out.println("Thread is "+Thread.currentThread().getId());
	  System.out.println("Inside double click operation method 2");
	  //JavaScriptExecutor is an Interface that helps to execute JavaScript through Selenium Webdriver.
	  //JavaScriptExecutor provides two methods “executescript” & “executeAsyncScript” to run javascript on the selected window or current page.
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,2500)");
	  driver.switchTo().frame(driver.findElement(MouseOperations.iframe));
	  WebElement el=driver.findElement(MouseOperations.doubleclick);
	  Actions ac =new Actions(driver);
	  ac.doubleClick(el).build().perform();
  }
  @Test(priority=5,groups= {"functional","sanity"})
  public void dragAndDrop()
  {
	  System.out.println("inside drag and drop");
	  driver.get(objProperties.getProperty("mouseOperationDragAndDrop"));
	  WebElement fr1=driver.findElement(MouseOperations.iframe);
	  driver.switchTo().frame(fr1);
	  WebElement el1=driver.findElement(MouseOperations.draggable);
	  WebElement el2=driver.findElement(MouseOperations.droppable);
	  Actions ac=new Actions(driver);
	  ac.dragAndDrop(el1, el2).build().perform();
  }
  @BeforeSuite
  public void beforeSuite() throws InterruptedException {
	  ReadPropertiesFile();
	  LaunchBrowser();
	  //Thread.sleep(3000);
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();

  }

}
