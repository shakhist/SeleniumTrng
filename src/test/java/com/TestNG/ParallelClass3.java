package com.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ParallelClass3 {
  @Test
  public void f1() {
	  System.out.println(" Class 3 : Thread count of first function "+Thread.currentThread().getId());
  }
  @Test
  public void f2() {
	  System.out.println(" Class 3 : Thread count of second function "+Thread.currentThread().getId());

  }
  @Test
  public void f3() {
	  System.out.println(" Class 3 : Thread count of third function "+Thread.currentThread().getId());

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
