package InnerClass;

public class InnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Koo k = new Koo();
		System.out.println(k.testGoo());
	}
}

class Koo
{
	int a = 1;
	class Goo
	{
		int getA()
		{
			return a;
		}
	}
	int testGoo()
	{
		Goo g = new Goo();
		return g.getA();
	}
}