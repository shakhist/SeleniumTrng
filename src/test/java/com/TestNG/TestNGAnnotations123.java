package com.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGAnnotations123 {
  @Test(priority=8)
  public void ValidateflipKartApplicationLoadedSuccessfully() {
	  System.out.println("inside testCase1");
  }
  
  @Test(priority=5)
  public void ValidateLoginFnctionality() {
	  System.out.println("inside testCase2");
  }
  
  @Test(priority=-4,invocationCount=3)
  public void testCase6() {
	  System.out.println("inside testCase6");
  }
  
  @Test(priority=-9)
  public void testCase3() {
	  System.out.println("inside testCase3");
  }
  
  @Test()
  public void testCase4() {
	  System.out.println("inside testCase4");
  }
  
  @Test(priority=0)
  public void TestCase5() {
	  System.out.println("inside TestCase5");
  }
  
  
  @Test(invocationCount=2)
  public void tEstCase7() {
	  System.out.println("inside tEstCase7");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("inside afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("inside beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("inside afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside aftersuite");
  }

}
