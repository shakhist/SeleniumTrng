package com.JavaBasics;

public class StringBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1=" Learning Java ";
		String str2="Learing Java";
		System.out.println("str1 length is" +str1.length());
		System.out.println("str1. index is "+str1.charAt(2));
		System.out.println("substring is "+str1.substring(2,5));
		
		System.out.println("concatenation is " +str1.concat(str2));
		System.out.println("strings are equal or not - " +str1.equals(str2));
		System.out.println("to lowercase is " +str1.toLowerCase());
		System.out.println("trim the word is" +str1.trim());//removes the beginning and ending spaces
		//but not the spaces inbetween
		
		System.out.println("replacing characters "+str1.replace('J','L'));
		
		System.out.println("hashcode is " +str1.hashCode());
		System.out.println("replacement is "+str1.replaceAll(str1, "  "));
	}

}
