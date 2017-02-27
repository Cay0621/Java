package InnerClass;

public class DemoInnerClass {

	private int age = 10;
	private static int count = 20;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//�ⲿ��
		DemoInnerClass outClassObj = new DemoInnerClass();
		outClassObj.sayAge();
		sayCount();
		
		//�Ǿ�̬�ڲ���
		InnerClass1 inner1 = outClassObj.new InnerClass1();
		inner1.sayAge();
		
		//��̬�ڲ���
		InnerClass2 inner2 = new DemoInnerClass.InnerClass2();
		InnerClass2 inner2_1 = new InnerClass2();
		
		inner2.sayCount();
		
		inner2_1.sayCount1();
		InnerClass2.sayCount1();
	}
	
	public void sayAge(){
		System.out.println("�ⲿ��age: " + age);
	}
	
	public static void sayCount(){
		System.out.println("�ⲿ��count: " + count);
	}

	class InnerClass1{
		public void sayAge(){
			//�����ⲿ�෽����ʱ����Ҫ�����ⲿ����+this+�ⲿ�෽����
			DemoInnerClass.this.sayAge();
			
			System.out.println("�Ǿ�̬�ڲ���age: " + age);
		}
	}
	
	static class InnerClass2{
		public void sayCount(){
			System.out.println("��̬�ڲ���Ǿ�̬����count: " + count);
		}
		
		public static void sayCount1(){
			System.out.println("��̬�ڲ��ྲ̬����count: " + count);
		}
	}
}
