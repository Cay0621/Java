package InterfaceTest;

public class BMW implements Car {
	private int price = 300000;
	private String name = "BWM";
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
