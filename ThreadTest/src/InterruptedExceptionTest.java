public class InterruptedExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * �����ж����������ֲ��ڲ���
		 * �ֲ��ڲ������������õ�ǰ�����������ֲ���������ô�ñ���������final��
		 */
		final Thread t1 = new Thread() {
			@Override
			public void run() {
			
				// TODO Auto-generated method stub
				// super.run();
				while (true) {
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						// e.printStackTrace();
						System.out.println("���ж��ˡ�����");
					}

				}
			}

		};

		Thread t2 = new Thread() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// super.run();
				for (int i = 1; i <= 5; ++i) {
					System.out.println(i + "��");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				t1.interrupt();//��t1�߳��ж�
			}

		};
		t1.start();
		t2.start();
	}

}
