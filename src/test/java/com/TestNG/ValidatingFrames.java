package com.TestNG;

import org.testng.annotations.Test;

import com.pages.ValidateFrames;
import com.utility.Library;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;

public class ValidatingFrames extends Library{
  @Test(priority=1)
  public void validateFrames() {
WebElement objElement=driver.findElement(By.id("singleframe"));
driver.switchTo().frame(objElement);
driver.findElement(ValidateFrames.frame1text).sendKeys("shakhi");
driver.switchTo().defaultContent();
}
  @Test(priority=2)
  public void frame2()
  {
	  driver.findElement(ValidateFrames.frame2button).click();
	  WebElement frame21=driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
	  driver.switchTo().frame(frame21);
	  WebElement frame2=driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
driver.switchTo().frame(frame2);
driver.findElement(ValidateFrames.frame2text).sendKeys("Joshua Stephen");
	  }
  @BeforeSuite
  public void beforeSuite() {
	  ReadPropertiesFile();
	  LaunchBrowser();
	  driver.get(objProperties.getProperty("FramesURL"));
	  
	  
  }

  @AfterSuite
  public void afterSuite() {
  }

}
