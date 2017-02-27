package InnerClass;

public class AnnInnerClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xoo x = new Xoo(){
			public int getA()
			{
				return 2;
			}
		}; //匿名类，匿名内部类,相当于继承
		System.out.println(x);
	}
}

class Xoo
{
	int a = 1;
	public int getA()
	{
		return a;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getA() + "";
	}
}