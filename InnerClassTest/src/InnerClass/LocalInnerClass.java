package InnerClass;

public class LocalInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class Koo //局部内部类，类似局部变量
		{
			int a = 1;
		}
		
		Koo k = new Koo();
		System.out.println(k.a);
	}

}
