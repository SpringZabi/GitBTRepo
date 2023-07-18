package Zabiulla.Udemyappium;

public class ChildDemo extends ParentDemo {
	public void Engine() {
		System.out.println("Engine is for new generations implementes");
	}
	public void color() {
		System.out.println(color);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildDemo cd = new ChildDemo();
		cd.Break();
		cd.Engine();
		cd.color();
		
		
	}

}
