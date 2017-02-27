package Singleton;

/**
 * ����ģʽ���κ�����£�����ֻ�ܴ���һ��ʵ��
 * 
 * ������
 * 	1������һ��˽�еľ�̬�ĵ�ǰ�������
 * 	2��˽�л����췽����������������ⴴ�����ʵ��
 * 	3������һ����̬�Ŀ��Ի�ȡ��ǰ��ʵ���ķ�����
 * 		����������п����ж��Ƿ񴴽���ʵ����
 * 		���δ�������򴴽�ʵ��������Ѵ���������ֱ�ӷ��ص�ǰʵ�����Ӷ��ﵽ����Ч��
 * 
 * @author ľʯǰ��Cam
 *
 */
public class SingletonTest {
	
	private static SingletonTest obj = null;
	//����˽�й��캯��
	private SingletonTest(){
		
	}
	
	//���幫�еľ�̬�������ڻ�ȡ��ǰʵ��
	public static SingletonTest getInstance(){
		if(obj == null)
			obj = new SingletonTest();
		return obj;
	}
}