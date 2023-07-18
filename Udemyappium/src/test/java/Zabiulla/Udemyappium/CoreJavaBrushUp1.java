package Zabiulla.Udemyappium;

import java.util.ArrayList;

public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,6,3,14,33,22};

		//		for (int i = 0; i < arr.length; i++) {
		//			if (arr[i]%2==0) {
		//				System.out.println(arr[i] + " is divisible by 2" );	
		//			}
		//			else {
		//				System.out.println(arr[i] + "is not divible by 2" );
		//			}
		//		}
		//Check if the Array is the multiple of 2
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]%2==0) {
				System.out.println(arr[i]);
				break;
			}
			else {
				System.out.println(arr[i] +  " is not an Mulitple of an 2");
			}	
		}

		//ArrayList
		ArrayList<String> al = new ArrayList<String>();
		//create Object of the Class - If we wanna call a method then object.methodname
		al.add("JISHA");
		al.add("Sreeja");
		al.add("Ali");
		al.remove(2);
		al.add("Rohit");
		System.out.println(al.get(1));
		al.add(1, "Zabi");
		System.out.println(al.get(1)); 
		

	}
}
