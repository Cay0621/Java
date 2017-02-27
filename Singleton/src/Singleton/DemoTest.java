package Singleton;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SingletonTest st = new SingletonTest();
		SingletonTest  st1 = SingletonTest.getInstance();
		SingletonTest  st2 = SingletonTest.getInstance();
		
		System.out.println(st1 == st2);//true
	}

}
