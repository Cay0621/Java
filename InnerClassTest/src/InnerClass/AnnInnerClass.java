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
		}; //�����࣬�����ڲ���,�൱�ڼ̳�
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