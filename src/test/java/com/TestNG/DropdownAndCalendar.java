package com.TestNG;

import org.testng.annotations.Test;

import com.utility.Library;

import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class DropdownAndCalendar extends Library {
  @Test(priority=1)
  public void Titlevalidation()
  {
	  String title=objProperties.getProperty("TitleOfPracticeFormPage");
	  
	  Assert.assertEquals(title, driver.getTitle());
  }
  @Test
  public void form()
  {
	  
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
