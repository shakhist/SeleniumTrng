package com.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGgroups {
  @Test(priority=1,invocationCount=2,groups="regression")
  public void testcase1() {
	  System.out.println("regression test");
  }
  @Test(priority=2,groups="sanity")
  public void testcase2()
  {
	  System.out.println("sanity test");
  }
  @Test(priority=3,groups={"sanity","regression"})
  public void testcase3()
  {
	  System.out.println("sanity and regression test");
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("inside before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("inside after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("inside beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("inside after suite");
  }

}
