
/**
 * ��̨����Ҳ���ػ�����
 * �ص㣺
 * 		��ǰ���������е�ǰ̨�߳������󣬺�̨����ǿ�������������Ƿ�������
 * @author ľʯǰ��Cam
 *
 */
public class DaemonThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread rose = new Thread(){
			public void run(){
				for(int i = 0;i < 10; ++i){
					System.out.println("Let me go!");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("��ͨ...");
			}
		};
		
		Thread jack = new Thread(){
			public void run(){
				for(int i = 0; i < 1000; ++i){
					System.out.println("You jump, i jump!");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		jack.setDaemon(true);//��jack�߳�����Ϊ�ػ�����...
		
		//�˴�main���̺�rose����Ϊǰ̨���̣�jackΪ��̨����
		//��main����(������)��rose����(�ڶ�������)��������jack���̲�����
		rose.start();
		jack.start();
		
		/*�����������һ�δ��룬��jack���̻�ȴ�main�����������ֹͣ���
		try {
			Thread.sleep(50000);//ʹmain����˯��һ��ʱ���������
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
