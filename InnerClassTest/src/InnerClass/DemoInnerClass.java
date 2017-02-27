package InnerClass;

public class DemoInnerClass {

	private int age = 10;
	private static int count = 20;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//外部类
		DemoInnerClass outClassObj = new DemoInnerClass();
		outClassObj.sayAge();
		sayCount();
		
		//非静态内部类
		InnerClass1 inner1 = outClassObj.new InnerClass1();
		inner1.sayAge();
		
		//静态内部类
		InnerClass2 inner2 = new DemoInnerClass.InnerClass2();
		InnerClass2 inner2_1 = new InnerClass2();
		
		inner2.sayCount();
		
		inner2_1.sayCount1();
		InnerClass2.sayCount1();
	}
	
	public void sayAge(){
		System.out.println("外部类age: " + age);
	}
	
	public static void sayCount(){
		System.out.println("外部类count: " + count);
	}

	class InnerClass1{
		public void sayAge(){
			//调用外部类方法的时候需要加上外部类名+this+外部类方法名
			DemoInnerClass.this.sayAge();
			
			System.out.println("非静态内部类age: " + age);
		}
	}
	
	static class InnerClass2{
		public void sayCount(){
			System.out.println("静态内部类非静态方法count: " + count);
		}
		
		public static void sayCount1(){
			System.out.println("静态内部类静态方法count: " + count);
		}
	}
}
