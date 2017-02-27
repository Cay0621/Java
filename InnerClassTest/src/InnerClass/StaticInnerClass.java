package InnerClass;

public class StaticInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foo.Goo g = Foo.instanceGoo();
		//Foo.Goo goo = new Foo.Goo();м╛ио
		System.out.println(g.getA());
	}
}

class Foo
{
	static int a = 1;
	static class Goo
	{
		int getA()
		{
			return a;
		}
	}
	
	static Goo instanceGoo(){
		return new Goo();
	}
}