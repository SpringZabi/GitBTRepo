package Zabiulla.Udemyappium;

import java.util.Iterator;

public class CoreJavaBrushUp {

	public static void main(String[] args) {
		//Variables and Datatypes
		//int,char,string,boolean,double,float are the datatypes 
		//num,character,name,bln,dbl are the variables name which can be any names this is provided by user
		int num = 10;
		char character ='Z';
		String name = "Zabiulla Appium";
		boolean bln= true;
		double dbl = 5.67;
		System.out.println(num);
		System.out.println(name + " is an Automation tester");	

		//Arrays
		int[] arr= new int [5];
		arr[0]=2;
		arr[1]=4;
		arr[2]=6;
		arr[3]=8;
		arr[4]=10;
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		//System.out.println(arr[5]);//ArrayIndexOutOfBoundsException

		int [] arr2= {1,2,3,4,6,6,7,8};
		System.out.println(arr2[2]);
		System.out.println(arr2[5]);

		String[] str= {"Sreeja","Jisha","Archana","Ali","Zabiulla","Rohit"};
		System.out.println(str[2]);

		//for loop
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}


		for (int i = 2; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
		//Enhanced For Loop/for each loop/Advance for loop
		for (String s : str) {
			System.out.println(s);
		}
		for (int a : arr) {
			System.out.println(a);
		}

	}
}
