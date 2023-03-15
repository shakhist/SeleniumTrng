package com.TestNG;

import org.testng.annotations.Test;

import com.pages.DropdownCalender;
import com.utility.Library;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class DropdownAndCalendar extends Library {
  @Test(priority=1)
  public void Titlevalidation()
  {
	  String title=objProperties.getProperty("TitleOfPracticeFormPage");
	  
	  Assert.assertEquals(title, driver.getTitle());
  }
  @Test(priority=2)
  public void form()
  {
	  WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
	  wait2.until(ExpectedConditions.elementToBeClickable(DropdownCalender.firstname));
	  driver.findElement(DropdownCalender.firstname).sendKeys("Shakhi");
	  driver.findElement(DropdownCalender.lastname).sendKeys("Abraham");
	  driver.findElement(DropdownCalender.email).sendKeys("sj2@gmail.com");
	  //driver.findElement(DropdownCalender.genderFemale).click();
	  driver.findElement(DropdownCalender.mobile).sendKeys("95893456789");
	  driver.findElement(DropdownCalender.DOB1).click();
	  WebElement yr=driver.findElement(DropdownCalender.year);
	  Select se1=new Select(yr);
	  se1.selectByValue(objProperties.getProperty("DOB_YY"));
	  WebElement mth=driver.findElement(DropdownCalender.month);
	  Select se2=new Select(mth);
	  se2.selectByVisibleText(objProperties.getProperty("DOB_Month"));
	  try {
	  List<WebElement> AllDays=driver.findElements(DropdownCalender.day);
	  int i=AllDays.size();
	  System.out.println("i is "+i);
	  for (int j=0;j<=i-1;j++)
	  {
		  String dy=objProperties.getProperty("DOB_DD");
		  String dy1=AllDays.get(j).getText();
		  if(dy1.equals(dy))
				   {
			  AllDays.get(j).click();
			  
		  }
		 
	  }
	  }catch (Exception e) {
			e.printStackTrace();
			//driver.findElement(DropdownCalender.DOB1).click();
			////String valueChoosen = driver.findElement(DropdownCalender.DOB1).getAttribute("value");
			//Assert.assertEquals(valueChoosen, objProperties.getProperty("dateOfBirth"));
	  }
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,150)");
	  WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
	  WebElement autoOptions=driver.findElement(DropdownCalender.subject);
	 wait1.until(ExpectedConditions.visibilityOf(autoOptions));
List<WebElement> li=autoOptions.findElements(DropdownCalender.autoOp);
for (WebElement li1:li)
{
	if ("English".equalsIgnoreCase(li1.getText()))
	{
		li1.click();
	}
}
driver.findElement(DropdownCalender.subject).click();
driver.findElement(DropdownCalender.sprots).click();
driver.findElement(DropdownCalender.currentaddress).sendKeys("4426 yorktown");
driver.close();
  }
  @BeforeSuite
  public void beforeSuite()
  {
	  ReadPropertiesFile();
	  LaunchBrowser();
	  driver.get(objProperties.getProperty("CalenderAndDropDownPage"));
  }

  @AfterSuite
  public void afterSuite() {
  }

}
