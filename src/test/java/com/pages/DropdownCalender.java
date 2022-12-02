package com.pages;

import org.openqa.selenium.By;

public class DropdownCalender {
	public static By firstname=By.id("firstName");
	public static By lastname=By.id("lastName");
	public static By email=By.id("userEmail");
	public static By genderMale=By.xpath("//input[@value='Male']");
	public static By genderFemale=By.xpath("//input[@value='Female']");
	public static By genderOther=By.xpath("//input[@value='Other']");
    public static By mobile=By.id("userNumber");
    public static By year=By.xpath("//select[@class='react-datepicker__year-select']");
    public static By month=By.xpath("//select[@class='react-datepicker__month-select']");
    public static By day=By.xpath("//div[@class='react-datepicker__month']");
    public static By subject=By.id("subjectsContainer");
    public static By sprots=By.xpath("//label[@for='hobbies-checkbox-1']");
    public static By pic=By.id("uploadPicture");
    public static By currentaddress=By.id("currentAddress");
	}
