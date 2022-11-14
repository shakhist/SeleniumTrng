package com.JavaBasics;



public class JavaVariables {
	
	int a=12; //instance variable
	
static String str="Java"; //static variable

void sum(int a,int b) //non static function
{
	int sum= a+ b;
	System.out.println("sum is "+sum);
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaVariables obj=new JavaVariables();
		System.out.println("local variable is "+obj.a);
		obj.sum(5,4);//calling non static function
		System.out.println("static variable is "+str);//we can call it without creating an object

	}

}
