package InterfaceTest;

public class InterfaceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarShop cs = new CarShop();
		cs.sellCar(new BMW());
		cs.sellCar(new CheryQQ());
		
		System.out.println("共卖出了" + cs.getTotalMoney() + "元");
	}

}
