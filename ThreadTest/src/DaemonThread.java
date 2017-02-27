
/**
 * 后台进程也称守护进程
 * 特点：
 * 		当前进程中所有的前台线程死亡后，后台进程强制死亡，无论是否在运行
 * @author 木石前盟Cam
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
				System.out.println("噗通...");
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
		jack.setDaemon(true);//将jack线程设置为守护进程...
		
		//此处main进程和rose进程为前台进程，jack为后台进程
		//当main进程(先死亡)和rose进程(第二个死亡)都死亡后，jack进程才死亡
		rose.start();
		jack.start();
		
		/*如果加上下面一段代码，则jack进程会等待main进程死亡后才停止输出
		try {
			Thread.sleep(50000);//使main进程睡眠一段时间造成阻塞
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
