package com.TestNG;

import org.testng.annotations.Test;

import com.pages.MultipleWindows1;
import com.utility.Library;

import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class MultipleWindows extends Library {
  @Test(priority=1)
  public void windowTitle() {
	
	  String gtitle=driver.getTitle();
	  Assert.assertEquals(gtitle, objProperties.getProperty("nxtgenaiacademyTitle"));
  }
  @Test(priority=2)
  public void newBrowserWindow()
  {
	  WebElement el=driver.findElement(MultipleWindows1.newWindow);
	  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(60));
	  String windowhandle1=driver.getWindowHandle();
	  wait.until(ExpectedConditions.elementToBeClickable(el));
	  el.click();
	  Set<String> WindowHandles=driver.getWindowHandles();
	  for(String IndividualWindow:WindowHandles)
	  {
		  driver.switchTo().window(IndividualWindow);
		  System.out.println("new window's title is "+driver.getTitle());
		  if (driver.getTitle().equals(objProperties.getProperty("newBrowserWindowTitle"))
				  ) {
			  driver.findElement(MultipleWindows1.newMenu).click();
			  driver.findElement(MultipleWindows1.Aboutme).click();
			  driver.close();
		  }
	  }
	  driver.switchTo().window(windowhandle1);
	  
  }
  @Test(priority=3,enabled=false)
  public void NewMessageWindow()
  {
	  System.out.println("Inside new message window");
	  String windHandle1=driver.getWindowHandle();
	  driver.findElement(MultipleWindows1.newMessWindow).click();
	  Set<String> winHandles=driver.getWindowHandles();
	  for (String InHandle:winHandles)
	  {
		
		  if(!InHandle.equals(windHandle1))
		  {
		  System.out.println("InWindowhandle is "+InHandle);
		 // driver.switchTo().window(windHandle1);
		  String messText=driver.findElement(MultipleWindows1.messText).getText();
		  System.out.println(messText);
		  }
	 }
	 // System.out.println(windHandle1);
	//  driver.switchTo().
  }
  @Test(priority=4)
  public void newBrowserWindow1()
  {
	  driver.findElement(MultipleWindows1.newBrowserTab).click();
	  String Ph=driver.getWindowHandle();
	  Set<String> wH=driver.getWindowHandles();
	  for (String InHandle:wH)
	  {
		  if(!InHandle.equals(Ph))
		  {
	  driver.switchTo().window(InHandle);
	  driver.findElement(MultipleWindows1.tabmenu).click();
		  }
	  }
  }
  @BeforeSuite
  public void beforeSuite() {
	  ReadPropertiesFile();
	  LaunchBrowser();
	  driver.get(objProperties.getProperty("nxtgenaiacademyURL"));

  }

  @AfterSuite
  public void afterSuite() {
	  //driver.quit();
  }

}
