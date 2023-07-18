package Zabiulla.Udemyappium;

public class CoreJavaBrushUp2 {

	public static void main(String[] args) {
		//String is an Object //String Literal
		String s= "Rahul Shetty Academy";
		String s1= "Rahul Shetty Academy";
		//In the above string only one object is created and s1 will pointed s
		//Becoz the sentences/value in the both the string is same.
		String s2="hello"; // here it is creating a new space
		 
		
		//Creating a new object in this creates a new space  in java memory
		//new
		String s3=new String ("Welcome");
		String s4 = new String("Welcome");
		
		//Splitting the string in an array with the spaces.
		String s5="Spring Digital is in AU";
		String[] splittedString = s5.split(" ");
//		System.out.println(splittedString[0]); 
//		System.out.println(splittedString[1]); 
//		System.out.println(splittedString[2]); 
//		System.out.println(splittedString[3]); 
//		System.out.println(splittedString[4]); 
		
//		for (int i = 0; i < splittedString.length; i++) {
//			 System.out.println(splittedString[i]);
//		}
		
		for (String string : splittedString) {
			 System.out.println(string);
		}
		
		//Splitting the array upon is
		String[] splitedString = s5.split("is");
		System.out.println(splitedString[0]);
		System.out.println(splitedString[1]);
		System.out.println(splitedString[1].trim());
		
		//printing the characters by one by one
//		for (int i = 0; i < s5.length(); i++) {
//			System.out.println(s5.charAt(i)); 	
//		}
		
		//print the string in Reverse order
		for (int i = s5.length()-1; i >=0; i--) {
			System.out.println(s5.charAt(i));
		}
	}
}
