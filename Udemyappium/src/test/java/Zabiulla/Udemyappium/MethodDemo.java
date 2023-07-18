package Zabiulla.Udemyappium;

public class MethodDemo {

	public static void main(String[] args) {
		MethodDemo d = new MethodDemo();
		d.data();
		String name = d.data();
		System.out.println(name);

		MethodDemo1 d2 = new MethodDemo1();
		d2.userdata();

//When we make it
		data2();
	}

	public String data() {
		System.out.println("Helo world");	
		return "zabi";
	}
	
	//When we make it as static then we need not to create a object in the main class we can call it directly
	public static String data2() {
		System.out.println("Hi");
		return "Zabi";
	}

}
