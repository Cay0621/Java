package InterfaceTest;

public class CarShop {
	private int totalMoney = 0;

	public int getTotalMoney() {
		return totalMoney;
	}
	
	public void sellCar(Car car) {
		System.out.println("Âô³öÁËÒ»Á¾" + car.getName());
		totalMoney += car.getPrice();
	}
}
